package bean;

public class Vendedor {

    private int codigoVendedor;
    private String nombreVendedor;
    
    private String apePatVendedor;
    private String apeMatVendedor;
    private int edad;
    private String telefono;
    private String sexo;

    public Vendedor(int codigoVendedor, String nombreVendedor, String apePatVendedor, String apeMatVendedor, int edad, String telefono, String sexo) {
        this.codigoVendedor = codigoVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apeMatVendedor = apeMatVendedor;
        this.apePatVendedor = apePatVendedor;
        this.edad = edad;
        this.telefono = telefono;
        this.sexo = sexo;
    }

    public int getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApeMatVendedor() {
        return apeMatVendedor;
    }

    public void setApeMatVendedor(String apeMatVendedor) {
        this.apeMatVendedor = apeMatVendedor;
    }

    public String getApePatVendedor() {
        return apePatVendedor;
    }

    public void setApePatVendedor(String apePatVendedor) {
        this.apePatVendedor = apePatVendedor;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
