package com.conversordemoneda.model;

import com.conversordemoneda.util.ConversorMoneda;
import com.conversordemoneda.util.SeleccionMonedas;


import java.util.List;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("si desea hacer una conversion entre monedas marque 1 de lo contrario marque 0");
        String opcion = scanner.nextLine();
        if (opcion.equals("0")){
            System.out.println("Gracias por usar nuestros servicios");

        }


        while (opcion.equals("1")){


            String monedas = """
                Seleccione entre las siguientes monedas:
                    ARS - Peso argentino
                    BOB - Boliviano boliviano
                    BRL - Real brasileño
                    CLP - Peso chileno
                    COP - Peso colombiano
                    USD - Dólar estadounidense
                """;

            System.out.println(monedas);
            System.out.println("elija una moneda");
            String tipoMoneda1 = scanner.next();
            System.out.println("elija otra moneda");
            String tipoMoneda2 = scanner.next();
            System.out.println("Ingrese la cifra a convertir");
            Double cifraAConvertir = scanner.nextDouble();



            BusquedaHttp busquedaHttp = new BusquedaHttp();
            Moneda coins = busquedaHttp.moneda(tipoMoneda1, tipoMoneda2);
            System.out.println("Tipo de moneda: " + coins);

            SeleccionMonedas seleccionMonedas1 = new SeleccionMonedas();
            List<String> seleccionMonedas = seleccionMonedas1.listaMonedas();

            ConversorMoneda conversorMoneda = new ConversorMoneda();
            conversorMoneda.conversor(coins, seleccionMonedas, tipoMoneda1,
                    tipoMoneda2, cifraAConvertir );



            System.out.println("Desea continuar marque 1 de lo contrario marque 0");
            opcion=scanner.next();

            if (opcion.equals("0")){
                System.out.println("Gracias por usar nuestros servicios");
                break;

            }
        }
        scanner.close();









    }
}

