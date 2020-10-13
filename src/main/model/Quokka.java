package model;

public class Quokka extends Animals {

    private int getApple = 30;
    private int getBone = 5;
    private int getCarrot = 25;
    private int getFish = 5;
    private int getLeaf = 35;

    public Quokka(){
        super();
    }

    //MODIFIES: this
    //EFFECTS: shows the total points, adding the rewarding points
    public void reward(String treat) {
        if (treat.equals(apple)) {
            points += getApple;
        } else if (treat.equals(bone)) {
            points += getBone;
        } else if (treat.equals(carrot)) {
            points += getCarrot;
        } else if (treat.equals(fish)) {
            points += getFish;
        } else if (treat.equals(leaf)) {
            points += getLeaf;
        }
    }

}
