
package net.mcreator.galacticfactorycore.item;

import net.minecraftforge.registries.ObjectHolder;

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
public class FryingPanItem extends GalacticfactorycoreModElements.ModElement {
	@ObjectHolder("galacticfactorycore:frying_pan")
	public static final Item block = null;

	public FryingPanItem(GalacticfactorycoreModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 15f;
			}

			public float getAttackDamage() {
				return 99996f;
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
		}, 3, 26f, new Item.Properties().group(GalacticFactoryCoreItemGroup.tab).isImmuneToFire()) {
			@Override
			public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
				super.addInformation(itemstack, world, list, flag);
				list.add(new StringTextComponent("You've been struck by~ You've been hit by~ PAN!"));
			}
		}.setRegistryName("frying_pan"));
	}
}
