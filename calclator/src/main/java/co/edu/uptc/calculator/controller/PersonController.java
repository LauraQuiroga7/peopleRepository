package co.edu.uptc.calculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.calculator.dto.PersonDTO;
import co.edu.uptc.calculator.dto.PersonDetalleDTO;
import co.edu.uptc.calculator.model.Person;
import co.edu.uptc.calculator.service.PersonService;

@RestController
@RequestMapping("/personas")
public class PersonController {

    private static final String MENSAJE = "Hola profesor";
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/pagina/{pagina}")
    public PersonDTO getPersons(@PathVariable int pagina) {
        List<Person> persons = personService.getPersons(pagina);
        String container = System.getenv("CONTAINER_NAME");
        return new PersonDTO(container, MENSAJE, persons);
    }

    @GetMapping("/{id}")
    public PersonDetalleDTO getPerson(@PathVariable Long id) {
        Person p = personService.getPerson(id);
        return new PersonDetalleDTO(
                p.getId(), p.getNombre(), p.getApellido(),
                System.getenv("CONTAINER_NAME"), MENSAJE);
    }

    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person datos) {
        return personService.updatePerson(id, datos);
    }

    private String getMensaje() {
        return "Lauuuuuu";
    }
}