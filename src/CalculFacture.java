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

    public static int voituresDisponibles(char type, char grandeur, int nbLouesHP, int nbLouesHI, int nbLouesHG, int nbLouesEP, int nbLouesEI, int nbLouesEG) {


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

    public static float prixLocationTypeGrandeur(char type, char grandeur) {
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
}






