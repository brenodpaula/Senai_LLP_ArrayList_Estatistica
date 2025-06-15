import java.util.*;

public class Estatistica {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        ArrayList<Double> numeros = new ArrayList<>();

        System.out.println("Informe números:");

        while (true) {
            String entrada = leia.nextLine();
            if (entrada.isEmpty()) break;
            double numero = Double.parseDouble(entrada);
            numeros.add(numero);
        }

        if (numeros.isEmpty()) {
            System.out.println("Nenhum número foi informado.");
            return;
        }

        double soma = 0, min = numeros.get(0), max = numeros.get(0);
        for (double num : numeros) {
            soma += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double media = soma / numeros.size();
        double moda = numeros.get(0);
        int maiorFrequencia = 0;
        for (double candidato : numeros) {
            int freq = 0;
            for (double n : numeros) {
                if (n == candidato) freq++;
            }
            if (freq > maiorFrequencia) {
                maiorFrequencia = freq;
                moda = candidato;
            }
        }

        double somaQuadrados = 0;
        for (double num : numeros) {
            double diff = num - media;
            somaQuadrados += diff * diff;
        }
        double desvioPadrao = Math.sqrt(somaQuadrados / numeros.size());

        System.out.printf("Média = %d%n", Math.round(media));
        System.out.printf("Moda = %d%n", Math.round(moda));
        System.out.printf("Mínimo = %d%n", Math.round(min));
        System.out.printf("Máximo = %d%n", Math.round(max));
        System.out.printf("Desvio padrão = %.3f%n", desvioPadrao);;

    }
}
