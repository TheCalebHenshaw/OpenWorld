package openworld.Items;

import openworld.Coordinates;
import openworld.entityTypes.TravellingWorldEntity;

public abstract class Item {
    protected Coordinates location;
    private String name;
    private int minLevelOfUse;
    private String description;

    public Item(String name, int minLevelOfUse, String description, Coordinates location){
        this.name = name;
        this.minLevelOfUse = minLevelOfUse;
        this.description = description;
        this.location = location;
    }

    public abstract void use(TravellingWorldEntity entity);

    public Coordinates getLocation(){
        return this.location;
    }
    public String getName(){
        return this.name;
    }




}
