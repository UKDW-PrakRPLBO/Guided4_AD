package com.rplbo.tabungan;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest2
{
    /**
     * Rigorous Test :-)
     */
    static Tabungan A = new Tabungan();
    static Tabungan B = new Tabungan();
    static Tabungan C = new Tabungan();
    @ParameterizedTest
    @MethodSource("inputTabunganA")
    public void buatTabunganA(int saldo,String nama){
        A.penyetoran(saldo);
        A.setPemilik(nama);
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
        B.penyetoran(saldo);
        B.setPemilik(nama);
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
        C.penyetoran(saldo);
        C.setPemilik(nama);
        System.out.println(C.getSaldo());
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
        A.transfer(200,B);
        B.transfer(2400,C);
        C.transfer(1100,A);
        assertEquals(2100,A.getSaldo());
        assertEquals(800,B.getSaldo());
        assertEquals(2800,C.getSaldo());
    }

    @Test
    public void Trans2(){
        B.transfer(1000,C);
        C.transfer(-2000,A);
        assertEquals(2100,A.getSaldo());
        assertEquals(800,B.getSaldo());
        assertEquals(2800,C.getSaldo());
    }

    @Test
    public void Trans3(){
        A.transfer(2000,A);
        assertEquals(2100,A.getSaldo());
    }


}
