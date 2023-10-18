package ioop.lab4;

public class Blob extends Monster{
    public Blob(String name, Coordinates location, int maxHealth, World world, Damage attack, int speed) {
        super(name, location, maxHealth, world, attack, speed);
    }

    public void encounter(WorldEntity traveller)
    {
        if(traveller instanceof Blob){
            //do the blob stuff
            Blob travelblob = (Blob) traveller;
            this.setCurrentHealth(this.currentHealth+travelblob.getCurrentHealth());
            this.maxHealth+=travelblob.getMaxHealth();
            travelblob.setCurrentHealth(0);
            this.gainXP(travelblob.getXp());

            Damage newdmg = new Damage(travelblob.getCurrentHealth(),DamageType.PHYSICAL);
            travelblob.takeDamage(newdmg);

            
        }
        else{
            super.encounter(traveller);
        }
    }


}
