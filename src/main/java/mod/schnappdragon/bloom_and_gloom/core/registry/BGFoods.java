package mod.schnappdragon.bloom_and_gloom.core.registry;

import net.minecraft.item.Food;
import net.minecraft.potion.EffectInstance;

public class BGFoods {
    public static final Food SUGARED_KABLOOM_FRUIT = new Food.Builder().hunger(3).saturation(0.3F).effect(() -> new EffectInstance(BGEffects.BLAST_ENDURANCE.get(), 1800, 0), 1.0F).build();
}