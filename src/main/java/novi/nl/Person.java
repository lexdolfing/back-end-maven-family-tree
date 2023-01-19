package novi.nl;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String middleName;
    private String lastName;
    private String sex;
    private int age;
    private Person mother;
    private Person father;
    private List<Person> siblings;
    private List<Person> children;
    private List<Pet> pets;




    public Person(String name, String lastName, int age, String sex){
        this();
        this.name=name;
        this.lastName=lastName;
        this.age=age;
        this.sex=sex;

    }

    public Person(String name, String middleName, String lastName, int age, String sex){
        this();
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;

    }

    private Person(){
        children = new ArrayList<>();
        siblings = new ArrayList<>();
        pets = new ArrayList<>();
    }

    public void addParents(Person mother, Person father){
        this.mother=mother;
        this.father=father;
    }

    public void addChild(Person child){
        this.children.add(child);
    }

    public void addSibling(Person sibling){
        this.siblings.add(sibling);
    }

    public List<Person> getGrandChildren(){
        List<Person> grandchildren = new ArrayList<Person>();
        for (Person child : getChildren()){
            grandchildren.addAll(child.getChildren());
        }

        return grandchildren;
    }

    public void addPet(Pet pet){
        pets.add(pet);
    }

    public List<Pet> getPetsOfGrandChildren(){
        List<Pet> petsOfGrandChildren= new ArrayList<Pet>();
       for (Person grandChild: getGrandChildren()){
           petsOfGrandChildren.addAll(grandChild.getPets());
       }
        return petsOfGrandChildren;
    }

    public List<Person> getNieces(){
        List<Person> nieces = new ArrayList<>();
        for (Person sibling: getSiblings()){
            for (Person child: sibling.getChildren()){
                if (child.getSex() == "vrouw"){
                    nieces.add(child);
                }
            }
        }
        return nieces;
    }


    public String getName(){
    return name;
    }

    public String getMiddleName(){
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getSiblings() {
        return siblings;
    }

    public List<Person> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setSiblings(List<Person> siblings) {
        this.siblings = siblings;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
