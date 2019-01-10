package bean;

import java.util.Date;

public class Contrato {
    private int codigo;
    private String nombreEmp;
    private String nombreCli;
    private String vehiculo;
    private Date FechaInicio, FechaFinal;
    private double monto;

    public Contrato(int codigo, String nombreEmp, String nombreCli, String vehiculo, Date FechaInicio, Date FechaFinal, double monto) {
        this.codigo = codigo;
        this.nombreEmp = nombreEmp;
        this.nombreCli = nombreCli;
        this.vehiculo = vehiculo;
        this.FechaInicio = FechaInicio;
        this.FechaFinal = FechaFinal;
        this.monto = monto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    public String getNombreCli() {
        return nombreCli;
    }

    public void setNombreCli(String nombreCli) {
        this.nombreCli = nombreCli;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Date getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public Date getFechaFinal() {
        return FechaFinal;
    }

    public void setFechaFinal(Date FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    
}
