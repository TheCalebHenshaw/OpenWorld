package ioop.lab4;

public class Wizard extends Character{

    public Wizard(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack, goal);
    }
    public void encounter(WorldEntity traveller){
        if(traveller instanceof Adventurer){
        Adventurer adventure = (Adventurer) traveller;
        adventure.addAttack(new Damage(10, DamageType.FIRE));
        }
        if(traveller instanceof Monster){
            world.battle(this, traveller);
        }

        super.encounter(traveller);
    }
    // Task 3.2


}
