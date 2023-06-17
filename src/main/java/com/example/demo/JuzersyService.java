package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@org.springframework.transaction.annotation.Transactional
public class JuzersyService {
    @Autowired
    private JuzersyRepository Repo;

    public List<Juzersy> listAll() {
        return Repo.findAll();
    }

    public Juzersy getJuzerById(Long id){
        return Repo.findById(id).get();
    }
    public List<Juzersy> findByNazw(String nazw){
        return Repo.findByNazw(nazw);
    }
    public List<Juzersy> findByDoZaplaty(Float DoZaplaty){
       return Repo.findByDoZaplaty(DoZaplaty);
    }
    public void delete(Long id){
        Repo.deleteById(id);
    }
    public void save(Juzersy klasa) {
        Juzersy juzer = Repo.findById(klasa.getId()).get();
        Float Cena = klasa.getCena() * klasa.getIlosc();
        juzer.setCena(klasa.getCena());
        juzer.setDate(klasa.getDate());
        juzer.setIlosc(klasa.getIlosc());
        juzer.setStatus(klasa.getStatus());
        juzer.setDoZaplaty(Cena);
    }
    public void changeStatus(Long id)
    {
        Juzersy juzer = Repo.findById(id).get();
        Long stat = juzer.getStatus();
        if(stat == 0) juzer.setStatus(1L);
        else juzer.setStatus(0L);
    }

}
