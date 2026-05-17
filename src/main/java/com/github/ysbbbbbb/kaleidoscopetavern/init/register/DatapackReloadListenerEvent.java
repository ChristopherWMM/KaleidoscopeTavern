package com.github.ysbbbbbb.kaleidoscopetavern.init.register;


import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.datamap.resources.DrinkEffectDataReloadListener;
import net.minecraft.resources.Identifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.AddServerReloadListenersEvent;

@EventBusSubscriber(modid = KaleidoscopeTavern.MOD_ID)
public class DatapackReloadListenerEvent {
    @SubscribeEvent
    public static void onAddReloadListenerEvent(AddServerReloadListenersEvent event) {
        event.addListener(Identifier.fromNamespaceAndPath(KaleidoscopeTavern.MOD_ID, "drink_effect_data"), new DrinkEffectDataReloadListener());
    }
}
