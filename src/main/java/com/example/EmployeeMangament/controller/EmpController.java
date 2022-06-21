package com.example.EmployeeMangament.controller;

import com.example.EmployeeMangament.entity.Employee;
import com.example.EmployeeMangament.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    private EmpService service;
    @GetMapping("/")
    public List<Employee> home(Model m)
    {
        List<Employee> emp =service.getAllEmp();
//        System.out.println(emp + " <- emp");
//        m.addAttribute("emp",emp);
//        return "index";
        return emp;
    }

    @GetMapping("/create")
    public List<Employee> employee() {
        Employee employee = new Employee();
        employee.setName("Mitesh");
        employee.setSalary(3400);
        employee.setEmail("mitesh@gmail.com");
        employee.setAddress("Mowa");
        employee.setId(1);
        employee.setPhno("999900988");

        this.service.addEmp(employee);
        return this.service.getAllEmp();
    }

//    @GetMapping("/{empId}")
//    public Employee getEmp(@PathVariable int empId){
//        return this.service.getEmpById(empId);
//    }
//    @GetMapping("/addemp")
//    public String addEmpForm()
//    {
//        return "add_emp";
//    }
//
//    public String edit(@PathVariable int id,Model m){
//        Employee e = service.getEmpById(id);
//        m.addAttribute("emp",e);
//        return "edit";
//    }
//
//    @PostMapping("/update")
//    public String updateEmp(@ModelAttribute Employee e, HttpSession session)
//    {
//        service.addEmp(e);
//        session.setAttribute("msg","Emp Data Update Sucessfully..");
//        return "redirect:/";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteEmp(@PathVariable int id, HttpSession session)
//    {
//        service.deleteEmp(id);
//        session.setAttribute(
//                "msg","Emp Data Deleted Sucessfully.."
//        );
//        return "redirect:/";
//    }


}
