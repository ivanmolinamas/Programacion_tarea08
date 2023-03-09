package Tarea07;

/**
 *
 * @author ivan Molina Mas
 */
public abstract class CuentaBancaria implements Imprimible {

    // creo una objeto que contendra el titular de la clase Persona
    private Persona Titular;
    private double saldo;
    private String IBAN;
//constructor
    public CuentaBancaria(Persona Titular, double saldo, String IBAN) {
        this.Titular = Titular;
        this.saldo = saldo;
        this.IBAN = IBAN;
    }
//Getter and setter
    public Persona getTitular() {
        return Titular;
    }

    public void setTitular(Persona Titular) {
        this.Titular = Titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
// devuelve String con valores del objeto persona llamado titular y los vales
    // de las variables de la clase
    @Override
    public String devolverInfoString() {
        return "CuentaBancaria{" + "Titular= " + Titular.devolverInfoString() + ", saldo= " + saldo + ", IBAN= " + IBAN + '}';
    }
}
