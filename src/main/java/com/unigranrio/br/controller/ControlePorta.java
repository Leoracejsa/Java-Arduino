package com.unigranrio.br.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JOptionPane;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.SerialPort;

public class ControlePorta {
	
	private OutputStream serialOut;
	private int taxa;
	private String portaCOM;
	public ControlePorta(String portaCOM, int taxa) {
		this.portaCOM = portaCOM;
		this.taxa = taxa;
		this.initialize();
	}

	private void initialize() {
		try {
			CommPortIdentifier portId = null;
			try {
				portId = CommPortIdentifier.getPortIdentifier(this.portaCOM);
			} 
			catch (NoSuchPortException npe) {
				JOptionPane.showMessageDialog(null, "Porta COM nao encontrada.", "Porta COM", JOptionPane.PLAIN_MESSAGE);
			}
			
			SerialPort port = (SerialPort) portId.open("Comunicacao serial", this.taxa);
			serialOut = port.getOutputStream();
			port.setSerialPortParams(this.taxa, 
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, 
					SerialPort.PARITY_NONE); 
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que fecha a comunicacao com a porta serial
	 */
	public void close() {
		try {
			serialOut.close();
		} 
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel fechar porta COM.", "Fechar porta COM", JOptionPane.PLAIN_MESSAGE);
		}
	}

	/**
	 * @param opcao
	 *            - Valor a ser enviado pela porta serial
	 */
	public void enviaDados(int opcao) {
		try {
			serialOut.write(opcao);// escreve o valor na porta serial para ser enviado
		} 
		catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Nao foi possivel enviar o dado. ", "Enviar dados", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
