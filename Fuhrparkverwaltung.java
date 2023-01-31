import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;   

public class Fuhrparkverwaltung
{
   private ArrayList<Fahrzeug> fahrzeugliste;

   public Fuhrparkverwaltung(ArrayList<Fahrzeug> fahrzeugliste){
        this.fahrzeugliste=fahrzeugliste;
   }

   public float summeDerKm(){
        float sum=0.0f;
        for(Fahrzeug f:fahrzeugliste){
            sum+=f.getGefahreneStrecke();
        }
        return sum;
    }

    public float summeDesGewinns(){
        float sum=0.0f;
        for(Fahrzeug f:fahrzeugliste){
            sum+=f.getEinnahmen();
        }
        return sum;
    }
    //Зроби вивод по алфавіту 
    //не забудь сортувати
    public void sort(){
        for (int a = 1; a < fahrzeugliste.size(); a++) {
            for (int b = 0; b < fahrzeugliste.size() - a; b++) {
                if (((fahrzeugliste.get(b).getKennzechen())
                        .compareTo((fahrzeugliste.get(b + 1).getKennzechen()))) > 0) {
                    
                    Collections.swap(fahrzeugliste, b, b+1);
                }
            }
        }
        for(Fahrzeug e:fahrzeugliste){
            System.out.println(e.getKennzechen());
        }
    }
}
