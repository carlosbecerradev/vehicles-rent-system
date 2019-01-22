
package modelo;
import bean.Cliente1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class arreglo_Cliente {
    private ArrayList<Cliente1> lista;

    public arreglo_Cliente() {
        lista = new ArrayList<Cliente1>();
        cargar();
    }
    public String adicionar(Cliente1 p){
        String mensaje;
        Cliente1 x = buscar(p.getCodigo());
        if (x==null){
            lista.add(p);
            mensaje = "El cliente se guardo correctamente";
        }else{
            mensaje = "El cliente ya existe";
        }
        return mensaje;
    }   
    public void eliminar(Cliente1 p){
        lista.remove(p);
    }
    
    public Cliente1 obtener(int posicion){
        return lista.get(posicion);
    }  
    public Cliente1 buscar(int codigo){
        Cliente1 p=null;
        for(int i=0; i<lista.size(); i++){
            if(obtener(i).getCodigo()==codigo){
                p = obtener(i);
                i = lista.size();
            }
        }
        return p;
    }    
    public int buscarPosicion(int codigo){
        int posicion = -1;
        for(int i=0; i<lista.size(); i++){
            if(obtener(i).getCodigo()==codigo){
                posicion = i;
                break;
            }
        }
        return posicion;
    }
    public void actualizar(Cliente1 p){
        lista.set(buscarPosicion(p.getCodigo()), p);
    }
    
    
    public int totalCliente(){
        return lista.size();
    }  
    private void cargar(){
        try{
            File archivo = new File("cliente.txt");
            if(archivo.exists()){
                BufferedReader br=new BufferedReader(new FileReader("cliente.txt"));
                String linea;

                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea,",");

                    int codigo = Integer.parseInt(st.nextToken().trim());
                    String nombre=st.nextToken().trim();
                    String apePaterno=st.nextToken().trim();
                    String apeMaterno=st.nextToken().trim();
                    int edad = Integer.parseInt(st.nextToken().trim());
                    int dni = Integer.parseInt(st.nextToken().trim());                    
                    int telefono = Integer.parseInt(st.nextToken().trim());
                    String direccion=st.nextToken().trim();
                    String licencia=st.nextToken().trim();
                    
                  

                    Cliente1 x =new Cliente1(codigo, nombre, apePaterno, apeMaterno, edad, dni,                        
                            telefono, direccion, licencia);
                    adicionar(x);
                }
                br.close();
            }
            else
                JOptionPane.showMessageDialog(null,"Abriendo el programa");
            } catch(Exception x){
                JOptionPane.showMessageDialog(null,"Se produjo un error: "+x.toString());
            }

    }
    public void grabar(){
        try{
            PrintWriter pw =new PrintWriter(new FileWriter("Cliente.txt"));
            for(int i=0; i<totalCliente(); i++)
                pw.println(obtener(i).getCodigo()+","+
                        obtener(i).getNombre()+","+
                        obtener(i).getApePaterno()+","+
                        obtener(i).getApeMaterno()+","+
                        obtener(i).getEdad()+","+
                        obtener(i).getDni()+","+
                        obtener(i).getTelefono()+","+
                        obtener(i).getDireccion()+","+
                        obtener(i).getLicencia());
            pw.close();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Se produjo un error: "+x.toString());
        }
    }    
}
