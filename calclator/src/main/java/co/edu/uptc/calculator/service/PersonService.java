package co.edu.uptc.calculator.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import co.edu.uptc.calculator.model.Person;
import co.edu.uptc.calculator.repository.PersonRepository;

@Service
public class PersonService {

    private static final int PERSONAS_POR_PAGINA = 100;

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional(readOnly = true)
    public List<Person> getPersons(int pagina) {

        if (pagina < 1) {
            throw new IllegalArgumentException("La página debe ser mayor que 0");
        }

        PageRequest pageable = PageRequest.of(
            pagina - 1,
            PERSONAS_POR_PAGINA,
            Sort.by("id")
        );

        return personRepository.findAllBy(pageable).getContent();
    }

    @Transactional
    public Person updatePerson(Long id, Person datos) {

        Person person = personRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No existe la persona con id " + id
            ));

        person.setNombre(datos.getNombre());
        person.setApellido(datos.getApellido());

        return personRepository.save(person);
    }
    @Transactional(readOnly = true)
    public Person getPerson(Long id) {
        return personRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No existe la persona con id " + id
            ));
    }
}