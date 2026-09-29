package in.tricks.curdSpringBootDemo.Controller;

import in.tricks.curdSpringBootDemo.Entity.Student;
import in.tricks.curdSpringBootDemo.Service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //Create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq) {
        Student studentResp = studentService.createdStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }

    //Get One
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(studentResp);
    }
    //Get All
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentList = studentService.getAllStudents();

        if(studentList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }
    //update
    @PutMapping("/updateStudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student studentReq){
       Student studentResp = studentService.updateStudent(id, studentReq);
       if(studentResp == null){
           return ResponseEntity.notFound().build();
       }
       return ResponseEntity.ok(studentResp);
    }

    //Delete
    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudent(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(isDeleted);
    }
}
