🎰 Programa de Máquina Tragamonedas

✨ Estructura del Proyecto

El proyecto está dividido en tres clases principales que implementan el patrón MVC. Estas clases son:

Model: SlotMachineModel

View: SlotMachineView

Controller: SlotMachineController

🎯 Descripción de las Clases

📚 Clase SlotMachineModel

SlotMachineModel es la clase que representa el modelo del juego de tragamonedas. Se encarga de manejar la lógica central del juego, incluyendo:

El saldo del jugador.

La generación de símbolos aleatorios.

La evaluación de premios según los resultados del giro.

📺 Clase SlotMachineView

SlotMachineView define la interfaz gráfica del juego de tragamonedas. Sus principales funciones incluyen:

Mostrar los rodillos con los símbolos.

Manejar la interacción con el usuario.

Actualizar el estado visual del juego con cada giro.

⚖️ Clase SlotMachineController

SlotMachineController maneja la lógica del juego y la comunicación entre la vista (SlotMachineView) y el modelo (SlotMachineModel). Además, implementa concurrencia para:

Animar los rodillos mientras se calcula el resultado del giro.

Gestionar las apuestas y el saldo del jugador.

🎡 Clase TragaPerrasMain

TragaPerrasMain es la clase principal del programa. Se encarga de:

Inicializar la interfaz gráfica.

Solicitar el saldo inicial al usuario.

Conectar el modelo con el controlador para iniciar el juego.

🎲 Cómo Jugar

Inicia el programa.

Ingresa un saldo inicial.

Haz clic en el botón “Girar” para empezar a jugar.

Si los tres símbolos coinciden, recibirás un mensaje con el monto ganado.

Si no tienes saldo suficiente, podrás agregar más.

¡Sigue jugando hasta que quieras detenerte!

