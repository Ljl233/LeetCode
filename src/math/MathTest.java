package math;

public class MathTest {
    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
//        int n = countPrimes.countPrimes(10);
        int n = countPrimes.eratosthenes(10);
        countPrimes.isPrimes(5);
        System.out.println("together-->"+n);
    }
}
