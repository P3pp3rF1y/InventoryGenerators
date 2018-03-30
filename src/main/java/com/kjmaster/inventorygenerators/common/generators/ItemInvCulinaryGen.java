package com.kjmaster.inventorygenerators.common.generators;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemInvCulinaryGen extends ItemInventoryGenerator {

    public ItemInvCulinaryGen() {
        super("inv_culinary_gen");
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        return stack.getItem() instanceof ItemFood;
    }

    @Override
    public int calculateTime(ItemStack stack) {
        if (!stack.isEmpty()) {
            Item item = stack.getItem();
            ItemFood food = (ItemFood) item;
            return (int) Math.ceil((food.getHealAmount(stack) * 10) * (getSaturation(food, stack) * 20));
        }
        return 0;
    }

    private float getSaturation(ItemFood food, ItemStack stack) {
        return food.getSaturationModifier(stack) != 0 ? food.getSaturationModifier(stack) : 0.1F;
    }

    @Override
    public void initModel() {
        super.initModel();
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
        super.onUpdate(stack, world, entity, itemSlot, isSelected);
    }
}