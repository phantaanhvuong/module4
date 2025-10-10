package com.example.quan_ly_heo.controller;

import com.example.quan_ly_heo.entity.Product;
import com.example.quan_ly_heo.entity.Type;
import com.example.quan_ly_heo.repository.ITypeRepository;
import com.example.quan_ly_heo.service.IProductService;
import com.example.quan_ly_heo.service.ITypeService;
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
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ITypeService typeService;
    @ModelAttribute("typeList")
    private List<Type> getAllType(){
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
        Page<Product> productPage = productService.search(name,nameType,pageable);
        model.addAttribute("name", name);
        model.addAttribute("nameType",nameType);
        model.addAttribute("productPage",productPage);
        return "index";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute Product product ,BindingResult bindingResult , RedirectAttributes redirectAttributes, Model model){

        if (bindingResult.hasErrors()) {
            model.addAttribute("product", product);
            return "create";
        }
        productService.add(product);
        redirectAttributes.addFlashAttribute("success", "Thêm mới thành công");
        return "redirect:/products";

    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id, RedirectAttributes redirectAttributes, Model model){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()){
            model.addAttribute("product", product.get());
            return "update";
        }else {
            redirectAttributes.addFlashAttribute("success","không tìm thấy đối tượng cần sửa");
            return "redirect:/products";
        }
    }
    @PostMapping("/{id}/edit")
    public String processEdit(@Validated @ModelAttribute Product product , BindingResult bindingResult,
                              RedirectAttributes redirectAttributes, Model model, @PathVariable Long id) {
        if(bindingResult.hasErrors()) {
//            model.addAttribute("errors", bindingResult.getAllErrors());
            return "update";
        }
        if(productService.findById(id).isEmpty()) {
            model.addAttribute("errors", "Không tìm thấy đối tuọng cần sửa");
            return "update";
        }
        productService.edit(product,id);
        redirectAttributes.addFlashAttribute("success", "Cập nhật thành công");
        return "redirect:/products";

    }
    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        productService.deleteById(product.getId());
        redirectAttributes.addFlashAttribute("success", "xoá thành công");
        return "redirect:/products";
    }

    @GetMapping("/detail/{id}")
    public  String detail(@PathVariable(name = "id") Long id, Model model){
        Optional<Product> product = productService.findById(id);
        model.addAttribute("product", product);
        return "view";
    }

}
