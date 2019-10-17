package com.rexuz.chatapp.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.rexuz.chatapp.models.document.Mensaje;
import com.rexuz.chatapp.models.service.IMensajeService;

@Controller
public class ChatController {

	@Autowired
	private IMensajeService mensajeService;
	
	@Autowired
	private SimpMessagingTemplate webSocket;
	
	private String[] colores = { "red", "green", "blue", "magenta", "purple", "orange" };

	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibirMensaje(Mensaje mensaje) {
		mensaje.setFecha(new Date().getTime());

		if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo usuario");
		}
		
		this.mensajeService.guardar(mensaje);
		return mensaje;
	}
	
	
	@MessageMapping("/escribiendo")
	@SendTo("/chat/escribiendo")
	public String escribiendoMensaje(String username) {
		System.out.println(username.concat(" está escribiendo..."));
		return username.concat(" está escribiendo...");
	}
	
	@MessageMapping("/historial")
	public void historialMensajes(String clientId) {
		System.out.println("Recuperando historial de mensajes..");
		this.webSocket.convertAndSend("/chat/historial/" + clientId, this.mensajeService.obtenerUltimos10Mensajes());
		
	}
}
