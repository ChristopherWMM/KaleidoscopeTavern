package com.github.ysbbbbbb.kaleidoscopetavern.datagen.tag;

import com.github.ysbbbbbb.kaleidoscopetavern.KaleidoscopeTavern;
import com.github.ysbbbbbb.kaleidoscopetavern.init.ModItems;
import com.github.ysbbbbbb.kaleidoscopetavern.init.tag.TagCommon;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class TagItem extends ItemTagsProvider {
    public TagItem(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider) {
        super(pOutput, pLookupProvider, KaleidoscopeTavern.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(TagCommon.FRUITS_GRAPES).add(
                ModItems.GRAPE.get()
        );

        tag(TagCommon.FRUITS).add(
                ModItems.GRAPE.get(),
                ModItems.ICE_GRAPE.get(),
                ModItems.GOLD_GRAPE.get(),
                ModItems.GREEN_GRAPE.get()
        );
    }
}
