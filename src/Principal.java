import conversor.monedas.clases.Coin;
import conversor.monedas.clases.ConsultarMoneda;
import conversor.monedas.clases.Validacion;

import java.util.Map;
import java.util.Scanner;

import static conversor.monedas.clases.Validacion.ValidarMoneda;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarMoneda consult = new ConsultarMoneda();
        double tasa = 0;

        try{
            // Solicitar la moneda de origen
            String usuarioMoneda;
            do{
                System.out.println("Escriba la moneda de origen (3 letras, ISO 4217): ");
                usuarioMoneda = teclado.nextLine();
            }while (!Validacion.ValidarMoneda(usuarioMoneda));// Validar la moneda de origen

            // Solicitar el monto de la moneda de origen
            double montoMonedaOrigen;
            do {
                System.out.println("Escriba el monto en " + usuarioMoneda + ": ");
                String montoTxt = teclado.nextLine();
                try {
                    montoMonedaOrigen = Validacion.convertirYValidarMonto(montoTxt); // Validación y conversión
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage()); // Mostrar mensaje de error específico
                    montoMonedaOrigen = -1; // Mantener el bucle activo
                }
            }while (montoMonedaOrigen <= 0); // Repetir hasta que sea un valor válido

            // Solicitar la moneda de destino
            String destinoMoneda;
            do {
                System.out.println("Escriba la moneda de destino (3 letras, ISO 4217): ");
                destinoMoneda = teclado.nextLine();
            } while (!Validacion.ValidarMoneda(destinoMoneda)); // Validar la moneda de destino

            // Buscar tasas de conversión usando la moneda de origen
            Coin coin = consult.buscarCoin(usuarioMoneda);
            if (coin != null) {

                // Obtener las tasas de conversión del objeto Coin
                Map<String, Double> rates = coin.conversion_rates();

                if (rates.containsKey(destinoMoneda)) {
                    tasa = rates.get(destinoMoneda);
                    System.out.println("La tasa de conversión para " + destinoMoneda + " es: " + tasa);
                } else {
                    System.out.println("La moneda " + destinoMoneda + " no se encuentra en las tasas de conversión de la base de datos.");
                    return;
                }
                // Calcular el monto en la moneda de destino
                double montoMonedaDestino = montoMonedaOrigen * tasa;
                System.out.println("El valor de " + montoMonedaOrigen + " " + usuarioMoneda + " equivale a " + montoMonedaDestino + " " + destinoMoneda);

            }else {
                System.out.println("No se pudo obtener la moneda");
            }
        }catch (RuntimeException e){
            System.out.println("Error al obtener la moneda: "+ e.getMessage());
        }finally {
            teclado.close(); // Cerrar el scanner al final
        }

    }

}
