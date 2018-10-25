package ba.unsa.etf;

public class Student {
    private String ime, prezime;
    private int brojIndexa;

    public Student() { }
    public Student(String ime, String prezime, int brojIndexa) {
        this.ime = ime;
        this.prezime = prezime;
        this.brojIndexa = brojIndexa;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public void setBrojIndexa(int brojIndexa) {
        this.brojIndexa = brojIndexa;
    }

    public String getIme() {
        return this.ime;
    }

    public String getPrezime() {
        return this.prezime;
    }

    public int getBrojIndexa() {
        return  this.brojIndexa;
    }

    @Override
    public Student clone() {
        return new Student(this.ime, this.prezime, this.brojIndexa);
    }

    @Override
    public String toString() {
        return this.prezime + " " + this.ime + " (" + this.brojIndexa + ")";
    }

    public boolean equals(Student student) {
        return this.prezime.equals(student.prezime) &&
                this.ime.equals(student.ime) &&
                this.brojIndexa == student.brojIndexa;
    }
}
