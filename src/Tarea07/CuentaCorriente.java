
package Tarea07;

/**
 *
 * @author IVAN
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    private String listaEntidades;

    public CuentaCorriente(String listaEntidades, Persona Titular, double saldo, String IBAN) {
        super(Titular, saldo, IBAN);
        this.listaEntidades = listaEntidades;
    }

    public String getListaEntidades() {
        return listaEntidades;
    }

    public void setListaEntidades(String listaEntidades) {
        this.listaEntidades = listaEntidades;
    }
    
      @Override
    public String devolverInfoString() {
        return super.devolverInfoString()+ ", listaEntidades= " + listaEntidades ;
    }   
}
