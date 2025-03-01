public class ValideSaisie {

    public static final int MAX_CHAR_TELEPHONE = 14;
    public static final char PARANTHESE_OUVRANTE = '(';
    public static final char PARANTHESE_FERMANTE = ')';
    public static final char TRAIT_UNION = '-';
    public static final byte POS_PARANTHESE_OUVRANTE_TEL = 0;
    public static final byte POS_PARANTHESE_FERMANTE_TEL = 4;
    public static final byte POS_TRAIT_UNION_TEL = 9;
    public static final char VEHICULE_HYBRIDE = 'h';
    public static final char VEHICULE_ELECTRIQUE = 'e';
    public static final char VEHICULE_PETIT = 'p';
    public static final char VEHICULE_INTERMEDIAIRE = 'i';
    public static final char VEHICULE_GRAND = 'g';
    public static final int MAXJOURSLOCATION = 30;
    public static final int MINJOURSLOCATION = 0;
    public static final char ASSURANCE_OUI = 'o';
    public static final char ASSURANCE_NON = 'n';
    public static final char CARTE_DEBIT = 'd';
    public static final char CARTE_CREDIT = 'c';
    public static final char VISA_CARTE_CREDIT = 'v';
    public static final char MC_CARTE_CREDIT = 'm';


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

            if (choixGrandeur == VEHICULE_PETIT || choixGrandeur == VEHICULE_INTERMEDIAIRE  || choixGrandeur == VEHICULE_GRAND ) {
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
}








