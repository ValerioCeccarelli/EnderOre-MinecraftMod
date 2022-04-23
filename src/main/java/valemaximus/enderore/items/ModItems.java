package valemaximus.enderore.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import valemaximus.enderore.EnderOreMod;
import valemaximus.enderore.tab.ModCreativeModeTab;

public class ModItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EnderOreMod.MODID);

    public static RegistryObject<Item> ENDER_FRAGMENT = ITEMS.register("ender_fragment",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.tab)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
