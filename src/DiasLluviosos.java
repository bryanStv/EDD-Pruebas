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
        //registrarQueLlovioElDia(1,true);
        //System.out.println(Arrays.toString(dias));
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
        int cuatri = 1, totalRecorrido = 0, suma, resultado;
        int masLluvioso = Integer.MIN_VALUE;
        while(cuatri < 5){
            suma = 0;
            for(int i = 0; i < cuatrimestre;i++){
                if(dias[totalRecorrido]){
                    suma++;
                }
            }
            if(suma > masLluvioso){
                resultado = cuatri;
                masLluvioso = suma;
            }
            cuatri++;
        }
        return cuatri;
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
