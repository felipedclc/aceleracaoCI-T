package br.com.codenation.desafioexe.fibonacci;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void addTolist(int number) {
        numbers.add(number);
    }

    // https://www.devmedia.com.br/sequencia-de-fibonacci-em-java/23620
    public long fibo(int n) {
        int cur = 0;
        int pre = 0;
        int index = 0;

        while (cur <= n) {
            if (index == 1) {
                cur = 1;
                pre = 0;
            } else {
                cur += pre;
                pre = cur - pre;
            }
            addTolist(cur);
            index++;
        }
        return cur;
    }

    public List<Integer> fiboList(int n) {
        fibo(n);
        return numbers;
    }
}
