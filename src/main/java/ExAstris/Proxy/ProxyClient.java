package ExAstris.Proxy;

import ExAstris.Block.BlockHammerAutomatic;
import ExAstris.Block.Model.ModelBarrelThaumium;
import ExAstris.Block.Model.ModelSieveAutomatic;
import ExAstris.Block.Render.Item.ItemRenderBarrelThaumium;
import ExAstris.Block.Render.Item.ItemRenderSieveAutomatic;
import ExAstris.Block.Render.RenderBarrelThaumium;
import ExAstris.Block.Render.RenderBlockHammer;
import ExAstris.Block.Render.RenderHammerAutomatic;
import ExAstris.Block.Render.RenderSieveAutomatic;
import ExAstris.Block.TileEntity.TileEntityBarrelThaumium;
import ExAstris.Block.TileEntity.TileEntityHammerAutomatic;
import ExAstris.Block.TileEntity.TileEntitySieveAutomatic;
import ExAstris.ExAstrisBlock;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import exnihilo.blocks.models.ModelSieveMesh;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ProxyClient extends Proxy {
	public ProxyClient() {
		Proxy.setInstance(this);
	}

	@Override
	public void initializeRenderers() {
		if(Loader.isModLoaded("Thaumcraft")) {
			ModelBarrelThaumium barrel = new ModelBarrelThaumium();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarrelThaumium.class, new RenderBarrelThaumium(barrel));
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.BarrelThaumium), new ItemRenderBarrelThaumium(barrel));
		}
		ModelSieveAutomatic sieve = new ModelSieveAutomatic();
		ModelSieveMesh mesh = new ModelSieveMesh();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySieveAutomatic.class, new RenderSieveAutomatic(sieve, mesh));
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.SieveAutomatic), new ItemRenderSieveAutomatic(sieve, mesh));
		BlockHammerAutomatic.renderId = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockHammer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHammerAutomatic.class, new RenderHammerAutomatic());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ExAstrisBlock.HammerAutomatic), new RenderBlockHammer());
	}
}
