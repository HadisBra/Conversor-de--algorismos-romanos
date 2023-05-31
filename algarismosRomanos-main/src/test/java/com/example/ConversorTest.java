package com.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ConversorTest {
    Conversor c;

    @BeforeEach
    void setUp() {
        c = new Conversor();
    }


    @ParameterizedTest(name="{0}={1}")
    @CsvSource({
        "X,10",
        "III,3",
        "C,100",
        "DIII,503",
        "MI,1001",
        "MD,1500",
        "LXX,70",
        "XCIX,99",
        "MCMXXXVII,1937",
        "MMM,3000",
        "VIII,8"

    })
    void romanoParaInteiro(String s ,int decimal){
        assertEquals(decimal,c.romanoParaInteiro(s)
            );
    }
@ParameterizedTest(name="{0}={1}")
@CsvSource({
"11,XI",
"22,XXII",
"99,XCIX",
"1000,M",
"2000,MM",
"8,VIII",
"1937,MCMXXXVII",
"1500,MD",
"100,C",
"10,X"
})
 void  inteiroParaRomano(int decimal,String s){
    assertEquals(s,c.converterDecimalParaRomano(decimal)
        );

}
@Test
public void verificacao_decimal(){
    Throwable exception = assertThrows(IllegalArgumentException.class,()->{c.converterDecimalParaRomano(0);}); 
    assertEquals("O valor digitado não é VALIDO!",exception.getMessage());
    }

@Test
public void verificado_NumeroRoman(){
    Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
      c.converteNumeroDecimal("VIIII");
  });
     assertEquals( "Símbolo romano inválido:",exception.getMessage()) ;
  }

}

