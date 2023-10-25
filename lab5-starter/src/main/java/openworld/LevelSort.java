package openworld;

import java.util.Comparator;
import openworld.monsters.Monster;

// Task 3.1
public class LevelSort implements Comparator<Monster> {

    @Override
    public int compare(Monster m1, Monster m2){
        if(m1.getLevel()==m2.getLevel()){
            return m1.getName().compareTo(m2.getName());
        }
        if(m1.getLevel() >m2.getLevel()){
            return m1.getLevel();
        }
        else{
            return m2.getLevel();
        }

    }

}
