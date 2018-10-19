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
}
