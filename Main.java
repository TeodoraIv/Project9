package fmi.informatics.hw9;

import fmi.informatics.functional.Rock;

public class Main extends Tasks {
    public static void main(String[] args) {
        firsttask();
        secondtask();
        thirdtask();
        fourthtask();

        Rock onEarth = new Rock();
        onEarth.drop(onEarth.height());
    }
}
