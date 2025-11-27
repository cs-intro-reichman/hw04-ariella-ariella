public class Primes {
    public static void main(String[] args) {
        int arrLength = Integer.parseInt(args[0]) + 1;
        boolean[] isPrime = new boolean[arrLength];
        for (int i = 2; i < arrLength; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i < arrLength; i++) {
            if (isPrime[i]) {
                for (int j = i * 2; j < arrLength; j++) {
                    if (j % i == 0) isPrime[j] = false;
                }
            }
        }

        System.out.println("Prime numbers up to " + args[0] + ":");
        int count = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.println(i);
                count++;
            }
        }
        System.out.print("There are " + count + " primes between 2 and " + args[0]);
        int percent = (int) ((count / Double.parseDouble(args[0])) * 100);
        System.out.print(" (" + percent + "% are primes)");
    }
}