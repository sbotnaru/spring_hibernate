package com.endava.demo.controller;

import com.endava.demo.entity.Intern;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.endava.demo.entity.InternStreams.JAVA;
import static com.endava.demo.entity.InternStreams.NET;


@Controller
public class InternController {

    static int helpId;
    @Autowired
    private InternService internService;

    @GetMapping("/newForm")
    public String secondView(Model model) {
        model.addAttribute("intern", new Intern("Serghei", 27, JAVA));
        return "newForm";
    }

    @PostMapping(value = "/newForm")
    public String fillForm(@ModelAttribute Intern intern) {
        System.err.println(intern);
        internService.add(intern);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteIntern(@PathVariable int id) {
        internService.remove(id);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String update(@RequestParam("intern_id") int id, Model model) {

        Intern theIntern = internService.getObjectById(id);

        model.addAttribute("intern", theIntern);
        helpId = id;
        return "updateForm";
    }

    @PostMapping(value = "/updateR")
    public String update(Model model, @ModelAttribute Intern intern) {
        Intern theIntern = internService.getObjectById(helpId);
        System.err.println("UpdateR:" + theIntern);
        System.err.println(intern);

        model.addAttribute("intern", intern);
        System.err.println(intern);
        internService.update(intern, helpId);
        return "redirect:/";
    }
}
