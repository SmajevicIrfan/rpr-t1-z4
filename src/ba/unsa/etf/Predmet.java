package ba.unsa.etf;

public class Predmet {
    private String nazivPredmeta;
    private String sifraPredmeta;
    final private int maxBrojStudenata;
    private int brojStudenata;
    private Student[] studenti;

    public Predmet(String nazivPredmeta, String sifraPredmeta, int maxBrojStudenata) {
        if (maxBrojStudenata <= 0)
            throw new NegativeArraySizeException("Maksimalan broj studenata mora biti pozitivan");

        this.nazivPredmeta = nazivPredmeta;
        this.sifraPredmeta = sifraPredmeta;
        this.maxBrojStudenata = maxBrojStudenata;

        this.studenti = new Student[this.maxBrojStudenata];
        this.brojStudenata = 0;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setSifraPredmeta(String sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public String getNazivPredmeta() {
        return this.nazivPredmeta;
    }

    public String getSifraPredmeta() {
        return this.sifraPredmeta;
    }

    public int getMaxBrojStudenata() {
        return this.maxBrojStudenata;
    }

    public int getBrojStudenata() {
        return this.brojStudenata;
    }

    public void upisi(Student student) {
        if (brojStudenata >= maxBrojStudenata)
            throw new IndexOutOfBoundsException("Broj upisanih studenata dostigao maksimum");

        for (int i = 0;i < brojStudenata; i++)
            if (this.studenti[i].equals(student))
                throw new IllegalArgumentException("Student je vec upisan na predmet");

        this.studenti[brojStudenata] = student.clone();
        brojStudenata++;
    }

    public void ispisi(Student student) {
        for (int i = 0; i < brojStudenata; i++) {
            if (this.studenti[i].equals(student)) {
                this.studenti[i] = studenti[brojStudenata - 1];
                this.studenti[brojStudenata - 1] = null;
                this.brojStudenata--;

                return;
            }
        }

        throw new IllegalArgumentException("Student nije upisan na predmet");
    }

    @Override
    public String toString() {
        String stringified = "";
        for (int i = 0; i < brojStudenata; i++)
            stringified += (i != 0 ? "\n" : "") + (i + 1) + ". " + this.studenti[i];

        return stringified;
    }

    public boolean equals(Predmet predmet) {
        return this.sifraPredmeta.equals(predmet.sifraPredmeta);
    }
}
