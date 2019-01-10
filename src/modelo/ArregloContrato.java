package modelo;

import bean.Cliente;
import bean.Contrato;
import bean.Empleado;
import bean.Vehiculo;
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

public class ArregloContrato {
    
    private ArrayList<Contrato> lista;

    public ArregloContrato () {
        lista = new ArrayList<Contrato>();
        cargar();
    }

    public String adicionar(Contrato c) {
        String mensaje;
        Contrato x = buscar(c.getCodigo());
        if (x == null) {
            lista.add(c);
            mensaje = "Contrato guardado correctamente";
        } else {
            mensaje = "El contrato ya existe";
        }
        return mensaje;
    }

    public void eliminar(Contrato c) {
        lista.remove(c);
    }

    public Contrato obtener(int posicion) {
        return lista.get(posicion);
    }

    public Contrato buscar(int codigo) {
        Contrato c = null;
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

    public void actualizar(Contrato c) {
        lista.set(buscarPosicion(c.getCodigo()), c);
    }

    public int totalCont() {
        return lista.size();
    }

    //Métodos para manipular el archivo de texto
    private void cargar() {
        try {
            File archivo = new File("contratos.txt");
            if (archivo.exists()) {
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("contratos.txt"), "CP1252"));
                String linea;

                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea, ",");

                    int cod = Integer.parseInt(st.nextToken().trim());
                    String empleado = st.nextToken().trim();
                    String cliente = st.nextToken().trim();
                    String vehiculo = st.nextToken().trim();
                    Date FechaInicio = new Date(st.nextToken().trim());
                    Date FechaFinal = new Date(st.nextToken().trim());
                    double monto = Double.parseDouble(st.nextToken().trim());

                    Contrato v = new Contrato(cod, empleado, cliente, vehiculo, FechaInicio, FechaFinal, monto);
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
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("contratos.txt"), "CP1252"));
            for (int i = 0; i < totalCont(); i++) {
                pw.println(obtener(i).getCodigo() + "," + obtener(i).getNombreEmp()+ "," +  
                        obtener(i).getNombreCli()+ "," + obtener(i).getVehiculo()+ "," + 
                        obtener(i).getFechaInicio()+ "," + obtener(i).getFechaFinal()+ "," + 
                        obtener(i).getMonto());
            }
            pw.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al grabar txt: " + e.toString());
        }
    }
    
}
