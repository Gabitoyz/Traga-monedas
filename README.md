#Programa de Máquina tragamonedas

##Estructura del proyecto:
El proyecto está dividido en tres clases principales que implementan el patrón MVC. Estas clases son:

1. Model: SlotMachineModel
2. View: SlotMachineModelView
3. Controller: SlotMachineModelController

###Clase SlotMachineModel
SlotMachineModel es la clase que representa el modelo del juego de tragamonedas. Se encarga de manejar la lógica central del juego, incluyendo el saldo del jugador, la generación de símbolos y la evaluación de premios.

####Clase SlotMachineModelView
SlotMachineView es la clase que define la interfaz gráfica del juego de tragamonedas. Se encarga de mostrar los rodillos, manejar la interacción con el usuario y actualizar el estado visual del juego.

######Clase SlotMachineModelController
SlotMachineController es la clase encargada de manejar la lógica del juego y la comunicación entre la vista (SlotMachineView) y el modelo (SlotMachineModel). Implementa concurrencia para animar los rodillos mientras se calcula el resultado del giro.

######Clase TragaPerrasMain
TragaPerrasMain es la clase principal del programa. Se encarga de inicializar la interfaz gráfica, solicitar el saldo inicial al usuario y conectar el modelo con el controlador para iniciar el juego.

#######Cómo jugar
1.Inicia el programa.
2.Ingresa un saldo inicial.
3. Haz clic en el botón “Girar”, para empezar a jugar.
4. Si los tres símbolos coinciden, recibirás un mensaje con el monto ganado.
5. Si no tienes saldo suficiente, podrás agregar más.
6.Sigue jugando hasta que quieras detenerte!.

