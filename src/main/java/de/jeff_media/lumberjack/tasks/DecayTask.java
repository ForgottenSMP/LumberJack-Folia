package de.jeff_media.lumberjack.tasks;

import de.jeff_media.lumberjack.LumberJack;
import de.jeff_media.lumberjack.utils.DecayUtils;
import de.jeff_media.lumberjack.utils.FoliaScheduler;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.Collection;
import java.util.Random;

public class DecayTask {

    private static final LumberJack plugin = LumberJack.getInstance();
    private static final Random rand = new Random();
    private final Collection<Block> leaves;

    public DecayTask(BlockState leaf) {
        this.leaves = DecayUtils.getLeaves(leaf);
    }

    public void schedule() {
        try {
            int maxDelay = Math.max(1, (int) Math.round(plugin.getConfig().getDouble("fast-leaves-decay-duration") * 20D));
            for (Block leaf : leaves) {
                FoliaScheduler.runAtBlockLater(plugin, leaf, rand.nextInt(maxDelay), () -> {
                    if (DecayUtils.isLeaf(leaf)) {
                        leaf.breakNaturally();
                    }
                });
            }
        } finally {
            plugin.finishDecayTask();
        }
    }
}
