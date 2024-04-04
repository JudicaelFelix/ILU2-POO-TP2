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
			System.out.println("Je suis d�sol� "+ nomVendeur+ " mail il faut �tre un habitant de notre village pour commercer ici");
		}else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un �tal.");
			boolean restetal = controlPrendreEtal.resteEtals();
			if(!restetal) {
				System.out.println("D�sol� " + nomVendeur +" je n'ai plus d'�tal qui ne soit pas d�j� occup�");
			}else {
				installerVendeur(nomVendeur);
			}
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un �tal pour vous ! ");
		System.out.println("Il me faudra quelques renseignements");
				
		StringBuilder question1 = new StringBuilder();
		question1.append("Quel produit souhaitez vous vendre ? ");
		String produit = Clavier.entrerChaine(question1.toString());
		StringBuilder question2 = new StringBuilder();
		question2.append("Combien souhaitez vous en vendre ?");
		int nbproduit = Clavier.entrerEntier(question2.toString());
		int nbetal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbproduit);	
		if(nbetal != -1) {
			System.out.println("Le vendeur"+ nomVendeur + "s'est install� � l'�tal"+ nbetal);
		}
		
		
	}
}
