package skh6075;

import cn.nukkit.plugin.PluginBase;
import skh6075.listener.EventListener;

public class DropCropPlugin extends PluginBase {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }
}
