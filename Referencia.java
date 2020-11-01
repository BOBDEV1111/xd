import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Referencia {

    private String fechaCondenzada;
    private int montoCondensado;
    private int digitoVerificador;
    private String RFC;

    static final String clave = "COL";

    static int anioEntero;
    static int mesEntero;
    static int diaEntero;
    static String montoAux;
    static String RFCAux;

    public Referencia() {

    }

    public String obtenerFecha(Scanner sc) throws ExcepcionEnFecha {

        boolean fechaCorrecta = false;

        do {

            try {

                System.out.println("Ingresa la fecha con el siguiente formato, AAAA-MM-DD ");
                String fechaSecundaria = sc.nextLine();

                // comprobacion de la longitud de la cadena
                if (fechaSecundaria.length() > 10) {
                    throw new ExcepcionLongitud("Exceso de caracteres");
                } else if (fechaSecundaria.length() < 10) {
                    throw new ExcepcionLongitud("Faltan caracteres ");
                }
                // termina la comprobacion

                // lo asigno a mis variables auxiliares
                String anioAux = fechaSecundaria.substring(0, 4);
                String mesAux = fechaSecundaria.substring(5, 7);
                String diaAux = fechaSecundaria.substring(8, 10);

                // compruebo que sean numeros
                if (EsNumero.esNumero(anioAux) == true) {
                    anioEntero = Integer.parseInt(anioAux);
                } else {
                    throw new ExcepcionEnFecha("Error en anio ");
                }

                if (EsNumero.esNumero(mesAux) == true) {
                    mesEntero = Integer.parseInt(mesAux);
                } else {
                    throw new ExcepcionEnFecha("Error en mes ");
                }

                if (EsNumero.esNumero(diaAux) == true) {
                    diaEntero = Integer.parseInt(diaAux);
                } else {
                    throw new ExcepcionEnFecha("Error en dia ");
                }
                // termina la comprobacion

                // stringbuiler para contruir la fecha condensada
                StringBuilder preCondensada = new StringBuilder();
                int aniosFinal = (anioEntero - 2014) * 372;
                int mesesFinal = (mesEntero - 1) * 31;
                int diasFinal = (diaEntero - 1);

                /*
                 * prueba fecha System.out.println("an " + anioEntero);
                 * System.out.println("mes " + mesEntero); System.out.println("dia " +
                 * diaEntero); System.out.println("suma: " + sumaCondensada);
                 * 
                 */

                // suma de las tres operaciones
                int sumaCondensada = (aniosFinal + mesesFinal + diasFinal);
                // obtenemos la longitud de la sumaCondensada
                String sumaCondensadaAux = Integer.toString(sumaCondensada);

                // agregamos al StringBuilder la suma
                preCondensada.append(sumaCondensadaAux);

                // realizamos las comparaciones
                if (sumaCondensadaAux.length() == 3) {
                    preCondensada.insert(0, '0');
                }
                if (sumaCondensadaAux.length() == 2) {
                    preCondensada.insert(0, '0');
                    preCondensada.insert(1, '0');
                }
                if (sumaCondensadaAux.length() == 1) {
                    preCondensada.insert(0, '0');
                    preCondensada.insert(1, '0');
                    preCondensada.insert(2, '0');
                }
                if (sumaCondensadaAux.length() == 0) {
                    preCondensada.insert(0, '0');
                    preCondensada.insert(1, '0');
                    preCondensada.insert(2, '0');
                    preCondensada.insert(3, '0');
                }

                // cambiamos el estado
                fechaCorrecta = true;

                // retornamos el valor
                this.fechaCondenzada = preCondensada.toString();

                // atrapamos las excepciones
            } catch (ExcepcionLongitud g) {
                System.out.println(g.getMessage() + "Intente de nuevo usando el formaro AAAA-MM-DD ");
            } catch (ExcepcionEnFecha les) {
                System.out.println(les.getMessage() + "Intente de nuevo usando el formaro AAAA-MM-DD ");
            }
        } while (fechaCorrecta == false);

        // retorno el valor
        return this.fechaCondenzada;
    }
    // termina fecha

    public String getFechaCondenzada() {
        return this.fechaCondenzada;
    }

    // monto condensado
    public int obtenerMonto(Scanner sc) throws ExcepcionMonto {

        // estado de control
        boolean estadoMonto = false;

        // bucle
        do {
            // pedir los numeros
            try {
                System.out.println("Ingresa el monto total incluyendo los centavos con un punto para separarlos, ejemplo 4321.39 ");
                String montoPrincipal = sc.nextLine();
                // retiro el punto
                montoAux = montoPrincipal.replace(".", "");
                // verifico que todos sean numeros
                for (int i = 0; i < montoAux.length(); i++) {
                    if (Character.isDigit(montoAux.charAt(i))) {
                        montoAux = montoAux;
                    } else {
                        throw new ExcepcionMonto("Error en monto ");
                    }
                }
                // termina verificacion

                // pasar el string a un array
                int[] arregloMonto = new int[montoAux.length()];
                for (int j = 0; j < arregloMonto.length; j++) {
                    // casteo
                    arregloMonto[j] = montoAux.charAt(j) - '0';
                }

                // operaciones
                ArrayList<Integer> lista2 = new ArrayList<>();

                int i = 1;
                int l = 3;
                int m = 7;
                int k = 0;
                int z = 0;

                int sumaMultiplicacion = 0;

                while (z <= arregloMonto.length) {
                    {
                        lista2.add(k, m);
                        z++;
                        k++;
                    }
                    // cortos
                    if (z >= arregloMonto.length) {
                        break;
                    }
                    {
                        lista2.add(k, l);
                        z++;
                        k++;
                    }
                    // cortos
                    if (z >= arregloMonto.length) {
                        break;
                    }
                    {
                        lista2.add(k, i);
                        z++;
                        k++;
                    }
                    // corto
                    if (z >= arregloMonto.length) {
                        break;
                    }
                }

                // lo invierto
                Collections.reverse(lista2);
                // los multiplico
                for (int g = 0; g < arregloMonto.length; g++) {
                    sumaMultiplicacion = sumaMultiplicacion + (arregloMonto[g] * lista2.get(g));
                }

                // obtenermos el residuo
                int residuo = sumaMultiplicacion % 10;

                // lo asignamos
                this.montoCondensado = residuo;

                // cambio el estado de control
                estadoMonto = true;

                // excepciones

            } catch (ExcepcionMonto h) {
                System.out.println(h.getMessage() + "Intente de nuevo");
            }
        } while (estadoMonto == false);

        return this.montoCondensado;
    }

    public int getMontoCondensado() {
        return this.montoCondensado;
    }
    // termina monto

    // digito verificador
    public int digitoVerificador(Scanner sc) throws ExcepcionRFC {

        // estado de control
        boolean estadoDigito = false;

        // bucle
        do {
            // try - catch
            try {
                System.out.println("Ingrese su RFC sin homoclave, ejemplo: NAMS640111 ");
                RFCAux = sc.nextLine();

                this.RFC = RFCAux;

                // verificamos que sea la longitud correcta
                if (RFCAux.length() > 10) {
                    throw new ExcepcionRFC("Exceso de caracteres ");
                } else if (RFCAux.length() < 10) {
                    throw new ExcepcionRFC("Faltan caracteres ");
                }

                // verificamos que sea el formato correcto
                String letraRFC = RFCAux.substring(0, 4);
                String digitoRFC = RFCAux.substring(4, 10);

                // clase pattern - matches para buscar coincidencias de A a Z
                boolean esLetra = Pattern.matches("^[A-Z]*$", letraRFC);
                if (esLetra = true) {
                    letraRFC = letraRFC;
                } else {
                    throw new ExcepcionRFC("Error en RFC ");
                }
                if (EsNumero.esNumero(digitoRFC)) {
                    digitoRFC = digitoRFC;
                } else {
                    throw new ExcepcionRFC("Error en RFC ");
                }
                // termina la verificacion

                // transformar los string del RFC a int, concatenamos COL y la parte cadena del
                // RFC
                String parteLetra = clave + letraRFC;

                // usamos ascii para obtener los valores
                int[] valoresLetras = new int[parteLetra.length()];
                for (int i = 0; i < valoresLetras.length; i++) {
                    // variable que va a obtener las letras
                    char caracterAux = parteLetra.charAt(i);
                    // parseamos a ascii
                    valoresLetras[i] = ((int) caracterAux - 55);
                }

                // fecha condensada, digitoRFCAUX y monto condensado a
                /*
                 * VALORESLETRAS -- 7, digitoRFC -- 6, fechaCondensada -- 4, montoCondensado --
                 * 1 Total 18
                 */

                // pasamos las variables que componen a preDigito a String
                String digitoRFCStr = String.valueOf(digitoRFC);
                String fechaCondensadaStr = this.fechaCondenzada;
                String montoCondensadoStr = String.valueOf(this.montoCondensado);

                // creamos los arreglos int que tendran los caracteres separados y casteados a
                // int de str
                int[] digitoRfcFinal = new int[digitoRFCStr.length()];
                int[] fechaCondensadaFinal = new int[fechaCondensadaStr.length()];
                int[] montoCondensadoFinal = new int[montoCondensadoStr.length()];

                // casteo digitoRfcFinal
                for (int i = 0; i < digitoRfcFinal.length; i++) {
                    digitoRfcFinal[i] = digitoRFCStr.charAt(i) - '0';
                }
                // casteo fechaCondensadaFinal
                for (int k = 0; k < fechaCondensadaFinal.length; k++) {
                    fechaCondensadaFinal[k] = fechaCondensadaStr.charAt(k) - '0';
                }
                // casteo montoCondensadoFinal
                for (int n = 0; n < montoCondensadoFinal.length; n++) {
                    montoCondensadoFinal[n] = montoCondensadoStr.charAt(n) - '0';
                }

                // creamos el arrrayList y asignamos los valores separados
                ArrayList<Integer> listaDigitos = new ArrayList<>();
                listaDigitos.add(0, valoresLetras[0]);
                listaDigitos.add(1, valoresLetras[1]);
                listaDigitos.add(2, valoresLetras[2]);
                listaDigitos.add(3, valoresLetras[3]);
                listaDigitos.add(4, valoresLetras[4]);
                listaDigitos.add(5, valoresLetras[5]);
                listaDigitos.add(6, valoresLetras[6]);
                // COL y 4 Letras RFC to int (VALORLETRAS)
                listaDigitos.add(7, digitoRfcFinal[0]);
                listaDigitos.add(8, digitoRfcFinal[1]);
                listaDigitos.add(9, digitoRfcFinal[2]);
                listaDigitos.add(10, digitoRfcFinal[3]);
                listaDigitos.add(11, digitoRfcFinal[4]);
                listaDigitos.add(12, digitoRfcFinal[5]);
                // digitosNumericos de RFC
                listaDigitos.add(13, fechaCondensadaFinal[0]);
                listaDigitos.add(14, fechaCondensadaFinal[1]);
                listaDigitos.add(15, fechaCondensadaFinal[2]);
                listaDigitos.add(16, fechaCondensadaFinal[3]);
                // fechaCondensada
                listaDigitos.add(17, montoCondensadoFinal[0]);
                // montoCondensado

                // creamos un arrayList para los potenciadores
                ArrayList<Integer> ListaPotenciadores = new ArrayList<>();
                // creamos los ListaPotenciadores y las variables de control
                int potencia1 = 11;
                int potencia2 = 13;
                int potencia3 = 17;
                int potencia4 = 19;
                int potencia5 = 23;

                // llenado de lista, como ya tengo un tamaño definido ya no es necesario crear
                // una lista dinamica
                ListaPotenciadores.add(0, potencia1);
                ListaPotenciadores.add(1, potencia2);
                ListaPotenciadores.add(2, potencia3);
                ListaPotenciadores.add(3, potencia4);
                ListaPotenciadores.add(4, potencia5);
                ListaPotenciadores.add(5, potencia1);
                ListaPotenciadores.add(6, potencia2);
                ListaPotenciadores.add(7, potencia3);
                ListaPotenciadores.add(8, potencia4);
                ListaPotenciadores.add(9, potencia5);
                ListaPotenciadores.add(10, potencia1);
                ListaPotenciadores.add(11, potencia2);
                ListaPotenciadores.add(12, potencia3);
                ListaPotenciadores.add(13, potencia4);
                ListaPotenciadores.add(14, potencia5);
                ListaPotenciadores.add(15, potencia1);
                ListaPotenciadores.add(16, potencia2);
                ListaPotenciadores.add(17, potencia3);
                // size 18

                // lo invierto
                Collections.reverse(ListaPotenciadores);

                // variable para la suma de las multiplicaciones
                int sumaMultiplicacionListas = 0;

                for (int i = 0; i < listaDigitos.size(); i++) {
                    sumaMultiplicacionListas = sumaMultiplicacionListas
                            + (listaDigitos.get(i) * ListaPotenciadores.get(i));
                }

                // aplicamos el operador mod %
                int residuoDV = sumaMultiplicacionListas % 97;
                // sumamos 1
                int preDigitoVerificador = residuoDV + 1;

                // verificamos que sean dos digitos sino integramos uno a la izquierda
                StringBuilder preDV = new StringBuilder();
                String predigitoVerificadorStr = Integer.toString(preDigitoVerificador);
                // lo asignamos
                preDV.append(predigitoVerificadorStr);

                if (predigitoVerificadorStr.length() <= 1) {
                    preDV.insert(0, '0');
                }

                // lo asigno a digitoVerificador
                this.digitoVerificador = Integer.parseInt(preDV.toString());

                /*
                 * System.out.println("No elementos l1 " + listaDigitos.size());
                 * System.out.println("No elementos l2 " + ListaPotenciadores.size()); for
                 * (Integer z : listaDigitos) { System.out.println(z); } for (Integer v :
                 * ListaPotenciadores) { System.out.println(v); }
                 */

                estadoDigito = true;

            } catch (ExcepcionRFC e) {
                System.out.println(e.getMessage() + "Intente de nuevo usando el formato correcto!");
            }

        } while (estadoDigito == false);

        return this.digitoVerificador;
    }
    // termina digito verificador

    public int getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public String getRFC() {
        return this.RFC;
    }

    // metodo toSting
    public String toString() {
        return "Referencia: " + clave + getRFC() + getFechaCondenzada() + getMontoCondensado() + getDigitoVerificador();
    }

}
