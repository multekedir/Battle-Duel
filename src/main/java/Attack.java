public abstract class Attack{



    public void getAttacked (Combatant obj, int damage){
        if(obj.getHealth() - damage <= 0) {
            obj.setHealth(0);;
            obj.setDead(true);
        } else {
            obj.setHealth(obj.getHealth() - damage);
        }
    }

    public void makesoud(String sound){
        System.out.println(sound);
    }


}