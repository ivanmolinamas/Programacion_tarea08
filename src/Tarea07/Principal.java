package Tarea07;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ivan Molina Mas
 */
public class Principal {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        
        // se declaran las variables necesarias fuera del bucle
        String nombreTitular, apellidosTitular, DNITitular, IBAN, listaEntidades, listaEntidadesEmp, buscaIBAN;
        double saldo, tipoInteres, mantenimientoPer, maxDescubierto, interesDescubierto, comisionDescubierto, ingreso, retirar, obtenersaldo;
        int opcionCuenta;
        String[] listaCuentas;
        int menu;
        boolean salir = true;
        boolean menuCuenta = false;
        boolean checkIBAN = false;

        Banco banco = new Banco();
        Persona titular;
        CuentaBancaria cuenta = null;

        //con un while se crea el bucle del menu hasta seleccionar el 7,
        // la variable salir es un booleano con true, en la opcion 7 el booleano es false.
        
        while (salir) {

            try {

                System.out.println("");
                System.out.println("Menu Principal");
                System.out.println("1 - Abrir una nueva cuenta");
                System.out.println("2 - Ver un listado de las cuents disponibles.");
                System.out.println("3 - Obtener los datos de una cuenta concreta.");
                System.out.println("4 - Realizar ingreso en una cuenta.");
                System.out.println("5 - Retirar efectivo de una cuenta.");
                System.out.println("6 - Consultar el saldo actual de una cuenta.");
                System.out.println("7 - Salir de la apliacion.");

                menu = sc.nextInt();
                sc.nextLine();

                System.out.println("opcion: " + menu);
                switch (menu) {
                    case 1:
                        //Abrir una nueva cuenta

                        // datos para crear la persona
                        System.out.println("Introduce el nombre del titular");
                        nombreTitular = sc.next();
                        System.out.println("Introduce los apellidos del titular");
                        apellidosTitular = sc.next();
                        System.out.println("Introduce el DNI del titular");
                        DNITitular = sc.next();

                        titular = new Persona(nombreTitular, apellidosTitular, DNITitular);
                        //se pide el IBAN
                        do {
                            System.out.println("Introduzca el IBAN");
                            IBAN = sc.next();
                            if (!IBAN.matches("^ES[0-9]{20}$")) {
                                System.out.println("El IBAN no tiene el formato correcto");
                                checkIBAN = false;
                            } else {
                                System.out.println("IBAN correcto");
                                checkIBAN = true;
                            }
                        } while (!checkIBAN);

                        System.out.println("Introduce saldo inicial");
                        saldo = sc.nextDouble();

                        do {
                            System.out.println("Elige el tipo de cuenta");
                            System.out.println("1 - Cuenta de Ahorro");
                            System.out.println("2 - Cuenta Corriente Personal");
                            System.out.println("3 - Cuenta Corriente Empresa");
                            opcionCuenta = sc.nextInt();

                            switch (opcionCuenta) {
                                case 1:
                                    // Cuenta de Ahorro
                                    System.out.println("Introduzca el tipo de interes");
                                    tipoInteres = sc.nextDouble();

                                    //Se crae la cuenta Ahorro
                                    cuenta = new CuentaAhorro(tipoInteres, titular, saldo, IBAN);

                                    menuCuenta = true;
                                    break;

                                case 2:
                                    // Cuenta corriente personal
                                    System.out.println("Introduzca lista de entidades autorizadas para cobrar recibos domciliados");
                                    listaEntidades = sc.next();

                                    System.out.println("Introduzca comision de mantenimiento anual");
                                    mantenimientoPer = sc.nextDouble();

                                    //Se crea la cuenta corriente personal
                                    cuenta = new CuentaCorrientePersonal(mantenimientoPer, listaEntidades, titular, saldo, IBAN);

                                    menuCuenta = true;
                                    break;

                                case 3:
                                    // Cuenta corriente Empresa
                                    System.out.println("Introduzca lista de entidades autorizadas para cobrar recibos domciliados");
                                    listaEntidadesEmp = sc.next();

                                    System.out.println("Introduzca comision por descubierto");
                                    comisionDescubierto = sc.nextDouble();

                                    System.out.println("Introduzca maximo descubierto permitido");
                                    maxDescubierto = sc.nextDouble();

                                    System.out.println("Introduzca interes por descubierto");
                                    interesDescubierto = sc.nextDouble();

                                    //Se crea la cuenta Empesa
                                    cuenta = new CuentaCorrienteEmpresa(maxDescubierto, interesDescubierto, comisionDescubierto, listaEntidadesEmp, titular, saldo, IBAN);

                                    menuCuenta = true;
                                    break;
                                default:
                                    System.out.println("Opcion incorrecta");
                                    menuCuenta = false;
                            }
                        } while (!menuCuenta);

                        if (banco.abrirCuenta(cuenta)) {
                            System.out.println("Se ha abierto la cuenta correctamente");
                        } else {
                            System.out.println("Ha habido un error y no se ha podido abrir la cuenta");
                        }

                        break;
                    case 2:
                        //Ver un listado de las cuents disponibles (código de cuenta, titular y saldo actual)
                        listaCuentas = banco.listadoCuentas();
                        for (int i = 0; i < listaCuentas.length; i++) {
                            System.out.println(listaCuentas[i]);
                        }

                        break;
                    case 3:
                        //Obtener los datos de una cuenta concreta. 
                        // se pide el iban
                        System.out.println("Introduce el IBAN de la cuenta para obtener datos");
                        buscaIBAN = sc.next();
                        // con un if llamamos al metodo informacionCuenta y le pasamos el argumento de la variabel iban pedida
                        // si encuentra imprime información, si es null imprimimos que no existe
                        if (banco.informacionCuenta(buscaIBAN) != null) {
                            System.out.println(banco.informacionCuenta(buscaIBAN));
                        } else {
                            System.out.println("Cuenta no encontrada");
                        }
                        break;
                    case 4:
                        // Realizar ingreso en una cuenta
                        System.out.println("Introduzca el IBAN");
                        buscaIBAN = sc.next();
                        System.out.println("Introduzca el importe a ingresar");
                        ingreso = sc.nextDouble();
                        if (banco.ingresoCuenta(buscaIBAN, ingreso) == true) {
                            System.out.println("Ingreso realizado con exito");
                        } else {
                            System.out.println("No se pudo realizar el ingreso");
                        }

                        break;
                    case 5:
                        //Retirar efectivo de una cuenta
                        System.out.println("Introduzca el IBAN");
                        buscaIBAN = sc.next();
                        System.out.println("Introduzca el importe a retirar");
                        retirar = sc.nextDouble();
                        if (banco.retiradaCuenta(buscaIBAN, retirar) == true) {
                            System.out.println("Retirada realizada con exito");
                        } else {
                            System.out.println("No se pudo realizar la retirada");
                        }

                        break;
                    case 6:
                        //Consultar el saldo actual de una cuenta
                        System.out.println("Introduzca el IBAN");
                        buscaIBAN = sc.next();

                        if (banco.obtenerSaldo(buscaIBAN) != -1) {
                            obtenersaldo = banco.obtenerSaldo(buscaIBAN);
                            System.out.println("El saldo es: " + obtenersaldo);
                        } else {
                            System.out.println("No existe la cuenta");
                        }

                        break;
                    case 7:
                        System.out.println("Salir de la apliacion");
                        salir = false;
                        //Salir de la apliacion
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("Escriba un numero");
                sc.next();
            }

        }
        System.out.println("Hasta luego!");
    }

}
