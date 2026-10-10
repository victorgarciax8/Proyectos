package proyectoalgoritmos;
import java.util.Scanner;

public class ProyectoAlgoritmos {
/*
Codigo Hecho Por:
Víctor Hugo García Orellana
1890-26-10752

Esta apunto de presenciar un codigo que ni yo mismo se como lo hice, pero aqui esta de alguna forma
Nota para cuando vuelva abrir el programa, porfavor buscar en youtube como decorar la terminal o el sout
para que no se vea tan simple y feo.
    
PD: borrar comentarios, si los estan leyendo es porque se me olvido AJJAJA
 */ 

    public static void main(String[] args) {
        //scanner
        Scanner teclado = new Scanner(System.in);
        //variables importantes para el funcionamiento del programa
        int operacion;
        int operacion2;
        int confirmarSalida;
        boolean salir = false;

        /*variables de registro de ventas
        Caracteristicas del producto*/
        int numeroProductosVenta = 0;
        int codigoProducto = 0;
        String nombreProducto = "";
        double precioProducto = 0;
        int cantidadProducto = 0;

        //variables para calcular el total de ventas
        double subtotalProducto = 0;
        double subtotalVenta = 0;
        double descuento = 0;
        double porcentajeDescuento = 0;
        double montoConDescuento = 0;
        double iva = 0;
        double totalVenta = 0;

        //variable para el total de productos que vendemos
        int productosVentaActual = 0;

        //Variables para las formas de pago
        String formaPago = "";
        double efectivoRecibido = 0;
        double cambio = 0;

        //Variables para la consulta de caja
        int ventasRealizadas = 0;
        int productosVendidos = 0;
        double totalVendido = 0;
        int ventasEfectivo = 0;
        int ventasTarjeta = 0;
        int ventasTransferencia = 0;

        //variables para estadisticas
        double ventaMayor = 0;
        double ventaMenor = 0;
        double promedioVenta = 0;
        int ventasConDescuento = 0;

//Comienza el programa
        do {
            System.out.println("************************************");
            System.out.println("Elija una de las siguientes opciones");
            System.out.println("1. Registrar una venta");
            System.out.println("2. Consultar caja");
            System.out.println("3. Mostrar estadisticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            operacion = teclado.nextInt();

//validacion, sirve para que el menu se siga ejecutando siempre y cuando este entre el 1 y 4
//mientras la opcion este entre el 1 y 4 todo okey, sino mal mal
            while (operacion < 1 || operacion > 4) {
                System.out.println("La opcion que ingreso no es valida.");
                System.out.print("Ingrese una opcion valida del 1 al 4: ");
                operacion = teclado.nextInt();
            }

//Switch de operaciones logicas, aqui se hace el registro de ventas, ver caja, etc
            switch (operacion) {

//Registro de ventas
                case 1:
//damos los datos del producto y calculamos el valor, forma de pago, etc
                    subtotalVenta = 0;
                    descuento = 0;
                    porcentajeDescuento = 0;
                    montoConDescuento = 0;
                    iva = 0;
                    totalVenta = 0;
                    productosVentaActual = 0;
                    formaPago = "";
                    efectivoRecibido = 0;
                    cambio = 0;
                    System.out.println("************************************");
                    System.out.println("REGISTRO DE VENTA");
                    System.out.println("************************************");

//aqui ingresamos cuantos productos son
                    do 
                      {
                        System.out.print("Ingrese la cantidad de productos diferentes: ");

                        numeroProductosVenta = teclado.nextInt();
                        if (numeroProductosVenta <= 0) {
                            System.out.println("La cantidad de productos no puede ser menor que cero");
                                                       }

                    } 
                    while (numeroProductosVenta <= 0);
                    //aqui registramos los productos y se guardan"
                    for (int i = 0; i < numeroProductosVenta; i++) {
                        System.out.println("Producto " + (i + 1));
                        do 
                           {
                            System.out.print("Codigo del producto: ");
                            codigoProducto = teclado.nextInt();
                            if (codigoProducto <= 0) {
                                System.out.println("El codigo debe ser mayor que cero");
                                                     }
                            } 
                        while (codigoProducto <= 0);
                        System.out.print("Nombre del producto: ");
                        teclado.nextLine();
                        nombreProducto = teclado.nextLine();

                        do 
                            {
                            System.out.print("Precio del producto: Q");
                            precioProducto = teclado.nextDouble();
                            if (precioProducto <= 0) {
                                System.out.println("El precio debe ser mayor que cero");
                                                     }
                            } 
                        while (precioProducto <= 0);
                        do 
                            {
                            System.out.print("Cantidad del producto: ");
                            cantidadProducto = teclado.nextInt();
                            if (cantidadProducto <= 0) {
                                 System.out.println("La cantidad del producto debe ser mayor que cero");
                                                       }
                            } 
                        while (cantidadProducto <= 0);
                        //aqui calculamos el subtotal del producto
                        subtotalProducto = precioProducto * cantidadProducto;
                        //el subtotal de la venta completa
                        subtotalVenta = subtotalVenta + subtotalProducto;
                        //El total de los productos que vendemos
                        productosVentaActual = productosVentaActual + cantidadProducto;
                        //El resultado
                        System.out.printf("Subtotal: Q%.2f%n", subtotalVenta);
                                                                    }              
                    //aqui se calculan los descuentos
                    System.out.println("************************************");
                    System.out.println("CALCULO DE VENTA");
                    System.out.println("************************************");
                    if (subtotalVenta < 200) {
                        porcentajeDescuento = 0;
                                             }
                    else if (subtotalVenta >= 200 && subtotalVenta < 500) {
                        porcentajeDescuento = 0.05;
                                                                          }
                    else if (subtotalVenta >= 500 && subtotalVenta < 1000) {
                        porcentajeDescuento = 0.08;
                                                                           }
                    else {
                        porcentajeDescuento = 0.10;
                         }
                    descuento = subtotalVenta * porcentajeDescuento;
                    montoConDescuento = subtotalVenta - descuento;
                    iva = montoConDescuento * 0.12;
                    totalVenta = montoConDescuento + iva;
                    //procesos de forma de pago
                    do {
                        System.out.println("************************************");
                        System.out.println("FORMAS DE PAGO");
                        System.out.println("************************************");
                        System.out.println("1. Efectivo");
                        System.out.println("2. Tarjeta");
                        System.out.println("3. Transferencia");
                        System.out.print("Seleccione una opcion: ");
                        operacion2 = teclado.nextInt();
                        //Validacion es decir que mientras las opciones esten en 1 y 3 todo nice
                        if (operacion2 < 1 || operacion2 > 3) {
                            System.out.println("La operacion que eligio no es valida");
                        }
                    } while (operacion2 < 1 || operacion2 > 3);
                    //switch de la forma de pago
                    switch (operacion2) {
                        //Efectivo
                        case 1:
                            formaPago = "Efectivo";
                            System.out.println("************************************");
                            System.out.println("\nLa forma de pago es por efectivo.");
                            System.out.print("Ingrese el efectivo recibido: Q");
                            efectivoRecibido = teclado.nextDouble();
                            
                            //esto sirve por si el dinero que nos dieron no alcanza para pagar el total de la compra
                            while (efectivoRecibido < totalVenta) {
                                //aqui miramos si el dinero que nos dio fue suficiente para pagar la compra o no
                                System.out.println("************************************");
                                System.out.println("El efectivo no es suficiente");
                                System.out.println("(\"Ingrese nuevamente la cantidad de efectivo: Q\");");
                                efectivoRecibido = teclado.nextDouble();
                                                                  }
                            cambio = efectivoRecibido - totalVenta;
                            ventasEfectivo++;
                            break;    
                        //Tarjetazo
                        case 2:
                            formaPago = "Tarjeta";
                            System.out.println("************************************");
                            System.out.println("\nLa forma de pago es por tarjeta.");
                            ventasTarjeta++;
                            break;
                        //transferencia
                        case 3:
                            formaPago = "Transferencia";
                            System.out.println("************************************");
                            System.out.println("\nLa forma de pago es por transferencia.");                        
                            ventasTransferencia++;
                            break;
                            /*Cada uno de las variables que termian en ++ son los acumuladores, sumadores o como se les diga
                            esto hace que mientras el programa esta funcionando vaya sumando las ventas por transferencia, tarjeta y efectivo
                            entonces en estadisticas vamos a poder ver cuantas hicimos de cada y asi*/
                            
                    }//termino el resgistro de ventas
                    
                    //Empieza caja
                    // Contador de ventas realizadas
                    ventasRealizadas++;
                    // Acumulador de productos vendidos, osea suma cuantos productos hemos vendido y despues podemos verlo
                    productosVendidos = productosVendidos + productosVentaActual;
                    // Acumulador del dinero de ventas, lo mismo que el de arriba jaajajaj. Ayuda no se cuanto llevo en esto
                    totalVendido = totalVendido + totalVenta;

                    //Empiezan las estadisticas
                    if (descuento > 0) {
                        ventasConDescuento++;
                                       }
                    if (ventasRealizadas == 1) {
                        ventaMayor = totalVenta;
                        ventaMenor = totalVenta;
                                                } 
                    else {

                        if (totalVenta > ventaMayor) {
                            ventaMayor = totalVenta;
                                                     }
                        
                        if (totalVenta < ventaMenor) {
                            ventaMenor = totalVenta;
                                                     }
                        }
                    //resumen de las venta o ventas
                    System.out.println("************************************");
                    System.out.println("RESUMEN DE LA VENTA");
                    System.out.println("************************************");
                    System.out.printf("Subtotal: Q%.2f%n", subtotalVenta);
                    System.out.printf("Descuento: Q%.2f%n", descuento);
                    System.out.printf("Monto con descuento: Q%.2f%n", montoConDescuento);
                    System.out.printf("IVA: Q%.2f%n", iva);
                    System.out.printf("Total: Q%.2f%n", totalVenta);
                    //informacion extra em en caso de que el pago sea en efectivo
                    if (operacion2 == 1) {
                    System.out.printf("Efectivo recibido: Q%.2f%n", efectivoRecibido);
                    System.out.printf("Cambio: Q%.2f%n", cambio);
                                         }
                    break;

                //Aqui pasamos ya a consultar caja
                case 2:
                    System.out.println("************************************");
                    System.out.println("CONSULTAR CAJA");
                    System.out.println("************************************");
                    System.out.println("Ventas realizadas: " + ventasRealizadas);
                    System.out.println("Productos vendidos: " + productosVendidos);
                    System.out.printf("Total vendido: Q%.2f%n", totalVendido);
                    System.out.println("Ventas en efectivo: " + ventasEfectivo);
                    System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                    System.out.println("Ventas por transferencia: " + ventasTransferencia);
                    break;


                 //Estadistias
                case 3:
                    if (ventasRealizadas == 0) {
                        System.out.println( "\nNo existen ventas registradas.");
                                               } 
                    else 
                    {
                        promedioVenta = totalVendido / ventasRealizadas;
                        
                        System.out.println("************************************");
                        System.out.println("ESTADISTICAS");
                        System.out.println("************************************");
                        System.out.println("Numero total de ventas: " + ventasRealizadas);
                        System.out.println("Cantidad total de productos vendidos: " + productosVendidos);
                        System.out.printf("Promedio de dinero por venta: Q%.2f%n", promedioVenta);
                        System.out.println("Ventas en efectivo: " + ventasEfectivo);
                        System.out.println("Ventas con tarjeta: " + ventasTarjeta);
                        System.out.println("Ventas por transferencia: " + ventasTransferencia);
                        System.out.printf("Venta de mayor valor: Q%.2f%n", ventaMayor);
                        System.out.printf("Venta de menor valor: Q%.2f%n", ventaMenor);
                        System.out.println("Ventas que recibieron descuento: " + ventasConDescuento);                     
                    }
                    break;
                //salir del programa
                case 4:
                    do {
                        System.out.println("\n Seguro que quiere salir?"); 
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        System.out.print("Seleccione una opcion: ");
                        confirmarSalida = teclado.nextInt();
                        if (confirmarSalida < 1 || confirmarSalida > 2) {
                            System.out.println("Opcion no valida.");
                                                                        }
                        } 
                    while (confirmarSalida < 1 || confirmarSalida > 2);
                    
                    if (confirmarSalida == 1) {
                        salir = true;
                        System.out.println("Gracias por utilizar el sistema.");
                    } 
                    else{

                        System.out.println("Regresando al menu");       
                        }
                    break;
            }

        } while (!salir);
        teclado.close();
    }
}

