package pkg2020.pkg12.pkg08.examen;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Estudiante {

    private String nombres, apellidos;
    private Double primedio_notas;
    private Double suma_notas;
    private int cantidad_notas;

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

    public Double getSuma_notas() {
        return suma_notas;
    }

    public void setSuma_notas(Double suma_notas) {
        this.suma_notas = suma_notas;
    }

    public int getCantidad_notas() {
        return cantidad_notas;
    }

    public void setCantidad_notas(int cantidad_notas) {
        this.cantidad_notas = cantidad_notas;
    }

    public Double getPromedio_notas() {
        return getSuma_notas() / getCantidad_notas();
    }

}

class Grupo {

    Lista<Estudiante> Alumnado = new ListaEnlazada<>();

    public void BajaEstudiantil(String nombre) {
        if (!Alumnado.isEmpty()) {
            Iterador<Estudiante> iterator = Alumnado.iter();
            Estudiante temp;
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.getNombres().toLowerCase().equals(nombre.toLowerCase())) {
                    try {
                        Alumnado.remove(Alumnado.getIndex(temp));
                    } catch (ElemNoEncE | PosicIncE ex) {
                        Logger.getLogger(Grupo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public void AltaEstudiantil(Estudiante alumno) {
        Alumnado.add(alumno);
    }

    public Double PromedioAlumnado() {
        Double prom = 0.0;
        if (!Alumnado.isEmpty()) {
            Iterador<Estudiante> iterator = Alumnado.iter();
            while (iterator.hasNext()) {
                prom = iterator.next().getPromedio_notas();
            }
        }
        return prom;

    }

    public Estudiante EstudianteMaxProm() {
        Double MaxProm = 0.0;
        if (!Alumnado.isEmpty()) {
            Estudiante temp, best = new Estudiante();
            Iterador<Estudiante> iterator = Alumnado.iter();
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.getPromedio_notas() > MaxProm) {
                    best = temp;
                    MaxProm = best.getPromedio_notas();
                }
            }
            return best;
        } else {
            return null;
        }
    }

    public Estudiante EstudianteMinProm() {
        Double MinProm = 10.0;
        if (!Alumnado.isEmpty()) {
            Estudiante temp, worst = new Estudiante();
            Iterador<Estudiante> iterator = Alumnado.iter();
            while (iterator.hasNext()) {
                temp = iterator.next();
                if (temp.getPromedio_notas() < MinProm) {
                    worst = temp;
                    MinProm = worst.getPromedio_notas();
                }
            }
            return worst;
        } else {
            return null;
        }
    }
}
