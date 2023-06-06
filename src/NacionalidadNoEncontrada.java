public class NacionalidadNoEncontrada extends RuntimeException
{
    public NacionalidadNoEncontrada ()
    {
        super("No se han encontrado alumnos de dicha nacionalidad. Es posible que no exista o que no haya alumnos de la misma. ");
    }
}
