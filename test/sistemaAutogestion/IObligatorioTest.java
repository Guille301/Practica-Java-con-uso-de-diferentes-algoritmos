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
public class IObligatorioTest {
    
    private Sistema miSistema;
    
    public IObligatorioTest() {
    }
    
     @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }

      @Test
    public void testCrearSistemaDeGestion() {
        Retorno r = this.miSistema.crearSistemaDeGestion();
        
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }
    
    
    
    /*******Agregar estudiante********/
  @Test
    public void testAgregarEstudiante() {
        Retorno r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
        r = this.miSistema.agregarEstudiante("Alejandro", "Sayid", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
  
    }
   
     @Test
    public void testAgregarEstudianteError1() {
     Retorno r = miSistema.agregarEstudiante("Roberto","" ,1);
     assertEquals(Retorno.error1().resultado,r.resultado);
     
     r = miSistema.agregarEstudiante("","Gurmendez" ,2);
    assertEquals(Retorno.error1().resultado,r.resultado);

     }
    
    
     @Test
    public void testAgregarEstudianteError2() {
     Retorno r = miSistema.agregarEstudiante("Carlos","Paez" ,0);
     assertEquals(Retorno.error2().resultado,r.resultado);
     
    r = miSistema.agregarEstudiante("Fernando","Fernandez" ,500001);
    assertEquals(Retorno.error2().resultado,r.resultado);
     }
    
    @Test
    public void testAgregarEstudianteError3() {
    this.miSistema.agregarEstudiante("Rodrigo", "Diaz", 1);
        
        Retorno r = this.miSistema.agregarEstudiante("Rodrigo", "Diaz", 1);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
     
     }

    

    
   /*Obtener estudiante*/ 
     
  @Test
    public void testObtenerEstudiante() {
        this.miSistema.agregarEstudiante("Micaela", "Pazi", 1);
        
        Retorno r = this.miSistema.obtenerEstudiante(1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }

  @Test
    public void testObtenerEstudianteError1() {
   this.miSistema.agregarEstudiante("Federico", "Adler", 1);
    Retorno r = miSistema.obtenerEstudiante(0);
     assertEquals(Retorno.error1().resultado,r.resultado);
     
    r = miSistema.obtenerEstudiante(500001);
     assertEquals(Retorno.error1().resultado,r.resultado);

    }

      @Test
    public void testObtenerEstudianteError2() {
        this.miSistema.agregarEstudiante("Verónica", "Zazúlich", 1);
    Retorno r = miSistema.obtenerEstudiante(23);
    assertEquals(Retorno.error2().resultado,r.resultado);

    }
    
    
   
    /*Eliminar estudiante*/
    
  @Test
    public void testEliminarEstudiante() {
        this.miSistema.agregarEstudiante("Nicolas", "Volga", 1);
        
        Retorno r = this.miSistema.eliminarEstudiante(1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }
    
    @Test
    public void testEliminarEstudianteError1() {
        this.miSistema.agregarEstudiante("Ignácio", "Menéndez", 1);
        
        Retorno r = this.miSistema.eliminarEstudiante(-100);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        
        r = this.miSistema.eliminarEstudiante(0);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        
        r = this.miSistema.eliminarEstudiante(1000000);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
    }
    
    @Test
    public void testEliminarEstudianteError2() {
        this.miSistema.agregarEstudiante("Juan", "Rodriguez", 1);
        
        Retorno r = this.miSistema.eliminarEstudiante(8);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }

    
    
    
    
    
    
    
    
    /*Agregar libro*/
    
    
    @Test
    public void testAgregarLibro() {
        Retorno r = miSistema.agregarLibro("Ariel", "a12", "Ensayo", 3);
     assertEquals(Retorno.ok().resultado,r.resultado);
     r = miSistema.agregarLibro("El progreso del peregrino", "abZk", "Novela", 15);
     assertEquals(Retorno.ok().resultado,r.resultado);
        
        
    }

     @Test
    public void testAgregarLibroError1() {
        Retorno r = miSistema.agregarLibro("Amadis de Gaula", "", "", 10);
     assertEquals(Retorno.error1().resultado,r.resultado);
     r = miSistema.agregarLibro("", "", "", 15);
     assertEquals(Retorno.error1().resultado,r.resultado);   
    }
    
    @Test
    public void testAgregarLibroError2() {

      this.miSistema.agregarLibro("El Corazón de las Tinieblas", "b113t", "Aventura", 6);
        
        Retorno r = this.miSistema.agregarLibro("El Corazón de las Tinieblas", "b113t", "Aventura", 6);
        assertEquals(Retorno.Resultado.ERROR_2, r.resultado);
    }
    
      @Test
    public void testAgregarLibroError3() {
  Retorno r = this.miSistema.agregarLibro("La Epopeya de Gilgamesh", "E3T", "Historia", -2);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
        
        r = this.miSistema.agregarLibro("La Vegetariana", "813TRA", "Novela", 0);
        assertEquals(Retorno.Resultado.ERROR_3, r.resultado);
    }
    
    
    
    /*Listas*/
    
    @Test
    public void testListarEstudiantes() {
        this.miSistema.agregarEstudiante("Alfonso", "Camaguey", 5);
        this.miSistema.agregarEstudiante("Enguerrando", "Marigny", 2);
        this.miSistema.agregarEstudiante("Felipe", "Capeto", 3);

        Retorno r = this.miSistema.listarEstudiantes();
        assertEquals("Enguerrando#Marigny#2|Felipe#Capeto#3|Alfonso#Camaguey#5", r.valorString);
    }

       @Test
    public void testListarLibros() {
         
        this.miSistema.agregarLibro("Aves del Uruguay", "asdf", "Ilustrativo", 1);
        this.miSistema.agregarLibro("El viaje hacia el oeste", "qwer", "Fábula", 2);
        this.miSistema.agregarLibro("La torre elevada", "efgh", "Periodismo de investigación", 15);


        Retorno r = this.miSistema.listarLibros();
        assertEquals("Aves del Uruguay#asdf#Ilustrativo|La torre elevada#efgh#Periodismo de investigación|El viaje hacia el oeste#qwer#Fábula", r.valorString);
    }
    
      @Test
    public void testlistarLibrosPorCategoria() {
        // Agregamos algunos libros de distintas categorías al sistema
        
     this.miSistema.agregarLibro("Historia secreta de los mongoles", "bTY3", "Historia", 2);
    this.miSistema.agregarLibro("Afghanistan", "at6v", "Historia", 1);
    this.miSistema.agregarLibro("La torre elevada", "vQ78", "Historia", 3);
    this.miSistema.agregarLibro("I Ching", "clk28", "Cultura", 4);

    Retorno r = this.miSistema.listarLibros("Historia");

    assertEquals("Afghanistan#at6v#Historia|Historia secreta de los mongoles#bTY3#Historia|La torre elevada#vQ78#Historia", r.valorString);
    }
    
    
     @Test
    public void testListarLibrosError1() {
     
        
        
        Retorno r = this.miSistema.listarLibros("");
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);
        
        r = this.miSistema.listarLibros(null);
        assertEquals(Retorno.Resultado.ERROR_1, r.resultado);   
    
    
    }
    
    
  
    
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   }

  
    
    

