package com.examplespring.pruebamvc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class DatosInfraccion {
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private Date fecha;
    private String descripcion;
    private String legajoDeInspector;
    private String calles;
    private String motivo;
    private String dniInfractor;

    public DatosInfraccion() {
    }

    public DatosInfraccion(Date fecha, String descripcion, String legajoDeInspector, String calles, String motivo,
                           String dniInfractor) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.legajoDeInspector = legajoDeInspector;
        this.calles = calles;
        this.motivo = motivo;
        this.dniInfractor = dniInfractor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLegajoDeInspector() {
        return legajoDeInspector;
    }

    public void setLegajoDeInspector(String legajoDeInspector) {
        this.legajoDeInspector = legajoDeInspector;
    }

    public String getCalles() {
        return calles;
    }

    public void setCalles(String calles) {
        this.calles = calles;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getDniInfractor() {
        return dniInfractor;
    }

    public void setDniInfractor(String dniInfractor) {
        this.dniInfractor = dniInfractor;
    }
}
