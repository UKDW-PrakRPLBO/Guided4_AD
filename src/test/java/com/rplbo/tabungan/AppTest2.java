package com.rplbo.tabungan;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest2
{
    /**
     * Rigorous Test :-)
     */

    @ParameterizedTest
    @MethodSource("inputTabunganA")
    public void buatTabunganA(int saldo,String nama){
        Tabungan A = new Tabungan();
        A.penyetoran(saldo);
        A.setPemilik(nama);
        System.out.println(A.getSaldo());
        assertEquals( 1200,A.getSaldo() );
        assertEquals( "A",A.getPemilik() );
    }

    private static Stream<Arguments> inputTabunganA(){
        return Stream.of(
                Arguments.of(1200,"A")
        );
    }

    @ParameterizedTest
    @MethodSource("inputTabunganB")
    public void buatTabunganB(int saldo, String nama){
        Tabungan B = new Tabungan();
        B.penyetoran(saldo);
        B.setPemilik(nama);
        System.out.println(B.getSaldo());
        assertEquals( 3000, B.getSaldo() );
        assertEquals("B", B.getPemilik() );
    }

    private static Stream<Arguments> inputTabunganB(){
        return Stream.of(
                Arguments.of(3000,"B")
        );
    }

    @ParameterizedTest
    @MethodSource("inputTabunganC")
    public void buatTabunganC(int saldo, String nama){
        Tabungan C = new Tabungan();
        C.penyetoran(saldo);
        C.setPemilik(nama);
        assertEquals( 1500, C.getSaldo() );
        assertEquals("C", C.getPemilik() );
    }

    private static Stream<Arguments> inputTabunganC(){
        return Stream.of(
                Arguments.of(1500,"C")
        );
    }

    @Test
    public void Trans1(){
        Tabungan A = new Tabungan();
        Tabungan B = new Tabungan();
        Tabungan C = new Tabungan();
        A.penyetoran(1200);
        B.penyetoran(3000);
        C.penyetoran(1500);

        A.transfer(200,B);
        B.transfer(2400,C);
        C.transfer(1100,A);
        assertEquals(2100,A.getSaldo());
        assertEquals(800,B.getSaldo());
        assertEquals(2800,C.getSaldo());
    }

    @Test
    public void Trans2(){
        Tabungan A = new Tabungan();
        Tabungan B = new Tabungan();
        Tabungan C = new Tabungan();
        A.penyetoran(1200);
        B.penyetoran(3000);
        C.penyetoran(1500);

        A.transfer(200,B);
        B.transfer(2400,C);
        C.transfer(1100,A);

        B.transfer(1000,C);
        C.transfer(-2000,A);
        assertEquals(2100,A.getSaldo());
        assertEquals(800,B.getSaldo());
        assertEquals(2800,C.getSaldo());
    }

    @Test
    public void Trans3(){
        Tabungan A = new Tabungan();
        Tabungan B = new Tabungan();
        Tabungan C = new Tabungan();

        A.penyetoran(1200);
        B.penyetoran(3000);
        C.penyetoran(1500);

        A.transfer(200,B);
        B.transfer(2400,C);
        C.transfer(1100,A);

        B.transfer(1000,C);
        C.transfer(-2000,A);

        A.transfer(2000,A);
        assertEquals(2100,A.getSaldo());
    }


}
