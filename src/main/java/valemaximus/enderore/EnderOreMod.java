package valemaximus.enderore;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import valemaximus.enderore.blocks.ModBlocks;
import valemaximus.enderore.items.ModItems;

@Mod(EnderOreMod.MODID)
public class EnderOreMod {
    public static final String MODID = "enderore";

    public EnderOreMod()
    {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }
}
