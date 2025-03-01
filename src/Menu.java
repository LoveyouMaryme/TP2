// Importing LocalDateTime and DateTimeFormatter
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Menu {
    public static final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";
    public static final String CHOIX_UN = "1. Afficher l'inventaire des véhicules";
    public static final String CHOIX_DEUX = "2. Facturer la location d’un véhicule";
    public static final String CHOIX_TROIS = "3. Afficher le nombre de véhicules hybrides et électriques loués";
    public static final String CHOIX_QUATRE = "4. Quitter le programme";

    public static void affichage(){

        System.out.println("\n" + MESSAGE_MENU_CHOIX);
        System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);

    }
    public static byte choix() {

        byte choixOption;
        do {
            System.out.print("\n\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();

            if(choixOption < 1 | choixOption > 4){
                System.out.println("\nL’option choisie est invalide! !\n");
                affichage();
            }

        } while (choixOption < 1 | choixOption > 4);

        return choixOption;
    }

    //mine
    public static void entete(){
        final String ENCADRE_SOUS_TIRE = "-----------------------------------------------------------";
        final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7" ;
        final String TELEPHONE_ENTREPRISE = "438 222-1111";
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
        final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";

        LocalDateTime now = LocalDateTime.now();
        String dateNowFormate = now.format(FORMATTER);

        System.out.println("\n" + ENCADRE_SOUS_TIRE);
        System.out.println(NOM_ENTREPRISE);
        System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
        System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
        System.out.println("Date et Heure : " + dateNowFormate );
        System.out.println(ENCADRE_SOUS_TIRE);
    }

    //mine
    public static void choixUn(){
        int voituresRestantesHybridesPetites = 12;
        int voituresRestantesHybridesIntermediaires = 10;
        int voituresRestantesHybridesGrandes = 3;
        int voituresRestantesElectriquesPetites = 11;
        int voituresRestantesElectriquesIntermediaires = 9;
        int voituresRestantesElectriquesGrandes = 5;

        entete();


    }



}
