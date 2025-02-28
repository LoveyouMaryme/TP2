public class ValideSaisie {

    public static final int maxCharTelephone = 14;
    public static final char parantheseOuvrante = '(';
    public static final char parantheseFermante = ')';
    public static final char traitUnion = '-';
    public static final byte posParantheseOuvrante = 0;
    public static final byte posParantheseFermante = 4;
    public static final byte posTraitUnion = 9;

    public static void prenomLocataire() {
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
    }

    public static void nomLocataire() {
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
    }

    public static void telephone() {
        String telephone;
        boolean valideTelephone = false;

        do {
            System.out.println("Entrez le numéro de téléphone du locataire (Exemple : (514) 784-6589):");
            telephone = Clavier.lireString().trim();


            if (telephone.length() == maxCharTelephone
                    && telephone.charAt(posParantheseOuvrante) == parantheseOuvrante
                    && telephone.charAt(posParantheseFermante) == parantheseFermante
                    && telephone.charAt(posTraitUnion) == traitUnion) {

                valideTelephone = true;
            }

            System.out.println("Le numéro de téléphone est invalide!");



        } while (!valideTelephone);


    }
}

