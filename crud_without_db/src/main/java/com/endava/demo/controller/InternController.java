package com.endava.demo.controller;

        import com.endava.demo.entity.Intern;
        import com.endava.demo.service.InternService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import static com.endava.demo.entity.InternStreams.NET;


@Controller
public class InternController {

    static int helpId;
    @Autowired
    private InternService internService;

    @GetMapping("/newForm")
    public String secondView(Model model) {
        model.addAttribute("intern", new Intern("Serghei", 27, NET));
        return "newForm";
    }

    @PostMapping(value = "/newForm")
    public String fillForm(@ModelAttribute Intern intern) {
        internService.add(intern);
        return "redirect:/";
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteIntern(@PathVariable int id) {
        internService.remove(id);
        return "redirect:/";
    }


    @GetMapping("/update")
    public String update(@RequestParam("intern_id") int id, Model model, @ModelAttribute Intern intern) {

        Intern theIntern = internService.getObjectById(internService.getIdOfObjFromList(id));
        model.addAttribute("intern", theIntern);
        helpId = id;
        return "updateForm";
    }

    @PostMapping(value = "/updateR")
    public String update(Model model, @ModelAttribute Intern intern) {

        model.addAttribute("intern", intern);
        intern.setId(helpId);
        internService.update(intern, internService.getIdOfObjFromList(helpId));
        System.err.println(internService.getIdOfObjFromList(helpId));
        return "redirect:/";
    }
}
