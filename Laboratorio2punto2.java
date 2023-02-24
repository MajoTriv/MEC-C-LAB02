import java.util.*;

public class Laboratorio2punto2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una línea de caracteres: ");
        String linea = sc.nextLine();

        // Invertir la línea de caracteres
        String lineaInvertida = "";
        for (int i = linea.length() - 1; i >= 0; i--) {
            lineaInvertida += linea.charAt(i);
        }
        System.out.println("La línea invertida es: " + lineaInvertida);

        // Sustituir las vocales por el carácter que más se repite
        Map<Character, Integer> frecuencias = new HashMap<>();
        char[] caracteres = linea.toCharArray();
        for (char c : caracteres) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                continue;
            }
            if (frecuencias.containsKey(c)) {
                frecuencias.put(c, frecuencias.get(c) + 1);
            } else {
                frecuencias.put(c, 1);
            }
        }
        char reemplazo = Collections.max(frecuencias.entrySet(), Map.Entry.comparingByValue()).getKey();
        String lineaSustituida = "";
        for (char c : caracteres) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                lineaSustituida += reemplazo;
            } else {
                lineaSustituida += c;
            }
        }
        System.out.println("La línea con las vocales sustituidas es: " + lineaSustituida);

        // Invertir la línea de caracteres con las vocales sustituidas
        String lineaSustituidaInvertida = "";
        for (int i = lineaSustituida.length() - 1; i >= 0; i--) {
            lineaSustituidaInvertida += lineaSustituida.charAt(i);
        }
        System.out.println("La línea invertida con las vocales sustituidas es: " + lineaSustituidaInvertida);
    }
}