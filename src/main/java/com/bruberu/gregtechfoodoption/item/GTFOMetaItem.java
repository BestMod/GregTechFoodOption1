package com.bruberu.gregtechfoodoption.item;

import com.bruberu.gregtechfoodoption.GTFOConfig;
import gregtech.api.items.materialitem.MaterialMetaItem;
import gregtech.api.items.metaitem.FoodStats;
import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.util.RandomPotionEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.Loader;

import java.awt.*;

import static net.minecraft.potion.Potion.getPotionById;


public class GTFOMetaItem extends MaterialMetaItem {
    public GTFOMetaItem()
    {
        super();
    }

    public static MetaItem<?>.MetaValueItem POPCORN_BAG;
    public static MetaItem<?>.MetaValueItem PAPER_BAG;
    public static MetaItem<?>.MetaValueItem FLAVORED_POPCORN_FLAKE;
    public static MetaItem<?>.MetaValueItem POPCORN_COB;
    public static MetaItem<?>.MetaValueItem DRIED_POPCORN_EAR;
    public static MetaItem<?>.MetaValueItem POPCORN_EAR;
    public static MetaItem<?>.MetaValueItem PHYCOMYCES_BLAKESLEEANUS_CULTURE;

    public static MetaItem<?>.MetaValueItem EIGHT_SMORE;
    public static MetaItem<?>.MetaValueItem SIXTEEN_SMORE;
    public static MetaItem<?>.MetaValueItem THIRTY_TWO_SMORE;
    public static MetaItem<?>.MetaValueItem SIXTY_FOUR_SMORE;
    public static MetaItem<?>.MetaValueItem SMOGUS;
    public static MetaItem<?>.MetaValueItem MORE_SMOGUS;
    public static MetaItem<?>.MetaValueItem FOUR_SMOGUS;
    public static MetaItem<?>.MetaValueItem HEART_SMOGUS;


    @Override
    public void registerSubItems()
    {
        PAPER_BAG = addItem(1, "component.bag");
        FLAVORED_POPCORN_FLAKE = addItem(2, "component.popcorn.flavored_flake");
        POPCORN_COB = addItem(3, "component.popcorn.cob");
        DRIED_POPCORN_EAR = addItem(4, "component.popcorn.dried_ear");
        POPCORN_EAR = addItem(5, "component.popcorn.ear");
        PHYCOMYCES_BLAKESLEEANUS_CULTURE = addItem(6, "phycomyces.culture");
        POPCORN_BAG = addItem(0, "food.popcorn_bag").addComponents(new FoodStats(GTFOConfig.GTFOFoodConfig.popcornHunger, GTFOConfig.GTFOFoodConfig.popcornSaturaion, false, true, PAPER_BAG.getStackForm(), new RandomPotionEffect(getPotionById(10), 15, 1, 100)));

        if(Loader.isModLoaded("nuclearcraft") && GTFOConfig.GTFONCConfig.addSmogus)
        {
            int heal = 44;
            double saturation = 8.6;
            int potionDuration = 1200;
            int metaValue = 100;

            MetaItem<?>.MetaValueItem[] smores = {EIGHT_SMORE, SIXTEEN_SMORE, THIRTY_TWO_SMORE, SIXTY_FOUR_SMORE, SMOGUS, MORE_SMOGUS, FOUR_SMOGUS, HEART_SMOGUS};
            String[] smoreStrings = {"smore.eight", "smore.sixteen", "smore.thirtytwo", "smore.sixtyfour", "smore.gusone", "smore.gustwo", "smore.gusfour", "smore.heartofthesmogus"};

            for (int i = 0; i < smores.length; i++) {
                heal = (heal * 2) + 4;
                saturation = (saturation * 2) + 1;
                potionDuration = (int)(((float)potionDuration) * 1.25);
                int potionStrength = (int)((int)(Math.pow(2,(((double)i)+8)))/Math.pow((((double)i)+8), 2));

                smores[i] = addItem(metaValue, smoreStrings[i]).addComponents(new FoodStats(heal, (float) saturation, false, true, ItemStack.EMPTY,
                        new RandomPotionEffect(getPotionById(1), potionDuration, potionStrength, 2 * i),
                        new RandomPotionEffect(getPotionById(22), potionDuration, potionStrength, 2 * i),
                        new RandomPotionEffect(getPotionById(3), potionDuration, potionStrength, 2 * i),
                        new RandomPotionEffect(getPotionById(23), potionDuration, potionStrength, 2 * i),
                        new RandomPotionEffect(getPotionById(21), potionDuration, potionStrength, 2 * i)));
                metaValue++;
            }

            EIGHT_SMORE = smores[0];
            SIXTEEN_SMORE = smores[1];
            THIRTY_TWO_SMORE = smores[2];
            SIXTY_FOUR_SMORE = smores[3];
            SMOGUS = smores[4];
            MORE_SMOGUS = smores[5];
            FOUR_SMOGUS = smores[6];
            HEART_SMOGUS = smores[7];

        }
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }
}
