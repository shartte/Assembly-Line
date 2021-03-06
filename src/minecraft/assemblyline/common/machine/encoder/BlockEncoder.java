package assemblyline.common.machine.encoder;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import assemblyline.common.AssemblyLine;
import assemblyline.common.CommonProxy;
import assemblyline.common.TabAssemblyLine;
import assemblyline.common.machine.BlockAssembly;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEncoder extends BlockAssembly
{
	Icon encoder_side;
	Icon encoder_top;
	Icon encoder_bottom;
	public BlockEncoder(int id)
	{
		super(id, Material.wood,"encoder");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IconRegister iconReg)
	{
		this.encoder_side = iconReg.registerIcon(AssemblyLine.TEXTURE_NAME_PREFIX+"encoder_side");
		this.encoder_top = iconReg.registerIcon(AssemblyLine.TEXTURE_NAME_PREFIX+"encoder_top");
		this.encoder_bottom = iconReg.registerIcon(AssemblyLine.TEXTURE_NAME_PREFIX+"encoder_bottom");
	}
	
	/**
	 * Returns the block texture based on the side being looked at. Args: side
	 */
	@Override
	public Icon getBlockTexture(IBlockAccess world, int x, int y, int z, int side)
	{
		return getIcon(side, 0);
	}
	
	/**
	 * Returns the block texture based on the side being looked at. Args: side
	 */
	@Override
	public Icon getIcon(int side, int meta)
	{
		if (side == 1)
		{
			return this.encoder_top;

		}
		else if (side == 0)
		{
			return this.encoder_bottom;

		}

		return this.encoder_side;
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	@Override
	public boolean onMachineActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int par6, float par7, float par8, float par9)
	{
		if (!world.isRemote)
		{
			entityPlayer.openGui(AssemblyLine.instance, CommonProxy.GUI_ENCODER, world, x, y, z);
		}

		return true;

	}

	@Override
	public TileEntity createTileEntity(World world, int metadata)
	{
		return new TileEntityEncoder();
	}
}
