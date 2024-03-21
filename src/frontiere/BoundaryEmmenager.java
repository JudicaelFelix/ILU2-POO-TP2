package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bonjour villageois" + nomVisiteur);
					StringBuilder forceq = new StringBuilder();
					forceq.append("Quelle est votre force?");
					int force = Clavier.entrerEntier(forceq.toString());
					ajouterGaulois(nomVisiteur,force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void ajouterGaulois(String nomVisiteur, int force) {
		controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}

	private void emmenagerDruide(String nomVisiteur) {
		System.out.println("Bonjour druide" + nomVisiteur);
		StringBuilder forcedruide = new StringBuilder();
		forcedruide.append("Quelle est votre force?");
		int forced = Clavier.entrerEntier(forcedruide.toString());
		int max = -1;
		int min = -1;
		while(max == -1 && min == -1) {
			forcedruide.replace(0,100,"Quelle est la potion la plus faible que vous produisez?");
			min = Clavier.entrerEntier(forcedruide.toString());
			forcedruide.replace(0, 100, "Quelle est la potion la plus forte que vous produisez?");
			max = Clavier.entrerEntier(forcedruide.toString());
			if(min>= 0 && max >= 0 && max<min) {
				System.out.println("Attention Druide, vous confondez maximum et minimum ");
			}
		}
		
		controlEmmenager.ajouterDruide(nomVisiteur, forced, min,max);
		
	}
}
