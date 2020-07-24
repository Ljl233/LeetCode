package interfaceTest;

public class WorkFactory {
    public static Work getWork(int flag){
        Work work;
        if (flag == 1) {
            work = new Muxi();
        } else {
            work = new StudentUnion();
        }
        return work;
    }
}
