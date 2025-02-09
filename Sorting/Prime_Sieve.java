public class Prime_Sieve {
    public static void main(String[] args) {
        int n = 100;
        System.out.println("Number of primes till " + n + ": " + PrimeSieve(n));
    }

    public static int PrimeSieve(int n) {
        if(n <= 2) {
            return n == 2 ? 1 : 0;
        }
        
        boolean[] isPrime = new boolean[n + 1];
        for(int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        
        isPrime[0] = isPrime[1] = false;
        
        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        int count = 0;
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) {
                count++;
            }
        }
        return count;
    }
}