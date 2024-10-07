package domein.testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domein.Bloem;
import domein.utils.Kleur;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

public class BloemTest {

    @ParameterizedTest
    @ValueSource(strings = { "abc de", "aa", "AZ", "AZZ" })
    void maakWitBloem_GeldigeNaamEnGeldigeKleur_MaaktWitBloem(String naam) {
        assertEquals(naam, new Bloem(naam, Kleur.WIT).getNaam());
    }
    @ParameterizedTest
    @ValueSource(strings = { "abc de", "aa", "AZ", "AZZ" })
    void maakGeelBloem_GeldigeNaamEnGeldigeKleur_MaaktGeelBloem(String naam) {
        assertEquals(naam, new Bloem(naam, Kleur.GEEL).getNaam());
    } @ParameterizedTest
    @ValueSource(strings = { "abc de", "aa", "AZ", "AZZ" })
    void maakRoodBloem_GeldigeNaamGeenGeldigeKleur_MaaktRoodBloem(String naam) {
        assertEquals(naam, new Bloem(naam, Kleur.ROOD).getNaam());
    }
    @ParameterizedTest
    @ValueSource(strings = { "a", "A", "  ", "      " })
    void maakWitBloem_GeenGeldigeNaamWelKleur_MaaktGeenBloem(String naam) {
        assertThrows(IllegalArgumentException.class, () -> new Bloem(naam, Kleur.WIT));
    }
    @ParameterizedTest
    @ValueSource(strings = { "a", "A", "  ", "      " })
    void maakGeelBloem_GeenGeldigeNaamWelKleur_MaaktGeenBloem(String naam) {
        assertThrows(IllegalArgumentException.class, () -> new Bloem(naam, Kleur.GEEL));
    }
    @ParameterizedTest
    @ValueSource(strings = { "a", "A", "  ", "      " })
    void maakRoodBloem_GeenGeldigeNaamEnKleur_MaaktGeenBloem(String naam) {
        assertThrows(IllegalArgumentException.class, () -> new Bloem(naam, Kleur.ROOD));
    } @ParameterizedTest
    @ValueSource(strings = { "a", "A", "  ", "      " })
    void maakKleurloosBloem_GeenGeldigeNaamEnGeenKleur_MaaktGeenBloem(String naam) {
        assertThrows(IllegalArgumentException.class, () -> new Bloem(naam, null));
    }



}
