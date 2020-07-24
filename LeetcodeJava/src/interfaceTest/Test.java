package interfaceTest;

public class Test {

    public static void main(String[] args) {
        int flag = 1;
        Work work = WorkFactory.getWork(flag);

        work.study();
        work.teach();
    }

}
