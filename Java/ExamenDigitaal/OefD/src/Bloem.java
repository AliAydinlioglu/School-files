package domein;

import domein.utils.Kleur;

public class Bloem {

    private static final int AANTAL_LETTERS = 26;
    private final String naam;
    private final Kleur kleur;

    public Bloem(String naam, Kleur kleur) {
        controleerNaam(naam);
        controleerKleur(kleur);
        this.naam = naam;
        this.kleur = kleur;
    }

    private void controleerNaam(String naam) {
        if (naam == null)
            throw new IllegalArgumentException("Je moet een naam invullen!");
        if (naam.length() <= 2)
            throw new IllegalArgumentException("De naam moet minstens 2 tekens bevatten!");
        if (naam.isBlank())
            throw new IllegalArgumentException("De naam mag niet enkel uit spaties bestaan!");
        for (int i = 0; i < AANTAL_LETTERS; i++)
            if (naam.charAt(i) < 'a' && naam.charAt(i) > 'z' || naam.charAt(i) < 'A' && naam.charAt(i) > 'Z')
                throw new IllegalArgumentException("De naam mag enkel uit groote of kleine letters bestaan");
    }

    private void controleerKleur(Kleur kleur) {
        if (kleur == null)
            throw new IllegalArgumentException("Je moet een kleur invullen!");
    }

    public String getNaam() {
        return naam;
    }

    public Kleur getKleur() {
        return kleur;
    }

    public boolean bloeitInLente() {
        if (kleur == Kleur.WIT) {
            return true;
        }if (kleur == Kleur.GEEL) {
            return true;
        }
        return false;

    }


}
