package ba.unsa.etf;

import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);

    private static Student[] studenti = new Student[100];
    private static Predmet[] predmeti = new Predmet[20];

    private static int brojStudenata = 0;
    private static int brojPredmeta = 0;

    private static Predmet kreirajPredmet(String nazivPredmeta, String sifraPredmeta, int maxBrojStudenata) {
        Predmet noviPredmet;
        try {
            noviPredmet = new Predmet(nazivPredmeta, sifraPredmeta, maxBrojStudenata);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

        for (int i = 0; i < brojPredmeta; i++) {
            if (predmeti[i].equals(noviPredmet)) {
                System.out.println("Predmet vec postoji, ne moze biti dodan");
                return null;
            }
        }

        predmeti[brojPredmeta] = noviPredmet;
        brojPredmeta++;

        return noviPredmet;
    }

    private static Student kreirajStudenta(String ime, String prezime, int brojIndexa) {
        Student noviStudent;
        try {
            noviStudent = new Student(ime, prezime, brojIndexa);
        } catch (Exception e) {
            System.out.print("Nemoguce kreirati novog studenta: ");
            System.out.println(e.getMessage());
            return null;
        }

        for (int i = 0; i < brojPredmeta; i++) {
            if (studenti[i].equals(noviStudent)) {
                System.out.println("Student vec postoji, ne moze biti dodan");
                return null;
            }
        }

        studenti[brojStudenata] = noviStudent;
        brojStudenata++;

        return noviStudent;
    }

    private static Predmet findPredmet(String sifraPredmeta) {
        Predmet predmet = null;
        for (int i = 0; i < brojPredmeta; i++) {
            if (predmeti[i].getSifraPredmeta().equals(sifraPredmeta)) {
                predmet = predmeti[i];
            }
        }

        return predmet;
    }

    private static Student findStudent(int brojIndexa) {
        Student student = null;
        for (int i = 0; i < brojStudenata; i++) {
            if (studenti[i].getBrojIndexa() == brojIndexa) {
                student = studenti[i];
            }
        }

        return student;
    }

    private static Predmet interfaceKreirajPredmet() {
        if (brojPredmeta >= 20) {
            System.out.println("Dostignut limit predmeta koji mogu postojati");
            return null;
        }

        scanner.nextLine();
        System.out.print("Unesite naziv predmeta: ");
        String nazivPredmeta = scanner.nextLine();

        System.out.print("Unesite sifru predmeta (ISKLJUCIVO BEZ RAZMAKA): ");
        String sifraPredmeta = scanner.next();

        System.out.print("Unesite maksimalan broj studenata na predmetu: ");
        int maxBrojStudenata = scanner.nextInt();

        return kreirajPredmet(nazivPredmeta, sifraPredmeta, maxBrojStudenata);
    }

    private static Student interfaceKreirajStudenta() {
        if (brojStudenata >= 100) {
            System.out.println("Dostignut limit studenata koji mogu postojati");
            return null;
        }

        System.out.print("Unesite ime studenta: ");
        String ime = scanner.next();

        System.out.print("Unesite prezime studenta: ");
        String prezime = scanner.next();

        System.out.print("Unesite  broj indeksa studenta: ");
        int brojIndexa = scanner.nextInt();

        return kreirajStudenta(ime, prezime, brojIndexa);
    }

    private static void upisiStudentaNaPredmet() {
        System.out.print("Unesite broj indeksa studenta kojeg zelite upisati: ");
        int brojIndexa = scanner.nextInt();

        Student student = findStudent(brojIndexa);

        if (student == null) {
            System.out.println("Student kojeg zelite upisati ne postoji.");
            System.out.print("Da li ga zelite kreirati (y/N): ");
            if (scanner.next().toUpperCase().equals("Y")) {
                try {
                    student = interfaceKreirajStudenta();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;
                }
            } else {
                return;
            }
        }

        System.out.print("Unesite sifru predmeta na kojeg zelite upisati studenta: ");
        String sifraPredmeta = scanner.next();

        Predmet predmet = findPredmet(sifraPredmeta);

        if (predmet == null) {
            System.out.println("Predmet na kojeg zelite upisati studenta ne postoji.");
            System.out.print("Da li ga zelite kreirati (y/N): ");
            if (scanner.next().toUpperCase().equals("Y")) {
                try {
                    predmet = interfaceKreirajPredmet();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }

        try {
            predmet.upisi(student);
        } catch (Exception e) {
            System.out.print("Nemoguce upisati studenta: ");
            System.out.println(e.getMessage());
        }
    }

    private static void ispisiStudentaSaPredmeta() {
        System.out.print("Unesite broj indeksa studenta kojeg zelite ispisati: ");
        int brojIndexa = scanner.nextInt();

        Student student = findStudent(brojIndexa);

        if (student == null) {
            System.out.println("Student kojeg zelite ispisati ne postoji.");
            return;
        }

        System.out.print("Unesite sifru predmeta sa kojeg zelite ispisati studenta: ");
        String sifraPredmeta = scanner.next();

        Predmet predmet = findPredmet(sifraPredmeta);

        if (predmet == null) {
            System.out.println("Predmet sa kojeg zelite ispisati studenta ne postoji.");
            return;
        }

        try {
            predmet.ispisi(student);
        } catch (Exception e) {
            System.out.print("Nemoguce ispisati studenta: ");
            System.out.println(e.getMessage());
        }
    }

    private static void izbrisiPredmet() {
        System.out.print("Unesite sifru predmeta kojeg zelite obrisati: ");
        String sifraPredmeta = scanner.next();

        Predmet predmet = findPredmet(sifraPredmeta);

        if (predmet == null) {
            System.out.println("Predmet kojeg zelite obrisati ne postoji.");
            return;
        }

        predmet = predmeti[brojPredmeta - 1];
        brojPredmeta--;
    }

    private static void izbrisiStudenta() {
        System.out.println("NAPOMENA: Student ce biti ispisan sa svih predmeta koje slusa!");

        System.out.print("Unesite broj indeksa studenta kojeg zelite obrisati: ");
        int brojIndexa = scanner.nextInt();

        Student student = findStudent(brojIndexa);

        if (student == null) {
            System.out.println("Student kojeg zelite obrisati ne postoji.");
            return;
        }

        for (int i = 0; i < brojPredmeta; i++) {
            predmeti[i].ispisi(student);
        }

        student = studenti[brojStudenata - 1];
        brojStudenata--;
    }

    private static void prikaziSveStudenteNaPredmetu() {
        System.out.print("Unesite sifru predmeta za kojeg zelite spisak studenata: ");
        String sifraPredmeta = scanner.next();

        Predmet predmet = findPredmet(sifraPredmeta);

        if (predmet == null) {
            System.out.println("Predmet za kojeg zelite spisak studenata ne postoji.");
            return;
        }

        System.out.println("Spisak studenata na odabranom predmetu je:");
        System.out.println(predmet);
    }

    private static void prikaziOpcije() {
        System.out.println(" -- Moguce komande -- ");
        System.out.println("1. Kreiraj novi predmet");
        System.out.println("2. Kreiraj novog studenta ");
        System.out.println("3. Upisi studenta na predmet");
        System.out.println("4. Ispisi studenta s predmeta");
        System.out.println("5. Obrisi predmet");
        System.out.println("6. Obrisi studenta");
        System.out.println("7. Prikazi spisak svih upisanih studenata na predmetu");
        System.out.println(" -- Bilo koji drugi broj rezultira prekidu programa -- ");
        System.out.println(" ----------------------------------------------------- ");
    }

    public static void main(String[] args) {
        int cmd;
        do {
            prikaziOpcije();

            System.out.print("Unesite broj zeljene komande: ");
            cmd = scanner.nextInt();

            switch (cmd) {
                case 1:
                    interfaceKreirajPredmet();
                    break;
                case 2:
                    interfaceKreirajStudenta();
                    break;
                case 3:
                    upisiStudentaNaPredmet();
                    break;
                case 4:
                    ispisiStudentaSaPredmeta();
                    break;
                case 5:
                    izbrisiPredmet();
                    break;
                case 6:
                    izbrisiStudenta();
                    break;
                case 7:
                    prikaziSveStudenteNaPredmetu();
                    break;
                default:
                    System.out.println("Prekidam sa radom");
            }
        } while (cmd >= 1 && cmd <= 7);
    }
}
