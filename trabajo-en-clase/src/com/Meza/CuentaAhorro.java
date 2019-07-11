package com.Meza;

public class CuentaAhorro extends Cuenta {

    public final double SALDO_MINIMO_BONO = 50_000;
    public final double INTERES_BONO = .01;

    public boolean depositar(double monto){
        if(monto > SALDO_MINIMO_BONO){
            monto += (monto * INTERES_BONO);
        }
        return super.depositar(monto);
    }
}
