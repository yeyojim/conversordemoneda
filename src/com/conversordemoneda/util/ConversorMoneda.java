package com.conversordemoneda.util;

import com.conversordemoneda.model.Moneda;

import java.util.List;

public class ConversorMoneda {


    public void conversor(Moneda coins, List<String> seleccionMonedas, String tipoMoneda1
            , String tipoMoneda2, Double cifraAConvertir){

        if (coins != null && coins.conversion_rate() != null && seleccionMonedas.contains(tipoMoneda1.toUpperCase())
                && seleccionMonedas.contains(tipoMoneda2.toUpperCase())) {
            // Mostramos las tasas de conversión

            Double conversionMoneda = coins.conversion_rate() * cifraAConvertir;

            System.out.println("Tasas de conversión de " + tipoMoneda1.toUpperCase() + " Vs " + tipoMoneda2.toUpperCase() + ":");
            System.out.printf("%.0f %s equivalen en %s a: %.0f%n",
                    cifraAConvertir,
                    tipoMoneda1.toUpperCase(),
                    tipoMoneda2.toUpperCase(),
                    conversionMoneda);

        }
        else{
            System.out.println("elija solo las monedas disponibles o revise su internet");

        }




    }
}
