import java.util.ArrayList;
import java.util.Arrays;

public class DiasLluviosos {
    private static boolean[] dias = new boolean[365];

    public static void setDias(boolean[] dias) {
        DiasLluviosos.dias = dias;
    }

    public static boolean[] getDias() {
        return dias;
    }

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(dias));
        registrarQueLlovioElDia(121,true);
        registrarQueLlovioElDia(120,true);
        System.out.println(Arrays.toString(dias));
        System.out.println(consultarCuatrimestreMasLluvioso());
    }
    public static void registrarQueLlovioElDia (int diaDeAño, boolean llovio){
        dias[diaDeAño] = llovio;
    }
    public static boolean consultarSiLlovioElDia (int diaDelAño){
        if(dias[diaDelAño]){
            return true;
        }else{
            return false;
        }
    }
    public static int contarDiasLluviosos (){
        int suma = 0;
        for (int i = 0; i < dias.length; i++) {
            if(dias[i]) suma++;
        }
        return suma;
    }
    public static int consultarCuatrimestreMasLluvioso(){
        int longitudCuatrimestre = dias.length / 4;
        int sumaMayor = 0;
        int cuatrimestreMayorSuma = 0;

        for (int i = 0; i <= dias.length - longitudCuatrimestre; i += longitudCuatrimestre) {
            int sumaCuatrimestre = 0;
            for (int j = i; j < i + longitudCuatrimestre; j++) {
                if (dias[j]) {
                    sumaCuatrimestre++;
                }
            }

            if (sumaCuatrimestre > sumaMayor) {
                sumaMayor = sumaCuatrimestre;
                cuatrimestreMayorSuma = i / longitudCuatrimestre + 1; // +1 porque los cuatrimestres comienzan en 1
            }
        }

        return cuatrimestreMayorSuma;
    }
    public static int consultarPrimerDiaConLluvia(){
        for (int i = 0; i < dias.length; i++) {
            if(dias[i]){
                return i;
            }
        }
        return -1;
    }
}
