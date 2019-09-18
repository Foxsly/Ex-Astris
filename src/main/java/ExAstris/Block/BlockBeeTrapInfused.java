package ExAstris.Block;

import ExAstris.Data.BlockData;
import ExAstris.Data.ModData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockBeeTrapInfused extends Block {
	public static IIcon topIcon;
	public static IIcon sideIcon;

	public BlockBeeTrapInfused() {
		super(Material.ground);
		setHardness(0.8f);
		setStepSound(soundTypeGrass);
		setCreativeTab(ExAstris.ExAstris.ExAstrisTab);
	}

	@Override
	public String getUnlocalizedName() {
		return ModData.ID + "." + BlockData.BEE_TRAP_INFUSED_UNLOCALIZED_NAME;
	}

	@Override
	public void registerIcons(IIconRegister register) {
		topIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapInfusedTopRaw");
		sideIcon = register.registerIcon(ModData.TEXTURE_LOCATION + ":IconBeeTrapInfusedSideRaw");
		blockIcon = sideIcon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(side == 0 || side == 1) {
			return topIcon;
		}
		return sideIcon;
	}
}
