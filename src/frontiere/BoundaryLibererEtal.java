package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if(!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else {
			String[] donnees = controlLibererEtal.libererEtal(nomVendeur);
			if(donnees[0]) {
				System.out.println("Vous avez vendu" + donnees[2].toString() + );
			}
		}
	}

}
