package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pelicula {
    private String name;
    private String autor;
    private Date fecha;

    //  get para poder enviar o obtener  el nombre de la pelicula
    public String getName() {
        return name;
    }

    // set para establecer o guardar  el nombre de la película
    public void setName(String name) {
        this.name = name;
    }

    // get para poder enviar o obtener  el nombre del autor
    public String getAutor() {
        return autor;
    }

    // set para establecer o guardar  el nombre del autor
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Getter para obtener la fecha de la película
    public Date getFecha() {
        return fecha;
    }

    // set para establecer la fecha de la película, recibe un String con el formato yyyy/mm/dd
    public void setFecha(String fecha) {
        // se instancia un objeto de la clase SimpleDateFormat, se le indica el formato de la fecha a recibir
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        try {

            // se intenta parsear el String fecha a un objeto de la
            // clase Date, y se establece como atributo fecha de la película
            this.fecha = format.parse(fecha);
        }
        catch (ParseException error) {
            // en caso de haber un error en el parseo de la fecha, se imprime la traza del error
            error.printStackTrace();
        }



    }
}

