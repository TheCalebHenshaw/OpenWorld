package openworld.entityTypes;

import java.util.ArrayList;

import openworld.Coordinates;
import openworld.Damage;
import openworld.DamageType;
import openworld.World;

public class WorldEntity {
    private String name;
    protected Coordinates location;
    protected int maxHealth;
    protected int currentHealth;
    protected Damage attack;

    protected World world;
    public boolean conscious;



    // Task 3.3
    public WorldEntity(String name, Coordinates location, int maxHealth,  World world, Damage attack) {
        this.name = name;
        this.location = location;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.world = world;
        this.attack = attack;


    }
    
    // Task 3.3
    public void takeDamage(Damage damage) {

    }

    
    // Task 3.3
    public void changeVulnerability(DamageType damageType, int newVulnerabilty)
    {

    }

    // Task 3.3
    public int getVulnerability(DamageType damageType)
    {

    }

    public void attack(WorldEntity traveller) {
        traveller.takeDamage(attack);
    }

    
    public void encounter(WorldEntity traveller) {
        System.out.println("You encounter name: " + name);
        System.out.println("Coordinate: [" + location.toString()+ "]");
        System.out.println("Max Health: " + maxHealth);
        System.out.println("Current Health: " + currentHealth);
    }

    public String getName() {
        return name;
    }

    public Coordinates getLocation() {
        return location;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Damage getAttack() {
        return attack;
    }

    public World getWorld() {
        return world;
    }

    public boolean isConscious() {
        return conscious;
    }

    public void setCurrentHealth(int health) {
        currentHealth=health;
    }
}
