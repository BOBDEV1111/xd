import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PruebaMonto {

    public static void main(String[] args) {
        
        ArrayList<Integer> lista1 = new ArrayList<>();
        lista1.add(5);
        lista1.add(6);
        lista1.add(2);
        lista1.add(0);
        lista1.add(5);
        lista1.add(0);

        ArrayList<Integer> lista2 = new ArrayList<>();

        int i = 1;
        int l = 3;
        int m = 7;
        int k = 0;
        int z = 0;

        int sumaMultiplicacion = 0;

        int[] multis = new int[lista2.size()];

        while (z <= lista1.size()) {

            {
                lista2.add(k, m);
                z++;
                k++;

            }
            //cortos
            if (z >= lista1.size()) {
                break;
            }
            {
                lista2.add(k, l);
                z++;
                k++;

            }
            //cortos
            if (z >= lista1.size()) {
                break;
            }
            {
                lista2.add(k, i);
                z++;
                k++;

            }
            //corto
            if (z >= lista1.size()) {
                break;
            }

        }

        // lo invierto 
        Collections.reverse(lista2);
        
        // los multiplico
        for (int j = 0; j < lista2.size(); j++) {
            sumaMultiplicacion = sumaMultiplicacion + (lista1.get(j)*lista2.get(j));
        } 

        for (Integer li : lista2) {
            System.out.println(li);
        }

        int residuo = sumaMultiplicacion % 10;

        System.out.println("Lista uno: " + lista1.size());
        System.out.println("Lista dos: " + lista2.size());

        System.out.println("La suma: " + sumaMultiplicacion);
        System.out.println("El residuo: " + residuo);
        

    }
}
