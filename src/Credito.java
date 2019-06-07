/**
 * Clase que se encarga de abstraer una cuenta de Crédito
 * @author Sus nombres
 * @author Sus nombres
 * @author Sus nombres
 * @version 1.0;
 */
public class Credito implements Cuenta{
    private String nombre;
    private int numeroCliente;
    private int numeroTarjeta;
    private double importeCredito;
    private double montoCredito;
    private String fechaApertura;
    private String fechaPago;
    private String fechaVencimiento;
    private int numeroSucursal;
    private boolean estado;
    private String correo;
    private String telefono;

    /**
     * Constructor con los datos necesarios para la creación de una cuenta.
     * @param nombre Nombre del cliente
     * @param numeroCliente Numero del cliente
     * @param numeroTarjeta Número de tarjeta
     * @param importeCredito Importe de crédito
     * @param montoCredito Monto de crédito
     * @param fechaApertura Fecha de apertura de la cuenta
     * @param fechaPago Fecha de pago de la cuenta
     * @param fechaVencimiento Fecha de vencimineto de la tarjeta
     * @param numeroSucursal Número de sucursal
     * @param correo Correo del cliente
     * @param telefono Teléfino del cliente
     * @param estado Estado de la cuenta.
     */
    public Credito (String nombre, int numeroCliente, int numeroTarjeta, double importeCredito, 
                  double montoCredito, String fechaApertura, String fechaPago, String fechaVencimiento,
                  int numeroSucursal,String correo, String telefono, boolean estado) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.importeCredito = importeCredito;
        this.montoCredito = montoCredito;
        this.fechaApertura = fechaApertura;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroSucursal = numeroSucursal;
        this.estado = estado;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Credito() {

    }

    /**
     * Método que nos develve la representación en cadena amigable para el ususario de los 
     * datos de la cuenta.
     * @return Representación en cadena amistosa de los datos de la cuenta.
     */
    public String toString() {
        String cadena = "Tipo de cuenta: Credito\n";
        cadena += String.format("Nombre: %s\nNumero de cliente:%d\nNumero de tarjeta:%4d\nImporte de credito: %f\nMonto de credito:%f\nFecha de apertura: %s\nFecha de pago: %s\nFecha de vencimineto:%s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %s", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono);
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
        return 0;
    }

    /**
     * Método que nos permite acceder al número del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número del cliente
     */
    @Override
    public int getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Método que nos permite acceder al tipo de cuenta manteniendo el
     * encapsulamiento de datos.
     * @return tipo de cuenta
     */
    @Override
    public String getClase() {
        return "credito";
    }
    
    /**
     * Método que nos permite acceder al RFC de la empresa donde lavora el cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return RFC de la empresa donde lavora el cliete
     */
    @Override
    public String getRfcEmpresa() {
        return null;
    }

    /**
     * Método que nos permite acceder al salde del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Saldo cliete
     */
    @Override
    public double getSaldo() {
        return 0;
    }

    /**
     * Método que nos permite acceder al importe cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Importe cliete
     */
    @Override
    public double getImporte() {
        return this.importeCredito;
    }

    /**
     * Método que nos permite acceder al la fecha de pago del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Fecha de pago del cliete
     */
    @Override
    public String getFechaPago() {
        return this.fechaPago;
    }

    /**
     * Método que nos permite acceder al número de la tarjeta del cliete registrado en la cuenta manteniendo el
     * encapsulamiento de datos.
     * @return Número de la tarjeta del cliete
     */
    @Override
    public int getNumeroTarjeta() {
        return this.numeroTarjeta;
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
        this.fechaApertura = fecha;
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
     * @param importeCredito Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setImporteCredito(int importeCredito) {
        this.importeCredito = importeCredito;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param montoCredito Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setMontoCredito(int montoCredito) {
        this.montoCredito = montoCredito;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param fechaPago Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param fechaVencimiento Nuevo valor para el atributo de clase con el mismo nombre.
     */
    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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
        }                                                           // 1         2              3               4             5              6               7           8              9              10       11       12
        return String.format("credito,%s,%d,%4d,%f,%f,%s,%s,%s,%d,%s,%s", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono, representacion);
    }

    /**
     * Método que nos indica si se puede modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param reposito Nuevo valor para el atributo de clase con el mismo nombre.
     * @return <true> En caso se tener los fondos suficientes </true>
     *         <false> En caso contrario </false>
     */
    @Override
    public boolean retiroValido(double retiro) {
        if (retiro <= this.importeCredito) {
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
        this.importeCredito -= retiro;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param retiro Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void incrementaMontoRetirado(double retiro) {
        double porcentaje = (retiro*0.05);
        this.montoCredito += porcentaje;
    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param deposito Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void deposito(double deposito) {

    }

    /**
     * Método que nos permite modificar el atributo de clase manteniendo el encapsulamiento de datos
     * @param pago Nuevo valor para el atributo de clase con el mismo nombre.
     */
    @Override
    public void pagoCredito(double pago) {
        if (pago == importeCredito) {
            importeCredito = pago;
        } else {
            double diferencia = (importeCredito - pago)*0.08;
            this.importeCredito -= pago;
            importeCredito += diferencia;
        }
    }
}