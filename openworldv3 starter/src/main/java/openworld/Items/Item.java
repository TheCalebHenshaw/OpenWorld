package openworld.Items;

public class Item {
    private String name;
    private int minLevelOfUse;
    private int uses;

    public Item(String name, int minLevelOfUse, int uses){
        this.name = name;
        this.minLevelOfUse = minLevelOfUse;
        this.uses = uses;
    }

    public void setUses(int uses){
        this.uses = uses;
    }
    public int getUses(){
        return this.uses;
    }



}
