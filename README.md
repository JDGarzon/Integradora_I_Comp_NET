# Conmputacion en Internet: Proyecto final

**Universidad:**
Universidad Icesi
**Maestro:**
Juan Manuel Madrid
**Participantes:**
Geovanny Quintero - A00378039
Juan David Garzon - A00377983
Samuel Adrian Soto - A00377818

## Informe del proyecto

### Sobre el programa creado
El programa creado se hizo utilizando la teoria del protocolo TCP para establecer una conexion entre 2 host: un cliente y un servidor. Se amplio la capacidad de conectar clientes a travez de un servidor en comun para establecer la comunicacion entre ellos con el servidor como intermediario.

El codigo utiliza un socket TCP que abre un flujo de datos a travez de un puerto especificado desde el host que enviara informacion, ya sea para el chat, el permiso de entrada o la alarma de panico. Se utilizo la conexión TCP debido a que las funcionalidad del programa requieren una entrega de informacion precisa, más que rapida.

El programa cumple con 3 funcionalidades basicas, siendo porteria un host servidor y los apartamentos hosts clientes:
* Anuncio de visita y autorización apertura de puerta: Cuando el portero reciba a un visitante en la portería, digitará el nombre del visitante en la terminal, y especificará el apartamento al que se dirige el visitante. En ese momento debe sonar un timbre en la terminal del apartamento, y se mostrará el nombre del visitante en pantalla. El residente del apartamento dispondrá de dos botones marcados “Admitir” y “Denegar”. Dependiendo del botón que se oprima, el portero recibirá un mensaje indicando si puede dejar pasar o no al visitante. 
* Conversación entre apartamentos: El residente de un apartamento debe ser capaz de  iniciar un chat con el residente del otro. 
* Botón de pánico: En caso de emergencia, el residente podrá presionar un “botón de pánico” que avise de la emergencia en portería y envíe un correo electrónico a una persona que el residente tenga registrada como contacto de emergencia.

### Dificultades
Para establecer la funcionalidad del chat:
* la conexion entre dos host clientes requerian estar conectadas a una misma red. Por ello, no fue posible probar el funcionamiento del codigo si no hasta las etapas finales del desarrollo, en las que el equipo se pudo reunir presencialmente. 

* A la hora de probar 2 host clientes bajo una misma red, uno de los host podia comunicarse con el otro pero no viceversa. Asumimos, despues de revisar el codigo exahustivamente, que el problema era del dispositivo desde el que tratabamos de conectar y no del programa.

### Conclusiones
Crear una conexion entre mas de un dispositivo es un reto desafiante. El cual te lleva a tener en cuenta estrategias con respecto a el uso de diferentes protocolos para diferentes funcionalidades que se deban implementar. En nuestro caso, aprender sobre el uso practico de TCP para el chat y los permisos, y SMTP para enviar emails; que era una funcionalidad del boton de panico. 
