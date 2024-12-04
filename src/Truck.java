public class Truck extends Vehicle{
    //Skapar en unik egenskap för släp tillgänglighet
    static boolean trailerSupport;

    public Truck(double price, String registration, String color, String model, boolean trailerSupport) {
        super(price, registration, color, model);
        Truck.trailerSupport = trailerSupport;
    }

    public static boolean isTrailerSupport() {
        return trailerSupport;
    }
}
