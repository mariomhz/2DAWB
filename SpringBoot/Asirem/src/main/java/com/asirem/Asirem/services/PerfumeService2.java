package com.asirem.Asirem.services;

import com.asirem.Asirem.interfaces.IPerfumeService;
import com.asirem.Asirem.models.Perfume;
import com.asirem.Asirem.repositories.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class PerfumeService2 implements IPerfumeService {

    @Autowired
    private PerfumeRepository perfumeRepository;

    @Override
    public List<Perfume> getAllPerfumes() {
        return perfumeRepository.findAll();
    }

    @Override
    public Perfume getPerfumeById(Integer id) {
        return perfumeRepository.findById(id).orElse(null);
    }

    @Override
    public Perfume addPerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    @Override
    public Perfume updatePerfume(Perfume perfume) {
        return perfumeRepository.save(perfume);
    }

    @Override
    public void deletePerfume(Integer id) {
        perfumeRepository.deleteById(id);
    }
}
