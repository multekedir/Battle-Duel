public class Combatant extends Attack  {
    private int health;
    private String name;
    private boolean isVillain;
    private boolean isDead;

    public Combatant(String name, int health, boolean isVillain) {
        this.name = name;
        this.health = health;
        this.isVillain = isVillain;
    }

    public boolean isVillain() {
        return isVillain;
    }

    public void setVillain(boolean villain) {
        isVillain = villain;
    }


    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    class Hero implements specialWeapon{

    }
}
