package com.example.app.util;

import org.apache.tomcat.jni.Local;

import java.sql.Date;
import java.time.LocalDate;

public class Tests {

    /*
    * Clase para hacer pequeños tests de diseño
    *
    * TODO: Borrar esta clase
    * */
    public static void main(String[] args) {

        String fecha = "18/1/2";

        Date i = DateUtil.stringToDate(fecha);
        String fecha2 = i.toString();

        System.out.println(fecha2);
    }
}
