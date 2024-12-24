/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pesce
 */
public class IObligatorioTestDoc {

    private IObligatorio miSistema;

    public IObligatorioTestDoc() {
        miSistema = new Sistema();
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }

    /*Agregar Estudiante*/
    
    @Test
    public void testAgregarEstudianteOk() {
        Retorno ret = miSistema.agregarEstudiante("Micaela", "Rodriguez", 1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        ret = miSistema.agregarEstudiante("Romina", "Gomez", 2222);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        ret = miSistema.agregarEstudiante("Martina", "Gutierrez", 3333);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }

    @Test
    public void testAgregarEstudianteError1() {
        Retorno ret = miSistema.agregarEstudiante("", "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, "Apellido", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante("", "", 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarEstudiante(null, null, 1111);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

    }

    @Test
    public void testAgregarEstudianteError2() {
        Retorno ret = miSistema.agregarEstudiante("Nombre", "Apellido", 0);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", -5);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500001);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.agregarEstudiante("Nombre", "Apellido", 500050);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }

    @Test
    public void testAgregarEstudianteError3() {
        Retorno ret = miSistema.agregarEstudiante("Micaela", "Rodriguez", 1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        ret = miSistema.agregarEstudiante("Felipe", "Ortiz", 1111);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
        ret = miSistema.agregarEstudiante("Romina", "Gomez", 2222);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }
    
     /*Fin Agregar Estudiante*/
    
    /*Obtener Estudiante*/

    @Test
    public void testObtenerEstudianteOk() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#1111", ret.valorString);
    }

    @Test
    public void testObtenerEstudianteError1() {
        
        Retorno ret = miSistema.obtenerEstudiante(-2);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500001);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.obtenerEstudiante(500500);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }

    @Test
    public void testObtenerEstudianteError2() {
        
        miSistema.agregarEstudiante("Nombre", "Apellido", 2222);
        
        Retorno ret = miSistema.obtenerEstudiante(1111);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(1);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.obtenerEstudiante(500000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
        
        ret = miSistema.obtenerEstudiante(500000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
        
        ret = miSistema.obtenerEstudiante(2222);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#2222", ret.valorString);
    }
    
     /*Fin Obtener Estudiante*/

    /*Eliminar Estudiante*/
    
    @Test
    public void testEliminarEstudianteOk() {
        
        Retorno ret = miSistema.agregarEstudiante("Micaela", "Rodriguez", 1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.agregarEstudiante("Romina", "Gomez", 2222);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
  
        ret = miSistema.eliminarEstudiante(1111);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.eliminarEstudiante(2222);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }

    @Test
    public void testEliminarEstudianteError1() {
        Retorno ret = miSistema.eliminarEstudiante(-2);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.eliminarEstudiante(0);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.eliminarEstudiante(500001);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.eliminarEstudiante(500500);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }

    @Test
    public void testEliminarEstudianteError2() {
        Retorno ret = miSistema.eliminarEstudiante(1111);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.eliminarEstudiante(1);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);

        ret = miSistema.eliminarEstudiante(500000);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
    }

    @Test
    public void testEliminarEstudianteError3() {
        //No se valida para primer obligatorio
    }
    
    /*Fin Eliminar Estudiante*/
    
    /*Agregar Libro*/

    @Test
    public void testAgregarLibroOk() {
        
        Retorno ret = miSistema.agregarLibro("Introducción a la investigación en educación", "978-6071506739", "Eduación", 150);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.agregarLibro("El arte de la investigación", "978-9688606230", "Investigación", 150);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
    }

    @Test
    public void testAgregarLibroError1() {
        Retorno ret = miSistema.agregarLibro("", "ISBN", "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", "", "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", "ISBN", "", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("", "", "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", "", "", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("", "ISBN", "", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro(null, "ISBN", "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", null, "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", "ISBN", null, 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro(null, null, "Categoria", 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro("NombreLibro", null, null, 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro(null, "ISBN", null, 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.agregarLibro(null, null, null, 150);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }
    
    @Test
    public void testAgregarLibroError2() {
        
        Retorno ret = miSistema.agregarLibro("Introducción a la investigación en educación", "978-6071506739", "Eduación", 150);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.agregarLibro("El arte de la investigación", "978-9688606230", "Investigación", 150);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.agregarLibro("Algotirmos", "978-6071506739", "Programación", 100);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
        
        ret = miSistema.agregarLibro("Algotirmos", "978-9688606230", "Programación", 100);
        assertEquals(Retorno.Resultado.ERROR_2, ret.resultado);
        
    }
    
        @Test
    public void testAgregarLibroError3() {
        
        Retorno ret = miSistema.agregarLibro("Introducción a la investigación en educación", "978-6071506739", "Eduación", 150);
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        
        ret = miSistema.agregarLibro("El arte de la investigación", "978-9688606230", "Investigación", -1);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
        
        ret = miSistema.agregarLibro("El arte de la investigación", "978-9688606230", "Investigación", 0);
        assertEquals(Retorno.Resultado.ERROR_3, ret.resultado);
        
    }
    
    /*Fin Agregar Libro*/
    
    /*Listar Estudiantes*/

    @Test
    public void testListarEstudiantesVacio() {
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("", ret.valorString);
    }

    @Test
    public void testListarEstudiantesUnElemento() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#1111", ret.valorString);

    }

    @Test
    public void testListarEstudiantesIngresoOrdenado() {
        miSistema.agregarEstudiante("Nombre1", "Apellido1", 1111);
        miSistema.agregarEstudiante("Nombre2", "Apellido2", 2222);
        miSistema.agregarEstudiante("Nombre3", "Apellido3", 3333);
        miSistema.agregarEstudiante("Nombre4", "Apellido4", 4444);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre1#Apellido1#1111|Nombre2#Apellido2#2222|Nombre3#Apellido3#3333|Nombre4#Apellido4#4444", ret.valorString);
    }

    @Test
    public void testListarEstudiantesIngresoNoOrdenado() {
        miSistema.agregarEstudiante("Nombre2", "Apellido2", 2222);
        miSistema.agregarEstudiante("Nombre1", "Apellido1", 1111);
        miSistema.agregarEstudiante("Nombre4", "Apellido4", 4444);
        miSistema.agregarEstudiante("Nombre3", "Apellido3", 3333);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre1#Apellido1#1111|Nombre2#Apellido2#2222|Nombre3#Apellido3#3333|Nombre4#Apellido4#4444", ret.valorString);
    }

    @Test
    public void testListarEstudiantesVerificarOrdenPorNumero() {
        miSistema.agregarEstudiante("Nombre", "Apellido", 2222);
        miSistema.agregarEstudiante("Nombre", "Apellido", 1111);
        miSistema.agregarEstudiante("Nombre", "Apellido", 4444);
        miSistema.agregarEstudiante("Nombre", "Apellido", 3333);
        Retorno ret = miSistema.listarEstudiantes();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("Nombre#Apellido#1111|Nombre#Apellido#2222|Nombre#Apellido#3333|Nombre#Apellido#4444", ret.valorString);
    }
    
    /*Fin Listar Estudiantes*/
    
     /*Listar Libros*/
    @Test
    public void testListarLibrosVacio() {
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals(ret.valorString, "");
    }

    @Test
    public void testListarLibrosUnElemento() {
        miSistema.agregarLibro("NombreLibro", "ISBN", "Categoria", 150);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro#ISBN#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosIngresoOrdenado() {
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosIngresoNoOrdenado() {
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        Retorno ret = miSistema.listarLibros();
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }
    
    /*Fin Listar Libros*/
    
    /*Listar Libros X Categoría*/

    @Test
    public void testListarLibrosXCategoriaError1() {
        Retorno ret = miSistema.listarLibros("");
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);

        ret = miSistema.listarLibros(null);
        assertEquals(Retorno.Resultado.ERROR_1, ret.resultado);
    }

    @Test
    public void testListarLibrosXCategoriaListadoVacioSinLibrosAgregados() {
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("", ret.valorString);
    }

    @Test
    public void testListarLibrosXCategoriaListadoVacioConLibrosAgregados() {
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria1", 250);
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria2", 150);
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals(ret.valorString, "");
    }

    @Test
    public void testListarLibrosXCategoriaIngresoOrdenado() {
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosXCategoriaIngresoNoOrdenado() {
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria", 250);
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria", 450);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro2#ISBN2#Categoria|NombreLibro3#ISBN3#Categoria|NombreLibro4#ISBN4#Categoria", ret.valorString);
    }

    @Test
    public void testListarLibrosXCategoriaIngresoOrdenadoConOtrosLibrosDeOtraCategoria() {
        miSistema.agregarLibro("NombreLibro1", "ISBN1", "Categoria", 150);
        miSistema.agregarLibro("NombreLibro2", "ISBN2", "Categoria2", 250);
        miSistema.agregarLibro("NombreLibro3", "ISBN3", "Categoria", 350);
        miSistema.agregarLibro("NombreLibro4", "ISBN4", "Categoria3", 450);
        Retorno ret = miSistema.listarLibros("Categoria");
        assertEquals(Retorno.Resultado.OK, ret.resultado);
        assertEquals("NombreLibro1#ISBN1#Categoria|NombreLibro3#ISBN3#Categoria", ret.valorString);
    }

    /*Fin Listar Libros X Categoría*/
}
