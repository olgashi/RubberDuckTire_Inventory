package main;

public class InHouse extends Part {
    private int machineId;

    //default constructor
    public InHouse() {
    }

    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);
        this.machineId = machineID;
    }

    public void setMachineId(int machineID) {
        this.machineId = machineID;
    }

    public int getMachineId() {
        return machineId;
    }
}
