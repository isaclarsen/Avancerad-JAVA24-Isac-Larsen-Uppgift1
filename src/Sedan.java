public class Sedan extends Vehicle {
    //Skapar en unik egenskap för auto pilot
    private static boolean autoPilot;

    public Sedan(double price, String registration, String color, String model, boolean autoPilot) {
        super(price, registration, color, model);
        Sedan.autoPilot = autoPilot;
    }

    public static boolean isAutoPilot() {
        return autoPilot;
    }
}
