package conversor.monedas.clases;

public class Validacion {

    private static final int LONGITUD_MONEDA = 3;

    /**
     * Valida que el código de la moneda cumpla con las reglas de ISO 4217.
     *
     * @param monedaTXT Código de la moneda ingresado por el usuario.
     * @return true si es válido, false en caso contrario.
     */
    public static boolean ValidarMoneda (String monedaTXT ){

        if (monedaTXT == null || monedaTXT.trim().isEmpty()) {
            System.out.println("El codigo de la moneda no puede estar vacio. Escriba un valor correcto");
            return false;
        }
        if (monedaTXT.length() != LONGITUD_MONEDA) {
            System.out.println("El codigo de la moneda no debedebe tener exactamente 3 caracteres");
            return false;
        }
        if (!monedaTXT.matches("[a-zA-Z]+")) {
            System.out.println("El código de la moneda solo puede contener letras (sin números ni caracteres especiales)");
            return false;
        }

        return true;

    }

    public static double convertirYValidarMonto(String montoTxt) throws IllegalArgumentException {
        try {
            double monto = Double.parseDouble(montoTxt);
            if (monto <= 0) {
                throw new IllegalArgumentException("El monto debe ser mayor a 0.");
            }
            return monto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error: Solo se permiten valores numéricos.");
        }
    }

}
