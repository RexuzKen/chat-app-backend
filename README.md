# chat-app-backend

Sockets
 Comunicacion bidireccional en TIEMPO REAL entre cliente-servidor y viceversa.
 También cliente-cliente con el servidor de intermediario.
 Una sola URL endpoint para la conexión inicial y todos los mensajes fluyen en esa misma conexión TCP.

Dependencias
DevTools, MongoDB, Web, WebSocket

@MessageMapping("/mensaje") para que clientes envien datos.
@SendTo("/chat/mensaje") para que clientes reciban datos.

Configurar conexion en .properties
spring.data.mongodb.uri=mongodb://localhost:27017/springboot_chat
Debug para que muestre las consultas en la consola
logging.level.org.springframework.data.mongodb.core.MongoTemplate=debug

Crear eventos unicos
@Autowired
private SimpMessagingTemplate webSocket;

@MessageMapping("/historial")
public void historial(String clienteId)
 webSocket.convertAndSend("/chat/historial/ + clientId", chatService.obtenerUltimos10Mensajes());
