import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";
    public static final String MESSAGE_RABAIS_LOCATION = "Rabais sur le prix de la location";
    public static final String MESSAGE_MONTANT_LOCATION_SOUS_TOTAL = "Montant de la location";
    public static final String MESSAGE_MONTANT_ASSURANCE = "Montant de l'assurance";
    public static final String MESSAGE_NOMBRE_VEHICULE_INVENTAIRE = "Nombre de véhicules disponibles dans l'inventaire";
    public static final String MESSAGE_NOMBRE_VEHICULE_LOUEE = "Nombre de véhicules loués par type et par catégorie";
    public static final String MESSAGE_SOUS_TOTAL = "Sous-total";
    public static final String MESSAGE_MONTANT_TPS = "Montant TPS";
    public static final String MESSAGE_MONTANT_TVQ = "Montant TVQ";
    public static final String MESSAGE_MONTANT_TOTAL = "Montant Total";
    public static final String MESSAGE_REMERCIEMENT = "Merci pour votre confiance!";
    public static final String CHOIX_UN = "1. Afficher l'inventaire des véhicules";
    public static final String CHOIX_DEUX = "2. Facturer la location d’un véhicule";
    public static final String CHOIX_TROIS = "3. Afficher le nombre de véhicules hybrides et électriques loués";
    public static final String CHOIX_QUATRE = "4. Quitter le programme";
    public static final String ENCADRE_SOUS_TIRE = "-----------------------------------------------------------";
    public static final char VEHICULE_HYBRIDE = 'h';
    public static final char VEHICULE_ELECTRIQUE = 'e';
    public static final char VEHICULE_PETIT = 'p';
    public static final char VEHICULE_INTERMEDIAIRE = 'i';
    public static final char VEHICULE_GRAND = 'g';
    public static final float PRIX_HYBRIDE_PETIT = 55.75f;
    public static final float PRIX_HYBRIDE_INTERMEDIAIRE = 60.25f;
    public static final float PRIX_HYBRIDE_GRAND = 65.50f;
    public static final float PRIX_ELECTRIQUE_PETIT = 45.50f;
    public static final float PRIX_ELECTRIQUE_INTERMEDIAIRE = 50.50f;
    public static final float PRIX_ELECTRIQUE_GRAND = 55.25f;
    public static final float ASSURANCE_HYBRIDE_PETIT = 13.50f;
    public static final float ASSURANCE_HYBRIDE_INTERMEDIAIRE = 14.50f;
    public static final float ASSURANCE_HYBRIDE_GRAND = 15.50f;
    public static final float ASSURANCE_ELECTRIQUE_PETIT = 12.50f;
    public static final float ASSURANCE_ELECTRIQUE_INTERMEDIAIRE = 12.75f;
    public static final float ASSURANCE_ELECTRIQUE_GRAND = 13.25f;
    public static final int NBR_JOUR_RABAIS = 15;
    public static final char ASSURANCE_OUI = 'o';
    public static final float POURCENTAGE_TPS = 0.05f;
    public static final float POURCENTAGE_TVQ = 0.09975f;
    public static final float POURCENTAGE_RABAIS_LOCATION = 0.20f;
    public static final int MAX_CHAR_TELEPHONE = 14;
    public static final char PARANTHESE_OUVRANTE = '(';
    public static final char PARANTHESE_FERMANTE = ')';
    public static final char TRAIT_UNION = '-';
    public static final byte POS_PARANTHESE_OUVRANTE_TEL = 0;
    public static final byte POS_PARANTHESE_FERMANTE_TEL = 4;
    public static final byte POS_TRAIT_UNION_TEL = 9;
    public static final int MAXJOURSLOCATION = 30;
    public static final int MINJOURSLOCATION = 0;
    public static final char ASSURANCE_NON = 'n';
    public static final char CARTE_DEBIT = 'd';
    public static final char CARTE_CREDIT = 'c';
    public static final char VISA_CARTE_CREDIT = 'v';
    public static final char MC_CARTE_CREDIT = 'm';
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");

    public static void affichageBievenue() {
        final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";
        final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de " + NOM_ENTREPRISE;
        final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";


        // Affichage de résultat //
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE + "\n");
    }

    public static void affichage() {

        System.out.println("\n" + MESSAGE_MENU_CHOIX);
        System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);

    }

    public static byte choix() {

        byte choixOption;
        do {
            System.out.print("\n\nEntrez votre choix : ");
            choixOption = Clavier.lireByte();

            if (choixOption < 1 | choixOption > 4) {
                System.out.println("\nL’option choisie est invalide! !\n");
                affichage();
            }

        } while (choixOption < 1 | choixOption > 4);

        return choixOption;
    }

    //mine
    public static void entete() {
        final String ENCADRE_SOUS_TIRE = "-----------------------------------------------------------";
        final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
        final String TELEPHONE_ENTREPRISE = "438 222-1111";
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
        final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";

        LocalDateTime now = LocalDateTime.now();
        String dateNowFormate = now.format(FORMATTER);

        System.out.println("\n" + ENCADRE_SOUS_TIRE);
        System.out.println(NOM_ENTREPRISE);
        System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
        System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
        System.out.println("Date et Heure : " + dateNowFormate);
        System.out.println(ENCADRE_SOUS_TIRE);
    }

    public static String prenomLocataire() {
        String prenomLocataire;
        boolean validePrenom = false;

        do {
            System.out.print("Entrez le prénom du locataire (entre 2 et 30 caractères inclusivement):");
            prenomLocataire = Clavier.lireString().trim();

            if (prenomLocataire.length() < 2 || prenomLocataire.length() > 30) {
                System.out.println("Le prénom est invalide!");
            } else {
                validePrenom = true;
            }


        } while (!validePrenom);
        return prenomLocataire;
    }

    public static String nomLocataire() {
        String nomLocataire;
        boolean valideNom = false;

        do {
            System.out.print("Entrez le nom du locataire (entre 2 et 30 caractères inclusivement):");
            nomLocataire = Clavier.lireString().trim();

            if (nomLocataire.length() < 2 || nomLocataire.length() > 30) {
                System.out.println("Le nom est invalide!");
            } else {
                valideNom = true;
            }

        } while (!valideNom);

        return nomLocataire;
    }

    public static String telephone() {
        String telephone;
        boolean valideTelephone = false;

        do {
            System.out.println("Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589):");
            telephone = Clavier.lireString().trim();


            if (telephone.length() == MAX_CHAR_TELEPHONE
                    && telephone.charAt(POS_PARANTHESE_OUVRANTE_TEL) == PARANTHESE_OUVRANTE
                    && telephone.charAt(POS_PARANTHESE_FERMANTE_TEL) == PARANTHESE_FERMANTE
                    && telephone.charAt(POS_TRAIT_UNION_TEL) == TRAIT_UNION) {

                valideTelephone = true;
            } else {
                System.out.println("Le numéro de téléphone est invalide!");
            }


        } while (!valideTelephone);

        return telephone;

    }

    public static String permisConduite() {
        String numeroPermis;
        boolean validePermis = false;

        do {
            System.out.println("Entrez le numéro de permis de conduire du locataire (Exemple : D1234-567891-23): L153117127408");
            numeroPermis = Clavier.lireString().trim();


            if (numeroPermis.matches("[A-Za-z][0-9]{1,4}-[0-9]{1,6}-[0-9]{1,2}")) {
                validePermis = true;
            } else {
                System.out.println("Le numéro de téléphone est invalide!");
            }

        } while (!validePermis);
        return permisConduite();
    }

    public static char typeVehicule() {
        char choixType;
        boolean valideTypeVehicule = false;

        do {
            System.out.println("\nEntrez le type du véhicule à louer");
            System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) :     ");
            choixType = Character.toLowerCase(Clavier.lireCharLn());

            if (choixType == VEHICULE_HYBRIDE || choixType == VEHICULE_ELECTRIQUE) {
                valideTypeVehicule = true;
            } else {
                System.out.println("Le type de véhicule est invalide!");
            }

        } while (!valideTypeVehicule);
        return choixType;
    }

    public static char grandeurVehicule() {
        char choixGrandeur;
        boolean valideGrandeurVehicule = false;

        do {
            System.out.println("\nEntrez la grandeur du véhicule à louer");
            System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
            choixGrandeur = Character.toLowerCase(Clavier.lireCharLn());

            if (choixGrandeur == VEHICULE_PETIT || choixGrandeur == VEHICULE_INTERMEDIAIRE || choixGrandeur == VEHICULE_GRAND) {
                valideGrandeurVehicule = true;
            } else {
                System.out.println("La grandeur du véhicule est invalide!");
            }

        } while (!valideGrandeurVehicule);
        return choixGrandeur;

    }

    public static int jourLocation() {
        int nbrJour;
        boolean valideNbrJour = false;

        do {
            System.out.println("Entrez le nombre de jours de location");
            System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
            nbrJour = Clavier.lireInt();

            if (nbrJour <= MINJOURSLOCATION || nbrJour >= MAXJOURSLOCATION) {
                System.out.println("Le nombre de jours de location est invalide!");
            } else {
                valideNbrJour = true;
            }


        } while (!valideNbrJour);

        return nbrJour;
    }

    public static char carteCredit() {

        char choixCarteCredit;
        boolean valideCarteCredit = false;

        do {
            System.out.println("\nEntrez le type de la carte de crédit");
            System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
            choixCarteCredit = Character.toLowerCase(Clavier.lireCharLn());

            if (choixCarteCredit != VISA_CARTE_CREDIT && choixCarteCredit != MC_CARTE_CREDIT) {
                System.out.println("Le type de la carte de crédit est invalide!");
            } else {
                valideCarteCredit = true;
            }

        } while (!valideCarteCredit);
        return choixCarteCredit;
    }

    public static char modePaiement() {
        char choixPaiement;
        boolean valideCarteCredit = false;

        do {
            System.out.println("\nEntrez le mode de paiement");
            System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
            choixPaiement = Character.toLowerCase(Clavier.lireCharLn());

            if (choixPaiement != CARTE_DEBIT && choixPaiement != CARTE_CREDIT) {
                System.out.println("Le mode de paiement est invalide!");
            } else {
                valideCarteCredit = true;
            }

        } while (!valideCarteCredit);
        return choixPaiement;
    }

    public static String numeroCarteCredit() {
        String numeroCarte;
        boolean valideCarte = false;

        do {
            System.out.println(" Entrez le numéro de la carte de crédit (Exemple : 1234 5678 9123 4567) :");
            numeroCarte = Clavier.lireString().trim();


            if (numeroCarte.matches("[0-9]{1,4} [0-9]{1,4} [0-9]{1,4} [0-9]{1,4}")) {
                valideCarte = true;
            } else {
                System.out.println("Le numéro de la carte de crédit est invalide!");
            }

        } while (!valideCarte);
        return numeroCarte;
    }

    public static char assurance() {
        char choixAssurance;
        boolean valideChoixAssurance = false;

        do {
            System.out.println("\nDésirez-vous prendre l'assurance");
            System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
            choixAssurance = Character.toLowerCase(Clavier.lireCharLn());

            if (choixAssurance != ASSURANCE_OUI && choixAssurance != ASSURANCE_NON) {
                System.out.println("La réponse est invalide!");
            } else {
                valideChoixAssurance = true;
            }

        } while (!valideChoixAssurance);
        return choixAssurance;
    }

    public static int obtenirVoituresDisponibles(char type, char grandeur, int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {


        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                return nbLouesHP++;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return nbLouesHI++;
            } else if (grandeur == VEHICULE_GRAND) {
                return nbLouesHG++;
            }

        } else {
            if (type == VEHICULE_ELECTRIQUE) {
                if (grandeur == VEHICULE_PETIT) {
                    return nbLouesEP++;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    return nbLouesEI++;
                } else if (grandeur == VEHICULE_GRAND) {
                    return nbLouesEG++;
                }
            }
        }
        return -1;
    }

    public static float obtenirPrixLocation(char type, char grandeur) {
        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                return PRIX_HYBRIDE_PETIT;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return PRIX_HYBRIDE_INTERMEDIAIRE;
            } else if (grandeur == VEHICULE_GRAND) {
                return PRIX_HYBRIDE_GRAND;
            }

        } else {
            if (type == VEHICULE_ELECTRIQUE) {
                if (grandeur == VEHICULE_PETIT) {
                    return PRIX_ELECTRIQUE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    return PRIX_ELECTRIQUE_INTERMEDIAIRE;
                } else if (grandeur == VEHICULE_GRAND) {
                    return PRIX_ELECTRIQUE_GRAND;
                }
            }
        }
        return -1;
    }

    public static float ObtenirPrixAssurance(char type, char grandeur, char choixAssurance) {

        if (choixAssurance == ASSURANCE_OUI) {


            if (type == VEHICULE_HYBRIDE) {
                if (grandeur == VEHICULE_PETIT) {
                    return ASSURANCE_HYBRIDE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    return ASSURANCE_HYBRIDE_INTERMEDIAIRE;
                } else if (grandeur == VEHICULE_GRAND) {
                    return ASSURANCE_HYBRIDE_GRAND;
                }

            } else {
                if (type == VEHICULE_ELECTRIQUE) {
                    if (grandeur == VEHICULE_PETIT) {
                        return ASSURANCE_ELECTRIQUE_PETIT;
                    } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                        return ASSURANCE_ELECTRIQUE_INTERMEDIAIRE;
                    } else if (grandeur == VEHICULE_GRAND) {
                        return ASSURANCE_ELECTRIQUE_GRAND;
                    }
                }
            }
        } else {
            return 0;
        }

        return -1;
    }

    public static float obtenirRabais(float prixLocation, char type, char grandeur, int nbJourLocation) {
        float rabaisApplique;

        if ((type == VEHICULE_ELECTRIQUE && (grandeur == VEHICULE_PETIT || grandeur == VEHICULE_INTERMEDIAIRE)) && nbJourLocation > NBR_JOUR_RABAIS) {
            rabaisApplique = prixLocation * POURCENTAGE_RABAIS_LOCATION;
        } else {
            rabaisApplique = 0;
        }
        return rabaisApplique;
    }

    public static float obtenirMontantLocation(int nbrJourLocation, float prixLocation, float rabais) {
        float montantLocation;

        montantLocation = nbrJourLocation * prixLocation + rabais;

        return -1;
    }

    public static float obtenirMontantAssurance(int nbrJourLocation, float prixAssurance) {
        float montantAssurance;

        montantAssurance = nbrJourLocation * prixAssurance;

        return montantAssurance;
    }

    public static float obtenirSousTotal(float montantLocation, float montantAssurance) {
        float sousTotal;

        sousTotal = montantLocation + montantAssurance;

        return sousTotal;
    }

    public static float obtenirMontantTPS(float sousTotal) {
        float montantTPS;

        montantTPS = sousTotal * POURCENTAGE_TPS;

        return montantTPS;
    }

    public static float obtenirMontantTVQ(float sousTotal) {
        float montantTVQ;

        montantTVQ = sousTotal * POURCENTAGE_TVQ;

        return montantTVQ;
    }

    public static float obtenirMontantTotal(float sousTotal, float montantTPS, float montantTVQ) {
        float montantTotal;

        montantTotal = sousTotal + montantTPS + montantTVQ;

        return montantTotal;
    }

    public static int obtenirNumeroFacture(int ancienNumeroFacture) {
        int numeroFacture;

        numeroFacture = ancienNumeroFacture++;

        return numeroFacture;
    }

    private static String obtenirTempsDebutLocation(LocalDateTime tempsMaintenant) {
        String tempsDebutLocation;

        tempsDebutLocation = tempsMaintenant.plusHours(3).format(FORMATTER);

        return tempsDebutLocation;

    }

    private static String obtenirTempsFinLocation(LocalDateTime tempsMaintenant, int nbrJourLocation) {
        String tempsFinLocation;

        tempsFinLocation = tempsMaintenant.plusHours(3).plusDays(nbrJourLocation).format(FORMATTER);

        return tempsFinLocation;
    }

    public static int incrementerVehiculeLoue(char typeChoisi, char typeCible, char grandeurChoisi, char grandeurCible, int nbrVehiculeChoisi) {

        if (typeChoisi == typeCible && grandeurChoisi == grandeurCible) {
            return nbrVehiculeChoisi++;
        } else {
            return nbrVehiculeChoisi;
        }
    }

    private static String obtenirDescriptionType(char type) {
        String description;

        if (type == VEHICULE_HYBRIDE) {
            description = "Hybride";
        } else {
            description = "Électrique";
        }

        return description;
    }

    private static String obtenirDescriptionGrandeur(char type) {
        String description;

        if (type == VEHICULE_PETIT) {
            description = "Petit";
        } else if (type == VEHICULE_INTERMEDIAIRE) {
            description = "Intermediaire";
        } else {
            description = "Grand";
        }

        return description;
    }

    public static void afficherVehiculeDisponible( int nbLouesHP, int nbLouesHI, int nbLouesHG,  int nbLouesEP,  int nbLouesEI, int nbLouesEG){
        System.out.printf("Petit %15d %15d", nbLouesHP, nbLouesEP);
        System.out.printf("\nIntermédiaire %7d %15d", nbLouesHI, nbLouesEI);
        System.out.printf("\nGrand %15d %15d\n\n", nbLouesHG, nbLouesEG);
        System.out.println(ENCADRE_SOUS_TIRE);
    }

    public static void afficherFacture(int numeroFacture,
                                       String prenomLocataire,
                                       String nomLocataire,
                                       String telephoneLocataire,
                                       String permisLocataire,
                                       String typeVehicule,
                                       String grandeurVehicule,
                                       char modePaiement,
                                       char typeCarteCredit,
                                       String numeroCarteCredit,
                                       int nbrJourLocation,
                                       float prixLocationParJour,
                                       float prixAssuranceParJour,
                                       float rabais,
                                       float montantLocation,
                                       float montantAssurance,
                                       float sousTotalFacture,
                                       float montantTPS,
                                       float montantTVQ,
                                       float montantTotalFacture
                                       ){
        System.out.println("Facture No :    " + numeroFacture);
        System.out.println(ENCADRE_SOUS_TIRE);

        System.out.println("\nPrénom et nom : " +  prenomLocataire + " " + nomLocataire);
        System.out.println("Téléphone : " + telephoneLocataire);
        System.out.println("Permis de conduire : " + permisLocataire);

        System.out.print("\nType de véhicule : " + typeVehicule);
        System.out.print("Grandeur du véhicule : " + grandeurVehicule);

        // Dates de début et de retour du location
        System.out.println("\nNombre de jours de location : " + nbrJourLocation);
//        System.out.println("Date de location : " + dateLocationFormate);
//
//        dateRetourFormate = now.plusHours(3).plusDays(choixJoursLocation).format(FORMATTER);
//        System.out.println("Date de retour   : " +  dateRetourFormate);

        // Mode de paiement
        System.out.print("\nMode de paiement : " + modePaiement);
        System.out.print("\nPrix de la location par jour       " + prixLocationParJour);
        System.out.print("\nPrix de l'assurance par jour       " + prixAssuranceParJour);

        System.out.printf("\n%-34s %.2f$", MESSAGE_RABAIS_LOCATION, rabais);

        System.out.printf("\n\n%-34s %.2f$", MESSAGE_MONTANT_LOCATION_SOUS_TOTAL, montantLocation);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_ASSURANCE, montantAssurance);
        System.out.printf("\n\n%-34s %.2f$", MESSAGE_SOUS_TOTAL, sousTotalFacture);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TPS, montantTPS);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TVQ, montantTVQ);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TOTAL, (montantTotalFacture));

    }




    public static void main(String[] args) {
        byte choixMenu;


        affichageBievenue();
        affichage();

        choixMenu = choix();

        do {
            switch (choixMenu) {
                // Afficher l'inventaire des voitures disponibles
                case 1:
                    System.out.println("1");
                    break;
                // Louer une voiture selon sa taille, son type, sa disponibilité et valider les modalités de paiement
                case 2:
                    System.out.println("2");
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


