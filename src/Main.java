import javax.sound.midi.SysexMessage;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) {
        byte choixMenu;


        AffichageBienvenue.affichageBievenue();
        Menu.affichage();

        choixMenu = Menu.choix();


        do {
            switch (choixMenu) {
                // Afficher l'inventaire des voitures disponibles
                case 1:
                    System.out.println("1");
                    break;
                // Louer une voiture selon sa taille, son type, sa disponibilité et valider les modalités de paiement
                case 2:
                    ValideSaisie.typeVehicule();
                    ValideSaisie.grandeurVehicule();
                    break;
                case 3:
                    System.out.println("3");
                    break;
                // Quitter le programme
                case 4:
                    System.out.println("\n\nMerci et à la prochaine !");
            }

        } while (choixMenu != 4);

    }
}


