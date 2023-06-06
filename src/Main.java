import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main
{
    public static void main(String[] args) throws HashMapVacio {
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese que ejercicio desea ver. (3) o (4). ");
        int opcion = scan.nextInt();
        switch (opcion)
        {
            case 3:
            {
                higherOrLower();
                break;
            }
            case 4:
            {

                Colegio colegio = new Colegio();

                Alumno a1 = new Alumno("Floky","Argentina");
                colegio.agregarAlumno2(a1);
                Alumno a2 = null;
                colegio.agregarAlumno2(a2);
                Alumno a3 = new Alumno("Tomi","Albania");
                colegio.agregarAlumno2(a3);

                colegio.mostrarHashMap();
                ///Alumno a4 = new Alumno("Capo","Rusia");




                System.out.println("Ingrese una nacionalidad, se le diran cuantos alumnos de esa nacionalidad hay.");
                scan.nextLine();
                try
                {
                    String nacionalidad = scan.nextLine();
                    colegio.verNacionalidad(nacionalidad);
                }
                catch (NacionalidadNoEncontrada e)
                {
                    System.out.println(e.getMessage());
                }

                System.out.println("Nacionalidades diferentes en el colegio: ");
                colegio.cuantos();

                System.out.println("HashMap antes de borrar: ");
                colegio.mostrarHashMap();
                try
                {
                    colegio.borrar(a3); ///preguntar
                }
                catch (AlumnoNulo e)
                {
                    System.out.println(e.getMessage());
                }
                System.out.println("HashMap luego de borrar: ");
                colegio.mostrarHashMap();
                
                try
                {
                    colegio.verTodos();
                }
                catch (HashMapVacio e)
                {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
    public static void higherOrLower ()
    {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int intentos = 1;
        int flag = 0;
        int numero = 0;
        int numeroRandom = random.nextInt(501);
        System.out.println("Numero random generado: " + numeroRandom);

        while(flag == 0)
        {
            try
            {
                System.out.println("Intente adivinar el numero random que salio. ");
                System.out.println("Ingrese un numero. ");
                numero = scan.nextInt(); ///preguntar
                if(numero < numeroRandom)
                {
                    System.out.println("El numero ingresado es menor al que hay que adivinar.");
                }
                else if(numero > numeroRandom)
                {
                    System.out.println("El numero ingresado es mayor al que hay que adivinar.");
                }
                else if (numero == numeroRandom)
                {
                    System.out.println("Felicidades haz adivinado en: " + intentos + "intentos.");
                    flag = 1;
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("No haz ingresado un numero entero. ");
                scan.nextLine();
            }
            finally {
                intentos++; ///tiene q ver con preguntar

            }

        }
    }
}