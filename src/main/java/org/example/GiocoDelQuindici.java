import java.util.*;

class MossaNonValidaException extends Exception {
    public MossaNonValidaException(String messaggio) {
        super(messaggio);
    }
}

public class GiocoDelQuindici {
    private static final int DIM = 4; // Dimensione della matrice 4x4
    private int[][] griglia = new int[DIM][DIM];
    private int rigaVuota, colonnaVuota; // Posizione dello spazio vuoto

    public GiocoDel15() {
        inizializzaGriglia();
        mescolaGriglia();
    }

    // Inizializza la matrice con numeri da 1 a 15 e uno spazio vuoto (0)
    private void inizializzaGriglia() {

        //TO DO - completa il codice
    }

    
    // Mescola la matrice in modo casuale
    private void mescolaGriglia() {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) { // 100 mosse casuali per mescolare
            int mossa = rand.nextInt(4);
            try {
                switch (mossa) {
                    case 0 -> muovi('W'); // Su
                    case 1 -> muovi('A'); // Sinistra
                    case 2 -> muovi('S'); // Giù
                    case 3 -> muovi('D'); // Destra
                }
            } catch (MossaNonValidaException ignored) {
                // Ignoriamo le mosse non valide durante la mescolatura
            }
        }
    }

    // Mostra la matrice
    public void stampaGriglia() {

                //TO DO - completa il codice

    }
    

    // Metodo per spostare una tessera
    public void muovi(char direzione) throws MossaNonValidaException {
        int nuovaRiga = rigaVuota, nuovaColonna = colonnaVuota;

        switch (Character.toUpperCase(direzione)) {
            case 'W' -> nuovaRiga--; // Su
            case 'S' -> nuovaRiga++; // Giù

                    //TO DO - completa il codice

        }

        // Controllo se la mossa è valida
        if (nuovaRiga < 0 || nuovaRiga >= DIM || nuovaColonna < 0 || nuovaColonna >= DIM) {
            throw new MossaNonValidaException("Mossa non valida! Non puoi uscire dai limiti.");
        }

        // Scambia lo spazio vuoto con la tessera selezionata
        griglia[rigaVuota][colonnaVuota] = griglia[nuovaRiga][nuovaColonna];
        griglia[nuovaRiga][nuovaColonna] = 0;
        rigaVuota = nuovaRiga;
        colonnaVuota = nuovaColonna;
    }

    // Controlla se il giocatore ha vinto
    public boolean haVinto() {
        int numero = 1;

        //TO DO - completa il codice

        
        return true;
    }

    // Metodo principale
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GiocoDel15 gioco = new GiocoDel15();

        System.out.println("=== Gioco del 15 ===");
        while (true) {
            gioco.stampaGriglia();
            System.out.println("Inserisci la mossa (W = su, S = giù, A = sinistra, D = destra, Q = esci): ");
            char mossa = scanner.next().charAt(0);

            if (Character.toUpperCase(mossa) == 'Q') {
                System.out.println("Hai abbandonato la partita.");
                break;
            }

            try {
                gioco.muovi(mossa);
                if (gioco.haVinto()) {
                    System.out.println("Complimenti! Hai risolto il puzzle!");
                    gioco.stampaGriglia();
                    break;
                }
            } catch (MossaNonValidaException | IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
