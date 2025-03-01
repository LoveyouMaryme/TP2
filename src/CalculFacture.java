public class CalculFacture {
    public static final char VEHICULE_HYBRIDE = 'h';
    public static final char VEHICULE_ELECTRIQUE = 'e';
    public static final char VEHICULE_PETIT = 'p';
    public static final char VEHICULE_INTERMEDIAIRE = 'i';
    public static final char VEHICULE_GRAND = 'g';

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

}




