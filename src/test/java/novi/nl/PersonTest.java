package novi.nl;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void getNameReturnsName(){
        Person hansje = new Person("Hansje", "Targaryen", 18, "non-binair");
        //act
        String naamhasje = hansje.getName();

        assertEquals("Hansje",naamhasje);

    }

    @Test
    public void addChildAddsChildToChildrensList(){
        //assert
        Person hansje = new Person("Hansje", "Targaryen", 38, "non-binair");
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "unicorn");

        //act
        hansje.addChild(klaasje);
        List<Person> hansjesChildren = hansje.getChildren();

        assertEquals(hansjesChildren, hansje.getChildren());
    }

    @Test
    public void addParentsAddsMotherAndFatherToPerson(){

        Person jelmer = new Person("Jelmer","Vierstra", 48, "man");
        Person jelmersMother = new Person ("Ans", "Ansdottir", 88, "vrouw");
        Person jelmersFather = new Person("Darth", "Vader", 68, "emperor");
        //act

        List<Person> expected = new ArrayList<Person>();
        expected.add(jelmersMother);
        expected.add(jelmersFather);


        jelmer.addParents(jelmersMother,jelmersFather);

        List<Person> actual = new ArrayList<Person>();
        actual.add(jelmer.getMother());
        actual.add(jelmer.getFather());

        //assert

        assertEquals(expected, actual);

    }

    @Test
    public void addSiblingsAddsPersonBAsSiblingToPeronA() {
        Person jelmer = new Person("Jelmer","Vierstra", 48, "man");
        Person jelmersSister = new Person ("Ans", "Ansdottir", 88, "vrouw");

        List<Person> expected = new ArrayList<Person>();
        expected.add(jelmersSister);
        jelmer.addSibling(jelmersSister);
        List<Person> actual = new ArrayList<Person>();
        actual.addAll(jelmer.getSiblings());
        assertEquals(expected,actual);
    }

    @Test
    public void addPetAddsAnObjectPetToListOfPetsFromPeron(){
        Person jelmer = new Person("Jelmer","Vierstra", 48, "man");
        Pet kat = new Pet("Miyuki", 3,"(Felis silvestris catus");

        jelmer.addPet(kat);
        List<Pet> actual = new ArrayList<Pet>();
        actual.addAll(jelmer.getPets());

        List<Pet> expected= new ArrayList<Pet>();
        expected.add(kat);

        assertEquals(expected, actual);

    }


    @Test
    void getPetsOfGrandChildrenReturnsPetListOfChildOfChildOfPersonA() {
        Person hansje = new Person("Hansje", "Targaryen", 38, "non-binair");
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "unicorn");
        Person antje = new Person("Antje", "Targaryen", 11, "female");

        hansje.addChild(klaasje);
        klaasje.addChild(antje);

        List<Pet> expected = new ArrayList<>();
        Pet miyuki = new Pet("Miyuki", 3, "(Felis silvestris catus");
        Pet lester = new Pet("Lester", 18, "(Felis silvestris catus");

        antje.addPet(miyuki);
        antje.addPet(lester);

        expected.add(miyuki);
        expected.add(lester);

        List<Pet> actual = new ArrayList<>();

        actual = antje.getPets();

        assertEquals(expected, actual);
    }

    @Test
    void getNiecesReturnsPersonListOfChildrenOfSiblingsOfPersonA(){
        //Person A
        Person jan = new Person("Jan", "de Bakker", 55, "man");
        //Siblings
        Person hansje = new Person("Hansje", "Targaryen", 38, "vrouw");
        Person henk = new Person("Henk", "Targaryen", 38, "man");

        //Children Hansje
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "vrouw");
        Person antje = new Person("Antje", "Targaryen", 11, "vrouw");

        //Children Henk
        Person mustafa = new Person("Mustafa", "Targaryen", 18, "man");
        Person sasha = new Person("Sasha", "Targaryen", 11, "vrouw");

        jan.addSibling(hansje);
        jan.addSibling(henk);

        hansje.addChild(klaasje);
        hansje.addChild(antje);

        henk.addChild(mustafa);
        henk.addChild(sasha);

        List<Person> expected = new ArrayList<Person>();
        expected.add(klaasje);
        expected.add(antje);
        expected.add(sasha);

        List<Person> actual = jan.getNieces();

        assertEquals(expected, actual);
    }


    @Test
    void getGrandChildrenReturnsPersonListOfCildrenOfChildren(){
        Person jan = new Person("Jan", "de Bakker", 55, "man");
        //Children
        Person hansje = new Person("Hansje", "Targaryen", 38, "vrouw");
        Person henk = new Person("Henk", "Targaryen", 38, "man");

        //Children Hansje
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "vrouw");
        Person antje = new Person("Antje", "Targaryen", 11, "vrouw");

        //Children Henk
        Person mustafa = new Person("Mustafa", "Targaryen", 18, "man");
        Person sasha = new Person("Sasha", "Targaryen", 11, "vrouw");

        jan.addChild(hansje);
        jan.addChild(henk);

        hansje.addChild(klaasje);
        hansje.addChild(antje);

        henk.addChild(mustafa);
        henk.addChild(sasha);

        List<Person> expected = new ArrayList<Person>();
        expected.add(klaasje);
        expected.add(antje);
        expected.add(mustafa);
        expected.add(sasha);

        assertEquals(expected, jan.getGrandChildren());

    }

    @Test
    void getPetsOfGrandChildrenReturnsPetListOfChildrenOfChildrenOfPersonA(){
        //Person A
        Person jan = new Person("Jan", "de Bakker", 55, "man");
        //Children
        Person hansje = new Person("Hansje", "Targaryen", 38, "vrouw");
        Person henk = new Person("Henk", "Targaryen", 38, "man");

        //Children Hansje
        Person klaasje = new Person("Klaasje", "Targaryen", 18, "vrouw");
        Person antje = new Person("Antje", "Targaryen", 11, "vrouw");

        //Children Henk
        Person mustafa = new Person("Mustafa", "Targaryen", 18, "man");
        Person sasha = new Person("Sasha", "Targaryen", 11, "vrouw");

        //Pets sasha
        Pet miyuki = new Pet("Miyuki", 3, "Felis silvestris catus");
        Pet lester = new Pet("Lester", 18, "Felis silvestris catus");

        //Pets antje
        Pet max = new Pet("Miyuki", 3, "Hond");
        Pet wallie = new Pet("Lester", 18, "Hond");



        jan.addChild(hansje);
        jan.addChild(henk);

        hansje.addChild(klaasje);
        hansje.addChild(antje);

        henk.addChild(mustafa);
        henk.addChild(sasha);

        sasha.addPet(miyuki);
        sasha.addPet(lester);

        antje.addPet(max);
        antje.addPet(wallie);

        List<Pet> expected = new ArrayList<Pet>();

        expected.add(max);
        expected.add(wallie);
        expected.add(miyuki);
        expected.add(lester);

        assertEquals(expected,jan.getPetsOfGrandChildren());
    }
}
