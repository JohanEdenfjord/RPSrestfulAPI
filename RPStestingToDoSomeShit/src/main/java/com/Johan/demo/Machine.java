package com.Johan.demo;

public class Machine {	
	
	public String computer() {
		int move = (int) (Math.random()*3);
		String[] RPSmoves = {"rock","paper","scissor"};		
		return RPSmoves[move];
	}
	
}
