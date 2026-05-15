package com.github.ysbbbbbb.kaleidoscopetavern.datamap.resources;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.datamap.data.DrinkEffectData;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.mojang.serialization.JsonOps;
import net.minecraft.resources.FileToIdConverter;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.Item;
import org.jspecify.annotations.NullMarked;

import java.util.Map;

@NullMarked
public class DrinkEffectDataReloadListener extends SimpleJsonResourceReloadListener<JsonElement> {
    public static final Map<Item, DrinkEffectData> INSTANCE = Maps.newHashMap();

    public DrinkEffectDataReloadListener() {
        super(ExtraCodecs.JSON, FileToIdConverter.json("datamap/drink_effect"));
    }

    @Override
    protected void apply(Map<Identifier, JsonElement> resources, ResourceManager resourceManager, ProfilerFiller profiler) {
        INSTANCE.clear();
        for (var entry : resources.entrySet()) {
            var result = DrinkEffectData.CODEC.parse(JsonOps.INSTANCE, entry.getValue());
            if (result.result().isPresent()) {
                DrinkEffectData data = result.result().get();
                INSTANCE.put(data.item().value(), data);
            } else if (result.error().isPresent()) {
                KaleidoscopeTavern.LOGGER.error("Failed to parse drink effect data from '{}': {}", entry.getKey(), result.error().get().message());
            }
        }
        KaleidoscopeTavern.LOGGER.info("Successfully loaded drink effect data with {} entries", INSTANCE.size());
    }
}
