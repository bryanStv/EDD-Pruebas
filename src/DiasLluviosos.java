import java.util.Arrays;

public class DiasLluviosos {
    private static boolean[] dias = new boolean[365];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dias));
        registrarQueLlovioElDia(1,true);
        System.out.println(Arrays.toString(dias));
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
        int cuatrimestre = dias.length/4;
        int cuatri = 1;
        int masLluvioso = Integer.MIN_VALUE;
        for (int i = 0; i < dias.length; i++) {
            for (int j = 0; j < cuatrimestre; j++) {
                return 0;
            }
        }
        return 0;
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
