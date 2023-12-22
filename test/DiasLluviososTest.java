import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DiasLluviososTest {

    private static void rellenarDias(){
        //Si el indice par, no llovió(false), si es impar, llovió(true)
        for (int i = 0; i < DiasLluviosos.getDias().length; i++) {
            if(i % 2 != 0){
                DiasLluviosos.getDias()[i] = true;
            }
        }
    }

    @org.junit.jupiter.api.Test
    void registrarQueLlovioElDia() {
        rellenarDias();
        //System.out.println(Arrays.toString(DiasLluviosos.getDias()));
        Assertions.assertTrue(DiasLluviosos.consultarSiLlovioElDia(1));
        Assertions.assertFalse(DiasLluviosos.consultarSiLlovioElDia(26));
        DiasLluviosos.registrarQueLlovioElDia(26,true);
        Assertions.assertTrue(DiasLluviosos.consultarSiLlovioElDia(26));
        Assertions.assertFalse(DiasLluviosos.consultarSiLlovioElDia(364));
        DiasLluviosos.registrarQueLlovioElDia(364,true);
        Assertions.assertTrue(DiasLluviosos.consultarSiLlovioElDia(364));
    }

    @org.junit.jupiter.api.Test
    void consultarSiLlovioElDia() {
        rellenarDias();
        Assertions.assertTrue(DiasLluviosos.consultarSiLlovioElDia(15));
        Assertions.assertFalse(DiasLluviosos.consultarSiLlovioElDia(16));
        Assertions.assertFalse(DiasLluviosos.consultarSiLlovioElDia(364));
        Assertions.assertTrue(DiasLluviosos.consultarSiLlovioElDia(363));
    }

    @org.junit.jupiter.api.Test
    void contarDiasLluviosos() {
        rellenarDias();
        //La mitad entera, 182(total dias en false)
        Assertions.assertEquals(182,DiasLluviosos.contarDiasLluviosos());
        //Añadiendo 1 día más
        DiasLluviosos.registrarQueLlovioElDia(0,true);
        Assertions.assertEquals(183,DiasLluviosos.contarDiasLluviosos());
        //Rellenando TODOS los días en true
        for (int i = 0; i < DiasLluviosos.getDias().length; i+=2) {
            DiasLluviosos.registrarQueLlovioElDia(i,true);
        }
        Assertions.assertEquals(365,DiasLluviosos.contarDiasLluviosos());
        //Dejando el vector en falso completamente
        boolean[] diasVacio = new boolean[365];
        DiasLluviosos.setDias(diasVacio);
        Assertions.assertEquals(0,DiasLluviosos.contarDiasLluviosos());
    }

    @org.junit.jupiter.api.Test
    void consultarCuatrimestreMasLluvioso() {
    }

    @org.junit.jupiter.api.Test
    void consultarPrimerDiaConLluvia() {
        //Vector vacío, ningún día llovió, devuelve -1
        DiasLluviosos.setDias(new boolean[365]);
        Assertions.assertEquals(-1,DiasLluviosos.consultarPrimerDiaConLluvia());
        //Rellenando vector
        DiasLluviosos.registrarQueLlovioElDia(16,true); //Primer día
        DiasLluviosos.registrarQueLlovioElDia(20,true);
        DiasLluviosos.registrarQueLlovioElDia(80,true);
        DiasLluviosos.registrarQueLlovioElDia(104,true);
        Assertions.assertEquals(16,DiasLluviosos.consultarPrimerDiaConLluvia());
        rellenarDias(); //Con el vector completamente relleno con días impares además de los anteriores pares
        Assertions.assertEquals(1,DiasLluviosos.consultarPrimerDiaConLluvia());
    }
}