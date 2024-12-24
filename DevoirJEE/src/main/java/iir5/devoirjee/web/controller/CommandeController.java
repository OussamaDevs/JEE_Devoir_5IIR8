package iir5.devoirjee.web.controller;

import iir5.devoirjee.entity.Commande;
import iir5.devoirjee.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @GetMapping(path = "/commandes/index")
    public List<Commande> getAllCommandes() {
        return commandeService.getAll();
    }

    @PostMapping(path = "/commandes/save")
    public Commande saveCommande(@RequestBody Commande commande) {
        return commandeService.save(commande);
    }

    @PutMapping(path = "/commandes/update/{id}")
    public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long id) {
        return commandeService.update(id, commande);
    }

    @DeleteMapping(path = "/commandes/delete/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.delete(id);
    }
}
