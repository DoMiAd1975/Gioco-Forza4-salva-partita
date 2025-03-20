## Lezione: Gestione dei File di Testo in Java con Forza 4

### Introduzione + Esercizio Finale (scrorrere in fondo il documento)

Questa lezione ti guiderà attraverso i concetti fondamentali della gestione dei file di testo in Java, usando il popolare gioco Forza 4 come esempio pratico. Imparerai come salvare lo stato di una partita in un file di testo e come caricare una partita precedentemente salvata per riprenderla in seguito.

### Concetti Fondamentali

* **File di Testo:** I file di testo sono file che contengono dati in formato leggibile dall'uomo, come caratteri, numeri e simboli. In Java, possiamo usare la classe `java.io.File` per rappresentare i file e le classi `java.io.FileReader` e `java.io.FileWriter` per leggere e scrivere dati da/verso file di testo.

* **Salvataggio:** Salvare lo stato di una partita in un file di testo implica scrivere i dati della partita in un file, in un formato che può essere letto in seguito.

* **Caricamento:** Caricare una partita salvata significa leggere i dati della partita da un file di testo e ripristinare lo stato del gioco.

### Esempio: Forza 4

Il gioco Forza 4 è un gioco da tavolo in cui due giocatori si alternano a far cadere delle pedine in una griglia verticale. Il primo giocatore che riesce ad allineare quattro pedine dello stesso colore in orizzontale, verticale o in diagonale vince.

#### Salvataggio della Partita

Per salvare lo stato di una partita di Forza 4, dobbiamo salvare la configurazione della griglia e il giocatore corrente. Questo può essere fatto scrivendo i dati della griglia in un file di testo, separando le righe con un carattere speciale, come il newline (`\n`).

Ecco un esempio di come potrebbe apparire un file di salvataggio per una partita di Forza 4:

```
. . . . . . .
. . . . . . .
. . . . . . .
. . . . . . .
. . . . . . .
X O X O . . .
X
```

* La prima parte del file rappresenta la griglia di gioco, con ogni riga rappresentata da una riga nel file.
* Il punto "." rappresenta una cella vuota, mentre "X" e "O" rappresentano le pedine dei due giocatori.
* La riga finale indica il giocatore corrente ("X" in questo caso).

#### Caricamento della Partita

Per caricare una partita salvata, dobbiamo leggere i dati dal file di testo e ripristinare lo stato del gioco. Questo implica leggere la griglia dal file e impostare il giocatore corrente in base ai dati letti.

### Metodi di Lettura e Scrittura

Per gestire la lettura e la scrittura dei file di testo, possiamo creare due metodi:

1. **`salvaPartita(String nomeFile)`:** Questo metodo salva lo stato della partita corrente nel file specificato dal parametro `nomeFile`.

2. **`caricaPartita(String nomeFile)`:** Questo metodo carica lo stato della partita dal file specificato dal parametro `nomeFile`.

