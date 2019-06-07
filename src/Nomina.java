/**
 * Clase que se encarga de abstraer una cuenta de Nómina
 * @author Sus nombres
 * @author Sus nombres
 * @author Sus nombres
 * @version 1.0;
 */
public class Nomina implements Cuenta{
    private String nombre;
    private int numeroCliente;
    private int numeroCuenta;
    private double saldo;
    private String fechaApertura;
    private int numeroSucursal;
    private boolean estado;
    private String correo;
    private String telefono;
    private String rfc;
    private String nombreEmpresa;
    private String fechaDeposito;

    /**
     * Constructor con los datos necesarios para la creación de una cuenta de Nómina
     * @param nombre Nombre del cliente
     * @param numeroCliente Numero del cliente
     * @param numeroCuenta Numero de cuenta
     * @param saldo Saldo incial de la cuenta
     * @param fechaApertura Fecha de apertura de la cuenta
     * @param numeroSucursal Numero de sucursal generada aleatoriamente
     * @param correo Correo del cliente
     * @param telefono Teléfino del cliente
     * @param rfc RFC de la empresa en la que trabaja el cliente
     * @param nombreEmpresa Nombre de la empresa en la que trabaja el cliente
     * @param fechaDeposito Fecha de depósito de la empresa en la que trabaja el cliente
     * @param estado Estado de la cuenta.
     */
    public Nomina(String nombre, int numeroCliente, int numeroCuenta, double saldo, 
                  String fechaApertura, int numeroSucursal, String correo, String telefono,
                  String rfc, String nombreEmpresa, String fechaDeposito, boolean estado) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroSucursal = numeroSucursal;
        this.correo = correo;
        this.telefono = telefono;
        this.rfc = rfc;
        this.estado = estado;
    }

    public Nomina() {}

    /**
     * Método que nos develve la representación en cadena amigable para el ususario de los 
     * datos de la cuenta.
     * @return Representación en cadena amistosa de los datos de la cuenta.
     */
    public String toString() {
        String cadena = "Tipo de cuenta: Nomina\n";
        cadena += String.format("Nombre: %s\nNumero de cliente: %d\nNumero de cuenta: %d\nSaldo: %f\nFecha de apertura: %s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %s\nRFC de la empresa: %s\nNombre de la empresa: %s\nFecha de deposito: %s", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito);
        return cadena;
    }

    /**
     * Método que nos permite acceder al nombre del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Nombre del cliente
     */
    @Override
    public String getNombreCliente() {
        return this.nombre;
    }

    /**
     * Método que nos permite acceder al número del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número del cliente
     */
    @Override
    public int numeroCliente() {
        return this.numeroCliente;
    }

    /**
     * Método que nos permite acceder al fecha de apertura registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Fecha de apertura de la cuenta.
     */
    @Override
    public String getFechaApertura() {
        return this.fechaApertura;
    }

    /**
     * Método que nos permite acceder al número de sucursal registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número de sucursal.
     */
    @Override
    public int getNueroSucursal() {
        return this.numeroSucursal;
    }

    /**
     * Método que nos permite acceder al estado de la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Estado de la cuenta
     */
    @Override
    public boolean getEstadoCuenta() {
        return this.estado;
    }

    /**
     * Método que nos permite acceder al correo electrónico del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Correo electrónico del cliente
     */
    @Override
    public String getCorreroElectronico() {
        return this.correo;
    }

    /**
     * Método que nos permite acceder al nombre del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Nombre del cliente
     */
    @Override
    public String getNumeroTelefono() {
        return this.telefono;
    }

    /**
     * Método que nos permite acceder al número de cuenta del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número de cuenta del cliente
     */
    @Override
    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }

    /**
     * Método que nos permite acceder al número del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número del cliente
     */
    @Override
    public int getNumeroCliente() {
        return this.numeroCliente;
    }

    /**
     * Método que nos permite acceder al tipo de cuenta manteniendo el
     * encapsulamiento de datos.
     * @return tipo de cuenta
     */
    @Override
    public String getClase() {
        return "nomina";
    }

    /**
     * Método que nos permite acceder al RFC de la empresa donde lavora el cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return RFC de la empresa donde lavora el cliete
     */
    @Override
    public String getRfcEmpresa() {
        return this.rfc;
    }
    
    /**
     * Método que nos permite acceder al salde del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Saldo cliete
     */
    @Override
    public double getSaldo() {
        return this.saldo;
    }

    /**
     * Método que nos permite acceder al importe cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Importe cliete
     */
    @Override
    public double getImporte() {
        return 0;
    }

    /**
     * Método que nos permite acceder al la fecha de pago del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Fecha de pago del cliete
     */
    @Override
    public String getFechaPago() {
        return fechaDeposito;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param nombre Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void setNombreCliente(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param fecha Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void setFechaApertura(String fecha) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param estado Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param correo Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void setCorreoElectronico(String correo) {
        this.correo = correo;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param telefono Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void setNumeroTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param numeroCuenta Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param rfc Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param nombreEmpresa Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param fechaDeposito Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setFechaDeposito(String fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param deposito Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void deposito(double deposito) {
        this.saldo += deposito;
    }

    /**
     * Método que nos indica si se puede modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param reposito Nuevo valor para el atributo de clase con el mismo nombre.
     * @return <true> En caso se tener los fondos suficientes </true>
     *         <false> En caso contrario </false>
     */
    @Override
    public boolean retiroValido(double retiro) {
        if (retiro <= this.saldo) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param retiro Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void efectuaRetiro(double retiro) {
        this.saldo -= retiro;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param retiro Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void incrementaMontoRetirado(double retiro) {

    }

    /**
     * Método que se encarga de regresar los dato de la cuenta separados por una coma para mantener
     * persistencia
     * @return Representación en cadena de los datos de la cuenta para su posterior almacenamiento.
     */
    @Override
    public String paraAlmacenar() {
        String representacion; 
        if (estado == true) {
            representacion = "activo"; 
        } else {
            representacion =  "inactivo";
        }                                 
        return String.format("nomina,%s,%d,%d,%f,%s,%d,%s,%s,%s,%s,%s,%s", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito, representacion);
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param pago Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void pagoCredito(double pago) {

    }

    /**
     * Método que nos permite acceder a la variable manteniendo el encapsulamiento de datos.
     * @return Variable indicada por el método
     */
    @Override
    public int getNumeroTarjeta() {
        return 0;
    }
}