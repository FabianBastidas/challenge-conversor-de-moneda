import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner teclado = new Scanner(System.in); //Entrada del usuario
        ConsultaMoneda consulta = new ConsultaMoneda();
        String historial;
        LocalDateTime tiempo;
        String base;
        String conv;
        double valor;
        int caso = 0;
        Strings letras = new Strings();



        try {
       while (caso != 10){
           Historial conversion = new Historial();
           Conversor moneda = new Conversor(0);
           System.out.println("********************************************************");
           System.out.println("Sea bienvenido/a al COnversor de Moneda :)");
           System.out.println("\n"+ letras.menu());
           System.out.println("********************************************************");
           caso = Integer.parseInt(teclado.nextLine());

           switch (caso) {

               case 1:
                   base = "USD";
                   conv = "ARS";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv,valor);
                   historial ="EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                                        + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 2:
                   base = "ARS";
                   conv = "USD";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv, valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 3:
                   base = "USD";
                   conv = "BRL";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv,valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 4:
                   base = "BRL";
                   conv = "USD";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv, valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 5:
                   base = "USD";
                   conv = "COP";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv,valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 6:
                   base = "COP";
                   conv = "USD";
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv, valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 7:
                   System.out.println("Ingrese el código en Mayusculas de la moneda base: ");
                   base  = teclado.nextLine();
                   System.out.println("Ingrese el código en Mayusculas de la moneda a la que va a convertir: ");
                   conv  = teclado.nextLine();
                   System.out.println("Ingrese el valor que desea convertir: ");
                   valor  = Double.parseDouble(teclado.nextLine());
                   moneda = consulta.consultaApi(base, conv,valor);
                   historial = "EL valor " + valor +" ["+base+"] corresponde al valor de =>>> "
                           + moneda.conversion_result() + " ["+conv+"]";
                   tiempo = LocalDateTime.now();
                   conversion.Historial(historial,tiempo);
                   consulta.historialDeConversiones(conversion);
                   System.out.println(historial);
                   break;
               case 8:
                   System.out.println("***************************************");
                   System.out.println("CÓDIGOS ADMITIDOS");
                   System.out.println(" ");
                   System.out.println(letras.codigos());
                   break;
               case 9:
                   System.out.println("***************************************");
                   System.out.println("HISTORIAL DE CONVERSIONES");
                   System.out.println(" ");
                   for (Historial lista : consulta.getListaDeConversiones()) {
                       System.out.println("Fecha y hora: "+lista.getTiempo()+ " -  Conversión: "+ lista.getHistorial() );
                   }
                   break;
               case 10:
                   System.out.println("Finalizando el programa. Gracias por usar nuestros servcios!");
                   break;
               default:
                   System.out.println("La opción es incorrecta, verifique nuevamente");
           }


       }
        } catch (NumberFormatException e){
            System.out.println("Escribiste algo diferente a un número " + e.getMessage());
        }


//
//
//


    }

}
