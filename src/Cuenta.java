/**
 * Clase padre encargada de modelar una cuenta.
 * @author Sus nombres
 * @author Sus nombres
 * @author Sus nombres
 * @version 1.0;
 */
public interface Cuenta {
    //Atributos y métodos que heredarán las clases Nómina, Cédito y Débito
    public String toString();
    public String getNombreCliente();
    public int getNumeroCliente();
    public int numeroCliente();
    public String getFechaApertura();
    public String getRfcEmpresa();
    public int getNueroSucursal();
    public boolean getEstadoCuenta();
    public String getCorreroElectronico();
    public String getNumeroTelefono();
    public boolean retiroValido(double retiro);
    public void efectuaRetiro(double retiro);
    public void incrementaMontoRetirado(double retiro);
    public void pagoCredito(double pago);
    public String getClase();
    public void deposito(double deposito);
    public void setNombreCliente(String nombre);
    public void setFechaApertura(String fecha);
    public void setEstado(boolean estado);
    public void setCorreoElectronico(String correo);
    public void setNumeroTelefono(String telefono);
    public double getSaldo();
    public String paraAlmacenar();
    public int getNumeroCuenta();
    public double getImporte();
    public String getFechaPago();
    public int getNumeroTarjeta();
}