package gregtechfoodoption.worldgen;

import gregtechfoodoption.block.GTFOTree;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraft.world.gen.ChunkGeneratorFlat;

import java.util.Random;

public class GTFOWorldGenerator implements IWorldGenerator {

    public static final GTFOWorldGenerator INSTANCE = new GTFOWorldGenerator();

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator iChunkGenerator, IChunkProvider iChunkProvider) {
        if (iChunkGenerator instanceof ChunkGeneratorFlat)
            return; // It's a superflat world, don't generate trees.
        for (GTFOTree tree : GTFOTree.TREES) {
            tree.setWorld(world);
            tree.getWorldGenInstance().generateInChunk(world, random, chunkX, chunkZ);
        }
    }
}
