
import java.util.Random;
import java.util.Scanner;

public class App {

    //Variables globales
    // Elementos necesarios para todas las acciones en los metodos.
    // Planetas, distancia, informacion
    static Scanner scanner = new Scanner(System.in);
    //static int option;
    static String[] planets = { "Mercury", "Venus", "Mars", "Jupiter", "Saturn" };
    static double[] distance = { 91000000.0, 61000000.0, 124000000.0, 588000000.0, 1345000000.0 };// distancia en millones de kilometros
    static String[] information = {"Solid, rocky planet\n| *Closest planet to the sun \n| *the smallest planet in the Solar System. \n| *Temperature from -180°C to +430°C. \n| *No atmosphere or water. ",
    "Second planet from the Sun\n| *Similar size and structure to Earth\n| *Surface temperature around 465°C\n| *No moons\n| *Thick atmosphere of carbon dioxide.",
    "Four planet from the Sun\n| *Known as the 'Red Planet'\n| *Temperature averages -60°C\n| *Two small moons\n| *Evidence of past water",
    "Fifth planet from the Sun\n| *Largest planet in the Solar System\n| *Gas giant with mostly hydrogen and helium\n| *Has 79 known moons\n| *Strong magnetic field\n| *Famous for the Great Red Spot(a massive strom)",
    "Sixth planet form the Sun\n| *Known for its prominent ring system\n| *Gas giant, mainly hydrogen and helium\n| *Second-largest planet in the Solar System\n| *Has 83 known moons\n| *No solid surface" };
    
    static String[] ships = { "Mother ship", "Interplanetary ship", "Spaceship", "Alien ship", "SpaceF5Z" };//naves
    static double[] shipSpeed = { 200000.0, 280000.0, 99000.0, 800000.0, 250000.0 };//Velocidades
    static double[] fuelConsumption = { 1000, 1800, 800, 3000, 1500 };// consumo de combustible por cada millon de kilometros
    static int choosePlanet;// indica la posicion del planeta seleccionado en el arreglo de planetas
    static int chooseship;// indica la posicion de la nave seleccionado en el arreglo de naves
    static double totalFuel;// variable total de combustible para cambiar en el trayecto
    static double totalOxygen;// variable total de oxygeno para cambiar en el trayecto
    static String end = "███████╗ ███╗   ██╗   ███████║\n" +
                        "███╔══╗╗ ████╗  ██║╚══██╔══╝ █║\n" +
                        "███████║ ██╔██╗ ██║   ██║     █║\n" +
                        "███╔═══╝ ██║╚██╗██║   ██║    █║\n" +
                        "███║███  ██║ ╚████║   ███████║  \n" +
                        "  ╚═╝     ╚═══╝  ╚═╝   ";

