
/**
 * Ce programme permet de gérer la location des véhicules hybrides et électriques tel que demandé par le client.
 * <p>
 * On peut :
 * 1. Afficher l'inventaire des voitures
 * 2. Louer une voiture en fonction de son type, de sa taille et de sa disponibilité
 * 3. Créer une facture tout en prennant en compte les calculs business spécifés par le client
 * 4. Regarder le nombre de voitures louées
 * 5. Sortir du programme
 *
 * @author Love-Mary Victor (CJ490809)
 * @version : 8 Mars, 2025
 * @github : https://github.com/LoveyouMaryme/TP2
 * @code_permanent : VICL12599701
 **/


// Importer les librairies nécessaires pour obtenir l'heure courant et le formatter

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    //Déclaration des constantes //

    //Messages affichés
    public static final String MESSAGE_MENU_CHOIX = "*** Menu de choix ***";
    public static final String SEPARATEUR_LIGNE = "-----------------------------------------------------------";
    public static final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";
    public static final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de " + NOM_ENTREPRISE;
    public static final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";
    public static final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
    public static final String TELEPHONE_ENTREPRISE = "438 222-1111";
    public static final String MESSAGE_PRIX_LOCATION = "Prix de la location par jour";
    public static final String MESSAGE_PRIX_ASSURANCE = "Prix de l'assurance par jour";
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

    // Prix des assurances et des locations
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

    // Choix de l'utilisateur
    public static final char VEHICULE_HYBRIDE = 'h';
    public static final char VEHICULE_ELECTRIQUE = 'e';
    public static final char VEHICULE_PETIT = 'p';
    public static final char VEHICULE_INTERMEDIAIRE = 'i';
    public static final char VEHICULE_GRAND = 'g';
    public static final char ASSURANCE_OUI = 'o';
    public static final char ASSURANCE_NON = 'n';
    public static final char CARTE_DEBIT = 'd';
    public static final char CARTE_CREDIT = 'c';
    public static final char VISA_CARTE_CREDIT = 'v';
    public static final char MC_CARTE_CREDIT = 'm';

    public static final String VEHICULE_HYBRIDE_DESCRIPTION = "Hybride";
    public static final String VEHICULE_ELECTRIQUE_DESCRIPTION = "Électrique";
    public static final String VEHICULE_PETIT_DESCRIPTION = "Petit";
    public static final String VEHICULE_INTERMEDIAIRE_DESCRIPTION = "Intermédiaire";
    public static final String VEHICULE_GRAND_DESCRIPTION = "Grand";
    public static final String CARTE_CREDIT_DESCRIPTION = "Crédit";
    public static final String CARTE_DEBIT_DESCRIPTION = "Débit";
    public static final String CREDIT_VISA_DESCRIPTION = "Visa";
    public static final String CREDIT_MASTERCARD_DESCRIPTION = "MasterCard";


    public static final String FORMAT_TELEPHONE = "\\([0-9]{3}\\) [0-9]{3}-[0-9]{4}";
    public static final String FORMAT_PERMIS = "[A-Za-z]{1}[0-9]{4}-[0-9]{6}-[0-9]{2}";

    // Invetaire de voitures disponibles au départ
    public static final int nbDisponiblesHP = 12;
    public static final int nbDisponiblesHI = 10;
    public static final int nbDisponiblesHG = 3;
    public static final int nbDisponiblesEP = 11;
    public static final int nbDisponiblesEI = 9;
    public static final int nbDisponiblesEG = 5;

    // Borne de location
    public static final int MAXJOURSLOCATION = 30;
    public static final int MINJOURSLOCATION = 0;

    // Calcul des taxes et rabais
    public static final float TAUX_TPS = 0.05f;
    public static final float TAUX_TVQ = 0.09975f;
    public static final float TAUX_RABAIS = 0.20f;
    public static final int SEUIL_JOUR_RABAIS = 15;


    // Formatter les dates
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");

    /**
     * Affiche un message de bienvenue pour l'entreprise Roulons les Véhicules Verts (RVV) (1)
     */
    public static void afficherMessageBievenue() {
        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE);
    }

    /**
     * Affiche les quatre options du menu principal de l'application.
     */
    private static void afficherOptionsMenu() {

        System.out.println();
        System.out.println();
        System.out.println(MESSAGE_MENU_CHOIX);
        System.out.printf("%s\n%s\n%s\n%s\n", CHOIX_UN, CHOIX_DEUX, CHOIX_TROIS, CHOIX_QUATRE);
        System.out.println();
        System.out.println();


    }

    /**
     * Demande à l'utilisateur de saisir un choix valide pour le menu.
     * Si l'utilisateur saisit un choix invalide, un message d'erreur est affiché
     * et les options sont de nouveau présentées. (2)
     *
     * @return Le choix valide de l'utilisateur (entre 1 et 4).
     */

    public static byte lireChoixMenu() {

        byte choixUtilisateur;
        do {
            System.out.print("Entrez votre choix : ");
            choixUtilisateur = Clavier.lireByteLn();


            if (choixUtilisateur < 1 | choixUtilisateur > 4) {

                System.out.println();
                System.out.println("L’option choisie est invalide!");
                afficherOptionsMenu();
            }

        } while (choixUtilisateur < 1 | choixUtilisateur > 4);

        return choixUtilisateur;
    }

    /**
     * Affiche l'en-tête contenant les informations de l'entreprise,
     * incluant le nom, l'adresse, le téléphone et la date/heure actuelle.
     */
    private static void afficherEnteteEntreprise() {


        LocalDateTime now = LocalDateTime.now();
        String dateNowFormatee = now.format(FORMATTER);

        System.out.println("\n" + SEPARATEUR_LIGNE);
        System.out.println(NOM_ENTREPRISE);
        System.out.println("Adresse :       " + ADRESSE_ENTREPRISE);
        System.out.println("Téléphone :     " + TELEPHONE_ENTREPRISE);
        System.out.println("Date et Heure : " + dateNowFormatee);

    }

    /**
     * Affiche l'en-tête d'une table contenant l'inventaire des véhicules.
     *
     * @param disponible Détermine si l'affichage concerne les véhicules disponibles (true)
     *                   ou les véhicules loués (false).
     */
    private static void afficherEnteteInventaire(boolean disponible) {

        System.out.println(SEPARATEUR_LIGNE);
        if (disponible) {
            System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_INVENTAIRE);
        } else {
            System.out.println("\n" + MESSAGE_NOMBRE_VEHICULE_LOUEE);
        }
        System.out.println("*************************************************");
        System.out.println("Grandeur          Hybride      Électrique");
        System.out.println("****************************************");
    }

    /**
     * Demande le prénom du locataire à l'utilisateur.
     * <p>
     * Si le prénom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
     * un message d'erreur est affiché et la saisie est redemandée. (3)
     *
     * @return Le prénom valide saisi par l'utilisateur.
     */

    public static String lirePrenomUtilisateur() {
        String prenomLocataire;
        boolean estPrenomValide = false;

        do {
            System.out.print("Entrez le prénom du locataire (entre 2 et 30 caractères inclusivement): ");
            prenomLocataire = Clavier.lireString().trim();

            if (prenomLocataire.length() < 2 || prenomLocataire.length() > 30) {
                System.out.println();
                System.out.println("Le prénom est invalide!");
            } else {
                estPrenomValide = true;
            }

            System.out.println();

        } while (!estPrenomValide);
        return prenomLocataire;
    }

    /**
     * Demande le nom du locataire à l'utilisateur.
     * <p>
     * Si le nom ne respecte pas les conditions (entre 2 et 30 caractères inclus),
     * un message d'erreur est affiché et la saisie est redemandée. (4)
     *
     * @return Le nom valide saisi par l'utilisateur.
     */
    public static String lireNomLocataire() {
        String nomLocataire;
        boolean estNomValide = false;

        do {
            System.out.print("Entrez le nom du locataire (entre 2 et 30 caractères inclusivement):");
            nomLocataire = Clavier.lireString().trim();

            if (nomLocataire.length() < 2 || nomLocataire.length() > 30) {
                System.out.println();
                System.out.println("Le nom est invalide!");
            } else {
                estNomValide = true;
            }

            System.out.println();

        } while (!estNomValide);

        return nomLocataire;
    }

    /**
     * Demande le téléphone du locataire à l'utilisateur.
     * <p>
     * Si le téléphone ne respecte pas le format spécifié : (NNN) NNN-NNNN ,
     * un message d'erreur est affiché et la saisie est redemandée. (5)
     *
     * @return Le téléphone valide saisi par l'utilisateur.
     */
    public static String lireTelephone() {
        String telephone;
        boolean estTelephoneValide = false;

        do {
            System.out.print("Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589):");
            telephone = Clavier.lireString().trim();


            if (telephone.matches(FORMAT_TELEPHONE)) {
                estTelephoneValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de téléphone est invalide!");
            }

            System.out.println();

        } while (!estTelephoneValide);
        return telephone;
    }


    /**
     * Demande le permis de conduire du locataire à l'utilisateur.
     * <p>
     * Si le permis de conduire ne respecte pas le format spécifié : ANNNN-NNNNNN-NN
     * un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le permis de conduire valide saisi par l'utilisateur. (6)
     */
    public static String lirePermisConduire() {
        String numeroPermis;
        boolean estPermisValide = false;

        do {
            System.out.print("Entrez le numéro de permis de conduire du locataire (Exemple : D1234-567891-23): ");
            numeroPermis = Clavier.lireString().trim();

            if (numeroPermis.matches(FORMAT_PERMIS)) {
                estPermisValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de permis de conduire est invalide!");
            }

            System.out.println();

        } while (!estPermisValide);

        return numeroPermis;
    }

    /**
     * Demande le type de véhicule choisi par l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "H" (Hybride) ou "E" (Électrique), sans distinction de casse.
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le type de véhicule valide ('h' pour Hybride, 'e' pour Électrique). (7)
     */
    public static char lireTypeVehicule() {
        char choixType;
        boolean estTypeValide = false;

        do {
            System.out.println();
            System.out.println("Entrez le type du véhicule à louer");
            System.out.print("(H ou h pour Hybride, et E ou e pour Électrique) : ");
            choixType = Character.toLowerCase(Clavier.lireCharLn());


            if (choixType == VEHICULE_HYBRIDE || choixType == VEHICULE_ELECTRIQUE) {
                estTypeValide = true;
            } else {
                System.out.println();
                System.out.println("Le type de véhicule est invalide!");
            }


        } while (!estTypeValide);
        return choixType;
    }

    /**
     * Demande la grandeur de véhicule choisi par l'utilisateur.
     * L'utilisateur doit entrer "P" (Petit), "I" (Intermédiaire) ou "G" (Grand)
     * sans distinction de casse.
     * `<p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée. (8)
     *
     * @return La grandeur de véhicule valide ("P" (Petit), "I" (Intermédiaire) ou "G" (Grand)).
     */
    public static char saisiGrandeurVehicule() {
        char choixGrandeur;
        boolean estGrandeurValide = false;

        do {
            System.out.println();
            System.out.println("Entrez la grandeur du véhicule à louer");
            System.out.print("(P ou p pour Petit, I ou i pour Intermédiaire, et G ou g pour Grand) :    ");
            choixGrandeur = Character.toLowerCase(Clavier.lireCharLn());

            if (choixGrandeur == VEHICULE_PETIT || choixGrandeur == VEHICULE_INTERMEDIAIRE || choixGrandeur == VEHICULE_GRAND) {
                estGrandeurValide = true;
            } else {
                System.out.println();
                System.out.println("La grandeur du véhicule est invalide!");
            }


        } while (!estGrandeurValide);

        System.out.println();
        return choixGrandeur;

    }

    /**
     * Demande à l'utilisateur de saisir le nombre de jours de location.
     * L'utilisateur doit entrer une valeur strictement supérieure à 0 et inférieure ou égale à 30. (9)
     * <p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le nombre de jours de location valide (1 à 30).
     */
    public static int lireNombreJourLocation() {
        int nombreJours;
        boolean estNbrJourValide = false;

        do {
            System.out.println("Entrez le nombre de jours de location");
            System.out.print("(supérieur à 0 et inférieur ou égal à 30) :    ");
            nombreJours = Clavier.lireInt();

            if (nombreJours <= MINJOURSLOCATION || nombreJours >= MAXJOURSLOCATION) {
                System.out.println();
                System.out.println("Le nombre de jours de location est invalide!");
            } else {
                estNbrJourValide = true;
            }
            System.out.println();

        } while (!estNbrJourValide);

        return nombreJours;
    }

    /**
     * Demande le mode de paiement du locataire à l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "D" (Débit) ou "C" (Crédit) sans distinction de casse.
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le mode de paiement valide saisi par l'utilisateur ("D" (Débit) ou "C" (Crédit))
     */
    public static char lireModePaiement() {
        char choixPaiement;
        boolean estModePaiementValide = false;

        do {
            System.out.println("Entrez le mode de paiement");
            System.out.print("(D ou d pour Débit, C ou c pour Crédit): ");
            choixPaiement = Character.toLowerCase(Clavier.lireCharLn());

            if (choixPaiement != CARTE_DEBIT && choixPaiement != CARTE_CREDIT) {
                System.out.println();
                System.out.println("Le mode de paiement est invalide!");
            } else {
                estModePaiementValide = true;
            }

            System.out.println();

        } while (!estModePaiementValide);
        return choixPaiement;
    }

    /**
     * Demande le type de carte de crédit du locataire à l'utilisateur.
     * <p>
     * L'utilisateur doit entrer "V" (Visa) ou "M" (MasterCard) sans distinction de casse
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le type de carte de crédit valide saisi par l'utilisateur. (12)
     */
    public static char lireCarteCredit() {

        char choixCarteCredit;
        boolean estCarteCreditValide = false;

        do {
            System.out.println("Entrez le type de la carte de crédit");
            System.out.print("(V ou v pour Visa, et M ou m pour MasterCard): ");
            choixCarteCredit = Character.toLowerCase(Clavier.lireCharLn());

            if (choixCarteCredit != VISA_CARTE_CREDIT && choixCarteCredit != MC_CARTE_CREDIT) {
                System.out.println();
                System.out.println("Le type de la carte de crédit est invalide!");
            } else {
                estCarteCreditValide = true;
            }

            System.out.println();

        } while (!estCarteCreditValide);
        return choixCarteCredit;
    }

    /**
     * Demande le numéro de carte de crédit du locataire à l'utilisateur.
     * <p>
     * Si le numéro de carte de crédit ne respecte pas le format spécifié : NNNN BNNN NNNN NNNN
     * Un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le numéro de carte de crédit valide saisi par l'utilisateur. (12)
     */
    public static String saisiNumeroCarteCredit() {
        String numeroCarte;
        boolean estNumeroValide = false;

        do {
            System.out.print("Entrez le numéro de la carte de crédit (Exemple : 1234 5678 9123 4567) :");
            numeroCarte = Clavier.lireString().trim();

            if (numeroCarte.matches("[0-9]{1,4} [0-9]{1,4} [0-9]{1,4} [0-9]{1,4}")) {
                estNumeroValide = true;
            } else {
                System.out.println();
                System.out.println("Le numéro de la carte de crédit est invalide!");
            }

            System.out.println();

        } while (!estNumeroValide);
        return numeroCarte;
    }

    /**
     * Demande à l'utilisateur s'il souhaite souscrire une assurance.
     * L'utilisateur doit entrer "O" (Oui) ou "N" (Non), sans distinction de casse.
     * <p>
     * Si l'entrée est invalide, un message d'erreur est affiché et la saisie est redemandée.
     *
     * @return Le choix d'assurance valide ('o' pour Oui ou 'n' pour Non). (12)
     */
    public static char lireChoixAssurance() {
        char choixAssurance;
        boolean estChoixAssuranceValide = false;

        do {
            System.out.println("Désirez-vous prendre l'assurance");
            System.out.print("(O ou o pour Oui, N ou n pour Non) ? :    ");
            choixAssurance = Character.toLowerCase(Clavier.lireCharLn());

            if (choixAssurance != ASSURANCE_OUI && choixAssurance != ASSURANCE_NON) {
                System.out.println();
                System.out.println("La réponse est invalide!");
            } else {
                estChoixAssuranceValide = true;
            }

            System.out.println();

        } while (!estChoixAssuranceValide);
        return choixAssurance;
    }

    /**
     * Calcule le nombre de véhicules disponibles selon le type et la grandeur choisis par le locataire. (3.1)
     *
     * @param type      Le type de véhicule choisi ('H' pour Hybride, 'E' pour Électrique).
     * @param grandeur  La taille du véhicule choisi ('P' pour Petit, 'I' pour Intermédiaire, 'G' pour Grand).
     * @param nbLouesHP Nombre de véhicules Hybride Petit loués.
     * @param nbLouesHI Nombre de véhicules Hybride Intermédiaire loués.
     * @param nbLouesHG Nombre de véhicules Hybride Grand loués.
     * @param nbLouesEP Nombre de véhicules Électrique Petit loués.
     * @param nbLouesEI Nombre de véhicules Électrique Intermédiaire loués.
     * @param nbLouesEG Nombre de véhicules Électrique Grand loués.
     * @return Le nombre de véhicules disponibles correspondant aux critères du locataire.
     */

    public static int calculerVehiculesDisponibles(char type, char grandeur, int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {
        int nbrDisponible;
        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                nbrDisponible = nbDisponiblesHP - nbLouesHP;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                nbrDisponible = nbDisponiblesHI - nbLouesHI;
            } else {
                nbrDisponible = nbDisponiblesHG - nbLouesHG;
            }

        } else {
            if (grandeur == VEHICULE_PETIT) {
                nbrDisponible = nbDisponiblesEP - nbLouesEP;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                nbrDisponible = nbDisponiblesEI - nbLouesEI;
            } else {
                nbrDisponible = nbDisponiblesEG - nbLouesEG;
            }
        }

        return nbrDisponible;
    }

    /**
     * Calcule le prix de location en fonction du type et de la grandeur du véhicule choisi par le locataire.
     *
     * @param type     Le type de véhicule choisi ('H' pour Hybride, 'E' pour Électrique).
     * @param grandeur La taille du véhicule choisi ('P' pour Petit, 'I' pour Intermédiaire, 'G' pour Grand).
     * @return Le prix du véhicule correspondant aux critères du locataire.
     */
    public static float calculerPrixLocationQuotidien(char type, char grandeur) {
        float prixQuotidien;

        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                prixQuotidien = PRIX_HYBRIDE_PETIT;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                prixQuotidien = PRIX_HYBRIDE_INTERMEDIAIRE;
            } else {
                prixQuotidien = PRIX_HYBRIDE_GRAND;
            }

        } else {
            if (grandeur == VEHICULE_PETIT) {
                prixQuotidien = PRIX_ELECTRIQUE_PETIT;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                prixQuotidien = PRIX_ELECTRIQUE_INTERMEDIAIRE;
            } else {
                prixQuotidien = PRIX_ELECTRIQUE_GRAND;
            }
        }

        return prixQuotidien;
    }

    /**
     * Calcule le prix de l'assurance en fonction du type et de la grandeur du véhicule choisi par le locataire.
     * Si le locataire refuse l'assurance, la méthode retourne 0. (3)
     *
     * @param type           Le type de véhicule choisi ('H' pour Hybride, 'E' pour Électrique).
     * @param grandeur       La taille du véhicule choisi ('P' pour Petit, 'I' pour Intermédiaire, 'G' pour Grand).
     * @param choixAssurance Le choix du locataire ('O' pour Oui, 'N' pour Non).
     * @return Le prix de l'assurance correspondant aux critères du locataire, ou 0 si l'assurance est refusée.
     */
    public static float calculerPrixAssuranceQuotidien(char type, char grandeur, char choixAssurance) {
        float prixAssuranceQuotidien;
        if (choixAssurance == ASSURANCE_OUI) {
            if (type == VEHICULE_HYBRIDE) {
                if (grandeur == VEHICULE_PETIT) {
                    prixAssuranceQuotidien = ASSURANCE_HYBRIDE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    prixAssuranceQuotidien = ASSURANCE_HYBRIDE_INTERMEDIAIRE;
                } else {
                    prixAssuranceQuotidien = ASSURANCE_HYBRIDE_GRAND;
                }

            } else {
                if (grandeur == VEHICULE_PETIT) {
                    prixAssuranceQuotidien = ASSURANCE_ELECTRIQUE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    prixAssuranceQuotidien = ASSURANCE_ELECTRIQUE_INTERMEDIAIRE;
                } else {
                    prixAssuranceQuotidien = ASSURANCE_ELECTRIQUE_GRAND;
                }
            }
        } else {
            prixAssuranceQuotidien = 0;
        }

        return prixAssuranceQuotidien;
    }

    /**
     * Calcule le rabais applicable à la location en fonction du type de véhicule, de sa grandeur
     * et du nombre de jours de location.
     * <p>
     * Si le locataire a choisi un véhicule électrique de petite ou intermédiaire taille et
     * loue pour plus de `seuilJourRabais` jours, un rabais de `tauxRabais` % est appliqué.
     *
     * @param prixLocation    Le prix total de la location avant rabais.
     * @param type            Le type de véhicule choisi ('H' pour Hybride, 'E' pour Électrique).
     * @param grandeur        La taille du véhicule choisi ('P' pour Petit, 'I' pour Intermédiaire, 'G' pour Grand).
     * @param nbrJourLocation Le nombre de jours de location.
     * @return Le montant du rabais appliqué, ou 0 si aucun rabais ne s'applique.
     */
    public static float calculerRabaisLocationQuotidien(float prixLocation, char type, char grandeur, int nbrJourLocation) {
        float rabais;

        if ((type == VEHICULE_ELECTRIQUE && (grandeur == VEHICULE_PETIT || grandeur == VEHICULE_INTERMEDIAIRE)) && nbrJourLocation > SEUIL_JOUR_RABAIS) {
            rabais = prixLocation * TAUX_RABAIS;
        } else {
            rabais = 0;
        }
        return rabais;
    }

    /**
     * Calcule le montant total de la location en fonction du nombre de jours loués,
     * du prix de location du véhicule choisi et d'un rabaisQuotidien éventuel.
     *
     * @param nbrJoursLocation      Le nombre de jours de location.
     * @param prixLocationQuotidien Le prix de location quotidien du véhicule choisi.
     * @param rabaisQuotidien       Le rabaisQuotidien journalier appliqué si les critères de réduction sont remplis.
     * @return Le montant total de la location après application du rabaisQuotidien.
     */
    public static float calculerMontantLocation(int nbrJoursLocation, float prixLocationQuotidien, float rabaisQuotidien) {
        float montantLocation;

        montantLocation = nbrJoursLocation * (prixLocationQuotidien - rabaisQuotidien);

        return montantLocation;
    }

    /**
     * Calcule le montant total de l'assurance en fonction du nombre de jours loués.
     *
     * @param nbrJoursLocation       Le nombre de jours de location.
     * @param prixAssuranceQuotidien Le prix d'assurance quotidien du véhicule choisi.
     * @return Le montant total de l'assurance pour la durée de la location.
     */
    public static float calculerMontantAssurance(int nbrJoursLocation, float prixAssuranceQuotidien) {
        float montantAssurance;

        montantAssurance = nbrJoursLocation * prixAssuranceQuotidien;

        return montantAssurance;
    }

    /**
     * Calcule le sous-total de la commande, correspondant à la somme du montant de location et du montant d'assurance.
     *
     * @param montantLocation  Le montant total de la location en fonction du véhicule et de la durée.
     * @param montantAssurance Le montant total de l'assurance si applicable.
     * @return Le sous-total de la facture.
     */
    public static float calculerSousTotal(float montantLocation, float montantAssurance) {
        float sousTotal;

        sousTotal = montantLocation + montantAssurance;

        return sousTotal;
    }

    /**
     * Calcule le montant de la TPS à partir du sous-total de la facture.
     *
     * @param sousTotal Le sous-total de la facture.
     * @return Le montant de la TPS.
     */
    public static float calculerMontantTPS(float sousTotal) {
        float montantTPS;

        montantTPS = sousTotal * TAUX_TPS;

        return montantTPS;
    }

    /**
     * Calcule le montant de la TVQ à partir du sous-total de la facture.
     *
     * @param sousTotal Le sous-total de la facture.
     * @return Le montant de la TVQ.
     */
    public static float calculerMontantTVQ(float sousTotal) {
        float montantTVQ;

        montantTVQ = sousTotal * TAUX_TVQ;

        return montantTVQ;
    }

    /**
     * Calcule le montant total de la facture après application de la TPS et de la TVQ.
     *
     * @param sousTotal  Le sous-total de la facture (avant taxes).
     * @param montantTPS Le montant de la TPS.
     * @param montantTVQ Le montant de la TVQ.
     * @return Le montant total de la facture après taxes.
     */
    public static float calculerMontantTotal(float sousTotal, float montantTPS, float montantTVQ) {
        float montantTotal;

        montantTotal = sousTotal + montantTPS + montantTVQ;

        return montantTotal;
    }


    /**
     * Génère un nouveau numéro de facture en incrémentant l'ancien.
     *
     * @param ancienNumeroFacture L'ancien numéro de facture.
     * @return Le nouveau numéro de facture, incrémenté de 1.
     */
    public static int obtenirNumeroFacture(int ancienNumeroFacture) {

        return ancienNumeroFacture + 1;
    }

    /**
     * Calcule l'heure de début de location, qui commence 3 heures après le moment actuel.
     *
     * @param tempsMaintenant L'instant actuel en date et heure.
     * @return L'heure de début de location formatée, avec un décalage de 3 heures.
     */

    private static String calculerDebutLocation(LocalDateTime tempsMaintenant) {
        String tempsDebutLocation;

        tempsDebutLocation = tempsMaintenant.plusHours(3).format(FORMATTER);

        return tempsDebutLocation;

    }

    /**
     * Calcule la date et l'heure de fin de la location en ajoutant le nombre de jours et 3 heures supplémentaires.
     *
     * @param tempsMaintenant L'instant actuel en date et heure.
     * @param nbrJourLocation Le nombre de jours de location.
     * @return La date et l'heure de fin de location formatées en chaîne de caractères.
     */

    private static String calculerFinLocation(LocalDateTime tempsMaintenant, int nbrJourLocation) {
        String tempsFinLocation;

        tempsFinLocation = tempsMaintenant.plusHours(3).plusDays(nbrJourLocation).format(FORMATTER);

        return tempsFinLocation;
    }

    /**
     * Incrémente le nombre de véhicules loués si le type et la grandeur correspondent aux critères ciblés.
     *
     * @param typeChoisie       Le type de véhicule choisi par le locataire.
     * @param typeCible         Le type de véhicule ciblé par l'incrémentation.
     * @param grandeurChoisie   La grandeur de véhicule choisie par le locataire.
     * @param grandeurCible     La grandeur de véhicule ciblée par l'incrémentation.
     * @param nbrVehiculesLoues Le nombre de véhicules loués précédemment.
     * @return Le nombre de véhicules loués après l'incrémentation si les critères correspondent.
     */

    public static int incrementerVehiculeLoue(char typeChoisie, char typeCible, char grandeurChoisie, char grandeurCible, int nbrVehiculesLoues) {
        if (typeChoisie == typeCible && grandeurChoisie == grandeurCible) {
            nbrVehiculesLoues++;
        }
        return nbrVehiculesLoues;
    }


    /**
     * Retourne la description liée au type de véhicule.
     *
     * @param type Le type de véhicule ('H' pour Hybride, 'E' pour Électrique).
     * @return La description textuelle du type de véhicule ("Hybride" ou "Électrique").
     */
    private static String obtenirDescriptionType(char type) {
        String description;

        if (type == VEHICULE_HYBRIDE) {
            description = VEHICULE_HYBRIDE_DESCRIPTION;
        } else {
            description = VEHICULE_ELECTRIQUE_DESCRIPTION;
        }

        return description;
    }

    /**
     * Retourne la description liée à la grandeur du véhicule.
     *
     * @param grandeur Le type de véhicule ('P' pour Petit, 'I' pour Intermédiaire et 'G' pour Grand).
     * @return La description textuelle du type de véhicule ("Petit", "Intermédiaire", "Grand").
     */
    private static String obtenirDescriptionGrandeur(char grandeur) {
        String description;

        if (grandeur == VEHICULE_PETIT) {
            description = VEHICULE_PETIT_DESCRIPTION;
        } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
            description = VEHICULE_INTERMEDIAIRE_DESCRIPTION;
        } else {
            description = VEHICULE_GRAND_DESCRIPTION;
        }

        return description;
    }

    /**
     * Retourne la description liée au mode de paiement.
     *
     * @param modePaiement Le mode de paiement ('D' pour Débit et 'C' pour Crédit).
     * @return La description textuelle du mode de paiement ('D' pour Débit et 'C' pour Crédit).
     */
    private static String obtenirDescriptionModePaiement(char modePaiement) {
        String description;

        if (modePaiement == CARTE_CREDIT) {
            description = CARTE_CREDIT_DESCRIPTION;
        } else {
            description = CARTE_DEBIT_DESCRIPTION;
        }

        return description;
    }

    /**
     * Retourne la description liée au type de carte de crédit.
     *
     * @param carteCredit La carte de crédit ('V' pour Visa et 'M' pour MasterCard).
     * @return La description textuelle du type de carte de crédit ('V' pour Visa et 'M' pour MasterCard).
     */
    private static String obtenirDescriptionCarteCredit(char carteCredit) {
        String description;

        if (carteCredit == VISA_CARTE_CREDIT) {
            description = CREDIT_VISA_DESCRIPTION;
        } else {
            description = CREDIT_MASTERCARD_DESCRIPTION;
        }

        return description;
    }

    /**
     * Affiche sous forme de tableau le nombre de véhicules disponibles pour chaque type et grandeur de véhicule.
     * <p>
     * Le calcul des véhicules disponibles est effectué en soustrayant le nombre de véhicules loués du nombre total disponible.
     *
     * @param nbLouesHP Nombre de véhicules Hybride Petit loués.
     * @param nbLouesHI Nombre de véhicules Hybride Intermédiaire loués.
     * @param nbLouesHG Nombre de véhicules Hybride Grand loués.
     * @param nbLouesEP Nombre de véhicules Électrique Petit loués.
     * @param nbLouesEI Nombre de véhicules Électrique Intermédiaire loués.
     * @param nbLouesEG Nombre de véhicules Électrique Grand loués.
     */

    public static void afficherVehiculeDisponible(int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {

        System.out.printf("Petit %15d %15d", (nbDisponiblesHP - nbLouesHP), (nbDisponiblesEP - nbLouesEP));
        System.out.printf("\nIntermédiaire %7d %15d", (nbDisponiblesHI - nbLouesHI), (nbDisponiblesEI - nbLouesEI));
        System.out.printf("\nGrand %15d %15d\n\n", (nbDisponiblesHG - nbLouesHG), (nbDisponiblesEG - nbLouesEG));
        System.out.println(SEPARATEUR_LIGNE);

    }

    /**
     * Affiche la facture détaillée d'un locataire, incluant ses informations personnelles,
     * le véhicule loué, la durée de location, le mode de paiement et les montants calculés.
     * <p>
     * Si le paiement a été effectué par carte de crédit, seul le dernier bloc de chiffres du numéro est affiché.
     *
     * @param numeroFacture        Le numéro de facture unique.
     * @param prenomLocataire      Le prénom du locataire.
     * @param nomLocataire         Le nom de famille du locataire.
     * @param telephoneLocataire   Le numéro de téléphone du locataire.
     * @param permisLocataire      Le numéro de permis de conduire du locataire.
     * @param typeVehicule         Le type de véhicule loué ('H' pour Hybride, 'E' pour Électrique).
     * @param grandeurVehicule     La taille du véhicule loué ('P' pour Petit, 'I' pour Intermédiaire, 'G' pour Grand).
     * @param modePaiement         Le mode de paiement utilisé ('D' pour Débit, 'C' pour Crédit).
     * @param typeCarteCredit      Le type de carte de crédit utilisée (si applicable).
     * @param numeroCarteCredit    Le numéro de carte de crédit masqué (si applicable).
     * @param nbrJourLocation      Le nombre de jours de location.
     * @param prixLocationParJour  Le prix journalier de la location du véhicule.
     * @param prixAssuranceParJour Le prix journalier de l'assurance (si souscrite).
     * @param rabais               Le rabais appliqué (si applicable).
     * @param montantLocation      Le montant total de la location avant assurance et taxes.
     * @param montantAssurance     Le coût total de l'assurance.
     * @param sousTotalFacture     Le sous-total avant taxes.
     * @param montantTPS           Le montant de la taxe TPS.
     * @param montantTVQ           Le montant de la taxe TVQ.
     * @param montantTotalFacture  Le montant total à payer après taxes.
     */
    public static void afficherFacture(int numeroFacture,
                                       String prenomLocataire,
                                       String nomLocataire,
                                       String telephoneLocataire,
                                       String permisLocataire,
                                       char typeVehicule,
                                       char grandeurVehicule,
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
    ) {

        afficherEnteteEntreprise();
        LocalDateTime now = LocalDateTime.now();

        // Affichage de l'en-tête de la facture
        System.out.println("Facture No :    " + numeroFacture);
        System.out.println(SEPARATEUR_LIGNE);

        // Affichage des informations du locataire
        System.out.println();
        System.out.println("Prénom et nom : " + prenomLocataire + " " + nomLocataire);
        System.out.println("Téléphone : " + telephoneLocataire);
        System.out.println("Permis de conduire : " + permisLocataire);
        System.out.println();

        // Affichage des informations sur le véhicule loué
        System.out.print("Type de véhicule : " + obtenirDescriptionType(typeVehicule));
        System.out.println();
        System.out.print("Grandeur du véhicule : " + obtenirDescriptionGrandeur(grandeurVehicule));
        System.out.println();

        //  // Génération et affichage des dates de location et de retour
        System.out.println();
        System.out.println("Nombre de jours de location : " + nbrJourLocation);
        System.out.println("Date de location : " + calculerDebutLocation(now));
        System.out.println("Date de retour   : " + calculerFinLocation(now, nbrJourLocation));

        // Affichage du mode de paiement
        System.out.print("\nMode de paiement : " + obtenirDescriptionModePaiement(modePaiement));

        // Si le paiement est effectué par carte de crédit, afficher les informations de la carte
        if (modePaiement == CARTE_CREDIT) {
            System.out.println();

            // Masque les 12 premiers chiffres du numéro de carte de crédit pour des raisons de sécurité
            String numeroCarteCreditCache = "XXXX XXXX XXXX " + numeroCarteCredit.substring(15, 19);
            System.out.println("Type de la carte de crédit : " + obtenirDescriptionCarteCredit(typeCarteCredit));
            System.out.println("Numéro de la carte de crédit : " + numeroCarteCreditCache);
        } else {
            System.out.println();
        }

        // Affichage des coûts journaliers
        System.out.printf("\n%-34s %.2f$", MESSAGE_PRIX_LOCATION, prixLocationParJour);
        System.out.printf("\n%-34s %.2f$", MESSAGE_PRIX_ASSURANCE, prixAssuranceParJour);

        // Si un rabais est appliqué, l'afficher
        if (rabais > 0) {
            System.out.printf("\n%-34s %.2f$", MESSAGE_RABAIS_LOCATION, rabais);
        }

        // Affichage des coûts totaux
        System.out.printf("\n\n%-34s %.2f$", MESSAGE_MONTANT_LOCATION_SOUS_TOTAL, montantLocation);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_ASSURANCE, montantAssurance);
        System.out.printf("\n\n%-34s %.2f$", MESSAGE_SOUS_TOTAL, sousTotalFacture);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TPS, montantTPS);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TVQ, montantTVQ);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TOTAL, montantTotalFacture);

        // Affichage du message de remerciement
        System.out.println();
        System.out.println(SEPARATEUR_LIGNE);
        System.out.println(MESSAGE_REMERCIEMENT);
        System.out.println();

    }

    /**
     * Affiche sous forme de tableau le nombre de véhicules louées pour chaque type et grandeur de véhicule.
     *
     * @param nbLouesHP Nombre de véhicules Hybride Petit loués.
     * @param nbLouesHI Nombre de véhicules Hybride Intermédiaire loués.
     * @param nbLouesHG Nombre de véhicules Hybride Grand loués.
     * @param nbLouesEP Nombre de véhicules Électrique Petit loués.
     * @param nbLouesEI Nombre de véhicules Électrique Intermédiaire loués.
     * @param nbLouesEG Nombre de véhicules Électrique Grand loués.
     */
    public static void afficherVehiculeLoues(int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {
        System.out.printf("Petit %15d %15d", nbLouesHP, nbLouesEP);
        System.out.printf("\nIntermédiaire %7d %15d", nbLouesHI, nbLouesEI);
        System.out.printf("\nGrand %15d %15d\n\n", nbLouesHG, nbLouesEG);
        System.out.println(SEPARATEUR_LIGNE);
    }

    /**
     * Affiche un message en fonction du nombre de voitures disponibles restantes.
     * <p>
     * Cette méthode déclenche le retour au menu principal s'il ne reste aucun véhicule disponible.
     *
     * @param nbrDisponible Le nombre de voitures disponibles.
     * @return true s'il n'y a plus de voitures disponibles, false s'il en reste.
     */
    private static boolean declencherRetourMenuPrincipal(int nbrDisponible) {
        boolean estRetourMenu;
        if (nbrDisponible > 0) {

            System.out.println(nbrDisponible + " véhicules de ce type et de cette grandeur sont disponibles !\n");
            estRetourMenu = true;

        } else {

            System.out.print("Aucun véhicule de ce type et de cette grandeur n'est disponible !");
            estRetourMenu = false;
        }
        return estRetourMenu;
    }

    /**
     * Attend que l'utilisateur appuie sur Entrée pour revenir au menu principal.
     *
     * @return Toujours true une fois que l'utilisateur a appuyé sur Entrée.
     */
    private static boolean retournerMenu() {
        System.out.println();
        System.out.println();
        System.out.print("Appuyer sur <ENTREE> pour réafficher le menu...");
        Clavier.lireFinLigne();

        return false;

    }

    /**
     * Point d'entrée du programme de location de véhicules.
     * Gère le menu principal et les interactions avec l'utilisateur.
     *
     * @param args Arguments de ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        // Déclaration des variables //

        // Choix et saisi de l'utilisateur
        byte choixMenu;
        char modePaiementLocataire;
        char carteCreditLocataire;
        String numeroCarteLocataire = null;
        char typeVehiculeChoisi;
        char grandeurVehiculeChoisi;
        int jourLocation;
        char choixAssuranceLocataire;

        // Information du locataire
        String prenomLocataire;
        String nomLocataire;
        String telephoneLocataire;
        String permisLocataire;


        // Informations liées à la facture
        int NumeroFacture = 0;
        float prixLocationParJour;
        float prixAssuranceParJour;
        float rabaisLocation;
        float montantLocation;
        float montantAssurance;
        float sousTotalLocation;
        float montantTPSLocation;
        float montantTVQLocation;
        float montantTotalLocation;

        // Actionner le retour au menu
        boolean isRunning;
        int nbrDisponibleVehiculeChoisi;

        //Initiation du nombre de véhicules loués
        int nbLouesHP = 0;
        int nbLouesHI = 0;
        int nbLouesHG = 3;
        int nbLouesEP = 0;
        int nbLouesEI = 0;
        int nbLouesEG = 0;


        // Affichage //

        // Affichage du message de bienvenue
        afficherMessageBievenue();

        do {

            // Affichage du menu principal et lecture du choix de l'utilisateur
            afficherOptionsMenu();
            choixMenu = lireChoixMenu();
            isRunning = true;

            // Tant que l'utilisateur n'a pas appuyé sur Entrée, il reste dans l'option choisie
            while (isRunning) {

                // Gestion des différentes options du menu
                switch (choixMenu) {
                    case 1: // Afficher l'inventaire des voitures disponibles
                        afficherEnteteEntreprise();
                        afficherEnteteInventaire(true);
                        afficherVehiculeDisponible(nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);
                        break;


                    case 2: // Louer une voiture et générer une facture
                        typeVehiculeChoisi = lireTypeVehicule();
                        grandeurVehiculeChoisi = saisiGrandeurVehicule();
                        nbrDisponibleVehiculeChoisi = calculerVehiculesDisponibles(typeVehiculeChoisi, grandeurVehiculeChoisi, nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);

                        // Si aucun véhicule n'est disponible, retour au menu principal
                        isRunning = declencherRetourMenuPrincipal(nbrDisponibleVehiculeChoisi);


                        if (isRunning) {
                            // Mise à jour du nombre de véhicules loués selon le type et la grandeur
                            nbLouesHP = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_PETIT, nbLouesHP);
                            nbLouesHI = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_INTERMEDIAIRE, nbLouesHI);
                            nbLouesHG = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_GRAND, nbLouesHG);

                            nbLouesEP = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_PETIT, nbLouesEP);
                            nbLouesEI = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_INTERMEDIAIRE, nbLouesEI);
                            nbLouesEG = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_GRAND, nbLouesEG);

                            // Lecture des informations du locataire
                            jourLocation = lireNombreJourLocation();
                            prenomLocataire = lirePrenomUtilisateur();
                            nomLocataire = lireNomLocataire();
                            telephoneLocataire = lireTelephone();
                            permisLocataire = lirePermisConduire();
                            modePaiementLocataire = lireModePaiement();

                            // Si le paiement est par carte de crédit, lecture des informations de la carte
                            if (modePaiementLocataire == CARTE_CREDIT) {
                                carteCreditLocataire = lireCarteCredit();
                                numeroCarteLocataire = saisiNumeroCarteCredit();
                            } else {
                                carteCreditLocataire = ' ' ; // Valeur par défaut parce qu'aucune carte de crédit a été saisie si le choix est débit
                            }

                            // Calcul des montants pour la facture
                            choixAssuranceLocataire = lireChoixAssurance();
                            prixLocationParJour = calculerPrixLocationQuotidien(typeVehiculeChoisi, grandeurVehiculeChoisi);
                            prixAssuranceParJour = calculerPrixAssuranceQuotidien(typeVehiculeChoisi, grandeurVehiculeChoisi, choixAssuranceLocataire);
                            rabaisLocation = calculerRabaisLocationQuotidien(prixLocationParJour, typeVehiculeChoisi, grandeurVehiculeChoisi, jourLocation);
                            montantLocation = calculerMontantLocation(jourLocation, prixLocationParJour, rabaisLocation);
                            montantAssurance = calculerMontantAssurance(jourLocation, prixAssuranceParJour);
                            sousTotalLocation = calculerSousTotal(montantLocation, montantAssurance);
                            montantTPSLocation = calculerMontantTPS(sousTotalLocation);
                            montantTVQLocation = calculerMontantTVQ(sousTotalLocation);
                            montantTotalLocation = calculerMontantTotal(sousTotalLocation, montantTPSLocation, montantTVQLocation);
                            NumeroFacture = obtenirNumeroFacture(NumeroFacture);

                            // Affichage de la facture finale
                            afficherFacture(
                                    NumeroFacture,
                                    prenomLocataire,
                                    nomLocataire,
                                    telephoneLocataire,
                                    permisLocataire,
                                    typeVehiculeChoisi,
                                    grandeurVehiculeChoisi,
                                    modePaiementLocataire,
                                    carteCreditLocataire,
                                    numeroCarteLocataire,
                                    jourLocation,
                                    prixLocationParJour,
                                    prixAssuranceParJour,
                                    rabaisLocation,
                                    montantLocation,
                                    montantAssurance,
                                    sousTotalLocation,
                                    montantTPSLocation,
                                    montantTVQLocation,
                                    montantTotalLocation
                            );
                        }
                        break;


                    case 3: // Afficher les voitures louées
                        afficherEnteteEntreprise();
                        afficherEnteteInventaire(false);
                        afficherVehiculeLoues(nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);
                        break;

                    case 4: // Quitter le programme
                        System.out.println("\n\nMerci et à la prochaine !");
                        break;


                }

                // Attente de l'utilisateur avant de retourner au menu
                if (choixMenu != 4) {
                    isRunning = retournerMenu();
                    // Quitter le programme sans retourner au menu suit au choix 4 du menu
                } else isRunning = false;


            }
        } while (choixMenu != 4);

    }
}

