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

    public String toString() {
        String cadena = "Tipo de cuenta: Credito\n";
        cadena += String.format("Nombre: %s\nNumero de cliente:%d\nNumero de tarjeta:%4d\nImporte de credito: %f\nMonto de credito:%f\nFecha de apertura: %s\nFecha de pago: %s\nFecha de vencimineto:%s\nNumero de sucursal: %d\nCorreo electronico: %s\nNumero telefonico: %s", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono);
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
    public String getNumeroTelefono() {
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
    public void setNumeroTelefono(String telefono) {
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
        String representacion; 
        if (estado == true) {
            representacion = "activo"; 
        } else {
            representacion =  "inactivo";
        }                                                           // 1         2              3               4             5              6               7           8              9              10       11       12
        return String.format("credito,%s,%d,%4d,%f,%f,%s,%s,%s,%d,%s,%s", nombre, numeroCliente, numeroTarjeta, importeCredito, montoCredito, fechaApertura, fechaPago, fechaVencimiento, numeroSucursal, correo, telefono, representacion);
    }

    @Override
    public int getNumeroCuenta() {
        return 0;
    }

    @Override
    public int getNumeroCliente() {
        return numeroCliente;
    }

    @Override
    public String getClase() {
        return "credito";
    }

    @Override
    public String getRfcEmpresa() {
        return null;
    }

    @Override
    public boolean retiroValido(double retiro) {
        if (retiro <= this.importeCredito) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void efectuaRetiro(double retiro) {
        this.importeCredito -= retiro;
    }

    @Override
    public void incrementaMontoRetirado(double retiro) {
        double porcentaje = (retiro*0.05);
        this.montoCredito += porcentaje;
    }

    @Override
    public void deposito(double deposito) {

    }

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

    @Override
    public double getSaldo() {
        return 0;
    }

    @Override
    public double getImporte() {
        return this.importeCredito;
    }

    @Override
    public String getFechaPago() {
        return this.fechaPago;
    }

    @Override
    public int getNumeroTarjeta() {
        return this.numeroTarjeta;
    }
}