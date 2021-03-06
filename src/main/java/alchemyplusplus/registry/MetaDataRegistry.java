/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alchemyplusplus.registry;

import alchemyplusplus.AlchemyPlusPlus;
import cpw.mods.fml.common.ModMetadata;
import java.util.Arrays;

public class MetaDataRegistry
{
    public static ModMetadata init(ModMetadata metadata)
    {
        // Setup Mod Metadata for players to see in mod list with other mods.
        metadata.modId = AlchemyPlusPlus.ID;
        metadata.name = AlchemyPlusPlus.NAME;
        metadata.description = AlchemyPlusPlus.NAME + ": Feel the need to brew the perfect potion? Is the vanilla Minecraft brewing system to simple for your refined tastes? If so, AlchemyPlusPlus might be the mod for you";
        metadata.url = "http://jakimfett.github.io/AlchemyPlusPlus/";
        metadata.logoFile = "assets/" + AlchemyPlusPlus.ID + "/logo.png";
        metadata.version = AlchemyPlusPlus.V_MAJOR + "." + AlchemyPlusPlus.V_MINOR + "." + AlchemyPlusPlus.V_REVIS;
        metadata.authorList = Arrays.asList("jakimfett");
        metadata.autogenerated = false;
        return metadata;
    }

}
