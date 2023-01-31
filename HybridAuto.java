
public class HybridAuto extends Auto
{
    public float verfügbareBenzin;
   public HybridAuto(float volumenTank, float dVerbrauch, int sitzplätze, float grundPreis, String kennzeichen, float kilometerPreis,float preisProLiter){
       super(volumenTank, dVerbrauch, sitzplätze, grundPreis, kennzeichen, kilometerPreis,preisProLiter);    
       verfügbareBenzin=volumenTank;
   }    
}
