package com.example.studentmanagement.controller;

import com.example.studentmanagement.entity.AClass;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.IClassService;
import com.example.studentmanagement.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService productService;
    @Autowired
    private IClassService typeService;
    @ModelAttribute("typeList")
    private List<AClass> getAllType(){
        return typeService.findAll();
    }
    @GetMapping("")
    public String showList(@RequestParam(required = false,defaultValue = "0")int page,
                           @RequestParam(required = false,defaultValue = "5")int size,
                           @RequestParam(required = false,defaultValue = "") String name,
                           @RequestParam(required = false,defaultValue = "") String nameType,
                           Model model){
        Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable = PageRequest.of(page,size,sort);
        Page<Student> studentPage = productService.search(name,nameType,pageable);
        model.addAttribute("name", name);
        model.addAttribute("nameType",nameType);
        model.addAttribute("studentPage",studentPage);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute Student student ,BindingResult bindingResult , RedirectAttributes redirectAttributes, Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("student", student);
            return "create";
        }
        productService.add(student);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/students";

    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model){
        Optional<Student> student = productService.findById(id);
        if (student.isPresent()){
            model.addAttribute("student", student.get());
            return "update";
        }else {
            redirectAttributes.addFlashAttribute("success","không tìm thấy đối tượng cần sửa");
            return "redirect:/students";
        }
    }
    @PostMapping("/{id}/edit")
    public String processEdit(@Validated @ModelAttribute Student student , BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
            return "update";
        }
        if(productService.findById(id).isEmpty()) {
            model.addAttribute("errors", "Không tìm thấy đối tuọng cần sửa");
            return "update";
        }
        productService.edit(student,id);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/students";

    }
    @PostMapping("/delete")
    public String delete(Student student, RedirectAttributes redirectAttributes){
        productService.deleteById(student.getId());
        redirectAttributes.addFlashAttribute("success", "xoá thành công");
        return "redirect:/students";
    }

    @GetMapping("/detail/{id}")
    public  String detail(@PathVariable(name = "id") Long id, Model model){
        Optional<Student> student = productService.findById(id);
        model.addAttribute("student", student);
        return "view";
    }

}
