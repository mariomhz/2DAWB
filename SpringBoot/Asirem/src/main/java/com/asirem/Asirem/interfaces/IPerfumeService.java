package com.asirem.Asirem.interfaces;

import com.asirem.Asirem.models.Perfume;
import java.util.List;

public interface IPerfumeService {

    List<Perfume> getAllPerfumes();
    Perfume getPerfumeById(Integer id);
    Perfume addPerfume(Perfume perfume);
    Perfume updatePerfume(Perfume perfume);
    void deletePerfume(Integer id);
}
