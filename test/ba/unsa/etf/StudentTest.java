package ba.unsa.etf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void equals() {
        Student s1 = new Student("Irfan", "Smajevic", 18205);
        Student s2 = new Student("Irfan", "Smajevic", 18205);
        Student s3 = new Student("Nasiha", "Smajevic", 18205);

        assertAll("Da Li Je Jednako",
                () -> assertTrue(s1.equals(s2)),
                () -> assertTrue(s2.equals(s1)),
                () -> assertFalse(s3.equals(s1))
        );
    }
}