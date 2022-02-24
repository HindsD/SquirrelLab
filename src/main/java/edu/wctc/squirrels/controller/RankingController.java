package edu.wctc.squirrels.controller;

import edu.wctc.squirrels.entity.Ranking;
import edu.wctc.squirrels.entity.Sighting;
import edu.wctc.squirrels.entity.Squirrel;
import edu.wctc.squirrels.service.SquirrelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class RankingController {
    private SquirrelService squirrelService;

    @Autowired RankingController (SquirrelService sqs){
        this.squirrelService = sqs;
    }

    @PostMapping("/update")
    public String processSighting(Model model,
                                  @Valid @ModelAttribute Squirrel squirrel,
                                  BindingResult bindingResult) {
        Squirrel squ = squirrelService.getSquirrel(squirrel.getId());
        squ.setRanking(squirrel.getRanking());

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            model.addAttribute("pageTitle", "Ranking");
            model.addAttribute("squirrel", squirrelService.getSquirrel(squ.getId()));
            return "ranking";
        }

        squirrelService.updateSquirrel(squ);

        model.addAttribute("pageTitle", "Thank You!");
        model.addAttribute("squirrel", squirrelService.getSquirrel(squ.getId()));

        return "confirmation2";
    }

    @RequestMapping("/ranking")
    public String showSightingForm(Model model,
                                   @RequestParam("id") int squirrelId) {
        model.addAttribute("pageTitle", "Ranking");
        //model.addAttribute("squirrel", squirrelService.getSquirrel(squirrelId));

        Squirrel sq = squirrelService.getSquirrel(squirrelId);
        model.addAttribute("squirrel", sq);

        return "ranking";
    }

}
