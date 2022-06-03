package com.nighthawk.SQL;
import com.nighthawk.SQL.student;
import com.nighthawk.SQL.studentSQLrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.validation.Valid;
import java.util.List;
@Controller
public class studentSQLMVC {
    @Autowired
    private studentSQLrepo repository;
    @GetMapping("/student")
    public String student(Model model){
        List<student> list=repository.listAll();
        System.out.println(list);
        model.addAttribute("list", list);
        return "student";
    }
    @PostMapping("/SQL/studentcreate")
    @ResponseBody
    public void studentSave(
            @RequestParam(name="id", required = false) int id,
            @RequestParam(name="grade", required = false) int grade,
            @RequestParam(name="name", required = false) String name
    ){
        student student = new student(id,grade,name);
        repository.save(student);
    }

    @GetMapping("/SQL/studentcreate")
    public String studentAdd(student student ){
        return "student";
    }

   /* @PostMapping("/SQL/studentcreate")
    public String studentSave(@Valid student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "student";

        }
        repository.save(student);
        return "redirect:/";


    }

    */
    @GetMapping("/SQL/studentupdate/{id}")
    public String studentUpdate(@PathVariable("id") int id, Model model){
        model.addAttribute("student", repository.get(id));
        return "student";
    }
    @PostMapping("/SQL/studentupdate")
    public String studentUpdateSave(@Valid student student, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "student";

        }
        repository.save(student);
        return "redirect:index";



    }
    @GetMapping ("/SQL/studentdelete/{id}")
    public String studentDelete(@PathVariable("id") long id){
        repository.delete(id);
        return "redirct:index";

    }
     @RequestMapping(value="/get")
    public ResponseEntity<List<student>> getstudents(){
        return new ResponseEntity<>(repository.listAll(), HttpStatus.OK);


     }
     @RequestMapping(value="/get/{id}")
    public ResponseEntity<student> getstudent(@PathVariable long id){
        return new ResponseEntity<>(repository.get(id), HttpStatus.OK);
     }
     @RequestMapping(value="/delete", method = RequestMethod.POST)
    public ResponseEntity<Object> deletestudent(@RequestParam ("id") long id) {
        repository.delete(id);
        return new ResponseEntity<>("" + id+ " deleted", HttpStatus.OK);
     }
    @RequestMapping (value="/post", method = RequestMethod.POST)
    public String poststudent(@RequestParam ("studentId") int studentId,
                                              @RequestParam ("grade") int grade,
                                              @RequestParam ("name") String name){
        student student = new student(studentId, grade, name);
        repository.save(student);
        return "redirect:/student";
    }
    @RequestMapping (value="/update", method = RequestMethod.POST)
    public ResponseEntity<Object> updatestudent(@RequestParam ("id") int id,
                                                @RequestParam ("studentId") int studentId,
                                                @RequestParam ("grade") int grade,
                                                @RequestParam ("name") String name){
        repository.delete(id);
        student student = new student(studentId, grade, name);
        repository.save(student);
        return new ResponseEntity<>(studentId+" has been updated", HttpStatus.CREATED);
    }





}
