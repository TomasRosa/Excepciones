public class AlumnoNulo extends RuntimeException
{
    public AlumnoNulo()
    {
        super("El alumno proporcionado es nulo.");
    }
}
