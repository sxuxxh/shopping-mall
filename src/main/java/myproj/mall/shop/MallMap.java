/*
 Project: shopping-mall
 Build: Maven
 Class: MallMap - map showing where stores are
*/
package myproj.mall.shop;

public class MallMap {
    // Fields
    private String mallMap;
    private int floorLvl;

    // Constructors
    public MallMap() {
    }

    public MallMap(String mallMap, int floorLvl) {
        this.mallMap = mallMap;
        this.floorLvl = floorLvl;
    }

    // Setters
    public void setMallMap(String mallMap) {
        this.mallMap = mallMap;
    }

    public void setFloorLvl(int floorLvl) {
        this.floorLvl = floorLvl;
    }

    // Getters
    public String getMallMap() {
        return mallMap;
    }

    public int getFloorLvl() {
        return floorLvl;
    }

    // ToString
    @Override
    public String toString() {
        return "MallMap{" +
                "mallMap='" + mallMap + '\'' +
                ", floorLvl=" + floorLvl +
                '}';
    }

    // Method to print mall map
    public static void printMap() {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[36m";
        System.out.println(ANSI_BLUE);
        System.out.println("                FULL MAP OF SKYLINE MALL");
        System.out.println(" ___________________________");
        System.out.println("|  __________  __________   |");
        System.out.println("|  |    E   |  |    F    |  |     _____________________");
        System.out.println("|  |#001____|  |#002_____|  |____/  _________________  |");
        System.out.println("|____________  ____________________/  #009          |  |");
        System.out.println("            |  |                           D    #10 |  |");
        System.out.println("   POND     |  |   PLAYGROUND                       |  |");
        System.out.println("____________|  |____________________________________|  |");
        System.out.println("|  __________   ______________________   ____________  |");
        System.out.println("|  |#003    |  | #008                |   |     #009 |  |");
        System.out.println("|  |        |  |                     |   |          |  |");
        System.out.println("|  |________|  |_____________________|   |__________|  |");
        System.out.println("|______________________________________________________|");
        System.out.print(ANSI_RESET);
    }
}
