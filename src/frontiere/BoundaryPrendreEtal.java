package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé "+ nomVendeur+ " mail il faut être un habitant de notre village pour commercer ici");
		}else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.");
			boolean restetal = controlPrendreEtal.resteEtals();
			if(!restetal) {
				System.out.println("Désolé " + nomVendeur +" je n'ai plus d'étal qui ne soit pas déjà occupé");
			}else {
				installerVendeur(nomVendeur);
			}
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous ! ");
		System.out.println("Il me faudra quelques renseignements");
				
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit souhaitez vous vendre ? ");
		String produit = Clavier.entrerChaine(question1.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez vous en vendre ?");
		int nbproduit = Clavier.entrerEntier(question2.toString());
		int nbetal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);	
		if(nbetal != -1) {
			System.out.println("Le vendeur"+ nomVendeur + "s'est installé à l'étal"+ nbetal);
		}
		
		
	}
}
