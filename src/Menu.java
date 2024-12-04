import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    //Skapar objekten
    Scanner input = new Scanner(System.in);
    Vehicle sedan = new Sedan(599, "GUV153", "Svart", "Mercedes", true);
    Vehicle suv = new SUV(799, "ITJ564", "Orange", "Range Rover", 50);
    Vehicle truck = new Truck(999, "UDK985", "Gul", "Volvo", true);

    public void virtualCarRentMenu(){
        //Menyn börjar här
        while(true){
            System.out.println("Välkommen till Biluthyrning!");
            System.out.println("----------------------------");
            System.out.println("Välj ditt val");
            System.out.println("1. Visa tillgängliga fordon");
            System.out.println("2. Hyr ett fordon");
            System.out.println("3. Returnera ett fordon");
            System.out.println("4. Visa totala kostnaden");
            System.out.println("");
            System.out.println("5. Stäng av programmet");

            int choice;

            Scanner input = new Scanner(System.in);

            //Catchar vid fel input, börjar om loopen i det fall man skriver fel
            try {
                choice = input.nextInt();
                input.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Ogiltig inmatning! Vänligen ange en siffra.");
                input.nextLine();
                continue;
            }

            //Om 1, visa tillgängliga bilar och deras egenskaper
            if(choice == 1){
                System.out.println("Tillgängliga bilar: ");
                System.out.println("Sedan: " + sedan.getModel() +
                        "\n \tFärg: " + sedan.getColor() +
                        "\n \tRegnummer: " + sedan.getRegistration() +
                        "\n \tPris per dygn: " + sedan.getPrice() +
                        "\n \tAutopilot: " + Sedan.isAutoPilot());
                System.out.println("SUV: " + suv.getModel() +
                        "\n \tFärg: " + suv.getColor() +
                        "\n \tRegnummer: " + suv.getRegistration() +
                        "\n \tPris per dygn: " + suv.getPrice() +
                        "\n \tBagageutrymme i liter: " + SUV.getTruckSize());
                System.out.println("Truck: " + truck.getModel() +
                        "\n \tFärg: " + truck.getColor() +
                        "\n \tRegnummer: " + truck.getRegistration() +
                        "\n \tPris per dygn: " + truck.getPrice() +
                        "\n \tSläp anpassad?: " + Truck.isTrailerSupport());
                System.out.println("Tryck enter för att komma tillbaka till huvudmenyn");
                input.nextLine();
                continue;
            //Om 2 visa bilarna som finns att hyra
            }else if (choice == 2){
                System.out.println("Vilket fordon vill du hyra?");
                System.out.println("---------------------------");
                System.out.println("1: " + sedan.getModel() + " (Sedan)");
                System.out.println("2: " + suv.getModel() + " (Suv)");
                System.out.println("3: " + truck.getModel() + " (Truck)");
                System.out.println("");
                System.out.println("4: Gå tillbaka till huvudmenyn");
                choice = input.nextInt();
                //Hämta rentVehicle metoden för respektive bil som ska hyras och använd setDays för att spara antalet dagar
                if (choice == 1){
                    sedan.rentVehicle();
                    sedan.setDays(input.nextInt());
                    System.out.println(sedan.getModel()  + " är nu uthyrd till dig!");
                    continue;

                } else if (choice == 2) {
                    suv.rentVehicle();
                    suv.setDays(input.nextInt());
                    System.out.println(suv.getModel()  + " är nu uthyrd till dig!");
                    continue;

                } else if (choice == 3) {
                    truck.rentVehicle();
                    truck.setDays(input.nextInt());
                    System.out.println(truck.getModel()  + " är nu uthyrd till dig!");
                    continue;
                } else if (choice == 4) {
                    continue;
                }else
                    System.out.println("Ojsan du skrev inte in något av alternativen");
                    System.out.println("Tryck enter för att komma tillbaka till huvudmenyn");
                    input.nextLine();
                    input.nextLine();
                    continue;
                //Om 3 visa bilarna och låt användaren välja vilken bil man vill returnera
            }else if (choice == 3){
                System.out.println("Vilket fordon vill du returnera?");
                System.out.println("---------------------------");
                System.out.println("1: " + sedan.getModel());
                System.out.println("2: " + suv.getModel());
                System.out.println("3: " + truck.getModel());
                System.out.println("");
                System.out.println("4. Gå tillbaka till huvudmenyn");
                choice = input.nextInt();
                //Hämta returnVehicle metoden för respektive bil som ska returneras
                if (choice == 1){
                    sedan.returnVehicle();
                    continue;
                }else if (choice == 2){
                    suv.returnVehicle();
                    continue;
                }else if (choice == 3){
                    truck.returnVehicle();
                    continue;
                }else
                    continue;
            //Om 4, skapa en double variabel med startvärde 0
            }else if (choice == 4){
                double totalCost = 0;
                //Hämta calculateCost metoden och lägg in kostnaden i totalcost
                totalCost += sedan.calculateCost();
                totalCost += suv.calculateCost();
                totalCost += truck.calculateCost();
                //Skriv ut den totala kostnaden
                System.out.println("Den totala kostnaden blir: " + totalCost + "kr");
                System.out.println("Tryck enter för att komma tillbaka till huvudmenyn");
                input.nextLine();
                continue;
            //Om 5, stäng av programmet
            }else if (choice == 5){
                System.out.println("Programmet stängs nu av!");
                break;
            //Om användare skriver in fel gå tillbaka till menyn
            }else
                System.out.println("Hoppsan, något blev knasigt!");
            System.out.println("Tryck enter för att komma tillbaka till huvudmenyn");
            input.nextLine();
        }
        input.close();
    }
}
