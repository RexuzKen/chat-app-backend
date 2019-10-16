package com.rexuz.chatapp.controller;

import java.util.Date;
import java.util.Random;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.rexuz.chatapp.models.document.Mensaje;

@Controller
public class ChatController {

	private String[] colores = { "red", "green", "blue", "magenta", "purple", "orange" };

	@MessageMapping("/mensaje")
	@SendTo("/chat/mensaje")
	public Mensaje recibirMensaje(Mensaje mensaje) {
		System.out.println(mensaje.getUsername() + " : " + mensaje.getColor());
		mensaje.setFecha(new Date().getTime());

		if (mensaje.getTipo().equals("NUEVO_USUARIO")) {
			mensaje.setColor(colores[new Random().nextInt(colores.length)]);
			mensaje.setTexto("Nuevo usuario");
		}
		return mensaje;
	}
}
