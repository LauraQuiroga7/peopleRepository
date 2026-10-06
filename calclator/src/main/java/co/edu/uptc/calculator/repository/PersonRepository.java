package co.edu.uptc.calculator.repository;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.uptc.calculator.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
        Slice<Person> findAllBy(Pageable pageable);

}
