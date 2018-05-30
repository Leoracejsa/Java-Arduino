package com.unigranrio.br.controller;

import com.unigranrio.br.model.LedOperationsEnum;
public class Arduino {
	
	private ControlePorta arduino;
	private static Arduino singleton = null;

	public Arduino() {
		arduino = new ControlePorta("COM7", 9600);
	}

	public String comunicacaoArduino(LedOperationsEnum operacao) {
		
	
		if (operacao == LedOperationsEnum.LIGAR) {
			arduino.enviaDados(1);
			return "Led Ligado";
		} 
		else if (operacao == LedOperationsEnum.DESLIGAR) {
			arduino.enviaDados(2);
			return "Led Desligado";
		} 
		else {
			return "Nenhuma acao. Operacao Invalida";
		}
	}

	public static Arduino getSingleton() {
		if (singleton == null)
			singleton = new Arduino();
		
		return singleton;
	}
}
