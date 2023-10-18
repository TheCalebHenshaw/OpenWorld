package ioop.lab4;

public class TravellingWorldEntity extends WorldEntity{

    public TravellingWorldEntity(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
    }

    // Task 2.1
    public void takeTurn()
    {

    }    
    
    // Task 2.1
    public void move(Coordinates vector)
    {
        this.location.addCoordinates(vector);
    }
    
}
