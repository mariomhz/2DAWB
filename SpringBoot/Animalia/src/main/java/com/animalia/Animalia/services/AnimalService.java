package com.animalia.Animalia.services;

import org.springframework.stereotype.Service;
import com.animalia.Animalia.models.Animal;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class AnimalService {
    private int counter = 1;
    private ArrayList<Animal> animales = new ArrayList<>();

    public ArrayList<Animal> listarAnimales() {
        return animales;
    }

    public Animal getAnimalById(Integer id) {

        for (Animal a : animales) {
            if (a.getId().equals(id))
                return a;
        }
        return null;
    }

    public void crearAnimal(Animal animal) {
        animal.setId(counter++);
        animales.add(animal);
    }

    public void actualizarAnimal(Animal animal) {

        for (Animal a : animales) {
            if (a.getId().equals(animal.getId())) {
                a.setNombre(animal.getNombre());
                a.setVidaMedia(animal.getVidaMedia());
                a.setExtinto(animal.getExtinto());
            }
        }
    }

    public void eliminarAnimal(Animal animal) {
        animales.removeIf(a -> a.getId().equals(animal.getId()));
    }
}
