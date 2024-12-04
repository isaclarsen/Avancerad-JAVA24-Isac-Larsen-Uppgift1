abstract class Vehicle implements Rentable {
    //Definiera bilens egenskaper
    private String model;
    private String color;
    private String registration;
    private double price;
    private int days;
    boolean isRented;

    //CONSTRUCTOR
    public Vehicle(double price, String registration, String color, String model) {
        this.price = price;
        this.registration = registration;
        this.color = color;
        this.model = model;
        this.isRented = false;
    }
//----------------------------------------------------------------
    //Getter för modell
    public String getModel() {
        if (!isRented) {
            return model;
        }else
            return model + " (rented)";
    }
    //Setter för modell
    public void setModel(String model) {
        this.model = model;
    }
    //Getter för färg
    public String getColor() {
        return color;
    }
    //Settet för färg
    public void setColor(String color) {
        this.color = color;
    }
    //Getter för regnummer
    public String getRegistration() {
        return registration;
    }
    //Setter för regnummer
    public void setRegistration(String registration) {
        this.registration = registration;
    }
    //Getter för pris
    public double getPrice() {
        return price;
    }
    //Setter för pris
    public void setPrice(double price) {
        this.price = price;
    }

    //Getter för dagar
    public int getDays() {
        return days;
    }
    //Setter för dagar
    public void setDays(int days) {
        this.days = days;
    }

//-------------------------------------------------------------------
//METODER
    //Räkna ut kostnaden
    public double calculateCost(){
        //Om bilen inte är uthyrd skriv ut att den inte är det
        if (!isRented) {
            System.out.println(model + " har inte blivit uthyrd");
            System.out.println("-----------------------------------------");
            //Returnera 0 så att priset inte förändras
            return 0;
            //Om bilen är uthyrd skriv ut i hur många dagar och totala priset för hyrningen
        }else if (isRented) {
            System.out.println(model + " är hyrd i " + days + " dygn och kommer att kosta: " + days * price + "kr");
            System.out.println("-----------------------------------------");
        }
        return days * price;
    }

    @Override
    public void rentVehicle() {
        // Om bilen inte redan är uthyrd fråga hur många dagar man vill hyra bilen
            if(!isRented){
                System.out.println("Hur många dygn vill du hyra fordonet?");
                isRented = true;
                //Om den redan är uthyrd, skriv ut att den redan är uthyrd
            }else
                System.out.println(model  + " är redan uthyrd!");
        }

    @Override
    public void returnVehicle() {
        //Om bilen är hyrd skriv ut att bilen har lämnats tillbaka och sätt isRented till false
        if (isRented){
            System.out.println(model + " är nu tillbakalämnad till oss");
            isRented = false;
            //Annars (bilen är inte uthyrd) skriv att den inte går att returnera för att den inte är uthyrd
        }else
            System.out.println(model + " är inte uthyrd");
    }

    public void rentStatus(boolean isRented){
        this.isRented = isRented;
    }
}
