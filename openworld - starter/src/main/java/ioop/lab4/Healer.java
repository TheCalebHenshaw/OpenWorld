package ioop.lab4;

public class Healer extends Character {
    
    public Healer(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack, goal);
    }
    public void enounter(WorldEntity traveller){
        if(traveller instanceof Adventurer){
            traveller.setCurrentHealth(traveller.maxHealth);
        }
        if(traveller instanceof Monster){
            world.battle(this, traveller);
        }
        super.encounter(traveller);
        
    }
    // Task 3.2


}
