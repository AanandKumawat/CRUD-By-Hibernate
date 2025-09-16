package com.controller;

import com.model.StudentForm;
import com.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class StudentController {
//   @Autowired
//  private StudentForm studentForm;
//  @Autowired
// private StudentDAO2 studentDAO2;

@Autowired
StudentServiceImpl studentService;

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String login() {
        System.out.println("in login control ");
        return "forward:/login.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password) {

        System.out.println("login success" + email + " " + password);
        if (email == null || email.isEmpty()) {
            return "forward:/login.jsp";
        }
        if (email.equals("aanandkumawat@gmail.com") && password.equals("12345")) {
            System.out.println("validitation is complete");
            return "studentForm";
        } else {
            return "forward:/login.jsp";
        }
    }

    @RequestMapping(value = "/submit_form", method = RequestMethod.POST)
    public String saveStudent(StudentForm studentForm, ModelMap modelMap) throws Exception {
        System.out.println("before inter check");

        System.out.println("before student insert check " + studentForm);

        studentService.insertStudent(studentForm);

        System.out.println("data inserted successfully");
        return "studentForm";

    }

    @RequestMapping(value = "/getAllStudents", method = RequestMethod.GET)
    public String getAllStudent(ModelMap modelMap) throws Exception {


        System.out.println("before getting students");
        List<StudentForm> students = studentService.getAllStudents();
        modelMap.addAttribute("students", students);


        return "studentList";


    }

    @RequestMapping(value = "/updateStudentButton", method = RequestMethod.POST)
    public String updateStudentButton(@RequestParam("id") Integer id, ModelMap modelMap) throws Exception {
        System.out.println("updated student id " + id);
        StudentForm student = studentService.getStudent(id);
        System.out.println("after getting student which is updated"
        );
        modelMap.addAttribute("student", student);
        return "editStudent";

    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public String updateStudent(StudentForm studentForm) throws Exception {
        System.out.println("before student update");
        System.out.println(studentForm);
        studentService.updateStudent(studentForm);
        System.out.println("student update successfully");
        return "redirect:/getAllStudents";
    }

    @RequestMapping(value = "/deleteStudentButton", method = RequestMethod.POST)
    public String deleteStu(@RequestParam("id") Integer id, ModelMap modelMap) throws Exception {
        System.out.println("updated hone vale student ki id" + id);
        StudentForm studentForm = studentService.getStudent(id);
        System.out.println("get student jo delete krna hee" + studentForm);
        System.out.println("before student delete");
        studentService.deleteStudent(id);
        System.out.println("student was deleted");
        return "redirect:/getAllStudents";
    }
}
