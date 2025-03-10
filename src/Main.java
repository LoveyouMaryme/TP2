
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
    public static final String ADRESSE_ENTREPRISE = "1500 rue Matata, Hakuna, Québec Y0Z 6Y7";
    public static final String TELEPHONE_ENTREPRISE = "438 222-1111";
    public static final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";
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
    public static final float POURCENTAGE_TPS = 0.05f;
    public static final float POURCENTAGE_TVQ = 0.09975f;
    public static final float POURCENTAGE_RABAIS_LOCATION = 0.20f;
    public static final int NBR_JOUR_RABAIS = 15;


    // Vérification du numéro de téléphone
    public static final int MAX_CHAR_TELEPHONE = 14;
    public static final char PARANTHESE_OUVRANTE = '(';
    public static final char PARANTHESE_FERMANTE = ')';
    public static final char TRAIT_UNION = '-';
    public static final byte POS_PARANTHESE_OUVRANTE_TEL = 0;
    public static final byte POS_PARANTHESE_FERMANTE_TEL = 4;
    public static final byte POS_TRAIT_UNION_TEL = 9;

    // Formatter les dates
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");

    /**
     * Affiche un message de bienvenue pour l'entreprise Roulons les Véhicules Verts (RVV) (1)
     */
    public static void afficherMessageBievenue() {
        final String NOM_ENTREPRISE = "Roulons les Véhicules Verts (RVV)";
        final String MESSAGE_BIENVENUE = "Bienvenue dans le système de facturation de " + NOM_ENTREPRISE;
        final String ENCADRE_TITRE = "---------------------------------------------------------------------------------";

        System.out.println(ENCADRE_TITRE);
        System.out.println(MESSAGE_BIENVENUE);
        System.out.println(ENCADRE_TITRE);
    }

    /**
     * Affiche les quatre options du menu principal de l'application.
     */
    public static void afficherOptionsMenu() {

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
     *
     */
    public static void afficherEnteteEntreprise() {


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
     * ou les véhicules loués (false).
     *
     *
     */
    public static void afficherEnteteInventaire(boolean disponible) {

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


            if (telephone.length() == MAX_CHAR_TELEPHONE
                    && telephone.charAt(POS_PARANTHESE_OUVRANTE_TEL) == PARANTHESE_OUVRANTE
                    && telephone.charAt(POS_PARANTHESE_FERMANTE_TEL) == PARANTHESE_FERMANTE
                    && telephone.charAt(POS_TRAIT_UNION_TEL) == TRAIT_UNION) {

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

            if (numeroPermis.matches("[A-Za-z][0-9]{1,4}-[0-9]{1,6}-[0-9]{1,2}")) {
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
     * <p>
     * L'utilisateur doit entrer "P" (Petit), "I" (Intermédiaire) ou "G" (Grand)
     * sans distinction de casse.
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
     * <p>
     * L'utilisateur doit entrer une valeur strictement supérieure à 0 et inférieure ou égale à 30. (9)
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
     *
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

    public static int obtenirVoituresDisponibles(char type, char grandeur, int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {

        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                return nbDisponiblesHP - nbLouesHP;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return nbDisponiblesHI - nbLouesHI;
            } else {
                return nbDisponiblesHG - nbLouesHG;
            }

        } else {
            if (grandeur == VEHICULE_PETIT) {
                return nbDisponiblesEP - nbLouesEP;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return nbDisponiblesEI - nbLouesEI;
            } else {
                return nbDisponiblesEG - nbLouesEG;
            }
        }
    }

    public static float obtenirPrixLocation(char type, char grandeur) {
        if (type == VEHICULE_HYBRIDE) {
            if (grandeur == VEHICULE_PETIT) {
                return PRIX_HYBRIDE_PETIT;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return PRIX_HYBRIDE_INTERMEDIAIRE;
            } else {
                return PRIX_HYBRIDE_GRAND;
            }

        } else {
            if (grandeur == VEHICULE_PETIT) {
                return PRIX_ELECTRIQUE_PETIT;
            } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                return PRIX_ELECTRIQUE_INTERMEDIAIRE;
            } else {
                return PRIX_ELECTRIQUE_GRAND;
            }
        }
    }

    public static float obtenirPrixAssurance(char type, char grandeur, char choixAssurance) {

        if (choixAssurance == ASSURANCE_OUI) {

            if (type == VEHICULE_HYBRIDE) {
                if (grandeur == VEHICULE_PETIT) {
                    return ASSURANCE_HYBRIDE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    return ASSURANCE_HYBRIDE_INTERMEDIAIRE;
                } else {
                    return ASSURANCE_HYBRIDE_GRAND;
                }

            } else {
                if (grandeur == VEHICULE_PETIT) {
                    return ASSURANCE_ELECTRIQUE_PETIT;
                } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
                    return ASSURANCE_ELECTRIQUE_INTERMEDIAIRE;
                } else {
                    return ASSURANCE_ELECTRIQUE_GRAND;
                }
            }

        } else {
            return 0;
        }
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

    public static float calculerMontantLocation(int nbrJourLocation, float prixLocation, float rabais) {
        float montantLocation;

        montantLocation = (nbrJourLocation * prixLocation) + (nbrJourLocation * rabais);

        return montantLocation;
    }

    public static float calculerMontantAssurance(int nbrJourLocation, float prixAssurance) {
        float montantAssurance;

        montantAssurance = nbrJourLocation * prixAssurance;

        return montantAssurance;
    }

    public static float calculerSousTotal(float montantLocation, float montantAssurance) {
        float sousTotal;

        sousTotal = montantLocation + montantAssurance;

        return sousTotal;
    }

    public static float calculerMontantTPS(float sousTotal) {
        float montantTPS;

        montantTPS = sousTotal * POURCENTAGE_TPS;

        return montantTPS;
    }

    public static float calculerMontantTVQ(float sousTotal) {
        float montantTVQ;

        montantTVQ = sousTotal * POURCENTAGE_TVQ;

        return montantTVQ;
    }

    public static float calculerMontantTotal(float sousTotal, float montantTPS, float montantTVQ) {
        float montantTotal;

        montantTotal = sousTotal + montantTPS + montantTVQ;

        return montantTotal;
    }

    public static int obtenirNumeroFacture(int ancienNumeroFacture) {
        int numeroFacture;

        numeroFacture = ++ancienNumeroFacture;

        return numeroFacture;
    }

    private static String calculerDebutLocation(LocalDateTime tempsMaintenant) {
        String tempsDebutLocation;

        tempsDebutLocation = tempsMaintenant.plusHours(3).format(FORMATTER);

        return tempsDebutLocation;

    }

    private static String calculerFinLocation(LocalDateTime tempsMaintenant, int nbrJourLocation) {
        String tempsFinLocation;

        tempsFinLocation = tempsMaintenant.plusHours(3).plusDays(nbrJourLocation).format(FORMATTER);

        return tempsFinLocation;
    }

    public static int incrementerVehiculeLoue(char typeChoisi, char typeCible, char grandeurChoisi, char grandeurCible, int nbrVehiculeChoisi) {
        if (typeChoisi == typeCible && grandeurChoisi == grandeurCible) {
            nbrVehiculeChoisi++;
            return nbrVehiculeChoisi;
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

    private static String obtenirDescriptionGrandeur(char grandeur) {
        String description;

        if (grandeur == VEHICULE_PETIT) {
            description = "Petit";
        } else if (grandeur == VEHICULE_INTERMEDIAIRE) {
            description = "Intermediaire";
        } else {
            description = "Grand";
        }

        return description;
    }

    private static String obtenirDescriptionModePaiement(char modePaiement) {
        String description;

        if (modePaiement == CARTE_CREDIT) {
            description = "Crédit";
        } else {
            description = "Débit";
        }

        return description;
    }

    private static String obtenirDescriptionCarteCredit(char carteCredit) {
        String description;

        if (carteCredit == VISA_CARTE_CREDIT) {
            description = "Visa";
        } else {
            description = "MasterCard";
        }

        return description;
    }


    public static void afficherVehiculeDisponible(int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {

// jupdate ensuite jenleve encoreiue45r

        System.out.printf("Petit %15d %15d", (nbDisponiblesHP - nbLouesHP), (nbDisponiblesEP - nbLouesEP));
        System.out.printf("\nIntermédiaire %7d %15d", (nbDisponiblesHI - nbLouesHI), (nbDisponiblesEI - nbLouesEI));
        System.out.printf("\nGrand %15d %15d\n\n", (nbDisponiblesHG - nbLouesHG), (nbDisponiblesEG - nbLouesEG));
        System.out.println(SEPARATEUR_LIGNE);

    }

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
        String numeroCarteCreditCache;
        afficherEnteteEntreprise();
        LocalDateTime now = LocalDateTime.now();

        System.out.println("Facture No :    " + numeroFacture);
        System.out.println(SEPARATEUR_LIGNE);

        System.out.println();
        System.out.println("Prénom et nom : " + prenomLocataire + " " + nomLocataire);
        System.out.println("Téléphone : " + telephoneLocataire);
        System.out.println("Permis de conduire : " + permisLocataire);

        System.out.println();

        System.out.print("Type de véhicule : " + obtenirDescriptionType(typeVehicule));
        System.out.println();
        System.out.print("Grandeur du véhicule : " + obtenirDescriptionGrandeur(grandeurVehicule));
        System.out.println();

        // Dates de début et de retour du location
        System.out.println();
        System.out.println("Nombre de jours de location : " + nbrJourLocation);
        System.out.println("Date de location : " + calculerDebutLocation(now));
        System.out.println("Date de retour   : " + calculerFinLocation(now, nbrJourLocation));

        // Mode de paiement
        System.out.print("\nMode de paiement : " + obtenirDescriptionModePaiement(modePaiement));

        if (modePaiement == CARTE_CREDIT) {
            System.out.println();
            numeroCarteCreditCache = "XXXX XXXX XXXX " + numeroCarteCredit.substring(15, 19);
            System.out.println("Type de la carte de crédit : " + obtenirDescriptionCarteCredit(typeCarteCredit));
            System.out.println("Numéro de la carte de crédit : " + numeroCarteCreditCache);
        } else {
            System.out.println();
        }
        System.out.printf("\n%-34s %.2f$", MESSAGE_PRIX_LOCATION, prixLocationParJour);
        System.out.printf("\n%-34s %.2f$", MESSAGE_PRIX_ASSURANCE, prixAssuranceParJour);

        if (rabais > 0) {
            System.out.printf("\n%-34s %.2f$", MESSAGE_RABAIS_LOCATION, rabais);
        }

        System.out.printf("\n\n%-34s %.2f$", MESSAGE_MONTANT_LOCATION_SOUS_TOTAL, montantLocation);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_ASSURANCE, montantAssurance);
        System.out.printf("\n\n%-34s %.2f$", MESSAGE_SOUS_TOTAL, sousTotalFacture);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TPS, montantTPS);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TVQ, montantTVQ);
        System.out.printf("\n%-34s %.2f$", MESSAGE_MONTANT_TOTAL, (montantTotalFacture));

        System.out.println();
        System.out.println(SEPARATEUR_LIGNE);
        System.out.println(MESSAGE_REMERCIEMENT);
        System.out.println();

    }

    public static void afficherVehiculeLoues(int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {
        System.out.printf("Petit %15d %15d", nbLouesHP, nbLouesEP);
        System.out.printf("\nIntermédiaire %7d %15d", nbLouesHI, nbLouesEI);
        System.out.printf("\nGrand %15d %15d\n\n", nbLouesHG, nbLouesEG);
        System.out.println(SEPARATEUR_LIGNE);
    }

    public static boolean verifieVoitureChoisiDisponible(int nbrDisponible) {
        boolean vehiculeEstDisponible;

        if (nbrDisponible != 0) {

            System.out.println(nbrDisponible + " véhicules de ce type et de cette grandeur sont disponibles !\n");
            vehiculeEstDisponible = false;

        } else {

            System.out.print("Aucun véhicule de ce type et de cette grandeur n'est disponible !");
            vehiculeEstDisponible = true;

        }
        return vehiculeEstDisponible;
    }

    public static boolean retourMenu() {
        boolean enterIsPressed;
        System.out.println();
        System.out.println();
        System.out.print("Appuyer sur <ENTREE> pour réafficher le menu...");
        Clavier.lireFinLigne();
        enterIsPressed = true;

        return enterIsPressed;

    }

    public static void main(String[] args) {

        byte choixMenu;


        char typeVehiculeChoisi;
        char grandeurVehiculeChoisi;
        int jourLocation;
        String prenomLocataire;
        String nomLocataire;
        String telephoneLocataire;
        String permisLocataire;
        char modePaiementLocataire;
        char carteCreditLocataire = ' ';
        String numeroCarteLocataire = null;
        char choixAssuranceLocataire;
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


        boolean enterIsPressed = false;
        int nbLouesHP = 0;
        int nbLouesHI = 0;
        int nbLouesHG = 0;
        int nbLouesEP = 0;
        int nbLouesEI = 0;
        int nbLouesEG = 0;


        int nbrDisponibleVehiculeChoisi;

        afficherMessageBievenue();

        do {
            afficherOptionsMenu();
            choixMenu = lireChoixMenu();
            enterIsPressed = false;

            while (enterIsPressed == false) {

                switch (choixMenu) {
                    // Afficher l'inventaire des voitures disponibles
                    case 1:
                        afficherEnteteEntreprise();
                        afficherEnteteInventaire(true);

                        afficherVehiculeDisponible(nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);
                        break;
                    // Louer une voiture selon sa taille, son type, sa disponibilité et valider les modalités de paiement
                    case 2:
                        typeVehiculeChoisi = lireTypeVehicule();
                        grandeurVehiculeChoisi = saisiGrandeurVehicule();
                        nbrDisponibleVehiculeChoisi = obtenirVoituresDisponibles(typeVehiculeChoisi, grandeurVehiculeChoisi, nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);
                        enterIsPressed = verifieVoitureChoisiDisponible(nbrDisponibleVehiculeChoisi);

                        if (enterIsPressed == true) {
                            break;
                        }


                        nbLouesHP = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_PETIT, nbLouesHP);
                        nbLouesHI = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_INTERMEDIAIRE, nbLouesHI);
                        nbLouesHG = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_HYBRIDE, grandeurVehiculeChoisi, VEHICULE_GRAND, nbLouesHG);

                        nbLouesEP = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_PETIT, nbLouesEP);
                        nbLouesEI = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_INTERMEDIAIRE, nbLouesEI);
                        nbLouesEG = incrementerVehiculeLoue(typeVehiculeChoisi, VEHICULE_ELECTRIQUE, grandeurVehiculeChoisi, VEHICULE_GRAND, nbLouesEG);

                        jourLocation = lireNombreJourLocation();
                        prenomLocataire = lirePrenomUtilisateur();
                        nomLocataire = lireNomLocataire();
                        telephoneLocataire = lireTelephone();
                        permisLocataire = lirePermisConduire();
                        modePaiementLocataire = lireModePaiement();

                        if (modePaiementLocataire == CARTE_CREDIT) {
                            carteCreditLocataire = lireCarteCredit();
                            numeroCarteLocataire = saisiNumeroCarteCredit();
                        } else {
                            carteCreditLocataire = 'c';
                        }


                        choixAssuranceLocataire = lireChoixAssurance();
                        prixLocationParJour = obtenirPrixLocation(typeVehiculeChoisi, grandeurVehiculeChoisi);
                        prixAssuranceParJour = obtenirPrixAssurance(typeVehiculeChoisi, grandeurVehiculeChoisi, choixAssuranceLocataire);
                        rabaisLocation = obtenirRabais(prixLocationParJour, typeVehiculeChoisi, grandeurVehiculeChoisi, jourLocation);
                        montantLocation = calculerMontantLocation(jourLocation, prixLocationParJour, rabaisLocation);
                        montantAssurance = calculerMontantAssurance(jourLocation, prixAssuranceParJour);
                        sousTotalLocation = calculerSousTotal(montantLocation, montantAssurance);
                        montantTPSLocation = calculerMontantTPS(sousTotalLocation);
                        montantTVQLocation = calculerMontantTVQ(sousTotalLocation);
                        montantTotalLocation = calculerMontantTotal(sousTotalLocation, montantTPSLocation, montantTVQLocation);
                        NumeroFacture = obtenirNumeroFacture(NumeroFacture);
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
                        break;
                    case 3:
                        afficherEnteteEntreprise();
                        afficherEnteteInventaire(false);
                        afficherVehiculeLoues(nbLouesHP, nbLouesHI, nbLouesHG, nbLouesEP, nbLouesEI, nbLouesEG);
                        break;
                    // Quitter le programme
                    case 4:
                        System.out.println("\n\nMerci et à la prochaine !");
                }

                enterIsPressed = retourMenu();
                if (enterIsPressed == true) {
                    break;
                }
            }
        } while (choixMenu != 4);

    }
}

