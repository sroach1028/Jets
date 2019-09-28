package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class JetsApp {
	private Airfield airfield;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		JetsApp ja = new JetsApp();
		ja.launch(kb);
		ja.displayUserMenu();
		ja.executeChoice(kb.next(), kb);

	}

	private void launch(Scanner kb) {
		airfield = new Airfield();

		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] parts = line.split(", ");
				if (parts[0].contentEquals("fighter")) {
					airfield.addJet(new FighterJet(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
				}
				if (parts[0].contentEquals("cargo")) {
					airfield.addJet(new CargoPlane(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
				}
				if (parts[0].contentEquals("cessna")) {
					airfield.addJet(new PropPlane(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]),
							Long.parseLong(parts[3])));
				}

			}

		} catch (IOException e) {
			System.err.println(e);
		}

	}

	private void displayUserMenu() {
		System.out.println(
				"1. List Fleet\n2. Fly All Jets\n3. View Fastest Jet\n4. View Jet With Longest Range\n5. Load all Cargo Jets\n6. Dogfight!!\n7. Add a Jet to Fleet\n8. Remove a jet from fleet\n9. Quit");
	}

	private void executeChoice(String choice, Scanner kb) {
		switch (choice) {
		case "1":
			for (Jet jet : airfield.getJetList()) {

				System.out.println(jet);
			}
			break;
		case "2":
			for (Jet jet : airfield.getJetList()) {

				jet.fly();
			}
			break;
		case "3":
			double fastestSpeed = 0.0;
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

			System.out.println("Model: ");
			String model = kb.next();
			System.out.println("Speed: ");
			double speed = Double.parseDouble(kb.next());
			System.out.println("Range: ");
			int range = Integer.parseInt(kb.next());
			System.out.println("Price: ");
			long price = Long.parseLong(kb.next());
			airfield.addJet(new PropPlane(model, speed, range, price));

		case "8":
			for (int i = 0; i < airfield.getJetList().size(); i++) {
				System.out.println(i + ": " + airfield.getJetList().get(i));
			}
			airfield.getJetList().remove(kb.nextInt());

			break;
		case "9":
			System.out.println("Goodbye!!");
			break;

		}
		// TODO Auto-generated method stub
	}
}