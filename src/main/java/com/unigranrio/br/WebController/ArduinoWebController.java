package com.unigranrio.br.WebController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unigranrio.br.ArduinoService.ArduinoService;

@RestController
@RequestMapping(value="/controlar")
public class ArduinoWebController {

	@Autowired
	ArduinoService arduinoserice;
	
	@RequestMapping(value="/ligar", method=RequestMethod.GET)
	public ResponseEntity ligarArduino(){

		arduinoserice.Ligar();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/desligar", method=RequestMethod.GET)
	public ResponseEntity desligarArduino(){

		arduinoserice.Desligar();
		return new ResponseEntity<>(HttpStatus.OK);
	}	
	
}
