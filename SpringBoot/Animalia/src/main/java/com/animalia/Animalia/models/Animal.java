package com.animalia.Animalia.models;
import jakarta.validation.constraints.*;

public class Animal {
    private Integer id;

    @NotBlank(message="Campo obligatorio.")
    @Size(min = 3, max = 15, message = "La longitud del nombre ha de ser entre 3 y 15 caracteres.")
    private String nombre;

    @NotNull(message = "Campo obligatorio.")
    @Min(value = 0, message = "La edad media no puede ser menor de 0.")
    @Max(value = 600, message = "La edad media no puede ser mayor de 600.")
    private Integer vidaMedia;

    private Boolean extinto;

    public Animal() {};

    public Animal(Integer id, String nombre, Integer vidaMedia, Boolean extinto){
        setId(id);
        setNombre(nombre);
        setVidaMedia(vidaMedia);
        setExtinto(extinto);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getVidaMedia() {
        return this.vidaMedia;
    }

    public void setVidaMedia(Integer vidaMedia){
        this.vidaMedia = vidaMedia;
    }

    public Boolean getExtinto() {
        return this.extinto;
    }

    public void setExtinto(Boolean extinto) {
        this.extinto = extinto;
    }
}
