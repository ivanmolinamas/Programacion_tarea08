package Tarea07;

import java.util.*;

/**
 *
 * @author ivanm
 */
public class Banco {

    // se creara un ArrayList para almacenar cuentas
    // un ArrayList es la mejor opcion aqui ya que tenemos una lista dinamica y ordenada
    private ArrayList<CuentaBancaria> cuentas;

//    private CuentaBancaria[] cuentas;
//    private final int MAX_CUENTAS = 100;
    //constructor para crear el array
    public Banco() {
        this.cuentas = new ArrayList<>();
//        this.cuentas = new CuentaBancaria[this.MAX_CUENTAS];
        
    }

    //metodo abrir cuenta
    public boolean abrirCuenta(CuentaBancaria cuenta) {
        // comprueba que hay espacio en el array
//        if (this.numeroCuentas >= this.MAX_CUENTAS) {
//            System.out.println("El sistema esta lleno");
//            return false;
//        }
        // comprueba que la cuenta no existe
        CuentaBancaria existe = this.buscarCuenta(cuenta.getIBAN());
        if (existe != null) {
            System.out.println("La cuenta bancaria ya existe");
            return false;
        }
        // si hay espacio y no existe, se añade la cuenta al array y se devuelve true
        this.cuentas.add(cuenta);
//        this.cuentas[this.numeroCuentas] = cuenta;
        
        return true;
    }

    /*
    Busca la cuenta bancaria con IBAN pasado por argumento con un bucle for
     */
    private CuentaBancaria buscarCuenta(String IBAN) {
        // con un bucle for se ba buscando hasta donde haya cuentas
        // con el contador numeroCuentas, si existe se devuelve el objeto
//        for (int i = 0; i < numeroCuentas; i++) {
//            if (this.cuentas[i].getIBAN().equals(IBAN)) {
//                return this.cuentas[i];
//            }
//        }
//        return null;

        for (CuentaBancaria bcuenta : cuentas) {
            if (bcuenta.getIBAN().equals(IBAN)) {
                return bcuenta;
            }
        }
        return null;
    }

    /*
    Metodo para listar cuentas, se crea un array de tipo String
    la longitud es la misma que la variable numeroCuentas, que es la que tiene el tamaño de las cuentas actual
    con un bucle for se van añadiendo el devolverInfoString a cada infocuentas del array
     */
//    public ArrayList<String> listadoCuentas() {
    public String[] listadoCuentas() {
        String[] infoCuentas = new String[this.cuentas.size()];
        for (int i = 0; i < infoCuentas.length ; i++) {
            infoCuentas[i] = this.cuentas.get(i).devolverInfoString();
        }
        return infoCuentas;
//        ArrayList<String> infoCuentas = new ArrayList<>();
        
//        for (int i = 0; i < cuentas.size(); i++) {
//            infoCuentas.add(this.cuentas.get(i).devolverInfoString());
//        }
//        return infoCuentas;
//        
    }

    //metodo para devolver un String con la información de la cuenta
    public String informacionCuenta(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.devolverInfoString();
        }
        return null;
        
    }
// metodo para ingresar en cuenta

    public boolean ingresoCuenta(String IBAN, double ingreso) {
        //se crea un objeto CuentaBancaria llamada C para meterle el IBAN que se busca
        //si encuentra el IBAN metera la info el el objeto en caso contrario sera null
        // si es null el if devolera false, si hay info, se añadira el saldo con los metodos set y la suma del saldo 
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            c.setSaldo(c.getSaldo() + ingreso);
            return true;
        }
        return false;
    }
    
    public boolean retiradaCuenta(String IBAN, double retirada) {
        /*
        se crea un objeto CuentaBancaria llamada C para meterle el IBAN que se busca
        si encuentra el IBAN metera la info el el objeto en caso contrario sera null
        dado que CuentaCorrienteEmpresa puede retirar hasta el limite que le hemos dado por variable
        usaremos ese valor para hacer que las cuentas de tipo CuentaCorriente se pueda retirar hasta dicho limite
        Para ello primero obtenemos el saldo, restamos la retirada que vamos a hacer, y en caso que sea mayor de 0 seguimos
        haciendno el booleano sePuedeRetirar en true
        añadimos un else if, para hacer un instanceof con CuentaCorrienteEmpresa.
        si es de ese tipo, entonces, con un auxiliar de tipo CuentaCorrienteEmpresa, obtendremos el maximo descubierto
        y con un if comprobaremos si el saldo que deseamos retirar junto al disponible esta en el limite del maximo descubierto
        si es correcto seguimos, poniendo el booleano en true, en caso contrario, seguimos.
        al estar el booleano en false, no seguiria con el siguiente if y se devolveria un false.
         */
        
        CuentaBancaria c = this.buscarCuenta(IBAN);
        
        if (c != null) {
            boolean sePuedeRetirar = false;
            
            if (c.getSaldo() - retirada >= 0) {
                sePuedeRetirar = true;
            } else if (c instanceof CuentaCorrienteEmpresa) {
                CuentaCorrienteEmpresa aux = (CuentaCorrienteEmpresa) c;
                if (Math.abs(c.getSaldo() - retirada) <= aux.getMaximoDescubierto()) {
                    sePuedeRetirar = true;
                }
            }
            if (sePuedeRetirar) {
                c.setSaldo(c.getSaldo() - retirada);
            }
            
            return sePuedeRetirar;
        }
        return false;
    }

    /*
    Metodo para obtener saldo, se aisgna CuentaBancaria a buscar cuenta con el IBAN
    si el metodo devuelve un null se retorna -1 si es contrario, se usa el metodo getsaldo.
     */
    public double obtenerSaldo(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            return c.getSaldo();
        }
        return -1;
    }
    
    public boolean cerrarCuenta(String IBAN) {
        CuentaBancaria c = this.buscarCuenta(IBAN);
        if (c != null) {
            for (CuentaBancaria cuenta : cuentas) {
                if (cuenta.getIBAN().equals(IBAN) && cuenta.getSaldo() == 0) {
                    this.cuentas.remove(cuenta);
                    return true;
                }
            }            
        }
        
        return false;
    }

    public boolean cerrarCuentaB(String IBAN) {
        CuentaBancaria ccuenta = this.buscarCuenta(IBAN);
        if (ccuenta != null) {
            if (ccuenta.getSaldo() == 0) {
                cuentas.remove(ccuenta);
                return true;
            }
        }
        return false;
        
    }
    
}
