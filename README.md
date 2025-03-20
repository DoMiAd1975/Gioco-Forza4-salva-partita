### **Esercizio: Gioco del 15**  
**Obiettivo:**  
Creare un programma in Java che implementi il **Gioco del 15**, un puzzle numerico con una griglia **4x4** dove i numeri da **1 a 15** devono essere ordinati, muovendo le tessere in uno spazio vuoto.  

---

### **Requisiti**
1. **Inizializzare una matrice 4x4** con i numeri da 1 a 15 e uno spazio vuoto `0`.
2. **Mescolare la matrice** in modo casuale all'inizio della partita.
3. **Consentire al giocatore di spostare le tessere** inserendo comandi (`W`, `A`, `S`, `D` per su, sinistra, giù, destra).
4. **Gestire le eccezioni**:
   - Se il giocatore inserisce un comando non valido, lanciare un'eccezione `IllegalArgumentException`.
   - Se il giocatore tenta una mossa impossibile (es. muovere una tessera oltre i bordi), lanciare un'eccezione personalizzata `MossaNonValidaException`.
5. **Controllare la vittoria**: il giocatore vince quando i numeri sono ordinati correttamente.

---

### **Punti Extra**
- Aggiungere un contatore per il numero di mosse.
- Implementare un sistema per annullare l'ultima mossa.

### **DA SAPERE**
- Completare il codice del file GiocoDelQuindici.

Ecco la soluzione del **Gioco del 15** in Java, con l'utilizzo di una **matrice bidimensionale**, gestione delle **eccezioni** e verifica della vittoria.  

---

### **Caratteristiche della soluzione:**
- **Matrice 4x4** con numeri da `1` a `15` e un `0` che rappresenta lo spazio vuoto.  
- **Mescolamento iniziale** per generare una disposizione casuale.  
- **Movimenti con input (`W`, `A`, `S`, `D`)** per spostare le tessere.  
- **Gestione delle eccezioni**:
  - `IllegalArgumentException` se l'input è errato.  
  - `MossaNonValidaException` se la mossa non è consentita.  
- **Verifica della vittoria**, controllando se i numeri sono ordinati correttamente.  

---
### **Come Funziona**
1. Il gioco crea una **griglia 4x4** con numeri da **1 a 15** e uno spazio vuoto `0`.  
2. La griglia viene **mescolata** in modo casuale.  
3. L'utente può muovere una tessera adiacente allo **spazio vuoto** usando i comandi:  
   - `W` (Su)  
   - `A` (Sinistra)  
   - `S` (Giù)  
   - `D` (Destra)  
   - `Q` (per uscire dal gioco)  
4. Se l'utente inserisce un comando non valido (`X`, `Z`, ecc.), viene lanciata una **IllegalArgumentException**.  
5. Se l'utente tenta di fare una **mossa non valida** (es. muoversi oltre i bordi), viene lanciata una **MossaNonValidaException**.  
6. Il gioco termina quando l'utente **ordina correttamente i numeri da 1 a 15**.  

---

### **Esempio di Output**
```
=== Gioco del 15 ===
 1  2  3  4 
 5  6  7  8 
 9 10 11 12 
13 14 15   

Inserisci la mossa (W = su, S = giù, A = sinistra, D = destra, Q = esci):  
A  
Errore: Mossa non valida! Non puoi uscire dai limiti.  

S  
 1  2  3  4  
 5  6  7  8  
 9 10 11   
13 14 15 12  
```

---

### **Varianti ed Estensioni**
- Implementare un **sistema per annullare l'ultima mossa**.  
- Aggiungere un **contatore di mosse**.  
- **Migliorare la mescolatura** garantendo che il puzzle sia sempre risolvibile.  

 
Buon lavoro! 🎲
