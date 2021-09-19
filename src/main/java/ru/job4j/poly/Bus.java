package ru.job4j.poly;

public class Bus implements Transport {
    private boolean closeDoor;
    private boolean enableTransmission;
    private boolean gasPedall;
    private  int passengers;
    private final int fuelPrice = 50;

    public int getFuelPrice() {
        return fuelPrice;
    }

    public void setCloseDoor(boolean closeDoor) {
        this.closeDoor = closeDoor;
    }

    public void setEnableTransmission(boolean enableTransmission) {
        this.enableTransmission = enableTransmission;
    }

    public void setGasPedall(boolean gasPedall) {
        this.gasPedall = gasPedall;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    @Override
    public void go() {
        setCloseDoor(true);
        setEnableTransmission(true);
        setGasPedall(true);
    }

    @Override
    public void passengers(int quantity) {
        setPassengers(quantity);
    }

    @Override
    public int fill(int fuel) {
        return getFuelPrice() * fuel;
    }
}
