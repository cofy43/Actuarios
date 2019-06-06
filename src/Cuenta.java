public interface Cuenta {
    public String toString();
    public String getNombreCliente();
    public int numeroCliente();
    public String getFechaApertura();
    public int getNueroSucursal();
    public boolean getEstadoCuenta();
    public String getCorreroElectronico();
    public int getNumeroTelefono();
    public void setNombreCliente(String nombre);
    public void setFechaApertura(String fecha);
    public void setEstado(boolean estado);
    public void setCorreoElectronico(String correo);
    public void setNumeroTelefono(int telefono);
    public String paraAlmacenar();
}