package ExAstris.Modifier;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tconstruct.library.tools.ToolCore;
import tconstruct.modifiers.tools.ModBoolean;

public class ModHammered extends ModBoolean {
	static String name = "Hammered";
	static String color = "\u00a79";
	static String tooltip = "Smashing";

	public ModHammered(ItemStack[] items, int i) {
		super(items, i, name, color, tooltip);
	}

	@Override
	protected boolean canModify(ItemStack tool, ItemStack[] input) {
		if(tool.getItem() instanceof ToolCore) {
			ToolCore toolitem = (ToolCore) tool.getItem();
			if(!validType(toolitem)) {
				return false;
			}
			NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
			if(!tags.getBoolean("Lava") && !tags.hasKey("Lapis") && !tags.hasKey("Silk Touch") && !tags.hasKey("Crooked")) {
				return tags.getInteger("Modifiers") > 0 && !tags.getBoolean(key);
			}
		}
		return false;
	}

	public void modify(ItemStack[] input, ItemStack tool) {
		NBTTagCompound tags = tool.getTagCompound().getCompoundTag("InfiTool");
		tags.setBoolean(name, true);
		int modifiers = tags.getInteger("Modifiers");
		modifiers -= 1;
		tags.setInteger("Modifiers", modifiers);
		int miningSpeed = tags.getInteger("MiningSpeed");
		miningSpeed -= 400;
		if(miningSpeed < 0) {
			miningSpeed = 0;
		}
		tags.setInteger("MiningSpeed", miningSpeed);
		int attack = tags.getInteger("Attack");
		attack += 3;
		tags.setInteger("Attack", attack);
		addToolTip(tool, color + tooltip, color + key);
	}

	public boolean validType(ToolCore tool) {
		return tool.getToolName().equals("Mattock") || tool.getToolName().equals("Hatchet") || tool.getToolName().equals("Broadsword") || tool.getToolName().equals("Longsword") || tool.getToolName().equals("Rapier") || tool.getToolName().equals("Cutlass") || tool.getToolName().equals("Cleaver") || tool.getToolName().equals("Lumber Axe") || tool.getToolName().equals("Scythe") || tool.getToolName().equals("Pickaxe") || tool.getToolName().equals("Hammer") || tool.getToolName().equals("Shovel") || tool.getToolName().equals("Excavator");
	}
}
