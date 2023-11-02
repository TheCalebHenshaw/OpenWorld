package openworld.Items;

import openworld.Coordinates;
import openworld.entityTypes.TravellingWorldEntity;

public class HealthPotion extends Item {
    private int HealingAmount;
    private int uses;

    public HealthPotion(String name, int minLevelOfUse, int uses, int HealingAmount, Coordinates location) {
        super(name, minLevelOfUse,"A Health potion that can restore your health!", location);
        this.HealingAmount = 50;
        this.uses=uses;
        
    }
    public void use(TravellingWorldEntity entity){
        if(entity.getCurrentHealth()<entity.getMaxHealth() && uses >=1 ){
            entity.setCurrentHealth(entity.getCurrentHealth()+HealingAmount);
        }
    }
    public int getUses(){
        return this.uses;
    }
    public void setUses(int uses){
        this.uses = uses;
    }
    public boolean isUsable(){
        return uses>=1;
    }
}
