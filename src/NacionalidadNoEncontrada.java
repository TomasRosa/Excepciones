public class NacionalidadNoEncontrada extends Exception
{
    public NacionalidadNoEncontrada ()
    {
        super("No se han encontrado alumnos de dicha nacionalidad. Es posible que no exista o que no haya alumnos de la misma. ");
    }
}
