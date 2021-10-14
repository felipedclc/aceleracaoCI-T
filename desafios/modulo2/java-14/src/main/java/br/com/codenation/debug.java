package br.com.codenation;

public class debug {

    // https://www.ti-enxame.com/pt/java/como-calcular-media-mediana-modo-e-intervalo-de-um-conjunto-de-numeros/970350439/
    public static int mode(int a[]) {
        int maxValue = 0, maxCount = 0;

        for (int i = 0; i < a.length; ++i) {
            int count = 0;
            for (int j = 0; j < a.length; ++j) {
                if (a[j] == a[i]) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = a[i];
            }
        }

        return maxValue;
    }
}
