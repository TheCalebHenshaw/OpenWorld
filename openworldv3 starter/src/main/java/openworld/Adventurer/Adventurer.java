package openworld.Adventurer;

import java.util.ArrayList;
import java.util.Scanner;

import openworld.Coordinates;
import openworld.Damage;
import openworld.World;
import openworld.characters.Healer;
import openworld.characters.NPC;
import openworld.characters.Wizard;
import openworld.entityTypes.TravellingWorldEntity;
import openworld.entityTypes.WorldEntity;
import openworld.terrain.Mountain;

public class Adventurer extends TravellingWorldEntity {

    private Damage[] attacks = new Damage[3];
    private int totalAttacks = 1;

    public Adventurer(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
        attacks[0] = attack;
    }

    public void addAttack(Damage attack) {
        if (totalAttacks < attacks.length) {
            attacks[totalAttacks] = attack;
            totalAttacks++;
        }
    }

    public void attack(WorldEntity target) {
        for (int i = 0; i < totalAttacks; i++) {
            target.takeDamage(attacks[i]);
        }
    }

    public Damage[] getAttacks() {
        return attacks;
    }

    public void takeTurn() {
        printOptions();
        boolean turnCompleted = false;
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNext()){
        int selection=(Integer.parseInt(userInput.nextLine()));
        }
        int selection=(Integer.parseInt(userInput.nextLine()));
        resolveTurn(selection); // Is this a type of resolve move?
     
    }
    public void printOptions(){ //Return all places the person can move
        ArrayList<Coordinates> moves = this.location.availableMoves(world);
        System.out.println("Move forwards");

        ArrayList<NPC> daddy = world.getNonPlayerCharacters();

    }
    public void resolveTurn(int selection){
        switch(selection){
            case (1): //Move North
            move(new Coordinates(location.getX()+1, location.getY()));
            break;

            
        }
    }
    
    
    

}