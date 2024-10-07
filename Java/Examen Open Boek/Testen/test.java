package Testen;

import Domein.ElektrischeFiets;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class test {
    private ElektrischeFiets ef;

    @BeforeEach
    void setup() {
        ef = new ElektrischeFiets();
    }

    @Test
    public void maakElektrischeFiets_geenGegevens_maaktFietsMetDefaultwaarden() {
        Assertions.assertEquals(ef.getMaxSnelheid(), 25);
    }

    @ParameterizedTest
    @ValueSource(ints = { 15, 45, 26 })
    void maakElektrischeFiets_normaleMaxSnelheid_maaktFietsMetGevraagdeLaxSnelheid(int maxSnelheid) {
        ef = new ElektrischeFiets(maxSnelheid, 1000);
        Assertions.assertEquals(ef.getMaxSnelheid(), maxSnelheid);
    }

    @ParameterizedTest
    @ValueSource(ints = { 1001, 4000 })
    void isSpeedpedelec_fietsMetVermogenVanEenSpeedpedelec_retourneertTrue(int vermogen) {
        ef = new ElektrischeFiets(20, vermogen);
        Assertions.assertTrue(ef.isSpeedpedelec());
    }

    @ParameterizedTest
    @ValueSource(ints = { 26, 40 })
    void isSpeedpedelec_fietsMetMaxSnelheidVanEenSpeedpedelec_retourneertTrue(int maxSnelheid) {
        ef = new ElektrischeFiets(maxSnelheid, 200);
        Assertions.assertTrue(ef.isSpeedpedelec());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1000, 500 })
    void isSpeedpedelec_fietsMetVermogenEnMaxSnelheidTeLaagVoorSpeedpedelec_retourneertFalse(int vermogen) {
        ef = new ElektrischeFiets(20, vermogen);
        Assertions.assertFalse(ef.isSpeedpedelec());
    }

    @ParameterizedTest
    @ValueSource(ints = { 25, 20 })
    void isSpeedpedelec_fietsMetMaxSnelheidEnVermogenTeLaagVoorSpeedpedelec_retourneertFalse(int maxSnelheid) {
        ef = new ElektrischeFiets(maxSnelheid, 200);
        Assertions.assertFalse(ef.isSpeedpedelec());
    }

    @Test
    public void isSpeedpedelec_defaultFiets_retourneertFalse() {
        Assertions.assertFalse(ef.isSpeedpedelec());
    }

    @ParameterizedTest
    @ValueSource(ints = { 251, 1000, 500 })
    void isGemotoriseerdeFiets_fietsMetVermogenEnMaxSnelheidVanEenGemotoriseerdeFiets_retourneertTrue(int vermogen) {
        ef = new ElektrischeFiets(20, vermogen);
        Assertions.assertTrue(ef.isGemotoriseerdeFiets());
    }

    @ParameterizedTest
    @ValueSource(ints = { 15, 25 })
    void isGemotoriseerdeFiets_fietsMetMaxSnelheidEnVermogenVanEenGemotoriseerdeFiets_retourneertTrue(int maxSnelheid) {
        ef = new ElektrischeFiets(maxSnelheid, 500);
        Assertions.assertTrue(ef.isGemotoriseerdeFiets());
    }

    @ParameterizedTest
    @ValueSource(ints = { 1001, 3500 })
    void isGemotoriseerdeFiets_fietsMetVermogenHogerDanToegestaanVoorGemotoriseerdeFiets_retourneertFalse(
            int vermogen) {
        ef = new ElektrischeFiets(20, vermogen);
        Assertions.assertFalse(ef.isGemotoriseerdeFiets());
    }

    @ParameterizedTest
    @ValueSource(ints = { 26, 35 })
    void isGemotoriseerdeFiets_fietsMetMaxSnelheidHogerDanToegestaanVoorGemotoriseerdeFiets_retourneertFalse(
            int maxSnelheid) {
        ef = new ElektrischeFiets(maxSnelheid, 800);
        Assertions.assertFalse(ef.isGemotoriseerdeFiets());
    }

    @ParameterizedTest
    @ValueSource(ints = { 250, 200 })
    void isGemotoriseerdeFiets_fietsMetVermogenTeLaagVoorGemotoriseerdeFiets_retourneertFalse(int vermogen) {
        ef = new ElektrischeFiets(20, vermogen);
        Assertions.assertFalse(ef.isGemotoriseerdeFiets());
    }

    @Test
    public void isGemotoriseerdeFiets_defaultFiets_retourneertFalse() {
        Assertions.assertFalse(ef.isGemotoriseerdeFiets());
    }

}
