package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

public class Airfield {
	private List<Jet> jetList;
	
	public Airfield() {
		
		jetList = new ArrayList<>();
		
	}

	public List<Jet> getJetList() {
		return jetList;
	}

	public void setJetList(List<Jet> jetList) {
		this.jetList = jetList;
	}
	
	public void addJet(Jet jet) {
		jetList.add(jet);
		
	}
	
}
