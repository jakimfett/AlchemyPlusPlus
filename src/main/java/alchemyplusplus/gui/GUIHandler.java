package alchemyplusplus.gui;

import alchemyplusplus.block.complex.diffuser.DiffuserContainer;
import alchemyplusplus.block.complex.diffuser.DiffuserTileEntity;
import alchemyplusplus.block.complex.distillery.DistilleryContainer;
import alchemyplusplus.block.complex.distillery.DistilleryGUI;
import alchemyplusplus.block.complex.distillery.DistilleryTileEntity;
import alchemyplusplus.block.complex.extractor.ExtractorContainer;
import alchemyplusplus.block.complex.extractor.ExtractorGUI;
import alchemyplusplus.block.complex.extractor.ExtractorTileEntity;
import alchemyplusplus.block.complex.fluidMixer.FluidMixerContainer;
import alchemyplusplus.block.complex.fluidMixer.FluidMixerGUI;
import alchemyplusplus.block.complex.fluidMixer.FluidMixerTileEntity;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import java.util.HashMap;
import net.minecraft.tileentity.TileEntity;

public class GUIHandler implements IGuiHandler
{
    public static HashMap<String, Integer> guiHandlerRegistry = new HashMap<String, Integer>();

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID)
        {
            case 0:
            { // Potion mixer
                return new FluidMixerGUI(player.inventory, (FluidMixerTileEntity) entity);
            }
            case 1:
            { // Extractor
                return new ExtractorGUI(player.inventory, (ExtractorTileEntity) entity);
            }
            case 2:
            { // Distillery
                return new DistilleryGUI(player.inventory, (DistilleryTileEntity) entity);
            }
            default:
                return null;
        }
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);
        
        switch (ID)
        {
            case 0:
            { // Potion mixer
                return new FluidMixerContainer(player.inventory, (FluidMixerTileEntity) entity);
            }
            case 1:
            { // Extractor
                return new ExtractorContainer(player.inventory, (ExtractorTileEntity) entity);
            }
            case 2:
            { // Distillery
                return new DistilleryContainer(player.inventory, (DistilleryTileEntity) entity);
            }
            case 3:
            { // Diffuser
                return new DiffuserContainer(player.inventory, (DiffuserTileEntity) entity);
            }
            default:
                return null;
        }
    }
}
