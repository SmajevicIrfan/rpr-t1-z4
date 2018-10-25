package ba.unsa.etf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PredmetTest {

    @Test
    void setNazivPredmeta() {
        Predmet predmet = new Predmet("Test1", "RPR", 60);
        predmet.setNazivPredmeta("Razvoj Programskih Rjesenja");
        assertEquals("Razvoj Programskih Rjesenja", predmet.getNazivPredmeta());
    }

    @Test
    void setSifraPredmeta() {
        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "Test2", 60);
        predmet.setSifraPredmeta("RPR");
        assertEquals("RPR", predmet.getSifraPredmeta());
    }

    @Test
    void getNazivPredmeta() {
        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 60);
        assertEquals("Razvoj Programskih Rjesenja", predmet.getNazivPredmeta());
    }

    @Test
    void getSifraPredmeta() {
        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 60);
        predmet.setSifraPredmeta("RPR");
        assertEquals("RPR", predmet.getSifraPredmeta());
    }

    @Test
    void getMaxBrojStudenata() {
        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 60);
        assertEquals(60, predmet.getMaxBrojStudenata());
    }

    @Test
    void getBrojStudenata() {
        Student s1 = new Student("Irfan", "Smajevic", 18205);
        Student s2 = new Student("Lamija", "Vrnjak", 18265);

        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 60);
        predmet.upisi(s1);
        predmet.upisi(s2);

        assertEquals(2, predmet.getBrojStudenata());
    }

    @Test
    void upisi() {
        Student s1 = new Student("Irfan", "Smajevic", 18205);
        Student s2 = new Student("Lamija", "Vrnjak", 18265);
        Student s3 = new Student("Selma", "Smajic", 18189);
        Student s4 = new Student("Neko", "Nekic", 18123);

        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 3);
        predmet.upisi(s1);
        predmet.upisi(s2);

        assertAll( "Upis",
                () -> assertThrows(IllegalArgumentException.class, () -> { predmet.upisi(s1); }),
                () -> assertThrows(IndexOutOfBoundsException.class, () -> { predmet.upisi(s3); predmet.upisi(s4); })
        );
    }

    @Test
    void ispisi() {
        Student s1 = new Student("Irfan", "Smajevic", 18205);
        Student s2 = new Student("Lamija", "Vrnjak", 18265);
        Student s3 = new Student("Selma", "Smajic", 18189);
        Student s4 = new Student("Neko", "Nekic", 18123);

        Predmet predmet = new Predmet("Razvoj Programskih Rjesenja", "RPR", 5);
        predmet.upisi(s1);
        predmet.upisi(s2);
        predmet.upisi(s3);
        predmet.upisi(s4);

        assertEquals(4, predmet.getBrojStudenata());

        predmet.ispisi(s3);

        assertEquals(3, predmet.getBrojStudenata());
    }
}