    public static void main(String[] args) throws Exception {
        
        welcome();
        int option;
        do {
            showMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    selectPlanets();
                    break;
                case 2:
                    selectShip();
                    break;
                case 3:
                    calculateResources();
                    break;
                case 4:
                    printPlanetInformation();
                    break;
                case 5:
                    starSimulation();
                    break;
                case 6:
                    System.out.println(end);
                    System.out.println("+==============================+");
                    System.out.println("| E N D  OF  T H E  T R I P !  |");
                    System.out.println("|                              |");
                    System.out.println("| Thank you for your visit!    |");
                    System.out.println("|                              |");
                    System.out.println("| E N D  O f  P R O G R A M !! |");
                    System.out.println("+==============================+");
                    break;
                default:
                    System.err.println("Invalid option, please, try again");
                    break;
            }
            if (option != 6) {
                pressEnter(scanner);
            }
            scanner.nextLine();
        } while (option != 6);

    }
    // Metodo para dar bienvenida al programa
    public static void welcome() {

        System.out.println(" ========================================= ");
        System.out.println("|                                         |");
        System.out.println("|  W E L C O M E                          |");
        System.out.println("|               T O  T H E                |");
        System.out.println("|                         J O U R N E Y   |");
        System.out.println("|                                         |");
        System.out.println("|  F A S T E N  Y O U R  S E A T B E L T  |");
        System.out.println("|                 |                       |");
        System.out.println("|             -/--  ----                  |");
        System.out.println("|            *  __|__   *                 |");
        System.out.println("|           *            *                |");
        System.out.println("|       ---------(_)----------            |");
        System.out.println("|          *              *               |");
        System.out.println("|         |  *         *  |               |");
        System.out.println("|           |   ° ° °  |                  |");
        System.out.println("|                 |                       |");
        System.out.println(" ========================================= ");
    }
    // Metodo para mostrar el menu del programa
    public static void showMenu() {

        System.out.println("+=============== MAIN MENU ===============+");
        System.out.println("| 1. Select your destination planet       |");
        System.out.println("| 2. Select a ship                        |");
        System.out.println("| 3. Calculate resources                  |");
        System.out.println("| 4. Print informations planet            |");
        System.out.println("| 5. Star flight simulation               |");
        System.out.println("| 6. Exit the program                     |");
        System.out.println("| Please, choose an option                |");
        System.out.println("+=========================================+");
        System.out.print("-> ");
    }
    // Metodo para mostar el planeta seleccionado 
    public static void selectPlanets() {
        
        System.out.println("+================= Planets ===============+");
        printSelectPlanets();
        System.out.println("+=========================================+");
        System.out.print("->");
    }
    // Metodo para imprimir y seleccionar planeta
    public static void printSelectPlanets() {

        for (int i = 0; i < planets.length; i++) {
            System.out.println("| " + (i + 1) + ". " + planets[i]);
        }
        System.out.println("| Select your destination planet");
        System.out.println("+=========================================+");
        System.out.print("-> ");
        int select = scanner.nextInt();
        if (select > 0 && select <= planets.length) {
            System.out.println("+=========================================+");
            System.out.println("| Your destination is: " + planets[select - 1]);
            choosePlanet = select - 1;
        } else {
            System.err.println("Invalid option, please, try again!");
        }
    }
    // Metodo para mostar la informacion basica del planeta 
    public static void printPlanetInformation() {
            
        switch (choosePlanet) {
            case 1:
                System.out.println("+=================== Information ===============+");
                printPlanetData();
                calculateTime();
                System.out.println("+===============================================+");
                break;
            case 2:
                System.out.println("+=================== Information ===============+");
                printPlanetData();
                calculateTime();
                System.out.println("+===============================================+");
                break;
            case 3:
                System.out.println("+=================== Information ===============+");
                printPlanetData();
                calculateTime();
                System.out.println("+===============================================+");
                break;
            case 4:
                System.out.println("+=================== Information ===============+");
                printPlanetData();
                calculateTime();
                System.out.println("+===============================================+");
                break;
            case 5:
                System.out.println("+=================== Information ===============+");
                printPlanetData();
                calculateTime();
                System.out.println("+=================== Information ===============+");
                break;
            default:
                System.err.println("Invalid option*");
                break;
        }
    }
    // Metodo para mostar la nave seleccionada
    public static void selectShip() {
        System.out.println("+=================== Ships ==================+");
        printSelectedShip();
        System.out.println("+============================================+");
    }
    // Metodo para imprimir y seleccionar la nave del viaje
    public static void printSelectedShip() {

        for (int i = 0; i < ships.length; i++) {
            System.out.println("| " + (i + 1) + ". " + ships[i] + "- Velocidad: " + shipSpeed[i]);
        }
        System.out.println("| Select Ship: ");
        System.out.println("+============================================+");
        System.out.print("-> ");
        int select = scanner.nextInt();
        if (select > 0 && select <= ships.length) {
            System.out.println("+============================================+");
            System.out.println("| You ships is: " + ships[select - 1]);
            chooseship = select - 1;
        } else {
            System.err.println("Invalid selection, try again!");
            ;
        }
    }
    // Metodo para calcular el tiempo en horas y dias del viaje
    public static void calculateTime() {

        double time = distance[choosePlanet] / shipSpeed[chooseship];
        double days = time / 24;
        System.out.printf("| Space travel time: %.2f hours\n| It would be %.2f days of travel.\n", time, days);
    }
    // Metodo para calcular recursos del viaje
    public static void calculateResources() {

        double oxygen = distance[choosePlanet] * 100; // por cada millon de kilometros, se necesita 100 unidades de
        totalOxygen = oxygen; // oxigeno
        double fuel = fuelConsumption[chooseship]; // Litros por cada millon de kilometro
        totalFuel = fuel * distance[choosePlanet];// litros para el trayecto
        System.out.println("+=============== Resources ===============+");
        System.out.println("| Units of oxygen required is: " + oxygen );
        System.out.println(
                "| Fuel needed is: " + fuel + " liters/kilometer.\n| Total fuel required: " + totalFuel + " liters");
        System.out.println("| Equipped resources on the trip ");
        System.out.println("+=========================================+");
    }
    // Metodo para iniciar la simulacion
    public static void starSimulation() {

        System.out.println("+================= Star flight simulation =================+");
        Random random = new Random();
        for (int progress = 0; progress <= 100; progress += 10) {
            System.out.println("| " + progress + "%  Progress ");
            int number = random.nextInt(10);
            if (progress == 50) {
                System.out.println("| We have reached the halfway point of the trip.");
                totalFuel = totalFuel / 2;
                System.out.println("| Available fuel: " + totalFuel);
                totalOxygen = totalOxygen / 2;
                System.out.println("| Available oxygen: " + totalOxygen);
            }else if (progress == 100) {
                System.out.println("| We have completed the journey.");
                totalFuel = totalFuel / 2;
                totalOxygen = totalOxygen / 2;
                 
            }
            if (number == 3) {// Realiza un evento aleatorio en problabilidad de 30%
                launchEvent(number);
            } else if (number == 1) {
                launchEvent(number);
            } else if (number == 8) {
                launchEvent(number);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println("Simulation error");
            }
        }
        System.out.println("| Successful arrival on the planet " + planets[choosePlanet]);
        System.out.println("| Arrival, available fuel " + totalFuel + " Liters");
        System.out.println("| Arrival, available oxygen " + totalOxygen + " Units");
    }

    // Metodos auxiliares
    // Metodo para lanzar los eventos en el viaje
    public static void launchEvent(int number) {

        if (number == 1) {

                System.out.println("| System failure");
                System.out.println("| Select an option: ");
                System.out.println("| 1. Repair the spaceship");
                System.out.println("| 2. continue the journey");
                int option = scanner.nextInt();

            if (option == 1) {

                System.out.println("| spaceship repaired, we have fuel permission and oxygen");
                totalFuel = totalFuel - 1010550000;
                System.out.println("| Available fuel: " + totalFuel + " Liters");
                totalOxygen = totalOxygen - 1010550000;
                System.out.println("| Available oxygen: " + totalOxygen + " Units");

            } else if (option == 2) {
                System.out.println(
                        "| We will continue with the failures, once we reach the destination we will repair the ship");// quitar recursos
            } else {
                System.err.println("| Invalid option");
            }
        } else if (number == 3) {

                System.out.println("| Asteroids");
                System.out.println("| Select an option: ");
                System.out.println("| 1. Avoid asteroids");
                System.out.println("| 2. continue your journey avoiding asteroids");
                int option = scanner.nextInt();

            if (option == 1) {

                System.out.println("| Establishing new route to destination, updating resources");
                totalFuel = totalFuel - 555550000;
                System.out.println("| Available fuel: " + totalFuel + " Liters");
                totalOxygen = totalOxygen - 555550000;
                System.out.println("| Available oxygen: " + totalOxygen + " Units");

            } else if (option == 2) {

                System.out.println("| calculating distances from meteorites");
                System.out.println("| establishing positions to avoid them");
                totalFuel = totalFuel - 525105000;
                System.out.println("| Available fuel: " + totalFuel + " Liters");
                totalOxygen = totalOxygen - 525105000;
                System.out.println("| Available oxygen: " + totalOxygen + " Units");

            } else {
                System.err.println("| Invalid option");
            }

        } else if (number == 8) {

                System.out.println("| We must divert the area with a black hole");
                System.out.println("| Select an option: ");
                System.out.println("| 1. Set new route to the right");
                System.out.println("| 2. Set new route to the left");
                int option = scanner.nextInt();

            if (option == 1) {

                System.out.println("| Establishing new route to destination, updating resources");
                totalFuel = totalFuel - 999999999;
                System.out.println("| Available fuel: " + totalFuel + " Liters");
                totalOxygen = totalOxygen - 999999999;
                System.out.println("| Available oxygen: " + totalOxygen + " Units");

            } else if (option == 2) {

                System.out.println("| We have lost control of the ship!");
                System.out.println("| END OF PROGRAM!");
                System.exit(6);

            } else {
                System.err.println("| Invalid option");
            }
        }
    }
    //Metodo para imprimir informacion de los planetas
    public static void printPlanetData() {
        
        System.out.println("| THE PLANET: " + planets[choosePlanet] + "\n| DISTANCE: "
                + distance[choosePlanet] + "KM. " + "\n| BASIC INFORMATION: " + information[choosePlanet]);
    }
    //Metodo para presionar espcacio en cada interaccion 
    public static void pressEnter(Scanner scanner) {
        System.out.println("Press enter to continue");
        scanner.nextLine();
    }
}
