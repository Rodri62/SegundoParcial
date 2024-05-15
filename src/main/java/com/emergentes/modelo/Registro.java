
package com.emergentes.modelo;
public class Registro {
     private int id;
    private String nombres;
    private String apellidos;
    private String seminarios;
    private boolean confirmado;
    private String fecha_Inscripcion;

    public Registro() {
        id = 0;
        nombres = "";
        apellidos = "";
        seminarios = "";
        confirmado = false;
        fecha_Inscripcion="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public String getFecha_Inscripcion() {
        return fecha_Inscripcion;
    }

    public void setFecha_Inscripcion(String fecha_Inscripcion) {
        this.fecha_Inscripcion = fecha_Inscripcion;
    }
    
}