#### Esempio di Codice

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ForzaQuattro {

    // Dimensione della griglia
    private static final int RIGHE = 6;
    private static final int COLONNE = 7;

    // Simboli dei giocatori
    private static final char GIOCATORE_1 = 'X';
    private static final char GIOCATORE_2 = 'O';

    // Griglia di gioco
    private static char[][] griglia;

    // Giocatore corrente
    private static char giocatoreCorrente;

    public static void main(String[] args) {
        // Inizializza il generatore di numeri casuali
        Random random = new Random();

        // Gioca 10 partite
        for (int partita = 1; partita <= 10; partita++) {
            System.out.println("\nPartita " + partita + ":");

            // Inizializza la griglia
            inizializzaGriglia();

            // Giocatore corrente
            giocatoreCorrente = GIOCATORE_1;

            // Gioco in corso
            boolean giocoInCorso = true;

            // Ciclo principale del gioco
            while (giocoInCorso) {
                // Ottiene l'input del giocatore (generato in modo casuale)
                int colonna = random.nextInt(COLONNE);

                // Inserisce la pedina nella griglia
                if (inserisciPedina(colonna, giocatoreCorrente)) {
                    // Controlla se il giocatore ha vinto
                    if (verificaVittoria(giocatoreCorrente)) {
                        // Stampa la griglia finale
                        stampaGriglia();
                        System.out.println("Il giocatore " + giocatoreCorrente + " ha vinto!");
                        giocoInCorso = false;
                    } else {
                        // Controlla se la griglia è piena
                        if (grigliaPiena()) {
                            // Stampa la griglia finale
                            stampaGriglia();
                            System.out.println("Pareggio!");
                            giocoInCorso = false;
                        } else {
                            // Cambia il giocatore corrente
                            giocatoreCorrente = (giocatoreCorrente == GIOCATORE_1) ? GIOCATORE_2 : GIOCATORE_1;
                        }
                    }
                } else {
                    // Se la colonna è piena, riprova con un'altra colonna
                }
            }

            // Salva la partita dopo ogni partita
            salvaPartita("partita_" + partita + ".txt");
        }
    }

    // Inizializza la griglia di gioco
    private static void inizializzaGriglia() {
        griglia = new char[RIGHE][COLONNE];
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                griglia[i][j] = '.';
            }
        }
    }

    // Stampa la griglia di gioco
    private static void stampaGriglia() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                System.out.print(griglia[i][j] + " ");
            }
            System.out.println();
        }
        // Stampa i numeri delle colonne
        for (int i = 0; i < COLONNE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Inserisce una pedina nella griglia
    private static boolean inserisciPedina(int colonna, char simbolo) {
        // Controlla se la colonna è valida
        if (colonna < 0 || colonna >= COLONNE) {
            return false;
        }

        // Trova la posizione più bassa disponibile nella colonna
        for (int i = RIGHE - 1; i >= 0; i--) {
            if (griglia[i][colonna] == '.') {
                griglia[i][colonna] = simbolo;
                return true;
            }
        }

        // Colonna piena
        return false;
    }

    // Verifica se il giocatore corrente ha vinto
    private static boolean verificaVittoria(char simbolo) {
        // Controlla le righe
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j <= COLONNE - 4; j++) {
                if (griglia[i][j] == simbolo && griglia[i][j + 1] == simbolo &&
                        griglia[i][j + 2] == simbolo && griglia[i][j + 3] == simbolo) {
                    return true;
                }
            }
        }

        // Controlla le colonne
        for (int i = 0; i <= RIGHE - 4; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (griglia[i][j] == simbolo && griglia[i + 1][j] == simbolo &&
                        griglia[i + 2][j] == simbolo && griglia[i + 3][j] == simbolo) {
                    return true;
                }
            }
        }

        // Controlla le diagonali \
        for (int i = 0; i <= RIGHE - 4; i++) {
            for (int j = 0; j <= COLONNE - 4; j++) {
                if (griglia[i][j] == simbolo && griglia[i + 1][j + 1] == simbolo &&
                        griglia[i + 2][j + 2] == simbolo && griglia[i + 3][j + 3] == simbolo) {
                    return true;
                }
            }
        }

        // Controlla le diagonali /
        for (int i = 0; i <= RIGHE - 4; i++) {
            for (int j = 3; j < COLONNE; j++) {
                if (griglia[i][j] == simbolo && griglia[i + 1][j - 1] == simbolo &&
                        griglia[i + 2][j - 2] == simbolo && griglia[i + 3][j - 3] == simbolo) {
                    return true;
                }
            }
        }

        // Nessuna vittoria
        return false;
    }

    // Controlla se la griglia è piena
    private static boolean grigliaPiena() {
        for (int j = 0; j < COLONNE; j++) {
            if (griglia[0][j] == '.') {
                return false;
            }
        }
        return true;
    }

    // Salva lo stato della partita in un file di testo
    private static void salvaPartita(String nomeFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeFile))) {
            // Scrive la griglia nel file
            for (int i = 0; i < RIGHE; i++) {
                for (int j = 0; j < COLONNE; j++) {
                    writer.write(griglia[i][j]);
                }
                writer.newLine();
            }

            // Scrive il giocatore corrente nel file
            writer.write(giocatoreCorrente);
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio della partita: " + e.getMessage());
        }
    }

    // Carica lo stato della partita da un file di testo
    private static void caricaPartita(String nomeFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeFile))) {
            // Legge la griglia dal file
            for (int i = 0; i < RIGHE; i++) {
                String riga = reader.readLine();
                for (int j = 0; j < COLONNE; j++) {
                    griglia[i][j] = riga.charAt(j);
                }
            }

            // Legge il giocatore corrente dal file
            giocatoreCorrente = reader.readLine().charAt(0);
        } catch (IOException e) {
            System.err.println("Errore durante il caricamento della partita: " + e.getMessage());
        }
    }
}
```

### Conclusione

Questa lezione ti ha introdotto ai concetti fondamentali della gestione dei file di testo in Java, usando il gioco Forza 4 come esempio pratico. Hai imparato come salvare lo stato di una partita in un file di testo e come caricare una partita precedentemente salvata.

### Esercizio da svolgere

1. Modifica il codice per consentire di giocare tra due umani, tra un umano e il pc oppure totalmente automatico (come adesso).
2. Modifica il codice per creare un menù che consenta di caricare la partita precedentemente salvata e che consenta di salvare la partita allo stato attuale, ivi compreso l'ultimo giocatore che ha fatto la mossa.
3. Modifica il codice presente per permettere all'utente di scegliere il nome del file di salvataggio.
4. Aggiungi la funzionalità per caricare una partita all'inizio del gioco, creando un menù di scelta iniziale: nuova partita (pc vs pc, umano vs pc, umano vs umano) , carica partita esistente, esci dal gioco.
5. Integra la possibilità di poter salvare la partita in qualsiasi momento,  solo per le partite tra umano e pc o tra umano e umano.
6. Implementa una funzione per visualizzare la storia delle partite giocate, leggendo i file di salvataggio.

### Suggerimenti

* Utilizza la classe `java.io.File` per controllare l'esistenza di un file prima di provare a leggerlo o scriverlo.
* Utilizza un blocco `try-with-resources` per gestire automaticamente la chiusura dei file.
* Scegli un formato di file chiaro e leggibile per semplificare la lettura e la scrittura dei dati.

Puoi approfondire ulteriormente la gestione dei file di testo in Java esplorando le diverse classi e metodi disponibili nella libreria Java.  

Buon lavoro! 🎲
