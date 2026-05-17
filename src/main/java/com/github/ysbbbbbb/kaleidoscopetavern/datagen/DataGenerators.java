package com.github.ysbbbbbb.kaleidoscopetavern.datagen;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.datamap.DataMapGenerator;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.datamap.DrinkEffectDataProvider;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.loottable.LootTableGenerator;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.misc.ParticleDescriptionGenerator;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.misc.SoundDefinitionsGenerator;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.model.ModModelProvider;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.recipe.ModRecipeGenerator;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.tag.TagBlock;
import com.github.ysbbbbbb.kaleidoscopetavern.datagen.tag.TagItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = KaleidoscopeTavern.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherDataClient(GatherDataEvent.Client event) {
        var generator = event.getGenerator();
        var registries = event.getLookupProvider();
        var pack = generator.getPackOutput();

        generator.addProvider(true, new ModModelProvider(pack));
        event.createProvider(ParticleDescriptionGenerator::new);

        generator.addProvider(true, new LootTableGenerator(pack, registries));

        generator.addProvider(true, new DrinkEffectDataProvider(pack));

        generator.addProvider(true, new DataMapGenerator(pack, registries));

        event.createProvider(SoundDefinitionsGenerator::new);

        event.createBlockAndItemTags(TagBlock::new,
                (output, lookup, blockTags) -> new TagItem(output, lookup)
        );

        event.createProvider(ModRecipeGenerator.Runner::new);
    }
}
