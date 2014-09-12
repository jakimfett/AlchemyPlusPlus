package alchemyplusplus.block.complex.extractor;

import alchemyplusplus.AlchemyPlusPlus;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ExtractorBlock extends BlockContainer
{

    public ExtractorBlock(int blockID)
    {
        super(Material.piston);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return null;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float b, float c, float g)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity != null)
        {
            if (!world.isRemote)
            {
                player.openGui(AlchemyPlusPlus.INSTANCE, 1, world, x, y, z);
            }
            return true;
        }
        return false;
    }

}
