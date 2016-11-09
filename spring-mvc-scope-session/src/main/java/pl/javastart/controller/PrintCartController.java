package pl.javastart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.javastart.component.ShoppingCart;

@Controller
public class PrintCartController {

    private ShoppingCart cart;

    @Autowired
    public PrintCartController(ShoppingCart cart) {
        this.cart = cart;
    }

    @GetMapping("/print")
    public String printProducts() {
        for (String product : cart.getProducts()) {
            System.out.println(product);
        }
        return "index.jsp";
    }
}