public class Alumno
{
    private String nombre;
    private String nacionalidad;
    public Alumno ()
    {

    }
    public Alumno (String nombre, String nacionalidad)
    {
        this.nacionalidad = nacionalidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
