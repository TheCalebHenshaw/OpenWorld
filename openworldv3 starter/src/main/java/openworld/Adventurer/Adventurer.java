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
        ArrayList<String> options = printOptions();
        Scanner userInput = new Scanner(System.in);
        while (!userInput.hasNext());
        int selection=(Integer.parseInt(userInput.nextLine()));
        
        resolveTurn(selection,options); // Is this a type of resolve move?
     
    }
    public ArrayList<String> printOptions(){ //Return all places the person can move
        ArrayList<String> options = new ArrayList<>();
        
        System.out.println("--------------- Option Selection ---------------");
        int optionIndex = 0;
        String toMove = "Move in direction: ";


        ArrayList<Coordinates> moves = this.location.availableMoves(world);
        for(Coordinates move : moves){
            String optionFormat = ("Option Number " + "(" + optionIndex +") ");
            System.out.print(optionFormat);
            System.out.println(toMove +"[" +  move.getX() + "," + move.getY()+ "]");
            optionIndex+=1;
            
            if(move.equals(Coordinates.NORTH_VECTOR)){
                options.add("Move,Up");
            }
            if(move.equals(Coordinates.SOUTH_VECTOR)){
                options.add("Move,Down");
            }
            if(move.equals(Coordinates.EAST_VECTOR)){
                options.add("Move,Right");
            }
            if(move.equals(Coordinates.WEST_VECTOR)){
                options.add("Move,Left");
            }


        }


        ArrayList<NPC> npcs = this.getWorld().getNonPlayerCharacters();
        for(NPC npc : npcs){
            String optionFormat = ("Option Number " + "(" + optionIndex +") ");
            if(npc.getLocation().getX()==this.getLocation().getX() && npc.getLocation().getY()==this.getLocation().getY()){
                System.out.print("\n"+ optionFormat);
                System.out.println(" Interact with " + npc.getName() );
                optionIndex++;
                options.add("Interact,"+ npc.getName());
            }
        }
     return options;


    }
    public void resolveTurn(int selection, ArrayList<String> options){
        switch(options.get(selection)){
            case("Move,Up"):
            this.move(Coordinates.NORTH_VECTOR);
            break;
            case("Move,Down"):
            this.move(Coordinates.SOUTH_VECTOR);
            break;
            case("Move,Right"):
            this.move(Coordinates.EAST_VECTOR);
            break;
            case("Move,Left"):
            this.move(Coordinates.WEST_VECTOR);
            break;
        }
        ArrayList<NPC> npcs = this.getWorld().getNonPlayerCharacters();
        for(NPC npc : npcs){
            if(options.get(selection).contains(npc.getName())){
                npc.encounter(this);
                SY
            }
        }

    }
    
    
    

}