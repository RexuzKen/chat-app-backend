package com.rexuz.chatapp.models.service;

import java.util.List;

import com.rexuz.chatapp.models.document.Mensaje;

public interface IMensajeService {
 
	public List<Mensaje> obtenerUltimos10Mensajes();
	
	public Mensaje guardar(Mensaje mensaje);
}
