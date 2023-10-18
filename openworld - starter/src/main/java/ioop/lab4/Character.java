package ioop.lab4;

public class Character extends TravellingWorldEntity {
    private Coordinates goal;

    // Task 3.2
    public Character(String name, Coordinates location, int maxHealth, World world, Damage attack, Coordinates goal) {
        super(name, location, maxHealth, world, attack);
        this.goal = goal;
    }

    // Task 3.2
    public void takeTurn(){
        Coordinates stepToGoal = location.getNextStepTo(goal);
        move(stepToGoal);
    }

    public Coordinates getGoal(){
        return this.goal;
    }

    public void setGoal(Coordinates vector){
        this.goal = vector;
    }



}
