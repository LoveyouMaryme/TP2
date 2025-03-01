import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CalculFacture {
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
    public static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");


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


}






