public class SUV extends Vehicle {
    //Skapar en unik egenskap för truck storlek
    private static int truckSize;

    public SUV(double price, String registration, String color, String model, int truckSize) {
        super(price, registration, color, model);
        SUV.truckSize = truckSize;
    }

    public static int getTruckSize() {
        return truckSize;
    }
}
