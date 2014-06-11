package alchemyplusplus.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;

public class FoodTemplate extends ItemFood
{

    String icon;

    public FoodTemplate(int id, String icon, int effectID, int amp, int duration)
    {
        super(id, -5, -0.5f, false);
        this.setPotionEffect(effectID, duration, amp, 1f);
        this.icon = icon;
    }

    @Override
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(icon);
    }

}