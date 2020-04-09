public abstract class Attack {

    private Integer strength;
    private Integer accuracy;
    private Integer distance;

    public void pickWeapon(Weapon weapon) {
        switch (weapon) {
            case Revolver:
                System.out.println("Ability for quick draw during dull. Best for close range fight");
                this.strength = 5;
                this.accuracy = 3;
                this.distance = 2;
                break;

            case Winchester:
                System.out.println("Highly powered");
                this.strength = 6;
                this.accuracy = 2;
                this.distance = 2;
                break;

            case Whitworth:
                System.out.println("Accurate ");
                this.strength = 2;
                this.accuracy = 5;
                this.distance = 3;
                break;

            default:
                System.out.println("Invalid weapon .");
                break;
        }

    }

    public void attack(Combatant obj, int damage) {
        if (obj.getHealth() - damage <= 0) {
            obj.setHealth(0);
            obj.setDead(true);
        } else {
            obj.setHealth(obj.getHealth() - damage);
        }
    }

    public Integer calculateDamage() {
        return null;
    }

    public enum Weapon {
        Revolver, Winchester, Whitworth,
    }

    public void makesoud(String sound) {
        System.out.println(sound);
    }


}