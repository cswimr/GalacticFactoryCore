
package net.mcreator.galacticfactorycore.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.galacticfactorycore.GalacticfactorycoreModElements;

@GalacticfactorycoreModElements.ModElement.Tag
public class GalacticFactoryCoreItemGroup extends GalacticfactorycoreModElements.ModElement {
	public GalacticFactoryCoreItemGroup(GalacticfactorycoreModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabgalactic_factory_core") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(Items.END_CRYSTAL);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}

	public static ItemGroup tab;
}
