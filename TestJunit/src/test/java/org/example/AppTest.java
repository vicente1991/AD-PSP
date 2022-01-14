package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    static Calculadora c;
    static int a,b;

    @BeforeAll
    static void init(){
        c = new Calculadora();
    }

    @BeforeEach
    void saludar(){
        a= ThreadLocalRandom.current().nextInt();
        b= ThreadLocalRandom.current().nextInt();
    }

    @Test
    @DisplayName("sumar los numeros 2 + 2")
    public void sumarDosEnteros(){
        assertEquals(4,c.sumar(2,2));
    };

    @Test
    @DisplayName("restar dos numeros")
    public void restarDosNumeros(){
        assertEquals(4,c.restar(8,4));
    }

    @Test
    @DisplayName("multiplicar dos numeros")
    public void multiplicarDosNumeros(){
        assertEquals(12,c.multiplicar(4,4));
    }

    @Test
    @DisplayName("Dividir dos numeros")
    public void dividirDosNumeros(){
        assertEquals(10,c.dividir(100,10));
    }

    @Test
    public void dividirEntre0(){
        assertThrows(ArithmeticException.class,()
        ->{
            c.dividir(1,0);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "2,3,5"
    })
    public void testSuma(int a,int b ,int res){
        assertEquals(res,a,b);
    }

}
