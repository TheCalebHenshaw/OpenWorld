package ioop.lab4;

public class Adventurer extends WorldEntity{

    private Damage[] attacks = new Damage[3];


    // Task 3.1
    public Adventurer(String name, Coordinates location, int maxHealth, World world, Damage attack) {
        super(name, location, maxHealth, world, attack);
        this.attacks[0] = attack;

    }

    // Task 3.1
    public void addAttack(Damage attack)
    {
        if(attacks.length <4){
            for(int i = 0; i<attacks.length;i++){
                if(attacks[i].getAmount()==0){
                    attacks[i]=attack;
                }
            }
        }
    }

    // Task 3.1
    public void attack(WorldEntity target)
    {
        for(Damage atk : attacks){
            target.takeDamage(atk);
        }
    }

    public Damage[] getAttacks()
    {
        return attacks;
    }
    


}