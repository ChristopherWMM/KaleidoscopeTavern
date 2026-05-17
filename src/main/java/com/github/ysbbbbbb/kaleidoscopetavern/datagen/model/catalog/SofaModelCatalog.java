package com.github.ysbbbbbb.kaleidoscopetavern.datagen.model.catalog;

import com.github.ysbbbbbb.kaleidoscopetavern.init.ModBlocks;

import java.util.List;

public final class SofaModelCatalog {
    private static final List<BlockCatalogEntry> ENTRIES = List.of(
            new BlockCatalogEntry("white", ModBlocks.WHITE_SOFA),
            new BlockCatalogEntry("light_gray", ModBlocks.LIGHT_GRAY_SOFA),
            new BlockCatalogEntry("gray", ModBlocks.GRAY_SOFA),
            new BlockCatalogEntry("black", ModBlocks.BLACK_SOFA),
            new BlockCatalogEntry("brown", ModBlocks.BROWN_SOFA),
            new BlockCatalogEntry("red", ModBlocks.RED_SOFA),
            new BlockCatalogEntry("orange", ModBlocks.ORANGE_SOFA),
            new BlockCatalogEntry("yellow", ModBlocks.YELLOW_SOFA),
            new BlockCatalogEntry("lime", ModBlocks.LIME_SOFA),
            new BlockCatalogEntry("green", ModBlocks.GREEN_SOFA),
            new BlockCatalogEntry("cyan", ModBlocks.CYAN_SOFA),
            new BlockCatalogEntry("light_blue", ModBlocks.LIGHT_BLUE_SOFA),
            new BlockCatalogEntry("blue", ModBlocks.BLUE_SOFA),
            new BlockCatalogEntry("purple", ModBlocks.PURPLE_SOFA),
            new BlockCatalogEntry("magenta", ModBlocks.MAGENTA_SOFA),
            new BlockCatalogEntry("pink", ModBlocks.PINK_SOFA)
    );

    public static List<BlockCatalogEntry> entries() {
        return ENTRIES;
    }
}


