public class Debito implements Cuenta{
    private String nombre;
    private int numeroCliente;
    private int numeroCuenta;
    private double saldo;
    private String fechaApertura;
    private String fechaCorte;
    private int numeroSucursal;
    private boolean estado;
    private String correo;
    private int telefono;

    public Debito(String nombre, int numeroCliente, int numeroCuenta, double saldo, 
                  String fechaApertura, String fechaCorte,int numeroSucursal,String correo, int telefono) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaApertura = fechaApertura;
        this.fechaCorte = fechaCorte;
        this.numeroSucursal = numeroSucursal;
        this.estado = true;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Debito(){}

    public String toString() {
        String cadena = "Tipo de cuenta: Debito\n";
        cadena += String.format("Nombre:%s\nNumero de cliente: %d\nNumero de cuenta: %d\nSaldo: $%f\nFecha de apertura: %s\nFecha de corte: %s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %d", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte, numeroSucursal, correo, telefono);
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

    public void setFechaCorte(String fechaCorte) {
        this.fechaCorte = fechaCorte;
    }

    @Override
    public String paraAlmacenar() {
        return String.format("%s,%d,%d,%f,%s,%s,%d,%s,%d", nombre, numeroCliente, numeroCuenta, saldo, fechaApertura, fechaCorte, numeroSucursal, correo, telefono);
    }
}