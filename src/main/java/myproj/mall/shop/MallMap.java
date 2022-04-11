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
}
