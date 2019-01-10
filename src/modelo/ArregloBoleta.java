package modelo;

import bean.Boleta;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class ArregloBoleta {
    
    private ArrayList<Boleta> lista;

    public ArregloBoleta () {
        lista = new ArrayList<Boleta>();
        cargar();
    }

    public String adicionar(Boleta c) {
        String mensaje;
        Boleta x = buscar(c.getCodigo());
        if (x == null) {
            lista.add(c);
            mensaje = "Boleta guardada correctamente";
        } else {
            mensaje = "La boleta ya existe";
        }
        return mensaje;
    }

    public void eliminar(Boleta c) {
        lista.remove(c);
    }

    public Boleta obtener(int posicion) {
        return lista.get(posicion);
    }

    public Boleta buscar(int codigo) {
        Boleta c = null;
        for (int i = 0; i < lista.size(); i++) {
            if (obtener(i).getCodigo() == codigo) {
                c = obtener(i);
                i = lista.size();
            }
        }
        return c;
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

    public void actualizar(Boleta c) {
        lista.set(buscarPosicion(c.getCodigo()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("./archivos/boletas.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./archivos/boletas.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int cod = Integer.parseInt(st.nextToken().trim());
                    String empleado = st.nextToken().trim();
                    String cliente = st.nextToken().trim();
                    String vehiculo = st.nextToken().trim();
                    String FechaInicio = st.nextToken().trim();
                    String FechaFinal = st.nextToken().trim();
                    double monto = Double.parseDouble(st.nextToken().trim());

                    Boleta v = new Boleta(cod, empleado, cliente, vehiculo, FechaInicio, FechaFinal, monto);
                    adicionar(v);
                }
                br.close();
            } else {
                JOptionPane.showMessageDialog(null, "El archivo boletas.txt no existe");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al cargar txt: " + e.toString());
        }

    }

    public void grabar() {
        try {
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./archivos/boletas.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodigo() + "," + obtener(i).getEmpleado()+ "," +  
                        obtener(i).getCliente()+ "," + obtener(i).getVehiculo()+ "," + 
                        obtener(i).getFechaInicio()+ "," + obtener(i).getFechaFinal()+ "," + 
                        obtener(i).getMonto());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
    
}
