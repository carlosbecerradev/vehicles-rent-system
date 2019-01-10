package bean;

public class Cliente {
    
    private int codigo;
    private String nombre;
    private int dni;

    public Cliente(int codigo, String nombre, int dni) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.dni = dni;
    }
    
    public Cliente(){
        codigo = 1;
        nombre = "Carlos Becerra";
        dni = 71463111;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    
    
    
}
