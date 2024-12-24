package iir5.devoirjee.service;

import iir5.devoirjee.entity.Commande;
import iir5.devoirjee.repository.ICommandeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {
    @Autowired
    private ICommandeRepository commandeRepository;

    public List<Commande> getAll(){
        return commandeRepository.findAll();
    }

    public Optional<Commande> getById(Long id){
        return commandeRepository.findById(id);

    }

    public Commande save(Commande commande){
        return commandeRepository.save(commande);
    }

    public Commande update(Long id, Commande commande) {
        Optional<Commande> existingCommande = commandeRepository.findById(id);
        if (existingCommande.isPresent()) {
            return commandeRepository.save(commande);
        } else {
            throw new IllegalArgumentException("Commande with ID " + id + " does not exist");
        }
    }

    public void delete(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Commande with ID " + id + " does not exist");
        }
    }
}
