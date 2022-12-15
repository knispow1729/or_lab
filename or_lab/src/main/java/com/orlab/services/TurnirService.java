package com.orlab.services;

import com.orlab.model.Sponzori;
import com.orlab.model.Turniri;
import com.orlab.repository.SponzoriRepository;
import com.orlab.repository.TurniriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnirService {

    private final TurniriRepository turniriRepository;
    private final SponzoriRepository sponzoriRepository;

    @Autowired
    public TurnirService(TurniriRepository turniriRepository,SponzoriRepository sponzoriRepository) {
        this.turniriRepository = turniriRepository;
        this.sponzoriRepository = sponzoriRepository;
    }

    public List<Turniri> getAllTurniri(){
        return turniriRepository.findAll();
    }

    public List<Sponzori> getAllSponzori(){
        return sponzoriRepository.findAll();
    }

    public Optional<Turniri> getTurnirById(Integer IdTurnir){
        return Optional.ofNullable(turniriRepository.findByIdTurnir(IdTurnir));
    }

    public Optional<List<Turniri>> getTurnirByTip(String tip){
        return Optional.ofNullable(turniriRepository.findByTip(tip));
    }

    public Optional<List<Turniri>> getTurnirBySerija(String serija){
        return Optional.ofNullable(turniriRepository.findBySerija(serija));
    }
    public Optional<List<Turniri>> getTurnirByLokacija(String lokacija){
        return Optional.ofNullable(turniriRepository.findByLokacija(lokacija));
    }

    public Turniri createOrUpdate(Turniri turnir) throws TurnirException {
        try{
            return turniriRepository.save(turnir);
        } catch (Exception e){
            throw new TurnirException("Uneseni turnir s id "+turnir.getIdTurnir()+"vec postoji.");
        }
    }
    public Sponzori createOrUpdateSponzor(Sponzori sponzori) throws TurnirException {
        try{
            return sponzoriRepository.save(sponzori);
        } catch (Exception e){
            throw new TurnirException("Uneseni sponzori s id "+sponzori.getIdSponzor()+"nije moguce unesti.");
        }
    }
    public Optional<Sponzori> getSponzorById(Integer IdSponzor){
        return Optional.ofNullable(sponzoriRepository.findByIdSponzor(IdSponzor));
    }

    public void deleteSponzorFromRepo(Sponzori sponzor){
        sponzoriRepository.delete(sponzor);
    }

}
