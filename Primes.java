public class Primes {
    public static void main(String[] args) {
        int arrLength = Integer.parseInt(args[0]) + 1;
        boolean[] isPrime = new boolean[arrLength];
        for (int i = 2; i < arrLength; i++) {
            isPrime[i] = true;
        }
        int currentMultiple = 2;
        int currentIndex = 3;
        while (currentMultiple != (arrLength - 1)) {
            while (currentIndex != (arrLength - 1)) {
                if (currentIndex % currentMultiple == 0) {
                    isPrime[currentIndex] = false;
                }
                currentIndex++;
            } 
            while (isPrime[currentMultiple] != true) currentMultiple++;
        }
        System.out.println( "Prime numbers up to " + args[0] + ":");
        int count = 0;
        for (int i = 0; i < isPrime.length; i++) {
            if (isPrime[i] == true) {
                System.out.println(i);
                count++;
            }
        }
        System.out.print("There are " + count + " primes between 2 and " + args[0]);
        int percent = (int) (count / 100.0);
        System.out.print(" (" + percent + " are primes)");
    }
}