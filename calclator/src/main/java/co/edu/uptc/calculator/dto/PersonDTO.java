package co.edu.uptc.calculator.dto;

import java.util.List;

import co.edu.uptc.calculator.model.Person;

public class PersonDTO {

    private String container;
    private String mensaje;
    private List<Person> personas;

    public PersonDTO() {
    }

    public PersonDTO(String container, String mensaje, List<Person> personas) {
        this.container = container;
        this.mensaje = mensaje;
        this.personas = personas;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Person> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Person> personas) {
        this.personas = personas;
    }
}