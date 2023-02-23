import java.util.Scanner;

public class Criba {

    private static boolean[] esPrimo;
    private static int primos[];

    public static int[] generarPrimos(int max) {
        if (max >= 2) {
            iniciarArray(max);
            realizarCriba();
            rellenarPrimos();
            return primos;
        } else {
            return new int[0];
        }
    }


    private static void iniciarArray(int max) {

        esPrimo = new boolean[max+1] ;
        int i;
        for (i = 0; i < esPrimo.length; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;
    }


    private static void realizarCriba() {
        int i, j;
        for (i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                for (j = 2 * i; j < esPrimo.length; j += i)
                    esPrimo[j] = false;
            }
        }
    }


    private static void rellenarPrimos() {
        int j;
        int i;
        primos = new int[contarPrimos()];
        for (i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }

    private static int contarPrimos() {
        int i;
        int cuenta = 0;
        for (i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }
}


