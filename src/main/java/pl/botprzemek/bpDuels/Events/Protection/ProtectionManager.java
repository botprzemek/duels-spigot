package pl.botprzemek.bpDuels.Events.Protection;

import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class ProtectionManager {

    private List<String> negateDamageCauses = new ArrayList<>();

    public ProtectionManager() {

        this.negateDamageCauses.add("FALL");

        this.negateDamageCauses.add("ENTITY_ATTACK");

        this.negateDamageCauses.add("ENTITY_SWEEP_ATTACK");

        this.negateDamageCauses.add("PROJECTILE");

        this.negateDamageCauses.add("ENTITY_EXPLOSION");

        this.negateDamageCauses.add("BLOCK_EXPLOSION");

    }

    public boolean canNegateDamage(EntityDamageEvent.DamageCause damageCause) {

        return !negateDamageCauses.contains(damageCause.name());

    }

}
