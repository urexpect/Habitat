package mod.schnappdragon.habitat.common.item.crafting;

import mod.schnappdragon.habitat.common.item.FairyRingMushroomItem;
import mod.schnappdragon.habitat.core.registry.HabitatItems;
import mod.schnappdragon.habitat.core.registry.HabitatRecipeSerializers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SuspiciousStewItem;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import org.apache.commons.lang3.tuple.Pair;

public class FairyRingMushroomSuspiciousStewRecipe extends CustomRecipe {
    public FairyRingMushroomSuspiciousStewRecipe(ResourceLocation idIn) {
        super(idIn);
    }

    @Override
    public boolean matches(CraftingContainer inv, Level worldIn) {
        boolean brown = false;
        boolean red = false;
        boolean fairy = false;
        boolean bowl = false;

        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack itemstack = inv.getItem(i);
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() == Blocks.BROWN_MUSHROOM.asItem() && !brown)
                    brown = true;
                else if (itemstack.getItem() == Blocks.RED_MUSHROOM.asItem() && !red)
                    red = true;
                else if (itemstack.getItem() == HabitatItems.FAIRY_RING_MUSHROOM.get() && !fairy)
                    fairy = true;
                else if (itemstack.getItem() == Items.BOWL && !bowl)
                    bowl = true;
                else
                    return false;
            }
        }

        return brown && red && fairy && bowl;
    }

    @Override
    public ItemStack assemble(CraftingContainer inv) {
        Pair<MobEffect, Integer> effect = FairyRingMushroomItem.getStewEffect();

        ItemStack stew = new ItemStack(Items.SUSPICIOUS_STEW, 1);
        SuspiciousStewItem.saveMobEffect(stew, effect.getLeft(), effect.getRight());
        return stew;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= 2 && height >= 2;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HabitatRecipeSerializers.CRAFTING_SPECIAL_FAIRYRINGMUSHROOMSUSPICIOUSSTEW.get();
    }
}
