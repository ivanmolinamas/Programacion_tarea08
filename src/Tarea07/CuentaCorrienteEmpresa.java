
package Tarea07;

/**
 *
 * @author IVAN
 */
public class CuentaCorrienteEmpresa extends CuentaCorriente {

    private double maximoDescubierto;
    private double tipoIneteresDescubierto;
    private double comisionFijaDescubierto;

    public CuentaCorrienteEmpresa(double maximoDescubierto, double tipoIneteresDescubierto, double comisionFijaDescubierto, String listaEntidades, Persona Titular, double saldo, String IBAN) {
        super(listaEntidades, Titular, saldo, IBAN);
        this.maximoDescubierto = maximoDescubierto;
        this.tipoIneteresDescubierto = tipoIneteresDescubierto;
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }

    public double getMaximoDescubierto() {
        return maximoDescubierto;
    }

    public void setMaximoDescubierto(double maximoDescubierto) {
        this.maximoDescubierto = maximoDescubierto;
    }

    public double getTipoIneteresDescubierto() {
        return tipoIneteresDescubierto;
    }

    public void setTipoIneteresDescubierto(double tipoIneteresDescubierto) {
        this.tipoIneteresDescubierto = tipoIneteresDescubierto;
    }

    public double getComisionFijaDescubierto() {
        return comisionFijaDescubierto;
    }

    public void setComisionFijaDescubierto(double comisionFijaDescubierto) {
        this.comisionFijaDescubierto = comisionFijaDescubierto;
    }
  @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+ ", maximoDescubierto= " + maximoDescubierto + ", tipoIneteresDescubierto= " + tipoIneteresDescubierto + ", comisionFijaDescubierto= " + comisionFijaDescubierto ;
    } 
  
}
