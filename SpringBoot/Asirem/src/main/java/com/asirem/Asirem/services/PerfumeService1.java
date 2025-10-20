package com.asirem.Asirem.services;

import com.asirem.Asirem.interfaces.IPerfumeService;
import com.asirem.Asirem.models.Perfume;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfumeService1 implements IPerfumeService {
    private int index = 1;
    private List<Perfume> perfumes = new ArrayList<>();

    @Override
    public List<Perfume> getAllPerfumes() {
        return perfumes;
    }

    @Override
    public Perfume getPerfumeById(Integer id) {
        for (Perfume p : perfumes) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Perfume addPerfume(Perfume perfume) {
        perfume.setId(index++);
        perfumes.add(perfume);
        return perfume;
    }

    @Override
    public Perfume updatePerfume(Perfume perfume) {
        for (Perfume p : perfumes) {
            if (p.getId().equals(perfume.getId())) {
                p.setName(perfume.getName());
                p.setBrand(perfume.getBrand());
                p.setPrice(perfume.getPrice());
                p.setDescription(perfume.getDescription());
            }
        }
        return perfume;
    }

    @Override
    public void deletePerfume(Integer id) {
        perfumes.removeIf(p -> p.getId().equals(id));
    }
}