package novi.nl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {

    @Test
    void getNameGetsNameOfPet() {
        Pet kat = new Pet("Miyuki", 3,"(Felis silvestris catus");
        String expected = "Miyuki";
        String actual = kat.getName();
        assertEquals(expected, actual);

    }

    @Test
    void addOwner() {
        Pet miyuki = new Pet("Miyuki", 3, "(Felis silvestris catus");
        Person bertine = new Person("Bertine", "Pape", 37, "vrouw");

        miyuki.addOwner(bertine);

        Person actual = miyuki.getOwner();

        assertEquals(bertine, actual);
    }

}