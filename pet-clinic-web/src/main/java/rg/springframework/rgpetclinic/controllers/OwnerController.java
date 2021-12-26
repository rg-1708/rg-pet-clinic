package rg.springframework.rgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import rg.springframework.rgpetclinic.services.OwnerService;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners", "/owners/index", "/owners/index.html"})
    public String listVets(Model model)
    {
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";
    }

}
