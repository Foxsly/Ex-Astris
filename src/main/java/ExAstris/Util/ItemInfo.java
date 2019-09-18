package ExAstris.Util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemInfo {
	private int id;
	private int subid;

	public ItemInfo(int id) {
		this.id = id;
		this.subid = -1;
	}

	public ItemInfo(ItemStack itemStack) {
		this.id = Item.getIdFromItem(itemStack.getItem());
		this.subid = itemStack.getMetadata();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + subid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		if(getClass() != obj.getClass()) {
			return false;
		}
		ItemInfo other = (ItemInfo) obj;
		if(id != other.id) {
			return false;
		}
		return subid == other.subid;
	}
}

