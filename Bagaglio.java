package esercizi.esercizio14;


public class Bagaglio {
    
    private static float limitePeso = 25; //peso massimo di un bagaglio
    private static float supplemento = 5; //5€/kg
    
    private float peso;
    private String nomePropietario;
    private boolean eccedente;

    public Bagaglio(float peso, String nomePropietario) {
        this.peso = peso;
        this.nomePropietario = nomePropietario;
    }
    
    public Bagaglio(Bagaglio b) {
        this.peso = b.peso;
        this.nomePropietario = b.nomePropietario;
    }
       
    public Bagaglio() {
        this.peso = 0;
        this.nomePropietario = "";
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNomePropietario() {
        return nomePropietario;
    }

    public void setNomePropietario(String nomePropietario) {
        this.nomePropietario = nomePropietario;
    }
    
    public float getTariffaExtra(){
        
        if(limitePeso <= this.peso ){
            return supplemento*(this.peso - limitePeso);
        }
        return 0;
    }

    public static float getLimitePeso() {
        return limitePeso;
    }

    public static float getSupplemento() {
        return supplemento;
    }
    
    public boolean isEccedente(){
        if(peso <= limitePeso) return false;
        else return true;
    }
    
}
