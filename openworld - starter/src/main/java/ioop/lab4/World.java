package ioop.lab4;

public class World {

    private int xDimension;
    private int yDimension;
    private Adventurer adventurer;

    public World(int xDimension, int yDimension) {
        this.xDimension = xDimension;
        this.yDimension = yDimension;

    }

    // Task 3.1
    public void battle(WorldEntity resident, WorldEntity traveller) {
        while(resident.getCurrentHealth() > 0 | traveller.getCurrentHealth() > 0){
            resident.attack(traveller);
            if(traveller.getCurrentHealth() <=0){   //Traveller has been killed
                break;
            }
            traveller.attack(resident);
            if(resident.getCurrentHealth() <=0){ // Resident has been killed
                break;
            }
        }
    }

    public int getxDimension() {
        return xDimension;
    }

    public void setxDimension(int xDimension) {
        this.xDimension = xDimension;
    }

    public int getyDimension() {
        return yDimension;
    }

    public void setyDimension(int yDimension) {
        this.yDimension = yDimension;
    }

    public void setAdventurer(Adventurer adventurer)
    {
        this.adventurer=adventurer;
    }

    public Adventurer getAdventurer()
    {
        return adventurer;
    }

    public static void main(String[] args) {

    }
}
