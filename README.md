💱 Conversor de Monedas

¡Bienvenido/a! Este es un programa de **Conversor de Monedas**, elaborado por Juan Ortiz (2024) que te permite convertir valores entre diferentes divisas utilizando una API de tasas de cambio en tiempo real.

🚀 Características

- **Interfaz interactiva**: El programa solicita al usuario ingresar los datos necesarios (moneda de origen, moneda de destino y monto).
- **Validaciones sólidas**:
  - Verifica que los códigos de las monedas sean válidos y cumplan con el estándar ISO 4217.
  - Asegura que el monto ingresado sea numérico y positivo.
- **Consumo de API**: Se conecta a una API de tasas de cambio para obtener información actualizada y confiable.
- **Resultados precisos**: Calcula el valor en la moneda de destino y lo presenta de manera clara.

🛠️ Requisitos

Asegúrate de tener instalado lo siguiente antes de ejecutar el programa:

- **Java 11** o superior.
- Una conexión a Internet (para consumir la API).
- Un IDE o consola para compilar y ejecutar el programa.

## 📦 Estructura del Proyecto

```
conversor-monedas/
│
├── src/
│   ├── conversor/monedas/clases/
│   │   ├── Coin.java               # Clase para modelar los datos de la API
│   │   ├── ConsultarMoneda.java    # Clase para manejar el consumo de la API
│   │   ├── Validacion.java         # Clase para validar entradas del usuario
│   ├── Principal.java              # Clase principal (punto de entrada)
│
└── README.md                       # Documentación del proyecto
```
🧑‍💻 Cómo Usar

1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/juanix360/ConversorMonedas_JuanOrtiz.git
   ```
2. **Abre el proyecto en tu IDE favorito** o compílalo desde la terminal.
   
3. **Sigue las instrucciones en la consola**:
   - Ingresa el código de la moneda de origen (por ejemplo, `USD`).
   - Especifica el monto a convertir.
   - Ingresa el código de la moneda de destino (por ejemplo, `EUR`).
   - El programa calculará el valor convertido y mostrará el resultado.

📡 API Utilizada

Este programa utiliza la API gratuita de [ExchangeRate-API](https://www.exchangerate-api.com/). Asegúrate de incluir tu clave API en la clase `ConsultarMoneda` antes de ejecutar el programa.

```java
private static final String API_URL = "https://v6.exchangerate-api.com/v6/";
private static final String API_KEY = "TU_CLAVE_API"; // Sustituye esto con tu clave API
```

🛡️ Validaciones Implementadas

- **Códigos de Moneda**:
  - Deben tener exactamente 3 letras.
  - Solo se aceptan letras (`A-Z` y `a-z`).
- **Monto**:
  - Debe ser un número.
  - Debe ser mayor a 0.

Si no se cumplen estas condiciones, el programa pedirá que ingreses nuevamente el valor hasta que sea válido.

🌟 Ejemplo de Ejecución

### Entrada:
```
Escriba la moneda de origen (3 letras, ISO 4217): USD
Escriba el monto en USD: 100.50
Escriba la moneda de destino (3 letras, ISO 4217): EUR
```

### Salida:
```
La tasa de conversión para EUR es: 0.92
El valor de 100.50 USD equivale a 92.46 EUR
```

🤔 ¿Cómo Funciona?

1. El usuario ingresa el código de la moneda de origen y el programa valida que sea un código ISO 4217 válido.
2. El usuario ingresa un monto a convertir, y el programa verifica que sea un valor numérico positivo.
3. El usuario ingresa el código de la moneda de destino.
4. El programa consulta las tasas de cambio actuales desde la API, calcula el valor en la moneda de destino y lo presenta al usuario.

## 📚 Aprendizajes

Este proyecto fue diseñado para aprender y practicar:
- **Consumo de APIs en Java** utilizando `HttpClient`.
- Validaciones de entrada de usuario.
- Uso de estructuras como `Map` para manejar datos dinámicos.
- Manejo de excepciones (`try-catch`) para robustecer el código.
- Diseño modular y buenas prácticas en Java.

📝 Notas

- Este proyecto es ideal para principiantes que desean practicar Java y trabajar con APIs.
- Si necesitas más monedas o funcionalidad avanzada, puedes modificar la clase `ConsultarMoneda` para adaptarla a otras APIs.

📧 Contacto

Si tienes sugerencias, preguntas o mejoras, no dudes en contactarme:

- GitHub: [juanix360](https://github.com/juanix360)
- Email: juan.ortiz.e@hotmail.com

---

Espero que disfrutes usando este programa tanto como yo disfruté creándolo. 🚀
