//gayathri.p
//2117240070087
program title:prime number checker 
  TEST CASE 1:
  public class Prime{
    public static void main(String[] args) {
        int n=2;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
  OUTPUT:
  Prime

  TEST CASE 2:
  public class Prime{
    public static void main(String[] args) {
        int n=15;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
      
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
OUTPUT:
    Not prime
    
  TEST CASE 3:
    public class Prime{
    public static void main(String[] args) {
        int n=17;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }

OUTPUT:
 Prime
 


 TEST CASE 4:
      public class Prime{
    public static void main(String[] args) {
        int n=1;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }

OUTPUT:
  Not prime



  TEST CASE 5:
        public class Prime{
    public static void main(String[] args) {
        int n=0;
        boolean isPrime=true;
        if(n<=1){
            isPrime=false;
        }else{
            for(int i=2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    isPrime=false;
            }
        }
        }
        if(isPrime){
            System.out.println("Prime");
        }else{
            System.out.println("Not prime");
        }
        
    }
OUTPUT:
  Not prime

          
  
