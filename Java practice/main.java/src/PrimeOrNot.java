import java.util.ArrayList;

public class PrimeOrNot {

    public void check(int n){
        if(isPrime(n)){
            System.out.println("Prime");
        }else System.out.println("Not Prime");
    }
    public boolean isPrime(int n){
        if (n<=1) return false;
        for (int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }

    public ArrayList getAllPrime(int n){
        ArrayList<Integer> primeArr=new ArrayList<>();
        for (int i=0;i<=n;i++){
            if (isPrime(i)){
                primeArr.add(i);
            }
        }
        return primeArr;
    }

    public ArrayList getAllEvenPrime(int n){
        ArrayList<Integer> primeArr=new ArrayList<>();
        for (int i=0;i<=n;i++){
            if (isPrime(i)){
                if(i%2==0){
                    primeArr.add(i);
                }

            }
        }
        return primeArr;
    }

    public ArrayList getAllOddPrime(int n){
        ArrayList<Integer> primeArr=new ArrayList<>();
        for (int i=0;i<=n;i++){
            if (isPrime(i)){
                if(i%2!=0){
                    primeArr.add(i);
                }

            }
        }
        return primeArr;
    }
}
