package cajero;

import javax.swing.JOptionPane;

public class Cajero {
    
    public int saldo = 900000;
    public String contraseña = "holamundo";
    
    //metodo para mostrar el menu principal
    public void mostrarMenu(){
       int opcion = 0;
       do{
           String cadena = JOptionPane.showInputDialog(null,""
               + "1 . Consultar saldo\n"
               + "2 . Depositar\n"
               + "3 . Retirar\n"
               + "4 . Cambiar clave\n"
               + "5 . Salir");
           
           if(cadena != null && ValidacionNumero.isNum(cadena)){
                opcion = Integer.parseInt(cadena);
                switch(opcion){
                    case 1:
                        consultarSaldo();
                        break;
                        
                    case 2:
                        depositar();
                        break;
                        
                    case 3:
                        retirar();
                        break;
                        
                    case 4:
                        cambiarClave();
                        break;
                             
                    case 5:
                        JOptionPane.showMessageDialog(null,"Gracias por su atención");
                        opcion = 5;
                        break;
                    
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no disponible , vuelva a digitar");
                        break;
                }
           }
           
       }while(opcion != 5);
    }
    
    //Creamos el metodo para depositar
    public void depositar(){
        String cadena;
        int deposito = 0;
        
        cadena = JOptionPane.showInputDialog(null,"Digite la cantidad que desea consignar : ");
        if(cadena != null && !cadena.equals("") && ValidacionNumero.isNum(cadena)){
            deposito = Integer.parseInt(cadena);
            
            if(deposito > 0){
                saldo += deposito;
                JOptionPane.showMessageDialog(null,"El saldo actual es : " + saldo);
            }
            else{
                JOptionPane.showMessageDialog(null,"Digite una cantidad mayor a cero para depositar");
            }
        }
    }
    
    //Metodo para retirar
    public void retirar(){
        String cadena;
        cadena = JOptionPane.showInputDialog(null,"Digite su clave : ");
        
        if(cadena == null){
            //vuelve a la ventana de inicio
        }else{
            if(!cadena.equals("")){
                if(cadena.equals(contraseña)){
                    cadena = JOptionPane.showInputDialog(null,""
                            + "a)5000\n"
                            + "b)10 000\n"
                            + "c)20 000\n"
                            + "d)50 000\n"
                            + "e)100 000\n"
                            + "f)Otra cantidad"); 
                    
                    if(cadena != null){
                        if(!cadena.equals("")){
                             switch(cadena){
                                 case "a":
                                     if((saldo - 5000) >= 10000){
                                         saldo -= 5000;
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                      }
                                     break;
                                     
                                 case "b":
                                     if((saldo - 10000) >= 10000){
                                         saldo -= 10000;
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                     }
                                     break;
                                     
                                 case "c":
                                     if((saldo - 20000) >= 10000){
                                         saldo -= 20000;
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                     }
                                     break;
                                     
                                 case "d":
                                     if((saldo - 50000) >= 10000){
                                         saldo -= 50000;
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                     }
                                     break;
                                     
                                 case "e":
                                     if((saldo - 100000) >= 10000){
                                         saldo -= 100000;
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                     }
                                     break;
                                     
                                 case "f":
                                     cadena = JOptionPane.showInputDialog(null,"Digite la cantidad de dinero retirar : ");
                                     if((cadena != null && !cadena.equals("") && ValidacionNumero.isNum(cadena)) && (saldo - Integer.parseInt(cadena) >= 10000) &&(Integer.parseInt(cadena) > 0)){
                                         saldo -= Integer.parseInt(cadena);
                                         JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
                                     }
                                     break;
                                     
                                 default:
                                     JOptionPane.showMessageDialog(null,"La opcion no existe , vuelva a digitar");
                                     break;
                             }
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"La contraseña es incorrecta");
                }
            }
        } 
    }
    
    //Metodo para cambiar clave
    public void cambiarClave(){
        String auxiliar;
        String contraseñaNueva;
        
        auxiliar = JOptionPane.showInputDialog(null,"Digite su clave actual : ");
        if(auxiliar != null){
            if(!auxiliar.equals("")){
                if(auxiliar.equals(contraseña)){
                     contraseñaNueva = JOptionPane.showInputDialog("Digite su nueva clave : ");
                     if(contraseñaNueva != null){
                         if(!contraseñaNueva.equals("")){
                             if(contraseñaNueva.length() > 3){
                                 auxiliar = null;
                                 auxiliar = contraseña;
                                 JOptionPane.showMessageDialog(null,"Su clave anterior es " + auxiliar);
                                 JOptionPane.showMessageDialog(null,"Su nueva contraseña es : " + contraseñaNueva);
                                 contraseña = contraseñaNueva;
                             }
                             else{
                                 JOptionPane.showMessageDialog(null,"Porfavor digite una clave que tenga mas de 3 letras");
                             }
                         }
                     }
                }
                else{
                    JOptionPane.showMessageDialog(null,"La clave no coincide");
                }
            }
        } 
    }
    
    //Metodo para consultar
    public void consultarSaldo(){
        JOptionPane.showMessageDialog(null,"Su saldo actual es : " + saldo);
    }
}