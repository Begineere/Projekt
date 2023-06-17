package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

import static java.lang.Float.parseFloat;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private JuzersyRepository Repo;
    @Autowired
    private JuzersyService service;
    private int ID;

    @GetMapping(path = "/wybierz")
    public String WybierzPage(){
        return "wybierz";
    }
    @PostMapping(path = "/wybierz")
    public String klasa(Klasa Imie, Klasa Nazw, Klasa cena, Klasa date, Klasa ilosc, Klasa status){
        Juzersy juzer = null;
        if( null != Imie || Nazw != null || cena != null || date != null || ilosc != null) {
            Float Cena = cena.getCena() * ilosc.getIlosc();
            Long ml = Long.valueOf(status.getStatus() ? 1 : 0);
            juzer = new Juzersy(
                    Imie.getImie(),
                    Nazw.getNazw(),
                    ilosc.getCena(),
                    date.getDate(),
                    ilosc.getIlosc(),
                    Cena,
                    ml);
        }
        else return "/zle";
        Repo.save(juzer);
        return "/odbierz";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("klasa") Juzersy klasa) {
        service.save(klasa);

        return "redirect:/";
    }

    @GetMapping(path = "/")
    public ModelAndView findAll() {
        ModelAndView mav = new ModelAndView("lista");
        mav.addObject("juzer", Repo.findAll());

        return mav;
    }
    @GetMapping(path = "/zmien")
    public ModelAndView findAll2() {
        ModelAndView mav2 = new ModelAndView("zmien");
        mav2.addObject("Numerki2", Repo.findAll());

        return mav2;
    }
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete((long) id);
        return "redirect:/zmien";
    }
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Juzersy juzer = service.getJuzerById((long)id);
        mav.addObject("juzer", juzer);

        return mav;
    }
    @RequestMapping(value = "/edit2/{id}")
    public String changeStatus(@PathVariable(name = "id") int id) {
        service.changeStatus((long)id);
        return "redirect:/";
    }
    @GetMapping("/znajdz")
    public ModelAndView findOrder()
    {
        ModelAndView mav3 = new ModelAndView("znajdz");
        Juzersy juzer = new Juzersy();
        mav3.addObject( "juzer",  juzer);
        return mav3;
    }
    @RequestMapping ("/znajdzNazw/{nazw}")
    public ModelAndView showFindNazw(@RequestParam(name = "nazw") String nazw){
        ModelAndView mav = new ModelAndView("lista");
        List<Juzersy> juzer = service.findByNazw(nazw);
        mav.addObject("juzer", juzer);
        return mav;
    }

    @RequestMapping ("/znajdzID/{id}")
    public ModelAndView showFindID(@RequestParam(name = "id") long id){
        ModelAndView mav = new ModelAndView("lista");
        Juzersy juzer = service.getJuzerById(id);
        mav.addObject("juzer", juzer);
        return mav;
    }
    @RequestMapping ("/znajdzDZ/{DoZaplaty}")
    public ModelAndView showFindDoZaplaty(@RequestParam(name = "DoZaplaty") float DoZaplaty){
        ModelAndView mav = new ModelAndView("lista");
        List<Juzersy> juzer = service.findByDoZaplaty(DoZaplaty);
        mav.addObject("juzer", juzer);
        return mav;
    }
}
