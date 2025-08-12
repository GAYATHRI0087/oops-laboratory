//gayathri.p
//2117240070087
program title:fibonacci sequence using recursion
  TEST CASE 1:
public class Fibonacci {

    
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 5;  

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
OUTPUT:
0 1 1 2 3

TEST CASE 2:
package exercise;

public class Fibonacci {

    
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 7;  

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
OUTPUT:
0 1 1 2 3 5 8

TEST CASE 3 :
package exercise;

public class Fibonacci {

    
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 1;  

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}

OUTPUT:
0


TEST CASE 4:
package exercise;

public class Fibonacci {

    
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 0;  

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}

OUTPUT:
(no output)

TEST CASE 5:
package exercise;

public class Fibonacci {

    
    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 10;  

        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
OUTPUT:
0 1 1 2 3 5 8 13 21 34

