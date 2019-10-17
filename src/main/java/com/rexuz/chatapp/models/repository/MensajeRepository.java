package com.rexuz.chatapp.models.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rexuz.chatapp.models.document.Mensaje;

public interface MensajeRepository extends MongoRepository<Mensaje, String>{
	
	List<Mensaje> findFirst10ByOrderByFechaDesc();
}
