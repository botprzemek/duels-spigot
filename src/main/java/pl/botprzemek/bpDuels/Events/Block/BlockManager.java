package pl.botprzemek.bpDuels.Events.Block;

import org.bukkit.Material;
import org.bukkit.block.Block;

import java.util.HashSet;
import java.util.Set;

public class BlockManager {

    private Set<Material> allowedBlocks = new HashSet<>();

    public BlockManager() {

        allowedBlocks.add(Material.OAK_LEAVES);

    }

    public boolean canBreak(Block block) {

        return !allowedBlocks.contains(block.getType());

    }

}
