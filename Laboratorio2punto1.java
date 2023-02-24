import java.util.*;

public class Laboratorio2punto1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del arreglo--> ");
        int n = input.nextInt();

        int[] numeros = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            numeros[i] = rand.nextInt(101); 
        }

        double suma = 0;
        for (int i = 0; i < n; i++) {
            suma += numeros[i];
        }
        double media = suma / n;

        Arrays.sort(numeros);
        double mediana;
        if (n % 2 == 0) {
            mediana = (numeros[n/2 - 1] + numeros[n/2]) / 2.0;
        } else {
            mediana = numeros[n/2];
        }

        double sumaCuadrados = 0;
        for (int i = 0; i < n; i++) {
            sumaCuadrados += Math.pow(numeros[i] - media, 2);
        }
        double varianza = sumaCuadrados / n;

        double desviacionEstandar = Math.sqrt(varianza);

        int moda = 0;
        int repeticiones = 0;
        for (int i = 0; i < n; i++) {
            int contador = 0;
            for (int j = 0; j < n; j++) {
                if (numeros[j] == numeros[i]) {
                    contador++;
                }
            }
            if (contador > repeticiones) {
                repeticiones = contador;
                moda = numeros[i];
            }
        }

        System.out.println("Arreglo--> " + Arrays.toString(numeros));
        System.out.println("Calculo de la Media--> " + media);
        System.out.println("Calculo de la Mediana: " + mediana);
        System.out.println("Calculo de la Varianza: " + varianza);
        System.out.println("Calculo de la Desviación estándar: " + desviacionEstandar);
        System.out.println("Moda: " + moda + " (se repite " + repeticiones + " veces)");

    }

}