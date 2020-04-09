public class Combatant extends Attack implements Heal {

    private int health;
    private String name;
    private boolean isDead;
    private boolean isVillain;

    public Combatant(String name, boolean isVillain) {
        this.name = name;
        this.health = 0;
        this.isVillain = isVillain;
    }

    public Combatant(String name) {
        this.name = name;
        this.health = 0;
        this.isVillain = false;
    }

    public int getHealth() {
        return health;
    }

    protected void setHealth(int health) {
        this.health += health;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public String getStatus() {
        return "";
    }

    @Override
    public String toString() {
        return "Combatant{" +
                "health=" + health +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean heal() {
        int howMuch = this.isVillain ? 10 : 0;
        this.setHealth(10);
        return howMuch != 0;
    }
}

