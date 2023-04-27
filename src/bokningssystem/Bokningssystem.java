    package bokningssystem;

    /**
 *
 * @author wincent.nordlanderw
 */
    
import java.util.Scanner;

public class Bokningssystem {

    // Konstanter för maximalt antal passagerare och pris per plats.
    private static final int MAX_PASSAGERARE = 21;
    private static final double PRIS_PER_PLATS = 299.90;

    // Två arrayer för att lagra passagerare och födelsedatum.
    private String[] passagerare = new String[MAX_PASSAGERARE];
    private int[] fodelsedatum = new int[MAX_PASSAGERARE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bokningssystem bokningssystem = new Bokningssystem();

        int val;
        // En meny-loop som körs tills användaren väljer att avsluta programmet.
        do {
            val = bokningssystem.visaMeny(scanner);
            switch (val) {
                case 1:
                    bokningssystem.laggTillPassagerare(scanner);
                    break;
                case 2:
                    bokningssystem.skrivUtLedigaPlatser();
                    break;
                case 3:
                    bokningssystem.raknaVinst();
                    break;
                case 4:
                    bokningssystem.avslutaProgrammet();
                    break;
                default:
                    System.out.println("Felaktigt val. Välj igen.");
            }
        } while (val != 4);
    }


    // Metod som visar huvudmenyn och tar inmatning från användaren
    private int visaMeny(Scanner scanner) {
        System.out.println("Välkommen till bokningssystemet!"); // Skriver ut välkomstmeddelande
        System.out.println("Välj ett alternativ:"); // Skriver ut instruktion för att välja ett alternativ
        System.out.println("1. Lägga till en passagerare – boka en obokad plats"); // Skriver ut alternativ 1
        System.out.println("2. Skriv ut hur många lediga platser det finns"); // Skriver ut alternativ 2
        System.out.println("3. Beräkna vinsten av antalet sålda biljetter (" + PRIS_PER_PLATS + " kr/st)"); // Skriver ut alternativ 3 med pris per plats
        System.out.println("4. Avsluta programmet"); // Skriver ut alternativ 4 för att avsluta programmet

            return scanner.nextInt(); // Tar in användarens val
}
    

    // Metod för att lägga till en passagerare
    private void laggTillPassagerare(Scanner scanner) {
        int ledigaPlatser = MAX_PASSAGERARE - antalBokadePlatser(); // Beräknar antalet lediga platser
        
        if (ledigaPlatser == 0) { // Om det inte finns några lediga platser
        System.out.println("Tyvärr finns det inga lediga platser kvar."); // Skriv ut meddelande om att det inte finns några lediga platser
        return; // Returnera från metoden
    }

        // Bokar en ledig plats åt en passagerare
        System.out.println("Det finns " + ledigaPlatser + " lediga platser kvar.");
        int index = forstaLedigaPlatsIndex();
        System.out.print("Ange namn på passagerare: ");
        String namn = scanner.next();
        System.out.print("Ange födelsedatum (ååååmmdd): ");
        int datum = scanner.nextInt();
        passagerare[index] = namn;
        fodelsedatum[index] = datum;
        System.out.println("Bokningen är klar. Tack för att du valde oss!");
    }

    // Skriver ut antalet lediga platser
    private void skrivUtLedigaPlatser() {
        int ledigaPlatser = MAX_PASSAGERARE - antalBokadePlatser();
        System.out.println("Det finns " + ledigaPlatser + " lediga platser kvar.");
    }

    // Räknar ut antalet sålda biljetter och vinsten
    private void raknaVinst() {
        int antalSåldaBiljetter = antalBokadePlatser();
        double vinst = antalSåldaBiljetter * PRIS_PER_PLATS;
        System.out.println("Antal sålda biljetter: " + antalSåldaBiljetter);
        System.out.println("Vinst: " + vinst + " kr");
}
    //Skriver ut avslutningsmeddelande när programmet avslutas.
    private void avslutaProgrammet() {
    System.out.println("Tack för besöket! Välkommen åter.");
}

    //Räknar ut antalet bokade platser genom att upprepa över passagerar-listan
    //och räkna antalet icke-null platser.
    private int antalBokadePlatser() {
        int antal = 0;
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] != null) {
            antal++;
        }
    }
    return antal;
}

    //Hittar indexet för den första obokade platsen genom att upprepa över passagerar-listan
    //och hitta den första positionen som är null.
    private int forstaLedigaPlatsIndex() {
        for (int i = 0; i < passagerare.length; i++) {
            if (passagerare[i] == null) {
                return i;
            }
        }
    // Om det inte finns några null-värden (dvs. alla platser är bokade) så returneras -1.
    return -1;
    }

}


