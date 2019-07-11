package com.Meza;

public abstract class Cuenta {

    public int numCuenta;
    public double saldo;
    public final double SALDO_MAX = 10_000_000;

    public boolean retirar(double monto){
        if((saldo - monto) < 0){
            System.out.println("¡Usted no cuenta con los fondos necesarios para hacer este retiro!");
            return false;
        }
        saldo -= monto;
        return true;
    }

    public boolean depositar(double monto){
        if((monto + saldo) > SALDO_MAX){
            System.out.println("¡Este deposito excede la cantida maxima que usted puede tener almacenado!");
            return false;
        }
        saldo += monto;
        return true;
    }
}
