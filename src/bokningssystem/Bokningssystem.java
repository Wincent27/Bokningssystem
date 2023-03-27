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


    private int visaMeny(Scanner scanner) {
        System.out.println("Välkommen till bokningssystemet!");
        System.out.println("Välj ett alternativ:");
        System.out.println("1. Lägga till en passagerare – boka en obokad plats");
        System.out.println("2. Skriv ut hur många lediga platser det finns");
        System.out.println("3. Beräkna vinsten av antalet sålda biljetter (" + PRIS_PER_PLATS + " kr/st)");
        System.out.println("4. Avsluta programmet");

        return scanner.nextInt();
    }

    private void laggTillPassagerare(Scanner scanner) {
        int ledigaPlatser = MAX_PASSAGERARE - antalBokadePlatser();
        if (ledigaPlatser == 0) {
            System.out.println("Tyvärr finns det inga lediga platser kvar.");
            return;
        }

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

    private void skrivUtLedigaPlatser() {
        int ledigaPlatser = MAX_PASSAGERARE - antalBokadePlatser();
        System.out.println("Det finns " + ledigaPlatser + " lediga platser kvar.");
    }

    private void raknaVinst() {
        int antalSåldaBiljetter = antalBokadePlatser();
        double vinst = antalSåldaBiljetter * PRIS_PER_PLATS;
        System.out.println("Antal sålda biljetter: " + antalSåldaBiljetter);
        System.out.println("Vinst: " + vinst + " kr");
}
    private void avslutaProgrammet() {
    System.out.println("Tack för besöket! Välkommen åter.");
}

private int antalBokadePlatser() {
    int antal = 0;
    for (int i = 0; i < passagerare.length; i++) {
        if (passagerare[i] != null) {
            antal++;
        }
    }
    return antal;
}

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


