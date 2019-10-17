package com.rexuz.chatapp.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexuz.chatapp.models.document.Mensaje;
import com.rexuz.chatapp.models.repository.MensajeRepository;

@Service
public class MensajeServiceImpl implements IMensajeService {

	@Autowired
	private MensajeRepository mensajeRepository;
	
	@Override
	public List<Mensaje> obtenerUltimos10Mensajes() {
		return this.mensajeRepository.findFirst10ByOrderByFechaDesc();
	}

	@Override
	public Mensaje guardar(Mensaje mensaje) {
		return this.mensajeRepository.save(mensaje);
	}

}
