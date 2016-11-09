package pl.javastart.controller.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import pl.javastart.controller.first.FirstService;

@Controller
public class SecondController {
    
    @Autowired
    private FirstService service;
    
    @Autowired
    AnnotationConfigWebApplicationContext ctx;

    @GetMapping("/second")
    public String hello(Model model) {
        model.addAttribute("message", "SECOND " + service.getMessage());
        System.out.println(ctx);
        System.out.println(ctx.getParent());
        System.out.println(ctx.getBean(FirstService.class));
        System.out.println(ctx.getBean(SecondService.class));
        return "index";
    }
    
}
