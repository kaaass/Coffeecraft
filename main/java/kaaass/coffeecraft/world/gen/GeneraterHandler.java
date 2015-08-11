package kaaass.coffeecraft.world.gen;

import java.util.Random;

import kaaass.coffeecraft.block.BlockCoffeeTreeSapling;
import kaaass.coffeecraft.init.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.common.BiomeDictionary;
import cpw.mods.fml.common.IWorldGenerator;

public class GeneraterHandler implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		WorldChunkManager worldchunkmanager = world.getWorldChunkManager();
	    if (worldchunkmanager != null){
	      BiomeGenBase biome = worldchunkmanager.getBiomeGenAt(chunkX * 16, chunkZ * 16);
	      if(BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.MOUNTAIN) || BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.FOREST)){
	        if(rand.nextInt(24) == 0){
	          generateCoffeeTree(rand, world, chunkX, chunkZ, 60);
	        }
	      }
	    }
	}
	
	private void generateCoffeeTree(Random rand, World world, int chunkX, int chunkZ, int maxHeight){
		for(int i = 0; i < rand.nextInt(5); i++){
			int x = chunkX * 16 + rand.nextInt(16);
			int y = rand.nextInt(maxHeight) + 60;
			int z = chunkZ * 16 + rand.nextInt(16);
			for (int a = 0; a < 10; a++){
				int l = x + rand.nextInt(8) - rand.nextInt(8);
				int j = y + rand.nextInt(4) - rand.nextInt(4);
				int k = z + rand.nextInt(8) - rand.nextInt(8);
				if(world.isAirBlock(l, j, k) && isDirt(world.getBlock(l, j - 1, k))){
					((BlockCoffeeTreeSapling)Blocks.coffeeTreeSaplingBlock).treeGene(world, l, j, k, rand);
					return;
				}
			}
	    }
	}
	
	private boolean isDirt(Block block){
		return block == Block.getBlockById(2) || block == Block.getBlockById(3);
	}
}
