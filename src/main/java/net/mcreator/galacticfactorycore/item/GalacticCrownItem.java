
package net.mcreator.galacticfactorycore.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.Entity;

import net.mcreator.galacticfactorycore.itemgroup.GalacticFactoryCoreItemGroup;
import net.mcreator.galacticfactorycore.GalacticfactorycoreModElements;

@GalacticfactorycoreModElements.ModElement.Tag
public class GalacticCrownItem extends GalacticfactorycoreModElements.ModElement {
	@ObjectHolder("galacticfactorycore:galactic_crown_helmet")
	public static final Item helmet = null;
	@ObjectHolder("galacticfactorycore:galactic_crown_chestplate")
	public static final Item body = null;
	@ObjectHolder("galacticfactorycore:galactic_crown_leggings")
	public static final Item legs = null;
	@ObjectHolder("galacticfactorycore:galactic_crown_boots")
	public static final Item boots = null;

	public GalacticCrownItem(GalacticfactorycoreModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 0, 0, 0}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_diamond"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "galactic_crown";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD,
				new Item.Properties().group(GalacticFactoryCoreItemGroup.tab).isImmuneToFire()) {
			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "galacticfactorycore:textures/models/armor/galacticcrowntemp_layer_" + (slot == EquipmentSlotType.LEGS ? "2" : "1") + ".png";
			}
		}.setRegistryName("galactic_crown_helmet"));
	}

}
