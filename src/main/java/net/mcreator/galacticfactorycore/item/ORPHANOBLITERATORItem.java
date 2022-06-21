
package net.mcreator.galacticfactorycore.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.client.util.ITooltipFlag;

import net.mcreator.galacticfactorycore.itemgroup.GalacticFactoryCoreItemGroup;
import net.mcreator.galacticfactorycore.GalacticfactorycoreModElements;

import java.util.List;

@GalacticfactorycoreModElements.ModElement.Tag
public class ORPHANOBLITERATORItem extends GalacticfactorycoreModElements.ModElement {
	@ObjectHolder("galacticfactorycore:orphanobliterator")
	public static final Item block = null;

	public ORPHANOBLITERATORItem(GalacticfactorycoreModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 99999;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 99997f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 0;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, 6f, new Item.Properties().group(GalacticFactoryCoreItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("HAHA  Pan Go Brrrrrrrrrrrrrrr"));
			}

			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("orphanobliterator"));
	}
}
