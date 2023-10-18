package ioop.lab4;

public class Coordinates {
    public final static Coordinates NORTH_VECTOR = new Coordinates(1, 0);
    public final static Coordinates SOUTH_VECTOR = new Coordinates(-1, 0);
    public final static Coordinates EAST_VECTOR = new Coordinates(0, 1);
    public final static Coordinates WEST_VECTOR = new Coordinates(0, -1);
    public final static Coordinates STATIONARY = new Coordinates(0, 0);

    private int x;
    private int y;

    // Task 1.1
    public Coordinates(int x, int y) { //Current coordinates?
        this.x = x;
        this.y = y;

    }

    // Task 1.1
    public void addCoordinates(Coordinates vector) {
        this.x +=vector.getX();
        this.y +=vector.getY();
    }

    // Task 1.1
    public Coordinates findSafeMove(World world) {
        int currentX = this.x;
        int currentY= this.y;
        int xbound = world.getxDimension();
        int ybound = world.getyDimension();

        if(currentX < xbound){
            return NORTH_VECTOR;
        }
        if(currentY < ybound){
            return EAST_VECTOR;
        }
        if(currentX > 0){
            return SOUTH_VECTOR;
        }
        if(currentY > 0){
            return  WEST_VECTOR;
        }
        return STATIONARY;
    }

    // Task 1.2
    public Coordinates getNextStepTo(Coordinates destination) {
        int xchange = destination.getX()-x;
        int ychange = destination.getY()-y;


        int xdiff = Math.abs(destination.getX()-x);
        int ydiff = Math.abs(destination.getY()-y);
        if(xchange==0 && ychange == 0){
            return STATIONARY;
        }
                                                        //check if x is more favorable, or y is favorable
        if(xdiff >= ydiff){
            if(xchange > 0){
                return NORTH_VECTOR;
            }
            else{
                return SOUTH_VECTOR;
            }
            }
        else{
            if(ydiff > 0){
                return EAST_VECTOR;
            }
            else{
                return WEST_VECTOR;
            }
        }


  
    }
    // Task 1.3
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

            Coordinates check = (Coordinates)obj;
            return this.x == check.getX() && this.y == check.getY();


        
        

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
