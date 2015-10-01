package kaaass.coffeecraft.world.gen;

import java.util.Random;

import kaaass.coffeecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
            generateNether(world, rand, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, rand, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, rand, chunkX * 16, chunkZ * 16);
            break;
		}
	}
	
	private void generateEnd(World world, Random rand, int chunkX, int chunkZ){
		
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ){
		for(int k = 0; k <= rand.nextInt(8); k++){
        	int posX = chunkX + rand.nextInt(16);
        	int posY = rand.nextInt(25) + 40;
        	int posZ = chunkZ + rand.nextInt(16);
        	
        	(new WorldGenMinable(Blocks.factorOre, 2 + rand.nextInt(4))).generate(world, rand, posX, posY, posZ);
        }
	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ){
		
	}
}
