package iir5.devoirjee.web.controller;

import iir5.devoirjee.entity.Commande;
import iir5.devoirjee.service.CommandeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
@RefreshScope
public class CommandeController {
    @Autowired
    private CommandeService commandeService;

    @Value("${mes-config-ms.commandes-last}")
    private int commandesLast;

    @PostConstruct
    public void init() {
        System.out.println("Commandes Last: " + commandesLast);
    }

    @GetMapping("/commandesLast")
    public String getCommandesLast() {
        return "Commandes Last: " + commandesLast;
    }

    @GetMapping(path = "/index")
    public List<Commande> getAllCommandes() {
        return commandeService.getAll();
    }

    @PostMapping(path = "/save")
    public Commande saveCommande(@RequestBody Commande commande) {
        System.out.println("Commande data: " + commande.getDescription());
        System.out.println("Commande data: " + commande.getDate());
        System.out.println("Commande data: " + commande.getMontant());
        System.out.println("Commande data: " + commande.getQuantity());

        return commandeService.save(commande);
    }

    @PutMapping(path = "/update/{id}")
    public Commande updateCommande(@RequestBody Commande commande, @PathVariable Long id) {
        return commandeService.update(id, commande);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteCommande(@PathVariable Long id) {
        commandeService.delete(id);
    }
}
