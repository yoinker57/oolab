package agh.ics.oop;

public class World {
    public World() {
    }

    public static void main(String[] args) {
        System.out.println("system wystartował");
        String[] Directions = new String[]{"FORWARD", "BACKWARD", "RIGHT", "LEFT"};
        run(Directions);
        System.out.println("system zakończył działanie");
    }

    public static void run(String[] args) {
        System.out.println("zwierzak idzie do przodu");
        String[] var1 = args;
        int var2 = args.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String element = var1[var3];
            System.out.println(element);
        }

    }
}

