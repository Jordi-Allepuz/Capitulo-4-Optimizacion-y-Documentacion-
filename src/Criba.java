import java.util.Scanner;

/**
 * Clase que realiza una Criba de Erastótenes para generar los numeros primos
 * desde 2 hasta el numero indicado por el usuario.
 * Explicacion: Se forma una tabla con todos los números naturales comprendidos entre 2 y max.
 * Se tachan los números que no son primos de la siguiente manera, Comenzando por el 2, se tachan todos sus múltiplos;
 * comenzando de nuevo,cuando se encuentra un número entero que no ha sido tachado, ese número es declarado primo,
 * y se procede a tachar todos sus múltiplos, así sucesivamente.
 * El proceso termina cuando el cuadrado del siguiente número confirmado como primo es mayor que max.
 *
 * @author Jordi Allepuz
 * @version 2.0.0  Febrero 2023
 */

public class Criba {

    private static boolean[] esPrimo;
    private static int primos[];

    /**
     * @param max parametro que debe introducir el usuario, el metodo calculara los primos hasta ese parametro.
     * @return metodo principal que devuelve un array con los primos si el numero introducio es mayor que 2 y si es
     * menor, devuelve un array vacio.
     */

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


    /**
     * Funcion que inicia un array de booleanos de largo, el numero indicado por el usuario (max). Poniendo todos las
     * posiciones a true excepto el 0 y 1 que serán false, ya que no los tendremos en cuenta.
     * @param max parametro que debe introducir el usuario, el metodo calculara los primos hasta ese parametro.
     */

    public static void iniciarArray(int max) {

        esPrimo = new boolean[max+1] ;
        int i;
        for (i = 0; i < esPrimo.length; i++)
            esPrimo[i] = true;

        esPrimo[0] = esPrimo[1] = false;
    }


    /**
     * Funcion que realiza la Criba de Erastótenes, y cambia a false los numeros que no son primos. Como resultado
     * tendremos el array esPrimos, con las posiciones que son Primos a true y las que no a False.
     */

    public static void realizarCriba() {
        int i, j;
        for (i = 2; i < Math.sqrt(esPrimo.length) + 1; i++) {
            if (esPrimo[i]) {
                for (j = 2 * i; j < esPrimo.length; j += i)
                    esPrimo[j] = false;
            }
        }
    }



    /**
     * Recorre el array esPrimos, y cuenta cuantas posiciones True tenemos. Para asi saver cuantos primos hay.
     * @return devuelve la cantidad de true que tiene el array esPrimos, buscamos saber la cantidad de primos que hay
     * para posteriormente crear otro array con esa longitud.
     */

    public static int contarPrimos() {
        int i;
        int cuenta = 0;
        for (i = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }


    /**
     * Funcion que crea otro array, de longitud n, donde n es el numero que nos devuelve "contarPrimos".
     * Recorre el array esPrimos, en busca de los TRUE y si es correcto, añade el numero correspondiente a esa posicion
     * al nuevo array. Creando asi, una lista de numeros los cuales son Primos.
     */

    public static void rellenarPrimos() {
        int j;
        int i;
        primos = new int[contarPrimos()];
        for (i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
    }

    /**
     * metodo para imprimir el array de numeros iniciales, solo muestra por pantalla los numeros del 0 hasta el numero
     * que hemos pasado como parametro, recorre todo el vector de numeros enteros.
     * @param vector, le pasamos el vector que hemos creado con el dato pasado por pantalla por el usuario
     */

    public static void imprimirIniciales(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(i + 1 + "\t");
        }
    }

    /**
     * metodo para imprimir el array de primos, generados por el metodo generarPrimos, se le pasa un vector como parametro
     * el cual son los primos, desde 2 hasta el numero que ha indicado el usuario
     * @param vector, le pasamos el vector que ha generado el metodo generarPrimos, el cual ha cambiado el vector inicial
     * por solo los primos.
     */

    public static void imprimirPrimos(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            System.out.print(vector[i] + "\t");
        }
    }




    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato = teclado.nextInt();
        int vector[] = new int[dato];
        System.out.println("\nVector inicial hasta :" + dato);
        imprimirIniciales(vector);
        vector = generarPrimos(dato);
        System.out.println("\nVector de primos hasta:" + dato);
        imprimirPrimos(vector);
    }
}


