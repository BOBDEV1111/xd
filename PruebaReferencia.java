import java.util.Scanner;

public class PruebaReferencia {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Referencia prueba = new Referencia();
        try {
            prueba.obtenerFecha(sc);
            System.out.println("Fecha condensada: " + prueba.getFechaCondenzada());
            System.out.println(":::");
            prueba.obtenerMonto(sc);
            System.out.println("Monto condensado: "+ prueba.getMontoCondensado());
            System.out.println(":::");
            prueba.digitoVerificador(sc);
            
        } catch (ExcepcionLongitud g) {
            System.out.println(g.getMessage());
        } catch (ExcepcionEnFecha fecha) {
            System.out.println(fecha.getMessage());
        } catch(ExcepcionMonto m){
            System.out.println(m.getMessage());
        } catch(ExcepcionRFC b){
            System.out.println(b.getMessage());
        }

        /*
         * String fecha = "24-10-2020"; String fechaSec = fecha.replace('-', ' ');
         * String fechaF = fechaSec.replaceAll("\\s", ""); char[] digitosFecha =
         * fechaF.toCharArray(); System.out.println(fechaF); System.out.println(); for
         * (char c : digitosFecha) { System.out.println(c + ":::"); }
         * 
         * String ejemplo = "2020-10-23"; String anioAux = ejemplo.substring(0, 4);
         * System.out.println(anioAux); System.out.println(); String mesAux =
         * ejemplo.substring(5, 7); System.out.println(mesAux); String diaAux =
         * ejemplo.substring(8, 10); System.out.println(diaAux);
         */
    }
}