package valemaximus.enderore.tab;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab tab = new CreativeModeTab("enderore_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.ENDER_PEARL);
        }

        @Override
        public boolean hasSearchBar() {
            return false;
        }
    };
}
