package com.example.app.util;

import com.example.app.excepcion.IncorrectDateFormatException;

import java.sql.Date;

public class DateUtil {

    public static Date stringToDate(String dateString) {

        try {
            String aux = convertToStandardDateString(dateString);
            dateString = aux;
        } catch (IncorrectDateFormatException e) {
            // Si salta el error que utilice el dateString, que sea el error de Date.valueOf y quien detenga la ejecución del programa.
            System.err.println("Cadena invalida. " + dateString + " - " + e.getMessage());
        }

        return Date.valueOf(dateString);
    }

    public static String dateToString (Date date) {
        return date.toString();
    }

    /**
     * Date.valueOf solo tiene una manera de convertir el date de String a Date, y es con el formato YYYY-MM-DD
     * Si queremos usar el formato DD-MM-YYYY o el DD/MM/YYYY tendremos que convertirlo nosotros
     * */
    private static String convertToStandardDateString (String dateString) throws IncorrectDateFormatException {
        if (dateString.indexOf('/')>=0) {
            dateString = dateString.replace('/', '-');
        }

        String[] dateSplitted = dateString.split("[-]");

        if (dateSplitted.length!=3)
            throw new IncorrectDateFormatException("La fecha debe ser del formato YYYY-MM-DD, YYYY/MM/DD, DD-MM-YYYY o DD/MM/YYYY");

        // Si el tercer valor tiene 4 caracteres pues invertimos el valor
        if (dateSplitted[2].length()==4) {
            String aux = dateSplitted[0];
            dateSplitted[0] = dateSplitted[2];
            dateSplitted[2] = aux;
        }

        return String.join("-", dateSplitted);
    }
}
