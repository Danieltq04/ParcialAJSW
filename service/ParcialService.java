package com.examplespring.pruebamvc.service;

import com.examplespring.pruebamvc.model.DatosInfraccion;
import com.examplespring.pruebamvc.repository.DatosInfraccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ParcialService {
    private String dni;

    private final DatosInfraccionRepository datosInfraccionRepository;
    @Autowired
    public ParcialService(DatosInfraccionRepository datosInfraccionRepository){
        this.datosInfraccionRepository = datosInfraccionRepository;
    }
    public  void generatePDFFromTxt(String filename, ArrayList<String> lines) throws IOException {
        // El código está comentado porque me genera errores
        /*Document pdfDoc = new Document(PageSize.A4);
        PdfWriter.getInstance(pdfDoc, new FileOutputStream(filename)).setPdfVersion(PdfWriter.PDF_VERSION_1_7);
        pdfDoc.open();

        Font myfont = new Font();
        myfont.setStyle(Font.NORMAL);
        myfont.setSize(11);
        pdfDoc.add(new Paragraph("\n"));

        String strLine;
        lines.stream().forEach(l->appendLine(pdfDoc,l,myfont));
        pdfDoc.close();*/
    }

    private void appendLine(Document pdfDoc, String line, Font myfont){
        /*try {
            Paragraph para = new Paragraph(line + "\n", myfont);
            para.setAlignment(Element.ALIGN_JUSTIFIED);
            pdfDoc.add(para);
        }catch(Exception e){

        }*/
    }

    public ArrayList<DatosInfraccion> findAllDatos() throws IOException {

        //Si los datos estuviesen en la BD en la nube, los obtengo por el repository
        /*
        return datosInfraccionRepository.findByDniInfractor(getDNI());
         */

        DatosInfraccion dato = new DatosInfraccion(new Date(),"Probando infraccion","Probando legajo","Probando calles","Probando motivo",getDNI());
        ArrayList<DatosInfraccion> infracciones = new ArrayList<DatosInfraccion>();
        infracciones.add(dato);

        ArrayList<String> datosAImprimir = new ArrayList<String>();

        for (DatosInfraccion infraccion:infracciones) {
            datosAImprimir.add(infraccion.getFecha().toString());
            datosAImprimir.add(infraccion.getDescripcion());
            datosAImprimir.add(infraccion.getLegajoDeInspector());
            datosAImprimir.add(infraccion.getCalles());
            datosAImprimir.add(infraccion.getMotivo());
            datosAImprimir.add(infraccion.getDniInfractor());
        }
        generatePDFFromTxt("ruta",datosAImprimir);
        return infracciones;
    }

    public void setDNI(String dni){
        this.dni = dni;
    }
    public String getDNI(){
        return dni;
    }
}
