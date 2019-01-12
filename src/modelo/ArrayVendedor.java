package modelo;

import bean.Vendedor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArrayVendedor {

    private ArrayList<Vendedor> vendedor ;

    public ArrayVendedor() {
        vendedor= new ArrayList<Vendedor>();
        cargar();
    }

    public String agregar(Vendedor v){
        String mensaje;
        Vendedor x = buscar(v.getCodigoVendedor());
        if (x==null){
            vendedor.add(v);
            mensaje = "Vendedor guardado correctamente";
        }else{
            mensaje = "El vendedor ya existe";
        }
        return mensaje;
    }

    public void eliminar(Vendedor v) {
        vendedor.remove(v);
    }

    public Vendedor obtener(int pos) {
        return vendedor.get(pos);
    }

    public int buscarPos(int cod) {
        int pos = -1;
        for (int i = 0; i < vendedor.size(); i++) {
            if (obtener(i).getCodigoVendedor() == cod) {
                pos = i;
            }
        }
        return pos;
    }

    public Vendedor buscar(int cod) {
        Vendedor v = null;
        for (int i = 0; i < vendedor.size(); i++) {
            if (obtener(i).getCodigoVendedor() == cod) {
                v = obtener(i);
                break;
            }
        }
        return v;
    }

    public void actualizar(Vendedor v) {
        vendedor.set(buscarPos(v.getCodigoVendedor()), v);
    }

    public int cantidadVendedor() {
        return vendedor.size();
    }
    
     //Métodos para manipular el archivo de texto
    private void cargar(){
        try{
            File archivo = new File("./archivos/vendedores.txt");
            if(archivo.exists()){
                BufferedReader br=new BufferedReader(new FileReader("./archivos/vendedores.txt"));
                String linea;

                while((linea=br.readLine())!=null){
                    StringTokenizer st=new StringTokenizer(linea,",");

                    int cod = Integer.parseInt(st.nextToken().trim());
                    String nombre=st.nextToken().trim();
                    String apellidoPat = st.nextToken().trim();
                    String apellidoMat = st.nextToken().trim();
                    int edad = Integer.parseInt(st.nextToken().trim());
                    String telefono = st.nextToken().trim();
                    String sexo = st.nextToken().trim();
                    Vendedor x =new Vendedor(cod, nombre, apellidoPat, apellidoMat,edad,telefono,sexo);
                    agregar(x);
                }
                br.close();
            }
            else
                JOptionPane.showMessageDialog(null,"El archivo vendedores.txt no existe");
            } catch(Exception x){
                JOptionPane.showMessageDialog(null,"Se produjo un error: "+x.toString());
            }

 }

    public void grabar(){
        try{
            PrintWriter pw =new PrintWriter(new FileWriter("./archivos/vendedores.txt"));
            for(int i=0; i<cantidadVendedor(); i++)
                pw.println(obtener(i).getCodigoVendedor()+","+obtener(i).getNombreVendedor()+","+obtener(i).getApePatVendedor()+","
                        +obtener(i).getApeMatVendedor()+","+obtener(i).getEdad()+","+obtener(i).getTelefono()+","+obtener(i).getSexo());
            pw.close();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Se produjo un error: "+x.toString());
        }
    }
}
