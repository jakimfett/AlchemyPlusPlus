package mokonaDesu.alchemypp.tileentities;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAlchemicalApparatus extends TileEntity {

  //public ApparatusApplicationSpiritLamp lamp = null;
  //public ApparatusApplicationBottleStand stand = null;
  //public ApparatusApplicationSprayer sprayer = null; 
  
  public ApparatusApplicationBottomAccessory bottom = null;
  public ApparatusApplicationStand stand = null;
  public ApparatusApplicationUpperAccessory upper = null;

  
  public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
        }

  public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
        readFromNBT(packet.customParam1);
  }
        
  public void readFromNBT(NBTTagCompound tag)
  {
    super.readFromNBT(tag);
    this.bottom = ApparatusApplicationBottomAccessory.readFromNBT(tag, this);
    this.stand = ApparatusApplicationStand.readFromNBT(tag, this);
    this.upper = ApparatusApplicationUpperAccessory.readFromNBT(tag, this);
    /*
    this.lamp = ApparatusApplicationSpiritLamp.readFromNBT(tag, this);
    this.stand = ApparatusApplicationBottleStand.readFromNBT(tag, this);
    this.sprayer = ApparatusApplicationSprayer.readFromNBT(tag, this);
    */
  }
        
   public void writeToNBT(NBTTagCompound tag)
  {
    super.writeToNBT(tag);
    if (this.upper != null) this.upper.writeToNBT(tag);
    if (this.stand != null) this.stand.writeToNBT(tag);
    if (this.bottom != null) this.bottom.writeToNBT(tag);
    /*
    if (this.lamp != null) this.lamp.writeToNBT(tag);
    if (this.stand != null) this.stand.writeToNBT(tag);
    if (this.sprayer != null) this.sprayer.writeToNBT(tag);
    */
  }
   
   public void updateEntity() {
	   /*
	   if (this.hasLamp()) this.lamp.update();
	   if (this.hasStand()) this.stand.update();
	   if (this.hasSprayer()) this.sprayer.update();
	   */
	   if (this.hasBottom()) this.bottom.update();
	   if (this.hasStand()) this.stand.update();
	   if (this.hasUpper()) this.upper.update();
   }
   
   //public boolean hasLamp() { return this.lamp != null; }
   public boolean hasStand() { return this.stand != null; }
   //public boolean hasBottle() { return this.stand != null && this.stand.stack != null; }
   //public boolean hasSprayer() { return this.sprayer != null; }
   
   public boolean hasUpper() { return this.upper != null;   }
   public boolean hasBottom() { return this.bottom != null;  }
   
  // public void addLamp() { this.lamp = new ApparatusApplicationSpiritLamp(this); }
  // public void addStand() { this.stand = new ApparatusApplicationBottleStand(this); }  
  // public void addSprayer() {this.sprayer = new ApparatusApplicationSprayer(this); }
   
   public void addBottom(ApparatusApplicationBottomAccessory application) {
	   if (this.bottom == null) {
		   application.parent = this;
		   this.bottom = application; 
	  }
   }
  
   public void addStand(ApparatusApplicationStand application) {
	   if (this.stand == null) {
	   application.parent = this;
	   this.stand = application;
	   }
   }
   	
   public void addUpper(ApparatusApplicationUpperAccessory application) {
	   if (this.upper == null) {
		   application.parent = this;
		   this.upper = application; 
	   }
   }
   
   
   
   public String getStat() {
	   String stat = "";
	  // stat += this.hasLamp() ? " Lamp: "+this.lamp.spirit + "/60 "+ (this.lamp.active ? "(Burning)" : "")+"\n" : "";
	  // stat += this.hasStand() ? "Bottle temp: " + (int)this.stand.temperature + "K (" + this.stand.normalTemperature + "K)\n" : "";
	  // stat += this.hasSprayer() ? "Has Sprayer" : "";
	   if (this.upper != null) stat += this.upper.getStat();
	   if (this.stand != null) stat += this.stand.getStat();
	   if (this.bottom != null) stat += this.bottom.getStat();
	   
	   return stat;   
   }
        
}
