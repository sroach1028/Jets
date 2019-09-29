package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApp {
	private Airfield airfield = new Airfield();

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.launch();

	}

	private void launch() {
		populateAirfield();
		do {
			displayUserMenu();
		} while (executeChoice());
	}

	private void populateAirfield() {
		String line;
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			while ((line = bufIn.readLine()) != null) {
				String[] parts = line.split(", ");
				switch (parts[0].charAt(0)) {

				case 'F':
					airfield.addJet(new FighterJet(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
					break;
				case 'C':
					airfield.addJet(new CargoPlane(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
					break;
				case 'B':
					airfield.addJet(new Bomber(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
					break;
				case 'R':
					airfield.addJet(new UAV(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
					break;
				default:
					airfield.addJet(new GeneralAviation(parts[0], Double.parseDouble(parts[1]),
							Integer.parseInt(parts[2]), Long.parseLong(parts[3])));
					break;
				}
			}
		}
		catch (IOException e) {
			System.err.println(e);
		}
	}

	private void displayUserMenu() {
		System.out.println("1. List Fleet\n2. Fly All Jets\n3. View Fastest Jet\n4. View Jet With Longest Range\n"
				+ "5. Load all Cargo Jets\n6. Dogfight!!\n7. Drop Bombs\n8. Spy on enemies\n9. Add a Jet to Fleet\n10. Remove a jet from fleet\n11. Quit");
	}

	private boolean executeChoice() {
		Scanner kb = new Scanner(System.in);
		String choice = kb.next();
		switch (choice) {
		case "1":
			System.out.println("Jets on the Airfield\n" + "-----------------------------------------");
			for (Jet jet : airfield.getJetList()) {
				System.out.println(jet);
			}
			break;

		case "2":
			for (Jet jet : airfield.getJetList()) {
				jet.taxi();
				}
			System.out.println("\nPress any key to clear the fleet for takeoff");
			kb.next();
			for (Jet jet : airfield.getJetList()) {
				jet.fly();
				
			}	
			
			break;
		case "3":
			double fastestSpeed = 0.0;
			System.out.println("Fastest Jet on the Airfield:");
			for (Jet jet : airfield.getJetList()) {
				if (jet.getSpeed() > fastestSpeed) {
					fastestSpeed = jet.getSpeed();
				}
			}
			for (Jet jet : airfield.getJetList()) {
				if (jet.getSpeed() == fastestSpeed) {
					System.out.println(jet);
				}
			}
			break;
		case "4":
			int longestRange = 0;
			System.out.println("Jet with the greatest range:");
			for (Jet jet : airfield.getJetList()) {
				if (jet.getRange() > longestRange) {
					longestRange = jet.getRange();
				}
			}
			for (Jet jet : airfield.getJetList()) {
				if (jet.getRange() == longestRange) {
					System.out.println(jet);
				}
			}
			break;
		case "5":
			for (Jet jet : airfield.getJetList()) {
				if (jet instanceof CargoPlane) {
					((CargoPlane) jet).loadCargo();
				}
			}
			break;

		case "6":
			for (Jet jet : airfield.getJetList()) {
				if (jet instanceof FighterJet) {
					((FighterJet) jet).fight();
				}
			}
			break;
		case "7":
			for (Jet jet : airfield.getJetList()) {
				if (jet instanceof Bomber) {
					((Bomber) jet).dropBombs();
				}
			}
			break;
			
		case "8":
			for (Jet jet : airfield.getJetList()) {
				if(jet instanceof UAV) {
					((UAV) jet).surveil();
				}
			}
			break;
		case "9":
			addJet(kb);
			break;
		case "10":
			removeJet(kb);
			break;
		case "11":
			System.out.println("Leaving the Airfield, good day");
			kb.close();
			return false;
		}
		System.out.println("\npress any key to return to main menu: ");
		kb.next();
		return true;
	}
	
	public void addJet(Scanner kb) {
		kb.nextLine();
		System.out.println("Model: ");
		String model = kb.nextLine();
		System.out.println("Speed: ");
		double speed = Double.parseDouble(kb.next());
		System.out.println("Range: ");
		int range = Integer.parseInt(kb.next());
		System.out.println("Price: ");
		long price = Long.parseLong(kb.next());
		airfield.addJet(new GeneralAviation(model, speed, range, price));
	}
	
	public void removeJet(Scanner kb) {
		int i;
		for (i = 0; i < airfield.getJetList().size(); i++) {
			System.out.println((i + 1) + ": " + airfield.getJetList().get(i));
		}
		int toRemove = kb.nextInt() - 1;
		if (toRemove >= 0 && toRemove <= airfield.getJetList().size()) {

			System.out.println("Removing " + airfield.getJetList().get(toRemove).getModel() + " from Airfield");
			airfield.getJetList().remove(toRemove);
		} else {
			System.out.println("No plane in that position.\n");
		}

	}

}