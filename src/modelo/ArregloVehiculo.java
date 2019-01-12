package modelo;

import bean.Vehiculo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArregloVehiculo {

    private ArrayList<Vehiculo> lista;

    public ArregloVehiculo() {
        lista = new ArrayList<Vehiculo>();
        cargar();
    }

    public String adicionar(Vehiculo v) {
        String mensaje;
        Vehiculo x = buscar(v.getCodigo());
        if (x == null) {
            lista.add(v);
            mensaje = "Vehículo guardado correctamente";
        } else {
            mensaje = "El vehículo ya existe";
        }
        return mensaje;
    }

    public void eliminar(Vehiculo v) {
        lista.remove(v);
    }

    public Vehiculo obtener(int posicion) {
        return lista.get(posicion);
    }
    
    public ArrayList<Vehiculo> obtMarca(String marca){
        ArrayList<Vehiculo> listVehiMarca = new ArrayList<Vehiculo>();
        Vehiculo v;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getMarca().equalsIgnoreCase(marca)) {
                v = obtener(i);
                listVehiMarca.add(v);
            }
        }
        return listVehiMarca;
    }

    public Vehiculo buscar(int codigo) {
        Vehiculo v = null;
        
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodigo() == codigo) {
                v = obtener(i);
                i = lista.size();
            }
        }
        return v;
    }

    public int buscarPosicion(int codigo) {
        int posicion = -1;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodigo() == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    public void actualizar(Vehiculo v) {
        lista.set(buscarPosicion(v.getCodigo()), v);
    }

    public int totalVehi() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/vehiculos.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/vehiculos.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int cod = Integer.parseInt(st.nextToken().trim());
                    String marca = st.nextToken().trim();
                    String modelo = st.nextToken().trim();
                    String placa = st.nextToken().trim();
                    String transmision = st.nextToken().trim();
                    String combustible = st.nextToken().trim();
                    int asientos = Integer.parseInt(st.nextToken().trim());
                    String categoria = st.nextToken().trim();
                    double costo = Double.parseDouble(st.nextToken().trim());
                    String estado = st.nextToken().trim();
                    String rutaImg = st.nextToken().trim();

                    Vehiculo v = new Vehiculo(cod, marca, modelo, placa, transmision, combustible, asientos, categoria, costo, estado, rutaImg);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo vehiculos.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/vehiculos.txt"), "CP1252"));
            for (int i = 0; i < totalVehi(); i++) {
                pw.println(obtener(i).getCodigo() + "," + obtener(i).getMarca() + "," +  
                        obtener(i).getModelo() + "," + obtener(i).getPlaca()+ "," + 
                        obtener(i).getTransmision()  + "," + obtener(i).getCombustible() + "," + 
                        obtener(i).getAsientos()  + "," + obtener(i).getCategoria() + "," + 
                        obtener(i).getCosto() + "," + obtener(i).getEstado() + "," + 
                        obtener(i).getRutaImg());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
}
