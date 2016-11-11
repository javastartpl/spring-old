package pl.javastart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.javastart.data.TimeDataRepository;
import pl.javastart.model.TimeData;

@Controller
public class TimeDataController {

    private TimeDataRepository timeDataRepository;

    @Autowired
    public TimeDataController(TimeDataRepository timeDataRepository) {
        super();
        this.timeDataRepository = timeDataRepository;
    }

    @PostMapping("/save")
    public String saveTime(@ModelAttribute TimeData timeData) {
        timeDataRepository.save(timeData);
        return "redirect:/";
    }

    @GetMapping("/show")
    public String showAll(Model model) {
        List<TimeData> allTimes = timeDataRepository.findAll();
        model.addAttribute("allTimes", allTimes);
        return "showall";
    }

}