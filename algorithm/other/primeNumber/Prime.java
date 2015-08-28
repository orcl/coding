public class Prime {
  
  //trivial cases
  //check whether an int is prime or not.
  boolean isPrime(int n) {
    for (int i = 2; i < n; i++) {
      if (n%i == 0) {
        return false;
      }
    }
    return true;
  }

  //a little bit better one
  //consider that i 2 divides some integer n, then (n/2) divides n as well. this tells us we don't have to try out all integers from 2 to n.
  boolean isPrime(int n) {
    for (int i = 2; 2*i < n; i++) {
      if (n%i == 0) {
        return false;
      }
    }
    return true;
  }


  //with some more efficient coding, we notice that you really only have to go up to the square root of n, because if you list out all the factors of a number, the square root will always be in the middle (if it happends to not be an integer, we're still ok, we just might over-approximate, but our code will still work.)

  //finally, we know 2 is the "oddest" prime -- it happens to be the only even prime number, because of this, we need only check 2 separately, then traverse odd numbers up to the square root of n. 
  //in the end our code will resemble this.

  //checks whether an int is prime or not
  boolean isPrime(int n) {
    //check if n is a multiple of 2
    if (n%2 == 0) return false;
    //if not, then just check the odds
    for (int i = 3; i * i < n; i+=2) {
      if (n%i == 0) {
        return false;
      }
    }
    return true;
  }


  //repetitions
  //let's say you write a program where you're asked to check whether many numbers are prime; not just once. Even though our program above is highly optimized for that algorithm, there exists another way specifically suited for this situation: the prime Sieve.
  //
  //here's the basic idea:
  //1. Assume every integer greater than or equal to 2 is prime.
  //2. start at the beginning of the list, if the number is prime, cross out every multiple o that number off the list,
  //they are not prime.
  //3. go to the next number, if it is crossed out, skip it, -- it is not prime, if it not crossed out, it must be prime, cross out it's multiples.
  //4. repeat.
  //
  //
  //in code, you might want to keep track of this list as an array, meaning you'll go through n numbers to set up this "sieve", but you'll make up for it when repeatedly calling the function, since it will return an instantaneous value whether a number is prime or not. Here's what it will look like. of course, you can edit this yourself to suit your needs.

  import java.util.Arrays;
  //global array just keep track of it in this example,
  //but you can easily do this within another function
  //
  //will contain true or false values for the first 10,000 integers.
  boolean[] primes = new boolean[10000];
  //set up the primesieve
  public void fillSieve() {
    Arrays.fill(primes, true);      //assume all integers are prime.
    primes[0] = primes[1] = false;  //we know 0 and 1 are not prime.
    for (int i = 2; i< primes.length; i++) {
      //if the number is prime,
      //then go through all its multiples and make their values false.
      if (primes[i]) {
        for (int j = 2; i*j < primes.length; j++) {
          primes[i*j] = false;
        }
      }
    }
  }

  public boolean isPrime(int n) {
    return primes[n]; //simple,huh
  }





}//end class prime



