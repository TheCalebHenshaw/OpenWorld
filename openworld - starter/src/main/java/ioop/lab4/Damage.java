package ioop.lab4;

public class Damage {
    private int amount;
    private DamageType damageType;
    private WorldEntity source;

    public Damage(int amount, DamageType damageType) {
        this.amount = amount;
        this.damageType = damageType;
       
    }

    public int getAmount() {
        return amount;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public WorldEntity getSource()
    {
        return source;
    }
}
