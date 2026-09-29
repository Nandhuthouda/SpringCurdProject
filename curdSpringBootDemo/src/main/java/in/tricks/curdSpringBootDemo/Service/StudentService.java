package in.tricks.curdSpringBootDemo.Service;

import in.tricks.curdSpringBootDemo.Entity.Student;
import in.tricks.curdSpringBootDemo.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepo studentRepo;
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }


    public Student createdStudent(Student studentReq) {
        //business logic
        //say repo to save data in db
        Student studentResp = studentRepo.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id) {
        //Optional is used to represent the possibility that a value may be absent,
        // so we can handle the "not found" case explicitly instead of directly dealing with null.
        Optional<Student> studentResp = studentRepo.findById(id);
        if(studentResp.isPresent())
            return studentResp.get();

        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student studentReq) {
        Optional<Student> exisitingStudent = studentRepo.findById(id);
        if(exisitingStudent.isEmpty()){
            return null;
        }

        Student studentToChange = exisitingStudent.get();
        studentToChange.setName(studentReq.getName());
        studentToChange.setRollNo(studentReq.getRollNo());
        studentToChange.setEmail(studentReq.getEmail());
        studentToChange.setSubject(studentReq.getSubject());


        return studentRepo.save(studentToChange);
    }

    public Boolean deleteStudent(Long id) {
        Boolean isDelete = studentRepo.existsById(id);
        if(!isDelete){
            return false;
        }
        studentRepo.deleteById(id);
        return true;
    }
}
