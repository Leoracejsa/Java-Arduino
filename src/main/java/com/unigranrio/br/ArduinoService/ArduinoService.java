package com.unigranrio.br.ArduinoService;

import org.springframework.stereotype.Service;

import com.unigranrio.br.controller.Arduino;
import com.unigranrio.br.model.LedOperationsEnum;

@Service
public class ArduinoService {
	
	public void Ligar() {
		Arduino conn = Arduino.getSingleton();
		conn.comunicacaoArduino(LedOperationsEnum.LIGAR);		
	}
	
	public void Desligar() {
		Arduino conn = Arduino.getSingleton();
		conn.comunicacaoArduino(LedOperationsEnum.DESLIGAR);		
	}
}
