import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Colegio
{
    private HashMap<String,String> hashmapColegio;
    ///Key nombre.
    ///Value nacionalidad.
    public Colegio ()
    {
        this.hashmapColegio = new HashMap<>();
    }
    public void mostrarHashMap ()
    {
        for(Map.Entry<String,String> entry: this.hashmapColegio.entrySet())
        {
            System.out.println("Clave: " + entry.getKey() + "Valor: " + entry.getValue());
        }
    }
    public void agregarAlumno2 (Alumno alumno) throws NullPointerException
    {
        try
        {
            this.hashmapColegio.put(alumno.getNombre(),alumno.getNacionalidad());
        }
        catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void verNacionalidad (String nacionalidad) throws NacionalidadNoEncontrada
    {
        System.out.println("Nacionalidad: " + nacionalidad);
        int cantidad = cantidadPorNacionalidad(nacionalidad);
        if(cantidad > 0)
        {
            System.out.println("Alumnos de esa nacionalidad: " + cantidad);
        }
        else if (cantidad == 0)
        {
            throw new NacionalidadNoEncontrada();
        }
    }
    public int cantidadPorNacionalidad (String nacionalidad)
    {
        int cantidad = 0;

        for(Map.Entry<String,String> entry: this.hashmapColegio.entrySet())
        {
            if(entry.getValue().equalsIgnoreCase(nacionalidad))
            {
                cantidad++;
            }
        }
        return cantidad;
    }
    public void cuantos () ///
    {
        HashSet<String> nacionalidades = new HashSet<String>();

        for(Map.Entry<String,String> entry: this.hashmapColegio.entrySet())
        {
            nacionalidades.add(entry.getValue());
        }

        System.out.println("Hay " + nacionalidades.size() + "nacionalidades diferentes.");

        System.out.println("Nacionalidades diferentes: ");

        for(String nacionalidad: nacionalidades)
        {
            System.out.println(nacionalidad);
        }
    }
    public void borrar (Alumno alumno) throws AlumnoNulo
    {
        alumno = buscarAlumno(alumno);
        System.out.println(alumno);

        if(alumno != null)
        {
            this.hashmapColegio.remove(alumno.getNombre());
        }
        else
        {
            ///Preguntar
            throw new AlumnoNulo();
        }
    }
    public Alumno buscarAlumno (Alumno alumno)
    {
        Alumno aBuscar = null;

        for(Map.Entry<String,String> entry: this.hashmapColegio.entrySet())
        {
            if(entry.getKey().equalsIgnoreCase(alumno.getNombre()))
            {
                Alumno aux = new Alumno(entry.getKey(), entry.getValue());
                System.out.println(aux);
                aBuscar = new Alumno(entry.getKey(), entry.getValue());
            }
        }
        return aBuscar;
    }
    public void verTodos () throws HashMapVacio
    {
        ///Creo un nuevo HashMap ya que me pide saber Nacionalidades y Numero de alumnos x nacionalidad.
        HashMap<String, Integer> hashmapCantidadNac = new HashMap<>();
        int contador = 0;

        if(this.hashmapColegio.size() > 0)
        {
            for(String nacionalidades: this.hashmapColegio.values())
            {
                if(hashmapCantidadNac.containsKey(nacionalidades))
                {
                    ///Si encuentra la nacionalidad en el nuevo hashmap contador obtiene el valor de la respectiva key evaluada.
                    contador = hashmapCantidadNac.get(nacionalidades);
                    ///Sobreescribo la nacionalidad (key) y le sumo uno al contador ya que estoy agregando esa nacionalidad nuevamente.
                    hashmapCantidadNac.put(nacionalidades,contador+1);
                }
                else
                {
                    ///Si no la encuentra significa que no esta, debo agregarla.
                    hashmapCantidadNac.put(nacionalidades,1);
                }
            }
            ///Recorro HashMap de esta manera:
            for(Map.Entry<String,Integer> entry: hashmapCantidadNac.entrySet())
            {
                System.out.println("Nacionalidad: " + entry.getKey() + " cantidad de alumnos: " + entry.getValue());
            }
        }
        else if (this.hashmapColegio.size() == 0)
        {
            throw new HashMapVacio();
        }
    }
}
