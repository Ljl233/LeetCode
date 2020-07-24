package animal;

public class CatTest {
    public static void main(String[] args){
        Cat cat=new Cat("dudu");
        System.out.println(cat.name);
        cat.name="dongdong";
        System.out.println(cat.name);

        cat.run("xixi");
    }
}
