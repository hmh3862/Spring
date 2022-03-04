package kr.green.core.vo;

import lombok.Data;

@Data
public class Performer {
	private String name;
	private Instrument instrument;
	
	public Performer(){
		
	}
	/*
	public Performer(String name) {
		this.name = name;
	}
	
	public Performer(Instrument instrument) {
		this.instrument = instrument;
	}
	*/
	public Performer(String name, Instrument instrument) {
		this.name = name;
		this.instrument = instrument;
	}
	
}
