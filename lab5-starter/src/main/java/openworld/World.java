package openworld;

import java.util.ArrayList;
import java.util.Collections;

import javax.crypto.SealedObject;

import openworld.adventurer.Adventurer;
import openworld.characters.Healer;
import openworld.characters.NPC;
import openworld.characters.Wizard;

import openworld.terrain.Volcano;
import openworld.terrain.Grasslands;
import openworld.terrain.Mountain;
import openworld.terrain.Terrain;
import openworld.entityTypes.WorldEntity;
import openworld.monsters.Blob;
import openworld.monsters.Monster;
import openworld.monsters.Skeleton;

public class World {

    private int xDimension;
    private int yDimension;
    private ArrayList<Terrain> terrain = new ArrayList<>();
    private ArrayList<Monster> monsters = new ArrayList<>();

    private ArrayList<NPC> nonPlayerCharacters = new ArrayList<>();
    private Adventurer adventurer;

    public World(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;
    }

    // Task 1.2
    public void initaliseWorld() {
        generateTerrain();
        generateMonsters();
        generateCharacters();
        adventurer = new Adventurer("Bob", new Coordinates(0, 0), 100, this, new Damage(10, DamageType.PHYSICAL));
    }

    // Task 3.1
    public void run() {
        adventurer.takeTurn(); //must start walking towards yDimension
        nonPlayerCharactersMove();
        monsterMove();
    }
    
    // Task 1.2
    public void generateMonsters(){
        boolean opposite = true;
        for(int x = 0; x<= xDimension;x++){
            for(int y = 0; y<= yDimension;y++){
                if((x*(yDimension + 1)+y)%7==0){
                    if(opposite){
                        monsters.add(new Skeleton("Mr Skelly", new Coordinates(x,y), 150, this, new Damage(5,DamageType.PHYSICAL),1 ));
                    }else{
                        monsters.add(new Blob("Mr Blob", new Coordinates(x, y), 150, this, new Damage(5,DamageType.PHYSICAL),1 ));
                    }
                    opposite = !opposite;
                }
            }
        }
    }

    // Task 1.2
    public void generateCharacters() {
        boolean opposite = true;
        for(int x = 0; x<= xDimension;x++){
            for(int y = 0; y<= yDimension;y++){
                if((x*(yDimension + 1)+y)%15==0){
                    if(opposite){
                        nonPlayerCharacters.add(new Wizard("Dr Heimerdinger", new Coordinates(x, y), 2000, this, null, null));
                    }else{
                        nonPlayerCharacters.add(new Healer("Tony Chopper", new Coordinates(x, y), 2000, this, null, null));
                    }
                    opposite = !opposite;
                }
            }
        }
    }

    public void generateTerrain() {
        for (int x = 0; x <= xDimension; x++) {
            for (int y = 0; y <= yDimension; y++) {
                terrain.add(new Grasslands("Grasslands", new Coordinates(x, y), 1000, this,
                        new Damage(0, DamageType.PHYSICAL)));
            }
        }
    }

    // Task 2.1
    public void printWorld() {
        for (int x = 0; x <= xDimension; x++) {
            for (int y = 0; y <= yDimension; y++) {
                boolean printedEntity = false;
                
                // Check for adventurer
                if (adventurer != null && adventurer.getLocation().getX() == x && adventurer.getLocation().getY() == y) {
                    System.out.print("Adv"); // Use 'A' to represent the adventurer
                    printedEntity = true;
                }
                
                // Check for monsters
                for (Monster monster : monsters) {
                    if (monster.getLocation().getX() == x && monster.getLocation().getY() == y) {
                        if (monster instanceof Skeleton) {
                            System.out.print("Skele"); // Use 'S' to represent Skeletons
                        } else if (monster instanceof Blob) {
                            System.out.print("Blob"); // Use 'B' to represent Blobs
                        } else {
                            System.out.print("Monster"); // Use 'M' for other monsters
                        }
                        printedEntity = true;
                        break;
                    }
                }
                
                // Check for non-player characters
                for (NPC npc : nonPlayerCharacters) {
                    if (npc.getLocation().getX() == x && npc.getLocation().getY() == y) {
                        if (npc instanceof Wizard) {
                            System.out.print("Wiz"); // Use 'W' to represent Wizards
                        } else if (npc instanceof Healer) {
                            System.out.print("Healer"); // Use 'H' to represent Healers
                        } else {
                            System.out.print("NPC"); // Use 'N' for other NPCs
                        }
                        printedEntity = true;
                        break;
                    }
                }
                
                // Check for terrain
                for (Terrain land : terrain) {
                    if (land.getLocation().getX() == x && land.getLocation().getY() == y) {
                        System.out.print("Grass"); // Use 'T' to represent terrain
                        printedEntity = true;
                        break;
                    }
                }
                
                if (!printedEntity) {
                    System.out.print("."); // Print a dot for empty spaces
                }
                
                System.out.print(" ");
            }
            System.out.println(); // Move to the next row
        }
    }
    

    // Task 3.1
    private void monsterMove() {
        Collections.sort(monsters, new LevelSort());
        for (Monster monster : monsters) {
            monster.takeTurn();
        }
    }

    // Task 3.1
    public void nonPlayerCharactersMove() {
        Collections.sort(nonPlayerCharacters, new AlphabeticalSort());
        for (NPC npc : nonPlayerCharacters) {
            npc.takeTurn();
        }
    }

    // Task 3.2
    public void resolveMove(WorldEntity traveller) {
        Coordinates loc = traveller.getLocation();

        for(Monster mon : monsters){
            if(mon instanceof Skeleton && mon.getLocation()==loc){
                Skeleton skel = (Skeleton)mon;
                skel.encounter(traveller);
            }
            if(mon instanceof Blob && mon.getLocation()==loc){
                Blob blob = (Blob)mon;
                blob.encounter(traveller);
            }
        }
        for(Terrain terr : terrain){
            if(terr instanceof Mountain){
                Mountain mou = (Mountain)terr;
                mou.encounter(traveller);
            }
            if(terr instanceof Volcano){
                Volcano vol = (Volcano)terr;
                vol.encounter(traveller);
            }
        }
        for(NPC npc : nonPlayerCharacters){
            if(npc instanceof Healer){
                Healer hel = (Healer)npc;
                hel.encounter(traveller);
            }
            if(npc instanceof Wizard){
                Wizard wiz = (Wizard)npc;
                wiz.encounter(traveller);
            }
        }
    }

    public void battle(WorldEntity location, WorldEntity traveller) {
        while (location.getCurrentHealth() > 0 && traveller.getCurrentHealth() > 0) {
            location.attack(traveller);
            if (traveller.getCurrentHealth() > 0) {
                traveller.attack(location);
            }
        }
    }

    // Task 2.2
    public static void main(String[] args) {
        World world = new World(7, 7);
        world.initaliseWorld();
        world.printWorld();
    }

    public int getxDimension() {
        return xDimension;
    }

    public int getyDimension() {
        return yDimension;
    }

    public Adventurer getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(Adventurer adventurer) {
        this.adventurer = adventurer;
    }

    public ArrayList<Terrain> getTerrain() {
        return terrain;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<NPC> getNonPlayerCharacters() {
        return nonPlayerCharacters;
    }

}
