
package modelo;
import bean.Cliente;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class arreglo_Cliente {
    private ArrayList<Cliente> lista;

    public arreglo_Cliente() {
        lista = new ArrayList<Cliente>();
        cargar();
    }
    public String adicionar(Cliente p){
        String mensaje;
        Cliente x = buscar(p.getCodigo());
        if (x==null){
            lista.add(p);
            mensaje = "El cliente se guardo correctamente";
        }else{
            mensaje = "El cliente ya existe";
        }
        return mensaje;
    }   
    public void eliminar(Cliente p){
        lista.remove(p);
    }
    
    public Cliente obtener(int posicion){
        return lista.get(posicion);
    }  
    public Cliente buscar(int codigo){
        Cliente p=null;
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
    public void actualizar(Cliente p){
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
                    
                  

                    Cliente x =new Cliente(codigo, nombre, apePaterno, apeMaterno, edad, dni,                        
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
