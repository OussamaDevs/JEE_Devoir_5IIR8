package iir5.devoirjee.entity;

import iir5.devoirjee.repository.ICommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    @Autowired
    private ICommandeRepository commandeRepository; // Your repository for 'COMMANDE'

    @Override
    public Health health() {
        // Check if there are any commandes in the table
        long count = commandeRepository.count();
        if (count > 0) {
            return Health.up().withDetail("commandesCount", count).build();
        } else {
            return Health.down().withDetail("reason", "No commandes found").build();
        }
    }
}
