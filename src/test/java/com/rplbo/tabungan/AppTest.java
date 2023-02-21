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
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    static Tabungan A = new Tabungan();
    static Tabungan B = new Tabungan();
    @ParameterizedTest
    @MethodSource("inputTabunganA")
    public void buatTabunganA(int saldo,String nama){
        A.penyetoran(saldo);
        A.setPemilik(nama);
        assertEquals( 300,A.getSaldo() );
        assertEquals( "A",A.getPemilik() );
    }

    private static Stream<Arguments> inputTabunganA(){
        return Stream.of(
                Arguments.of(300,"A")
        );
    }

    @ParameterizedTest
    @MethodSource("inputTabunganB")
    public void buatTabunganB(int saldo, String nama){
        B.penyetoran(saldo);
        B.setPemilik(nama);
        assertEquals( 1200, B.getSaldo() );
        assertEquals("B", B.getPemilik() );
    }

    private static Stream<Arguments> inputTabunganB(){
        return Stream.of(
                Arguments.of(1200,"B")
        );
    }

    @Test
    public void saldoTabunganA(){
        A.penyetoran(300);
        assertEquals(300,A.getSaldo());
    }

    @Test
    public void saldoTabunganB(){
        B.penyetoran(1200);
        assertEquals(1200,B.getSaldo());
    }

    @Test
    public void lakukanMacem2A(){
        A.penarikan(150);
        A.penyetoran(-1000);
        assertEquals(150,A.getSaldo());
    }

    @Test
    public void lakukanMacem2B(){
        B.penyetoran(300);
        B.penarikan(-500);
        System.out.println(B.getSaldo());
        assertEquals(1500,B.getSaldo());
    }

}
