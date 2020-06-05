/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;


import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Tab;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import model.Waehrung;
import model.Artikel;

/**
 *
 * generiert eine PDF Datei (Quittung) mit Daten einer Bestellung
 */
public class QuittungMaker {
    private List<Artikel> listArtikel;
    private Waehrung waehrung;
    private Double endsumme;
    private String kundenName;   
    
    public QuittungMaker(List<Artikel> listArtikel, Waehrung waehrung, double endsumme, String kundenName){ 
        this.waehrung = waehrung;        
        this.kundenName = kundenName;
        this.listArtikel = listArtikel;
        this.endsumme = endsumme;  
    }
    
    private String makeList(){        
        StringBuilder listFinal = new StringBuilder();
        long schal = listArtikel.stream()
            .filter(t -> t.getName().equals("Schal"))
            .count();
        long muetze = listArtikel.stream()
            .filter(t -> t.getName().equals("Mütze"))
            .count();
        long stirnband = listArtikel.stream()
            .filter(t -> t.getName().equals("Stirnband"))
            .count();
        long hose = listArtikel.stream()
            .filter(t -> t.getName().contains("Hose"))
            .count();
       
        if (schal != 0){
            listFinal.append("Loop-Schal " + schal + " Stk.\n");
        }
        if (muetze != 0){
            listFinal.append("Mütze " + muetze + " Stk.\n");
        }
        if (stirnband != 0){
            listFinal.append("Stirnband " + stirnband + " Stk.\n");
        }
        if (hose != 0){
            listFinal.append("Hose " + hose + " Stk.\n");
        }
        return listFinal.toString();
    }
    
    public void makePDF(){
        try{
            FileOutputStream fos = new FileOutputStream(new File(kundenName + ".pdf"));
            PdfWriter pdfWriter = new PdfWriter(fos);
            PdfDocument pdf= new PdfDocument(pdfWriter);
           
            Document document = new Document(pdf);
            
            //Schriftart
            PdfFont regular = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            
            Text titelText = new Text("\t\t\tQuittung\n");
            titelText.setFont(bold);
            titelText.setFontSize(20);
            Paragraph titel = new Paragraph().addTabStops(new TabStop(56f, TabAlignment.LEFT));
            titel.add(new Tab());
            titel.add(titelText);      
            
            Text anmerkung = new Text("\tUmsatzsteuer wird nicht ausgewiesen, da der " +
                        "Verkäufer Kleinunternehmer im Sinne des §19 UStG ist.\n\n");
            anmerkung.setFont(regular);
            anmerkung.setFontSize(6);
            Paragraph kleingedrucktes = new Paragraph().addTabStops(new TabStop(40f, TabAlignment.LEFT));
            kleingedrucktes.add(new Tab());
            kleingedrucktes.add(anmerkung);
            
            Text restText = new Text("Für\n" + makeList() + 
                    "\n" +
                    "Gesamt " + waehrung + "\n" + String.format("%.2f", endsumme) + " (inkl. Versandkosten)\n\n\n" +  
                    "Ort/Datum \n" +
                    "Berlin, " + LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.YYYY")) + "\n\n\n" +                     
                    "Peter Inhaber\n" +
                    "Adresse des Inhabers\n" +
                    "12345 Berlin\n" +
                    "Deutschland");
            restText.setFont(regular);
            restText.setFontSize(13);
            Paragraph tobbi = new Paragraph(restText).setTextAlignment(TextAlignment.LEFT);
            
            document.add(titel);
            document.add(kleingedrucktes);
            document.add(tobbi);
       
            document.close();
        } catch (IOException e) {            
            JOptionPane.showMessageDialog(null, "Quittung konnte nicht erstellt werden!", 
                        "Fehler", JOptionPane.WARNING_MESSAGE);            
        }   
    }

}
