import java.util.Arrays;
import java.util.regex.Pattern;

public class pruebasExclude {
    
    public static void main(String[] args) {
    /*    String m = "NAMS21";

        boolean esLetra = Pattern.matches("^[A-Z]*$", m);

        System.out.println(esLetra);*/

        char[] alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        String m = "COL";
        String n = "NAMS";

        String z = m+n;

        
        int[] p = new int[z.length()];

        for (int i = 0; i < z.length(); i++) {
            char aux = z.charAt(i);
            p[i] = ((int) aux - 55);
        }

        for (int i : p) {
            System.out.println(i);
            System.out.println("--------->");
        }

        // le quitamos los corchetes
        String clave_RFC = Arrays.toString(p).replaceAll("\\[|\\]|,|\\s", "");

        System.out.println(clave_RFC);

        String v = clave_RFC + "vvv";

        System.out.println(v);


    }
}
