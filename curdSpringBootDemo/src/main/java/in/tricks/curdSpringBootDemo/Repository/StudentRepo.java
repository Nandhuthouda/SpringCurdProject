package in.tricks.curdSpringBootDemo.Repository;

import in.tricks.curdSpringBootDemo.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepo extends JpaRepository<Student, Long> {

}
