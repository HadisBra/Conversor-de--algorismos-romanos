    package com.example;

import java.util.HashMap;
import java.util.TreeMap;

public class Conversor {
    String converterDecimalParaRomano(int decimal) {
        if (decimal <= 0 || decimal > 3999) {
            throw new IllegalArgumentException("O número decimal deve estar entre 1 e 3999.");
        }
        
        TreeMap<Integer, String> decimalParaRomanoMap = new TreeMap<>();
        decimalParaRomanoMap.put(1000, "M");
        decimalParaRomanoMap.put(900, "CM");
        decimalParaRomanoMap.put(500, "D");
        decimalParaRomanoMap.put(400, "CD");
        decimalParaRomanoMap.put(100, "C");
        decimalParaRomanoMap.put(90, "XC");
        decimalParaRomanoMap.put(50, "L");
        decimalParaRomanoMap.put(40, "XL");
        decimalParaRomanoMap.put(10, "X");
        decimalParaRomanoMap.put(9, "IX");
        decimalParaRomanoMap.put(5, "V");
        decimalParaRomanoMap.put(4, "IV");
        decimalParaRomanoMap.put(1, "I");
        
        StringBuilder romano = new StringBuilder();
        
        while (decimal > 0) {
            int chave = decimalParaRomanoMap.floorKey(decimal);
            String algarismo = decimalParaRomanoMap.get(chave);
            romano.append(algarismo);
            decimal -= chave;
        }
        
        return romano.toString();
    }


    public int converteNumeroDecimal(String romano){
        if(romano == null || romano.isEmpty() || !romano.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
          throw new IllegalArgumentException("O algarismo romano fornecido é  inválido ou campo não esta prenchido.");
    
        }
        
        int resultado = 0;
        int valor = 0;
    
        for (int i =  romano.length() - 1; i >= 0; i--) {
    
          int pegarValue = valorDecimal(romano.charAt(i));
            
        
          if(pegarValue < valor){
              resultado -= pegarValue;
          }else{
            resultado += pegarValue;
            valor = pegarValue;
          }
        }
        
        return resultado;
      }


    private int valorDecimal(char charAt) {
        return 0;
    }
    int romanoParaInteiro(String s) {
        // Cria um hash map vazio.
        HashMap<Character, Integer> map = new HashMap<>();

        // Inserindo os valores no map.
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Criando uma variavel para receber o valor da conversão
        int resultado = 0;
        int repeticao = 0;

        // Inicializa o loo para iterar a string que contem o numero romano
        for (int i = 0; i < s.length(); i++) {

            // VErificando se o valor atual
            // não é menor que o anterior
            if (i > 0
                    && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                resultado += map.get(s.charAt(i))
                        - 2 * map.get(s.charAt(i - 1));
            } else {
                resultado += map.get(s.charAt(i));
            }
        }
        // Retorna o inteiro que representa o numero romano informado.
        return resultado;
    }

}
