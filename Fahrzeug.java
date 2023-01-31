
/**
 * Beschreiben Sie hier die Klasse Fahrzeug.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public abstract class Fahrzeug
{
    private int sitzplätze; 
    private float grundPreis; 
    private String kennzeichen; 
    private float kilometerPreis; 
    private float gefahreneStrecke; 
    private float einnahmen;
    private float kilometerstand; 
    
    public Fahrzeug(int sitzplätze, float grundPreis, String kennzeichen, float kilometerPreis){
        this.sitzplätze=sitzplätze; 
        this.grundPreis=grundPreis; 
        this.kennzeichen=kennzeichen; 
        this.kilometerPreis=kilometerPreis; 
        gefahreneStrecke=0.0f;
        einnahmen=0.0f; 
    }

    public String getKennzechen(){
        return kennzeichen;
    }

    public float getGefahreneStrecke(){
        return gefahreneStrecke;
    }

    public float getEinnahmen(){
        return einnahmen;
    }

    public void reset(){
        gefahreneStrecke=0.0f; 
        einnahmen=0.0f; 
    }
    
    public float berechneFahrpreis(float km){
        float fahrpreis=0;
        fahrpreis+=grundPreis;
        einnahmen+=grundPreis;
        kilometerstand+=km;
        gefahreneStrecke+=km;
        
        if(km<=3){
            return fahrpreis;
        }else{
            km=km-3;
            fahrpreis+=km*kilometerPreis;
            einnahmen+=km*kilometerPreis;
            return fahrpreis;
        }
        
    }
}
