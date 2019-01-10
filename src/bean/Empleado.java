
package bean;

public class Empleado {
    
    private int codigo;
    private String nombre;
    private String cargo;

    public Empleado(int codigo, String nombre, String cargo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargo = cargo;
    }

    public Empleado(){
        codigo = 1;
        nombre = "Trace Drow";
        cargo = "Vendedor";
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
    
}
