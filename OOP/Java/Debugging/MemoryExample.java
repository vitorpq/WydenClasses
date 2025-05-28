public class MemoryExample {

    public static void main(String[] args) {
        int primitiveVar = 10;
        System.out.println("Initial primitiveVar: " + primitiveVar);
        modifyPrimitive(primitiveVar);
        System.out.println("After modifyPrimitive: " + primitiveVar);

        Person person = new Person("Alice", 25);
        System.out.println("Initial person: " + person);
        modifyObject(person);
        System.out.println("After modifyObject: " + person);
    }

    public static void modifyPrimitive(int var) {
        var = 20;
        System.out.println("Inside modifyPrimitive: " + var);
    }

    public static void modifyObject(Person person) {
        person.setName("Bob");
        person.setAge(30);
        System.out.println("Inside modifyObject: " + person);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}