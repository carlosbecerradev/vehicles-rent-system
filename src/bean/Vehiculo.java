package bean;

public class Vehiculo {
    
    private int codigo;
    private String marca;
    private String modelo;
    private String placa;
    private String transmision;
    private String combustible;
    private int asientos;//Capacidad de Asientos
    private String categoria; //Aire acondicionado
    private double costo;//Costo de alquiler por día
    private String estado;// Alquilado | Disponible | En reparacion
    private String rutaImg;

    public Vehiculo(int codigo, String marca, String modelo, String placa, String transmision, String combustible, int asientos, String categoria, double costo, String estado, String rutaImg) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.transmision = transmision;
        this.combustible = combustible;
        this.asientos = asientos;
        this.categoria = categoria;
        this.costo = costo;
        this.estado = estado;
        this.rutaImg = rutaImg;
    }

    public Vehiculo(int codigo, String marca, String modelo, String placa){
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRutaImg() {
        return rutaImg;
    }

    public void setRutaImg(String rutaImg) {
        this.rutaImg = rutaImg;
    }

}
