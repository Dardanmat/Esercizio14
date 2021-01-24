package esercizi.esercizio14;
import java.util.ArrayList;

public class Volo {
    
    private ArrayList<Bagaglio> listaBagagli;
    private String codice;
    
    public Volo(ArrayList<Bagaglio> listaBagagli, String codice) {
            this.listaBagagli = listaBagagli;
            this.codice = codice;
    }
    
    public ArrayList<Bagaglio> getListaBagagli() {
        return listaBagagli;
    }

    public void setListaBagagli(ArrayList<Bagaglio> listaBagagli) {
        this.listaBagagli = listaBagagli;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
    
    
    
    //Metodo che calcola l'importo totale dei supplementi (totale delle tasse dei bagagli che superano i 25 kg)
    public float importoTotaleSupplementi(){
        float tot = 0;
        for(Bagaglio b: listaBagagli){
            
            tot += b.getTariffaExtra();
        }
        return tot;
    }
    
    public int numeroBagagliEccedenti(boolean b){ // se b è true, allora restituisce il numero di bagagli eccedenti
        int n = 0;                                  // se b è false, restituisce il numero di bagagli non eccedenti
        for(Bagaglio bl: listaBagagli){
            if(bl.isEccedente() == b) n++;
        }
        return n;
    }
    
    public ArrayList<Bagaglio> getListaBagagliEccedenti(){
        ArrayList<Bagaglio> lista = new ArrayList<>();
        
        for(Bagaglio b: listaBagagli){
            if(b.isEccedente()) lista.add(b);
        }
        return lista;
    }

    //Metodo che riceve in input due valori rappresentanti il peso minimo e il peso massimo di un bagaglio e
    //restituisce un elenco con i bagagli con il peso compreso tra i due valori (valori limite inclusi).
    public ArrayList<Bagaglio> listaBagagliNeiLimitiPeso(float min, float max){
        ArrayList<Bagaglio> lista = new ArrayList<>();
        
        for(Bagaglio b: listaBagagli){
            if(b.getPeso()>=min && b.getPeso()<=max) lista.add(b);
        }
        return lista;
    }
    
//    Metodo che, ricevuto in input il nome di un passeggero, stampa a schermo i suoi bagagli con il relativo
//    peso, ad es:
//
//    Nome passeggero: Rossi Mario
//    Bagagli:
//    - Bagaglio1 peso: 20 Kg
//    - Bagaglio2 peso: 18 Kg
//    - Bagaglio3 peso: 27 Kg
//    - Bagaglio4 peso: 28 Kg
//    Se il passeggero non esiste stampare un opportuno messaggio di output.
    public void stampaBagagliPasseggero(String nome){
        boolean trovato = false;
        
        System.out.println("Nome Passeggero: "+nome+"\nBagagli:\n");
        
        for(int i = 0; i < listaBagagli.size(); i++){
            if(listaBagagli.get(i).getNomePropietario().equalsIgnoreCase(nome)){
                trovato = true;
                System.out.println("- Bagaglio " + (i+1) + " peso: " + listaBagagli.get(i).getPeso() + "Kg");
            }
        }
        if(trovato == false) System.out.println("Il passeggero non possiede bagagli nella stiva");
    }
    
    
    
}
