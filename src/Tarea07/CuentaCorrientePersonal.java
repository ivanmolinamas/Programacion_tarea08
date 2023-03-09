package Tarea07;

/**
 *
 * @author IVAN
 */
public class CuentaCorrientePersonal extends CuentaCorriente {

    private double comisionMantenimiento;

    public CuentaCorrientePersonal(double comisionMantenimiento, String listaEntidades, Persona Titular, double saldo, String IBAN) {
        super(listaEntidades, Titular, saldo, IBAN);
        this.comisionMantenimiento = comisionMantenimiento;
    }

    public double getComisionMantenimiento() {
        return comisionMantenimiento;
    }

    public void setComisionMantenimiento(double comisionMantenimiento) {
        this.comisionMantenimiento = comisionMantenimiento;
    }

    @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+ ", comisionMantenimiento= " + comisionMantenimiento;
    }
    
}
