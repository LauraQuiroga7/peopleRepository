package co.edu.uptc.calculator.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.calculator.dto.PersonDTO;
import co.edu.uptc.calculator.model.Person;
import co.edu.uptc.calculator.service.PersonService;

@RestController
@RequestMapping("/personas")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // Consultar personas por página
    @GetMapping("/pagina/{pagina}")
    public PersonDTO getPersons(@PathVariable int pagina) {
        List<Person> persons = personService.getPersons(pagina);
        String container = System.getenv("CONTAINER_NAME");
        return new PersonDTO(container, persons);
    }
    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
    return personService.getPerson(id);
}

    // Modificar una persona
    @PutMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person datos) {
        return personService.updatePerson(id, datos);
    }
}