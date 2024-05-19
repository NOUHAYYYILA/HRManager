package com.example.demo.web;

import com.example.demo.dao.entities.Employee;
import com.example.demo.service.EmployeeManager;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeManager employeeManager;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("")
    public String start() {
        return "redirect:indexpage";
    }

    @PostMapping("/ajouter")
    public String ajouterProduitAction(Model model,
                                       @RequestParam(name = "id", defaultValue =  "") Integer id,
                                       @RequestParam(name = "nom") String nom,
                                       @RequestParam(name = "prenom") String prenom,
                                       @RequestParam(name = "position")String position,
                                       @RequestParam(name = "adress") String adress){
        Employee employee = new Employee(id,position,nom ,prenom ,adress);
        employeeManager.addEmployee(employee);
        return "redirect:indexpage";
    }

    @PostMapping("/ajouterOnce")
    public String ajouterEmployee(Model model,
                                 @Valid Employee employee,
                                 BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "ajouteremployee" ;
        }
        employeeManager.addEmployee(employee);
        return "redirect:indexpage";
    }

    @GetMapping("/ajouterEmployee")
    public String ajouteremployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "ajouteremployee";
    }


    @GetMapping("/indexpage")
    public String listEmployees(Model model,
                               @RequestParam(name = "page", defaultValue = "0") int page,
                               @RequestParam(name = "taille", defaultValue = "6") int taille,
                               @RequestParam(name = "search", defaultValue = "") String keyword
    ) {
        Page<Employee> employees = employeeManager.searchEmployee(keyword, page, taille);
        model.addAttribute("listEmployees", employees.getContent());
        int[] pages = new int[employees.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        return "indexlayout";
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(Model model, @RequestParam(name = "id") Integer id) {
        if (employeeManager.deleteEmployee(id)) {
            return "redirect:/indexpage";
        } else {
            return "error";
        }
    }


    @GetMapping("/editEmployee")
    public String editEmployee(Model model, @RequestParam(name = "id") Integer id) {
       Employee employee  = employeeManager.getEmployeeById(id);
        if (employee != null) {
            model.addAttribute("EmployeeToBeUpdated", employee);
            return "updateEmployee";
        } else {
            return "error";
        }
    }
}



