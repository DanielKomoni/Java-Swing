
/**
 * Beschreiben Sie hier die Klasse Auto.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Auto extends Fahrzeug
{
    private float volumenTank;
    private float verfügbareBenzin;
    private float dVerbrauch; 
    private float preisProLiter;

    public Auto(float volumenTank, float dVerbrauch, int sitzplätze, float grundPreis, String kennzeichen, float kilometerPreis, float preisProLiter){
        super(sitzplätze,grundPreis,kennzeichen,kilometerPreis);
        this.volumenTank=volumenTank; 
        this.preisProLiter=preisProLiter;
        this.dVerbrauch=dVerbrauch; 
        verfügbareBenzin=volumenTank;
    }

    public void volltanken(){
        verfügbareBenzin=volumenTank;
        System.out.println("Fahrzeug vollgetankt");
    }
    
    @Override
    public float berechneFahrpreis(float km) {
        float verbrauchProKm=dVerbrauch/100.0f;
        float verbrauchteBenzin=verbrauchProKm*km;
        if(verfügbareBenzin-verbrauchteBenzin<=0.0f){
            System.out.println("Nicht Genug benzin, fahre Tanken");
            volltanken();
        }else{
            verfügbareBenzin=verfügbareBenzin-verbrauchteBenzin;
        }
        return super.berechneFahrpreis(km)+verbrauchteBenzin*preisProLiter;
    }
   
}
