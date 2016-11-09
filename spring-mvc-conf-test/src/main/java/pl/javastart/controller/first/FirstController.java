package pl.javastart.controller.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import pl.javastart.controller.second.SecondService;

@Controller
public class FirstController {
    
    @Autowired
    private FirstService service;
    
    @Autowired
    AnnotationConfigWebApplicationContext ctx;

    @GetMapping("/first")
    public String hello(Model model) {
        model.addAttribute("message", "FIRST " + service.getMessage());
        System.out.println(ctx);
        System.out.println(ctx.getParent());
        System.out.println(ctx.getBean(FirstService.class));
        System.out.println(ctx.getBean(SecondService.class));
        
        return "index";
    }
    
}
