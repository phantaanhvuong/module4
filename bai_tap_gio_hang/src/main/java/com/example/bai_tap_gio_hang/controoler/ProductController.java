package com.example.bai_tap_gio_hang.controoler;

import com.example.bai_tap_gio_hang.model.Cart;
import com.example.bai_tap_gio_hang.model.Product;
import com.example.bai_tap_gio_hang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart initCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        return new ModelAndView("shop", "products", productService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(cart::addProduct);
        return action.equals("show") ? "redirect:/shopping-cart" : "redirect:/shop";
    }

    @GetMapping("/decrease/{id}")
    public String decreaseFromCart(@PathVariable Long id,
                                   @ModelAttribute("cart") Cart cart,
                                   @RequestParam("action") String action) {
        Optional<Product> product = productService.findById(id);
        product.ifPresent(prod -> {
            if (cart.getProducts().containsKey(prod)) {
                int quantity = cart.getProducts().get(prod);
                if (quantity > 1) {
                    cart.getProducts().put(prod, quantity - 1);
                } else {
                    cart.getProducts().remove(prod);
                }
            }
        });
        return action.equals("show") ? "redirect:/shopping-cart" : "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showProductDetail(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        return product.map(p -> new ModelAndView("detail", "product", p))
                .orElseGet(() -> new ModelAndView("error_404"));
    }

    @GetMapping("/checkout")
    public String checkout(@SessionAttribute("cart") Cart cart) {
        cart.getProducts().clear();
        return "redirect:/shop?checkout=success";
    }
}
