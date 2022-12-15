package com.orlab.controllers;

import com.orlab.model.Sponzori;
import com.orlab.model.Turniri;
import com.orlab.services.ResponseHandler;
import com.orlab.services.TurnirException;
import com.orlab.services.TurnirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class TurnirRestController {

    @Autowired
    TurnirService turnirService;

    @GetMapping("/turniri")
    public List<Turniri> getTurnirs(){
        return turnirService.getAllTurniri();
    }
    @GetMapping("/sponzori")
    public List<Sponzori> getSponzors(){
        return turnirService.getAllSponzori();
    }

    @GetMapping("/api/v1/turniri")
    public ResponseEntity<?> getTurniri(){
        return ResponseHandler.generateResponse("Fetched turnirs", HttpStatus.OK, turnirService.getAllTurniri());
    }

    @GetMapping("/api/v1/turniri/{IdTurnir}")
    public ResponseEntity<?> getOneTurnir(@PathVariable Integer IdTurnir){

        Optional<Turniri> turnir= turnirService.getTurnirById(IdTurnir);
        if (turnir.isEmpty()){
            return ResponseHandler.generateResponse("Could not find turnir with id "+IdTurnir,HttpStatus.NOT_FOUND, null);
        }
        else{
            return ResponseHandler.generateResponse("Fetched turnir", HttpStatus.OK, turnir.get());
        }
    }

    @GetMapping("/api/v1/tip/{tip}")
    public ResponseEntity<?> getByTip(@PathVariable String tip){

        Optional<List<Turniri>> turnir= turnirService.getTurnirByTip(tip);
        if (turnir.isEmpty() || turnir.get().isEmpty()){
            return ResponseHandler.generateResponse("Could not find turnir with tip "+tip,HttpStatus.NOT_FOUND, null);
            //return new ResponseEntity<>("Could not find turnir with tip "+tip, HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseHandler.generateResponse("Fetched turnir with entered type", HttpStatus.OK, turnir.get());
            //return new ResponseEntity<>(turnir, HttpStatus.OK);
        }
    }

    @GetMapping("/api/v1/serija/{serija}")
    public ResponseEntity<?> getBySerija(@PathVariable String serija){

        Optional<List<Turniri>> turnir= turnirService.getTurnirBySerija(serija);
        if (turnir.isEmpty() || turnir.get().isEmpty()){
            return ResponseHandler.generateResponse("Could not find serija with name "+serija, HttpStatus.NOT_FOUND, null);
            //return new ResponseEntity<>("Could not find serija with name "+serija, HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseHandler.generateResponse("Fetched turnir with entered serija", HttpStatus.OK, turnir.get());
            //return new ResponseEntity<>(turnir, HttpStatus.OK);
        }
    }

    @GetMapping("/api/v1/lokacija/{lokacija}")
     public ResponseEntity<?> getByLokacija(@PathVariable String lokacija){
        Optional<List<Turniri>> turnir= turnirService.getTurnirByLokacija(lokacija);

        if (turnir.isEmpty() || turnir.get().isEmpty()){
            return ResponseHandler.generateResponse("Could not find lokacija with name "+lokacija, HttpStatus.NOT_FOUND, null);
            //return new ResponseEntity<>("Could not find lokacija with name "+lokacija, HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseHandler.generateResponse("Fetched turnir with entered lokacija", HttpStatus.OK, turnir.get());
            //return new ResponseEntity<>(turnir, HttpStatus.OK);
        }
    }

    @PostMapping("/api/v1/sponzori")
    public ResponseEntity<?> newSponzori(@RequestBody Sponzori sponzor) throws TurnirException {
        if(sponzor.getNaziv() == null || sponzor.getIznos()==null || sponzor.getIdSponzor()==null){
            return ResponseHandler.generateResponse("Sponzor must have Naziv and Iznos and IdSponzor",HttpStatus.BAD_REQUEST, null);
            //return new ResponseEntity<>("Sponzor must have Naziv and Iznos", HttpStatus.BAD_REQUEST);
        }
        Sponzori sponzori = turnirService.createOrUpdateSponzor(sponzor);
        return ResponseHandler.generateResponse("Entered new item sponzor", HttpStatus.CREATED, sponzori);
        //return new ResponseEntity<Sponzori>(sponzori, HttpStatus.CREATED);
    }

    @PutMapping("/api/v1/sponzori/{IdSponzor}")
    public ResponseEntity<?> refreshTurnir(@RequestBody Sponzori sponzor, @PathVariable Integer IdSponzor){

        if(turnirService.getSponzorById(IdSponzor).isEmpty()){
            return ResponseHandler.generateResponse("Sponzor with id " + IdSponzor+ " does not exist.",HttpStatus.NOT_FOUND, null);
            //return new ResponseEntity<>("Sponzor with id " + IdSponzor+ " does not exist.", HttpStatus.NOT_FOUND);
        }
        if(sponzor.getNaziv() == null || sponzor.getIznos()==null ){
            return ResponseHandler.generateResponse("Sponzor must have Naziv and Iznos", HttpStatus.BAD_REQUEST, null);
            //return new ResponseEntity<>("Sponzor must have Naziv and Iznos", HttpStatus.BAD_REQUEST);
        }
        Sponzori s =  turnirService.getSponzorById(IdSponzor)
                .map(spon ->{
                    spon.setNaziv(sponzor.getNaziv());
                    spon.setIznos(sponzor.getIznos());
                    try {
                        return turnirService.createOrUpdateSponzor(spon);
                    } catch (TurnirException e) {
                        e.printStackTrace();
                    }
                    return spon;
                })
                .orElseGet(()->{
                    sponzor.setIdSponzor(IdSponzor);
                    try {
                        return turnirService.createOrUpdateSponzor(sponzor);
                    } catch (TurnirException e) {
                        e.printStackTrace();
                    }
                    return sponzor;
                });
        return ResponseHandler.generateResponse("Updated sponzor", HttpStatus.CREATED, s);
        //return new ResponseEntity<Sponzori>(s, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/sponzori/{IdSponzor}")
    public ResponseEntity<?> deleteSponzor(@PathVariable Integer IdSponzor){
        Optional<Sponzori> sponzor = turnirService.getSponzorById(IdSponzor);
        if(sponzor.isEmpty()) {
            return ResponseHandler.generateResponse("Sponzor with id " + IdSponzor + " does not exist.", HttpStatus.NOT_FOUND, null);
            //return new ResponseEntity<>("Sponzor with id " + IdSponzor + " does not exist.", HttpStatus.NOT_FOUND);
        }
        else{
            turnirService.deleteSponzorFromRepo(sponzor.get());
            return ResponseHandler.generateResponse("Deleted sponzor with id "+IdSponzor, HttpStatus.OK, null);
            //return new ResponseEntity<>("Deleted sponzor with id "+IdSponzor, HttpStatus.OK);
        }

    }

}
