package mlg.project.portfolio.views;

import mlg.project.portfolio.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
