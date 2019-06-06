public class Nomina implements Cuenta{
    private String nombre;
    private int numeroCliente;
    private int numeroCuenta;
    private double saldo;
    private String fechaApertura;
    private int numeroSucursal;
    private String correo;
    private int telefono;
    private String rfc;
    private String nombreEmpresa;
    private String fechaDeposito;
    private boolean estado;

    public Nomina(String nombre, int numeroCliente, int numeroCuenta, double saldo, 
                  String fechaApertura, int numeroSucursal, String correo, int telefono,
                  String rfc, String nombreEmpresa, String fechaDeposito) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.numeroSucursal = numeroSucursal;
        this.correo = correo;
        this.telefono = telefono;
        this.rfc = rfc;
        this.estado = true;
    }

    public Nomina() {}

    public String toString() {
        String cadena = "Tipo de cuenta: Nomina\n";
        cadena += String.format("Nombre: %s\nNumero de cliente: %d\nNumero de cuenta: %d\nSaldo: %f\nFecha de apertura: %s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %d\nRFC de la empresa: %s\nNombre de la empresa: %s\nFecha de deposito: %s", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito);
        return cadena;
    }

    @Override
    public String getNombreCliente() {
        return this.nombre;
    }

    @Override
    public int numeroCliente() {
        return this.numeroCliente;
    }

    @Override
    public String getFechaApertura() {
        return this.fechaApertura;
    }

    @Override
    public int getNueroSucursal() {
        return this.numeroSucursal;
    }

    @Override
    public boolean getEstadoCuenta() {
        return this.estado;
    }

    @Override
    public String getCorreroElectronico() {
        return this.correo;
    }

    @Override
    public int getNumeroTelefono() {
        return this.telefono;
    }

    @Override
    public void setNombreCliente(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setFechaApertura(String fecha) {
        this.fechaApertura = fechaApertura;
    }

    @Override
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public void setCorreoElectronico(String correo) {
        this.correo = correo;
    }

    @Override
    public void setNumeroTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setFechaDeposito(String fechaDeposito) {
        this.fechaDeposito = fechaDeposito;
    }

    @Override
    public String paraAlmacenar() {
        return String.format("%s,%d,%d,%f,%s,%d,%s,%d,%s,%s,%s", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, numeroSucursal, correo, telefono, rfc, nombreEmpresa, fechaDeposito);
    }
}