import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;  

public class Main {
    public static void main(String[] args) {
        

    JFrame frame=new JFrame("Taxi Unternehmen");  
    JLabel modellWahl=new JLabel("Wähle den Typ");
    JLabel sitzplätzeWählen=new JLabel("Sitzplätze");
    JLabel kennzeichenwahl= new JLabel("Schreiben den Kennzeichen");
    JTextField kennzeichen=new JTextField();
    JTextField tankGröße= new JTextField();
    JTextField verbrauch=new JTextField();
    JLabel tankgrößeWahl=new JLabel("Tankgröße");
    JLabel verbrauchWählen=new JLabel("Verbrauch");
    JLabel grundpreisWählen=new JLabel("Geundpreis:");
    JLabel preisProKmWählen=new JLabel("Pris pro km:");
    JTextField grundpreis=new JTextField();
    JTextField preisProKm=new JTextField();
    JButton fahrzeugBestätigen=new JButton("Bestätigen");
    DefaultListModel<String> l1 = new DefaultListModel<>();  
    l1.addElement("Auto");  
    l1.addElement("Rikscha");  
    l1.addElement("Hybrid");    
    JList<String> list = new JList<>(l1);  
    SpinnerModel value=new SpinnerNumberModel(
        3,
        3,
        9,
        1
    );
    JSpinner plätze=new JSpinner(value);   
    String column[]={"Typ","Sitzplätze","Kennzeichen","Tankgröße","Verbrauch","Preis pro km", "grundpreis"};         
    JTable jt=new JTable();      
    DefaultTableModel dtm = new DefaultTableModel(0, 0);
    dtm.setColumnIdentifiers(column);
    jt.setModel(dtm);
    JScrollPane jp=new JScrollPane(jt);
    JButton auftragBestätigen=new JButton("Auftrag");
    JLabel gebenSieDenAbstand=new JLabel("Länge:");
    JTextField strecke=new JTextField();
    JLabel nummer=new JLabel("Kennzeichen:");
    JTextField nummerEingabe=new JTextField();
    JLabel statistic=new JLabel("Gewinn: ");
    JLabel statistic2=new JLabel("Gesammtstrecke: ");
    JLabel gewinnSumme=new JLabel();
    JLabel streckeSumme=new JLabel();
    
    gewinnSumme.setBounds(680, 300, 100, 20);
    streckeSumme.setBounds(730,330,100,20);
    statistic.setBounds(611, 300, 50, 20);
    statistic2.setBounds(611, 330, 120, 20);
    nummerEingabe.setBounds(700, 235, 50, 20);
    nummer.setBounds(611,220,100,50);
    strecke.setBounds(700,215,50,20);
    gebenSieDenAbstand.setBounds(650,200,100,50);
    auftragBestätigen.setBounds(650, 170, 100, 40);
    jp.setBounds(0,170,600,200);
    fahrzeugBestätigen.setBounds(250,100,100,30);
    preisProKm.setBounds(573,10,30,30);
    grundpreis.setBounds(573,40,30,30);
    preisProKmWählen.setBounds(500,10,70,30);
    grundpreisWählen.setBounds(500,40,70,30);
    verbrauch.setBounds(386,40,65,52);
    verbrauchWählen.setBounds(390,0,65,30);
    tankgrößeWahl.setBounds(324,0,65,30);
    tankGröße.setBounds(324,40,65,52);
    kennzeichenwahl.setBounds(160, 0, 170, 30);
    kennzeichen.setBounds(155,40,170,52);
    sitzplätzeWählen.setBounds(100,0,70,30);
    plätze.setBounds(100,40,55,52);   
    modellWahl.setBounds(0, 0, 100, 30);
    list.setBounds(0,40, 100,52); 
    frame.add(gewinnSumme);
    frame.add(streckeSumme);
    frame.add(statistic);
    frame.add(statistic2);
    frame.add(nummerEingabe);
    frame.add(nummer);
    frame.add(strecke);
    frame.add(gebenSieDenAbstand);
    frame.add(auftragBestätigen);
    frame.add(fahrzeugBestätigen);
    frame.add(grundpreis);
    frame.add(preisProKm);
    frame.add(grundpreisWählen);
    frame.add(preisProKmWählen);
    frame.add(verbrauch);
    frame.add(verbrauchWählen);
    frame.add(tankgrößeWahl);
    frame.add(tankGröße);
    frame.add(kennzeichen);
    frame.add(kennzeichenwahl);
    frame.add(sitzplätzeWählen);
    frame.add(plätze);
    frame.add(modellWahl);
    frame.add(list); 
    frame.add(jp);
    frame.setSize(1000,700);  
    frame.setLayout(null);  
    frame.setVisible(true);   
    
    ArrayList<Fahrzeug> autoList=new ArrayList<Fahrzeug>();
    
    fahrzeugBestätigen.addActionListener(e -> {
        
       String rFahrzeugtyp = list.getSelectedValue();
       int rSitzplätze = (int)plätze.getValue();
       String rKennzeichen=kennzeichen.getText();
       float rTankgröße=Float.parseFloat(tankGröße.getText());
       float rVerbrauch=Float.parseFloat(verbrauch.getText());
       float rPreisProKm=Float.parseFloat(preisProKm.getText());
       float rGrundpreis=Float.parseFloat(grundpreis.getText());
       if(rFahrzeugtyp=="Rikscha"){
        Rischa rikscha=new Rischa(rSitzplätze, rGrundpreis, rKennzeichen, rPreisProKm);
        autoList.add(rikscha);
       }else if(rFahrzeugtyp=="Auto"){
        Auto auto = new Auto(rTankgröße, rVerbrauch, rSitzplätze, rGrundpreis, rKennzeichen, rPreisProKm, 0.50f);
        autoList.add(auto);
       }else if(rFahrzeugtyp=="Hybrid"){
        HybridAuto hybridAuto=new HybridAuto(rTankgröße, rVerbrauch, rSitzplätze, rGrundpreis, rKennzeichen, rPreisProKm, 0.20f);
        autoList.add(hybridAuto);
       }        
        dtm.addRow(new Object[] { rFahrzeugtyp, rSitzplätze, rKennzeichen,
                rTankgröße, rVerbrauch, rPreisProKm, rGrundpreis }); 
                System.out.println("Size 1 "+ autoList.size());               
    });
    
    Fuhrparkverwaltung fuhrparkverwaltung=new Fuhrparkverwaltung(autoList);
    auftragBestätigen.addActionListener(e->{
        String rKennzeichen = nummerEingabe.getText();
        float rStrecke =Float.parseFloat(strecke.getText());
        
       for(int i=0;i<autoList.size();i++){
            if(autoList.get(i).getKennzechen().equals(rKennzeichen)){
                autoList.get(i).berechneFahrpreis(rStrecke);
                gewinnSumme.setText(String.valueOf(fuhrparkverwaltung.summeDesGewinns()));
                streckeSumme.setText(String.valueOf(fuhrparkverwaltung.summeDerKm()));
            }
       }
       
    });
    

    }
}
