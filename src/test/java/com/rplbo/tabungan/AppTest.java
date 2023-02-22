package com.rplbo.tabungan;

import org.junit.jupiter.api.*;
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
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	 
	 @BeforeAll
    public static void init() {
		System.out.println("Awal");
       
    }

    @AfterAll
    public static void destory(){
        System.out.println("AKHIRRR");
       
    }
    @BeforeEach
    public void setUp() {

    }

    @AfterEach
    public void tearDown() {

    }

    @ParameterizedTest
    @MethodSource("inputTabunganA")
    public void buatTabunganA(int saldo,String nama){
        Tabungan A = new Tabungan();
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
        Tabungan B = new Tabungan();
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
        Tabungan A = new Tabungan();
         A.penyetoran(300);
        assertEquals(300,A.getSaldo());
    }

    @Test
    public void saldoTabunganB(){
         Tabungan B = new Tabungan();
        B.penyetoran(1200);
        assertEquals(1200,B.getSaldo());
    }

    @Test
    public void lakukanMacem2A(){
        Tabungan A = new Tabungan();
        A.penyetoran(300);
        A.penarikan(150);
        A.penyetoran(-200);
        assertEquals(150,A.getSaldo());
    }

    @Test
    public void lakukanMacem2B(){
        Tabungan B = new Tabungan();
        B.penyetoran(1200);
        B.penyetoran(300);
        B.penarikan(-1000);
        System.out.println(B.getSaldo());
        assertEquals(1500,B.getSaldo());
    }

}
