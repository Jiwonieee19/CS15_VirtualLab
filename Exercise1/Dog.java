package Exercise1;

public class Dog {
    private String n;
    private int a;

    public Dog(String name, int age) {
        this.n = name;
        this.a = age;
    }

    public void bark() {
        System.out.println("Woof!");
    }

    public void celebrateBirthday() {
        this.a++;
        System.out.printf("HAppy Birthday! %s is now %d years old.", this.n, this.a);
        System.out.println();
    }

    public String getInfo() {
        String res = "Name: " + this.n + ", Age: " + this.a;
        return res;
    }

    public static void main(String[] args) {
        Dog d = new Dog("Yosh", 5);
        d.bark();
        d.celebrateBirthday();
        System.out.println(d.getInfo());
    }
}