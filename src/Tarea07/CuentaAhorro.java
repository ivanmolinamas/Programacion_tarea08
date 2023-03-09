package Tarea07;

/**
 *
 * @author IVAN
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteresAnual;

    public CuentaAhorro(double tipoInteresAnual, Persona Titular, double saldo, String IBAN) {
        super(Titular, saldo, IBAN);
        this.tipoInteresAnual = tipoInteresAnual;
    }

    public double getTipoInteresAnual() {
        return tipoInteresAnual;
    }

    public void setTipoInteresAnual(double tipoInteresAnual) {
        this.tipoInteresAnual = tipoInteresAnual;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString() + ", tipoInteresAnual= " + tipoInteresAnual ;
    }
}
