package com.Meza;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Cuenta> cuentas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        System.out.println("<><><><>Bienvenido<><><><>");
        while (true){
            System.out.println("(1) Crear una cuenta");
            System.out.println("(2) Depositar");
            System.out.println("(3) Retirar");
            System.out.println("(4) Mostrar informacion de una cuenta");
            System.out.println("(5) Mostrar cuentas");
            System.out.println("(6) Salir");
            System.out.printf("Ingrese su opcion: ");
            int opcion = LectorDeDatos.solicitarEntero("Ingrese una opcion: ");

            switch (opcion){
                case 1:
                    System.out.println("<><><>Creando cuenta nueva<><><>");
                    Random rand = new Random();
                    int numeroCuenta = rand.nextInt(1000);

                    System.out.println("El numero de su nueva cuenta es: " + numeroCuenta);
                    System.out.println("Especifique el tipo de cuenta desea crear");
                    System.out.println("\t1. Cuenta de Ahorro");
                    System.out.println("\t2. Cuenta a Largo Plazo");
                    int tipoCuenta = lector.nextInt();
                    double saldo = LectorDeDatos.solicitarDouble("Ingrese su saldo inicial: ");

                    if (tipoCuenta == 1){
                        CuentaAhorro nuevaCuenta = new CuentaAhorro();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");

                    } else if(tipoCuenta == 2){
                        CuentaLargoPlazo nuevaCuenta = new CuentaLargoPlazo();
                        nuevaCuenta.numCuenta = numeroCuenta;
                        nuevaCuenta.saldo = saldo;
                        cuentas.add(nuevaCuenta);
                        System.out.println("La cuenta ha sido creada!");

                    } else{
                        System.out.println("Tipo de cuenta no existe");

                    }
                    break;

                case 2:
                    boolean j = false;
                    while(j == false) {
                        int deposito = LectorDeDatos.solicitarEntero("Ingrese su numero de cuenta: ");
                        double monto = LectorDeDatos.solicitarDouble("¿Cuanto desea depositar?: ");

                        for (Cuenta c : cuentas) {
                            if (c.numCuenta == deposito) {
                                c.depositar(monto);
                                String tipo = "";
                                if (c instanceof CuentaAhorro)
                                    tipo = "Ahorro";
                                else if (c instanceof  CuentaLargoPlazo)
                                    tipo = "Largo Plazo";
                                System.out.println("Numero de Cuenta: " + c.numCuenta + "  Con un saldo de: " + c.saldo + "  Siendo una cuenta de: " + tipo);
                                j = true;
                                break;
                            }
                        }
                        if(j == false){
                            System.out.println("Ese numero de cuenta no existe, por favor ingrese un numero de cuenta valido");
                        }
                    }

                case 3:
                    boolean i = false;
                    while(i == false) {
                        int retiro = LectorDeDatos.solicitarEntero("Ingrese su numero de cuenta: ");
                        double monto = LectorDeDatos.solicitarDouble("¿Cuanto desea retirar?: ");

                        for (Cuenta c : cuentas) {
                            if (c.numCuenta == retiro) {
                                c.retirar(monto);
                                String tipo = "";
                                if (c instanceof CuentaAhorro)
                                    tipo = "Ahorro";
                                else if (c instanceof  CuentaLargoPlazo)
                                    tipo = "Largo Plazo";
                                System.out.println("Numero de Cuenta: " + c.numCuenta + "  Con un saldo de: " + c.saldo + "  Siendo una cuenta de: " + tipo);
                                i = true;
                                break;
                            }
                        }
                        if(i == false){
                            System.out.println("Ese numero de cuenta no existe, por favor ingrese un numero de cuenta valido");
                        }
                    }
                    break;

                case 4:

                    if (cuentas.isEmpty()){
                        System.out.println("<><><>No hay cuentas<><><>");
                    } else {
                        System.out.println("<><><>Informacion de Cuentas<><><>");
                    }
                    while (true){
                        int numCuenta = LectorDeDatos.solicitarEntero("Ingrese el numero de cuenta: ");
                        int n = 0;
                        for (Cuenta c: cuentas) {
                            String tipo = "";
                            if (numCuenta == c.numCuenta){
                                n = 1;
                                if (c instanceof CuentaAhorro)
                                    tipo = "Ahorro";
                                else if (c instanceof CuentaLargoPlazo)
                                    tipo = "Largo Plazo";

                                System.out.println("Cuenta: " + c.numCuenta + "  Con un saldo de: " + c.saldo + "  Siendo una cuenta de: " + tipo);
                            }
                        }
                        if (n == 0)
                            System.out.println("El numero de cuenta no existe");

                        if (numCuenta == -1){
                            break;
                        }
                    }
                    break;

                case 5:
                    if (cuentas.isEmpty()) {
                        System.out.println("<><><>No hay cuentas<><><>");
                    } else {
                        System.out.println("<><><>Mostrando Cuentas<><><>");
                    }
                    for (Cuenta c : cuentas){
                        String tipo = "";
                        if (c instanceof CuentaAhorro)
                            tipo = "Ahorro";
                        else if (c instanceof  CuentaLargoPlazo)
                            tipo = "Largo Plazo";

                        System.out.println("Numero de Cuenta: " + c.numCuenta + " - " + tipo);
                    }
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
            if (opcion == 6){
                break;
            }
        }

    }



}
