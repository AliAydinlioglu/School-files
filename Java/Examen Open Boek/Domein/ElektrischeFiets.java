package Domein;

public class ElektrischeFiets {
    private int maxSnelheid;
    private int vermogen;

    public ElektrischeFiets() {
        setVermogen(250);
        setMaxSnelheid(25);
    }

    public ElektrischeFiets(int maxSnelheid, int vermogen) {
        setVermogen(vermogen);
        setMaxSnelheid(maxSnelheid);
    }

    public int getMaxSnelheid() {
        return maxSnelheid;
    }

    public boolean isSpeedpedelec() {
        if (this.vermogen > 1000 || this.maxSnelheid > 25) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isGemotoriseerdeFiets() {
        if (vermogen >= 251 && vermogen <= 1000 && maxSnelheid <= 25) {
            return true;
        } else {
            return false;
        }
    }

    private void setMaxSnelheid(int maxSnelheid) {
        if (maxSnelheid >= 15 && maxSnelheid <= 45) {
            this.maxSnelheid = maxSnelheid;
        } else {
            this.maxSnelheid = 25;
        }
    }

    private void setVermogen(int vermogen) {
        if (vermogen >= 100 && vermogen <= 4000) {
            this.vermogen = vermogen;
        } else {
            this.vermogen = 250;
        }
    }
@Override
    public String toString() {
        if (isSpeedpedelec()) {
            return "Speedpedelec";
        } else if (isGemotoriseerdeFiets()) {
            return "Gemotoriseerde fiets";
        } else {
            return "Elektrische fiets met hulpmotor";
        }
    }
}
