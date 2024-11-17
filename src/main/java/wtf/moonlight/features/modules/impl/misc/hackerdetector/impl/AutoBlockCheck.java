package wtf.moonlight.features.modules.impl.misc.hackerdetector.impl;

import net.minecraft.entity.player.EntityPlayer;
import wtf.moonlight.events.impl.packet.PacketEvent;
import wtf.moonlight.features.modules.impl.misc.hackerdetector.Check;

public class AutoBlockCheck extends Check {
    private int blockingTime;

    @Override
    public String getName() {
        return "Auto Block";
    }

    @Override
    public void onPacketReceive(PacketEvent event, EntityPlayer player) {

    }

    @Override
    public void onUpdate(EntityPlayer player) {
        if (player.isBlocking()) ++blockingTime;
        else blockingTime = 0;
        if (blockingTime > 5 && player.isSwingInProgress) {
            flag(player, "Swing when using item or blocking");
        }
    }
}
