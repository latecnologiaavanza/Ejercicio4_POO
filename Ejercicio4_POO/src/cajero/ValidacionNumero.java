package cajero;
public class ValidacionNumero {
      public static boolean isNum(String cadena){
           try{
                int numero = Integer.parseInt(cadena);
                return true;
                
           }catch(NumberFormatException error){
                System.out.println(error);
                return false;
           }
      }
}
