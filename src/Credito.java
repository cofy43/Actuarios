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
    private int telefono;

    public Credito (String nombre, int numeroCliente, int numeroTarjeta, double importeCredito, 
                  double montoCredito, String fechaApertura, String fechaPago, String fechaVencimiento,
                  int numeroSucursal,String correo, int telefono) {
        this.nombre = nombre;
        this.numeroCliente = numeroCliente;
        this.numeroTarjeta = numeroTarjeta;
        this.importeCredito = importeCredito;
        this.montoCredito = montoCredito;
        this.fechaApertura = fechaApertura;
        this.fechaPago = fechaPago;
        this.fechaVencimiento = fechaVencimiento;
        this.numeroSucursal = numeroSucursal;
        this.estado = true;
        this.correo = correo;
        this.telefono = telefono;
    }
    public Credito() {

    }

    public String toString() {
        String cadena = "Tipo de cuenta: Credito\n";
        cadena += String.format("Nombre: %f\nNumero de cliente:%d\nNumero de tarjeta:%4d\nImporte de credito: %f\nMonto de credito:%f\nFecha de apertura: %s\nFecha de pago: %s\nFecha de vencimineto:%s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %d", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono);
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
        this.fechaApertura = fecha;
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

    public void setImporteCredito(int importeCredito) {
        this.importeCredito = importeCredito;
    }

    public void setMontoCredito(int montoCredito) {
        this.montoCredito = montoCredito;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String paraAlmacenar() {
        return String.format("%f,%d,%4d,%f,%f,%s,%s,%s,%d,%s,%d", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono);
    }
}