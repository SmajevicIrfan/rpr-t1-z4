package ba.unsa.etf;

public class Predmet {
    private String nazivPredmeta;
    private int sifraPredmeta;
    final private int maxBrojStudenata;
    private int brojStudenata;
    private Student[] studenti;

    public Predmet(String nazivPredmeta, int sifraPredmeta, int maxBrojStudenata) {
        this.nazivPredmeta = nazivPredmeta;
        this.sifraPredmeta = sifraPredmeta;
        this.maxBrojStudenata = maxBrojStudenata;

        this.studenti = new Student[this.maxBrojStudenata];
        this.brojStudenata = 0;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setSifraPredmeta(int sifraPredmeta) {
        this.sifraPredmeta = sifraPredmeta;
    }

    public void upisi(Student student) {
        if (brojStudenata >= maxBrojStudenata)
            throw new IndexOutOfBoundsException("Broj upisanih studenata dostigao maksimum");

        this.studenti[brojStudenata] = student.clone();
        brojStudenata++;
    }

    public void ispisi(Student student) {
        for (int i = 0; i < brojStudenata; i++) {
            if (this.studenti[i].equals(student)) {
                this.studenti[i] = studenti[brojStudenata];
                this.studenti[brojStudenata] = null;
                this.brojStudenata--;

                break;
            }
        }
    }
}
