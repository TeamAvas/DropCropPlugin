package skh6075.listener;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockCrops;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.item.Item;

import java.util.Arrays;
import java.util.List;

public class EventListener implements Listener {

    @EventHandler
    public void handleBlockBreak (BlockBreakEvent event){
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (!event.isCancelled()) {
            if (block instanceof BlockCrops) {
                if (block.getDamage() >= 0x07) {
                    Item[] drops = event.getDrops();
                    List <Item> dropItems = Arrays.asList(drops);
                    if (dropItems.toArray().length == 0) {
                        return;
                    }
                    for (int index = 0; index <= dropItems.toArray().length; index ++) {
                        if (player.getInventory().canAddItem(drops[index])) {
                            player.getInventory().addItem(drops[index]);
                            dropItems.remove(index);
                        }
                    }
                    event.setDrops((Item[]) dropItems.toArray());
                }
            }
        }
    }
}
