package mod.schnappdragon.habitat.common.levelgen.placement;

import com.mojang.serialization.Codec;
import mod.schnappdragon.habitat.core.registry.HabitatPlacementModifierTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.Random;

public class SlimeChunkFilter extends PlacementFilter {
    private static final SlimeChunkFilter FILTER = new SlimeChunkFilter();
    public static Codec<SlimeChunkFilter> CODEC = Codec.unit(() -> FILTER);

    public static SlimeChunkFilter filter() {
        return FILTER;
    }

    protected boolean shouldPlace(PlacementContext context, Random random, BlockPos pos) {
        return WorldgenRandom.seedSlimeChunk(pos.getX() >> 4, pos.getZ() >> 4, context.getLevel().getSeed(), 987234911L).nextInt(10) == 0;
    }

    public PlacementModifierType<?> type() {
        return HabitatPlacementModifierTypes.SLIME_CHUNK_FILTER;
    }
}