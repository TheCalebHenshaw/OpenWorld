package openworld.terrain;

import openworld.Coordinates;
import openworld.Damage;
import openworld.DamageType;
import openworld.World;
import openworld.entityTypes.TravellingWorldEntity;
import openworld.entityTypes.WorldEntity;


// Task 1.1
public class Volcano extends Terrain  {

    public Volcano(String name, Coordinates location, int maxHealth, World world, Damage attack){
        super(name, location, maxHealth, world, attack);


   } 
   @Override
   public void encounter(WorldEntity traveller){
    if(traveller instanceof TravellingWorldEntity){
        TravellingWorldEntity travel = (TravellingWorldEntity) traveller;
        travel.move(travel.getLocation().findSafeMove(world));
    }
   }
}
