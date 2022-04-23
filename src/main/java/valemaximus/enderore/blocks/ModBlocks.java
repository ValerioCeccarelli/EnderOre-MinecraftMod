package valemaximus.enderore.blocks;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import valemaximus.enderore.EnderOreMod;
import valemaximus.enderore.items.ModItems;
import valemaximus.enderore.tab.ModCreativeModeTab;

import java.util.function.Supplier;

public class ModBlocks {

    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EnderOreMod.MODID);

    public static final RegistryObject<Block> ENDER_ORE = registerBlock("ender_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.tab);

    public static final RegistryObject<Block> DEEPSLATE_ENDER_ORE = registerBlock("deepslate_ender_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(4,8)), ModCreativeModeTab.tab);

    public static final RegistryObject<Block> NETHERRACK_ENDER_ORE = registerBlock("netherrack_ender_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.tab);

    public static final RegistryObject<Block> ENDSTONE_ENDER_ORE = registerBlock("endstone_ender_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(9f).requiresCorrectToolForDrops(), UniformInt.of(3,7)), ModCreativeModeTab.tab);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
