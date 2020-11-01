public class EsNumero {
    
    public static boolean esNumero(String posibleNumero){
        try{
            Integer.parseInt(posibleNumero);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
