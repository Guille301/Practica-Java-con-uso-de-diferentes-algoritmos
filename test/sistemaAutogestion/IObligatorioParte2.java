/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaAutogestion;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author adril
 */
public class IObligatorioParte2 {
      private Sistema miSistema;
    
    public IObligatorioParte2() {
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
    
    
    
    
    /*PrestarLibro*/
      @Test
    public void testPrestarLibro() {
        Retorno r = miSistema.agregarLibro("Ariel", "a12", "Ensayo", 3);
     assertEquals(Retorno.ok().resultado,r.resultado);
     
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
      assertEquals(Retorno.ok().resultado,r.resultado);

   
       this.miSistema.prestarLibro("a12", 1);
       this.miSistema.prestarLibro("a12", 1);
       this.miSistema.prestarLibro("a12", 1);
  
     assertEquals(Retorno.ok().resultado,r.resultado);
        
        
    }
    
    
    @Test
    public void testPrestarLibroError1() {
      Retorno r = miSistema.agregarLibro("Ariel", "", "Ensayo", 3);

     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
          
         r = this.miSistema.prestarLibro("", 1);
     assertEquals(Retorno.error1().resultado,r.resultado);
      
      
    }
    
     @Test
    public void testPrestarLibroError2() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1)
             ;
         r = this.miSistema.prestarLibro("hhyg", 1);
     assertEquals(Retorno.error2().resultado,r.resultado);
    }
    
     @Test
    public void testPrestarLibroError3() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", -8);
     this.miSistema.agregarEstudiante("Juan", "Perez", 500001);

         r = this.miSistema.prestarLibro("asdf", -8);
         r = this.miSistema.prestarLibro("asdf", 500001);

     assertEquals(Retorno.error3().resultado,r.resultado);
    }
    
    
       @Test
    public void testPrestarLibroError4() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
     

         r = this.miSistema.prestarLibro("asdf", 87);
       

     assertEquals(Retorno.error4().resultado,r.resultado);
    }
    
           @Test
    public void testPrestarLibroError5() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 1);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
          this.miSistema.agregarEstudiante("Ro", "Gur", 83);

         r = this.miSistema.prestarLibro("asdf", 8);
       r = this.miSistema.prestarLibro("asdf", 83);
     assertEquals(Retorno.error5().resultado,r.resultado);
    }
    
    
    
      @Test
    public void testPrestarLibroError6() {
        
     
      this.miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 15);
       this.miSistema.agregarLibro("Del freno al impulso", "as2df", "Ensayo", 15);
        this.miSistema.agregarLibro("La metamorfosis", "as23df", "Ensayo", 15);
         this.miSistema.agregarLibro("La iliada", "as4df", "Ensayo", 15);
          this.miSistema.agregarLibro("La Odisea", "as5df", "Ensayo", 15);
           this.miSistema.agregarLibro("La guerra de las Galias", "asd6f", "Ensayo", 15);
            this.miSistema.agregarLibro("Riqueza de las naciones", "as7df", "Ensayo", 15);
             this.miSistema.agregarLibro("Egipto", "asd8f", "Ensayo", 15);
             this.miSistema.agregarLibro("Historia de las guerras", "as9df", "Ensayo", 15);
               this.miSistema.agregarLibro("Programacion en JAVA", "as10df", "Ensayo", 15);
                this.miSistema.agregarLibro("Matematica", "asd11f", "Ensayo", 15);
               
      
      
      
      
     this.miSistema.agregarEstudiante("Rob", "Gurndez", 1);
     this.miSistema.agregarEstudiante("Rerto", "Gurndez", 2);
     this.miSistema.agregarEstudiante("Roerto", "Gundez", 3);
     this.miSistema.agregarEstudiante("Rorto", "Gurmedez", 4);
     this.miSistema.agregarEstudiante("Roo", "Gendez", 5);
     this.miSistema.agregarEstudiante("Robto", "Gu", 6);
     this.miSistema.agregarEstudiante("Ro", "G", 7);
     this.miSistema.agregarEstudiante("Ro", "Gurdez", 8);
     
          
//Prueba de si ya existe un prestamo activo de ese libro para ese estudiante
 Retorno r = this.miSistema.prestarLibro("asdf", 8);
  r =     this.miSistema.prestarLibro("asdf", 8);
       
  
  
  //Prueba de que tiene 8 prestamos activos
         this.miSistema.prestarLibro("asdf", 1);
          this.miSistema.prestarLibro("as2df", 1);
          this.miSistema.prestarLibro("as23df", 1);
            this.miSistema.prestarLibro("as4df", 1);
              this.miSistema.prestarLibro("as5df", 1);
              this.miSistema.prestarLibro("asd6f", 1);
              this.miSistema.prestarLibro("as7df", 1);
              this.miSistema.prestarLibro("asd11f", 1);

 r =    this.miSistema.prestarLibro("asd8f", 1);
       
     assertEquals(Retorno.error6().resultado,r.resultado);
        
    }
    
    
    
    
  
 
    /*****Reservar libro*****/
    
     @Test
    public void testReservarLibroOK() {
        Retorno r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
             r = this.miSistema.agregarEstudiante("Robert", "Gurmendez", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
               r = this.miSistema.agregarEstudiante("Rober", "Gurmendez", 3);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
        
        
        r = this.miSistema.agregarLibro("Steve Jobs", "asde1", "Biografia", 2);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
         this.miSistema.prestarLibro("asde1", 1);
         this.miSistema.prestarLibro("asde1", 2);
       
        
        r = this.miSistema.reservarLibro("asde1", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);

  
    }
    
    
        
    @Test
    public void testReservarLibroError1() {
      Retorno r = miSistema.agregarLibro("Ariel", "", "Ensayo", 3);
     
 //Ver como pasarle el null
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
         r = this.miSistema.reservarLibro("", 1);
     assertEquals(Retorno.error1().resultado,r.resultado);
      
      
    }
    
    
      @Test
    public void testReservarLibroError2() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
     r = this.miSistema.reservarLibro("hhyg", 1);
     assertEquals(Retorno.error2().resultado,r.resultado);
    }
    
    
       
      @Test
    public void testReservarLibroError3() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", -1);
     this.miSistema.agregarEstudiante("Juan", "Perez", 500001);

         r = this.miSistema.reservarLibro("asdf", -1);
         r = this.miSistema.reservarLibro("asdf", 500001);

     assertEquals(Retorno.error3().resultado,r.resultado);
    }
    
    
       @Test
    public void testReservarLibroError4() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
         r = this.miSistema.reservarLibro("asdf", 87);
       

     assertEquals(Retorno.error4().resultado,r.resultado);
    }
    
          @Test
    public void testReservarLibroError5() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 2);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
     this.miSistema.agregarEstudiante("Ro", "Gur", 83);

          this.miSistema.prestarLibro("asdf", 8);

       r = this.miSistema.reservarLibro("asdf", 83);
     assertEquals(Retorno.error5().resultado,r.resultado);
    }
  
    
    
    
    
    
    /**************Devolver libro*************/
    
        @Test
    public void testDevolverLibroOK() {
        Retorno r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        this.miSistema.agregarEstudiante("Juan", "Perez", 2);

   
        r = this.miSistema.agregarLibro("Steve Jobs", "asde1", "Biografia", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);
        
         this.miSistema.prestarLibro("asde1", 1);
       
         this.miSistema.reservarLibro("asde1", 2);
        
        r = this.miSistema.devolverLibro("asde1", 1);
        assertEquals(Retorno.Resultado.OK, r.resultado);

    }
    
    
         
    @Test
    public void testDevolverLibroError1() {
      Retorno r = miSistema.agregarLibro("Ariel", "", "Ensayo", 3);
     
 
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
         r = this.miSistema.devolverLibro("", 1);
     assertEquals(Retorno.error1().resultado,r.resultado);
      
      
    }
    
    
      @Test
    public void testDevolverLibroError2() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
     r = this.miSistema.devolverLibro("hhyg", 1);
     assertEquals(Retorno.error2().resultado,r.resultado);
    }
    
    
       
      @Test
    public void testDevolverLibroError3() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", -1);
     this.miSistema.agregarEstudiante("Juan", "Perez", 500001);

         r = this.miSistema.devolverLibro("asdf", -1);
         r = this.miSistema.devolverLibro("asdf", 500001);

     assertEquals(Retorno.error3().resultado,r.resultado);
    }
    
    
       @Test
    public void testDevolverLibroError4() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     
      this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
      this.miSistema.prestarLibro("asdf", 8);

      r = this.miSistema.devolverLibro("asdf", 87);
       

     assertEquals(Retorno.error4().resultado,r.resultado);
    }
    
    
    @Test
    public void testDevolverLibroError5() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     
      this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
      
 
      r = this.miSistema.devolverLibro("asdf", 8);
       

     assertEquals(Retorno.error5().resultado,r.resultado);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      /*Eliminar libro*/
    
      @Test
    public void testEliminarLibro() {
        this.miSistema.agregarLibro("El profeta armado", "asdw1", "Biografia", 4);
        
        Retorno r = this.miSistema.eliminarLibro("asdw1");
        assertEquals(Retorno.Resultado.OK, r.resultado);
    }
    
    
    
    /********Listar prestamos de un estudiate*******/
    
   @Test
    public void testListarPrestamosEstudianteOK() {
    this.miSistema.agregarLibro("Historia secreta de los mongoles", "bTY3", "Historia", 2);
    this.miSistema.agregarLibro("Afghanistan", "at6v", "Historia", 1);
    this.miSistema.agregarLibro("La torre elevada", "vQ78", "Historia", 3);
    this.miSistema.agregarLibro("I Ching", "clk28", "Cultura", 4);

    this.miSistema.agregarEstudiante("Joaquin", "Ponce", 1);
    this.miSistema.agregarEstudiante("Joa", "Po", 2);
    this.miSistema.agregarEstudiante("Joan", "Perez", 3);

    this.miSistema.prestarLibro("bTY3", 1);
    this.miSistema.prestarLibro("at6v", 1);
    this.miSistema.prestarLibro("vQ78", 1);

   
       this.miSistema.devolverLibro("bTY3", 1);

    
    
    Retorno r = this.miSistema.listarPrestamos(1);
    assertEquals("La torre elevada#vQ78#Historia#activo|Afghanistan#at6v#Historia#activo|Historia secreta de los mongoles#bTY3#Historia#Finalizado", r.valorString);
    }

       @Test
    public void testListarPrestamosEstudianteError1() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
      
     this.miSistema.agregarEstudiante("Roberto", "Gurmendez", -8);
     this.miSistema.agregarEstudiante("Juan", "Perez", 500001);

         r = this.miSistema.listarPrestamos(-8);
         r = this.miSistema.listarPrestamos(500001);

     assertEquals(Retorno.error1().resultado,r.resultado);
    }
    
    
         @Test
    public void testListarPrestamosEstudianteError2() {
      Retorno r = miSistema.agregarLibro("Ariel", "asdf", "Ensayo", 3);
     
      this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 8);
      this.miSistema.prestarLibro("asdf", 8);

      r = this.miSistema.listarPrestamos(87);
       

     assertEquals(Retorno.error2().resultado,r.resultado);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /******* Cantidad de prestamos activos **********/
        @Test
    public void testCantidadPrestamosActivos() {
     this.miSistema.agregarLibro("Historia secreta de los mongoles", "bTY3", "Historia", 5);
    this.miSistema.agregarLibro("Afghanistan", "at6v", "Historia", 1);
    this.miSistema.agregarLibro("La torre elevada", "vQ78", "Historia", 3);
    this.miSistema.agregarLibro("I Ching", "clk28", "Cultura", 4);

    this.miSistema.agregarEstudiante("Joaquin", "Ponce", 1);
    this.miSistema.agregarEstudiante("Joa", "Po", 2);
   this.miSistema.agregarEstudiante("Joaa", "Pos", 3);
   this.miSistema.agregarEstudiante("Juan", "Posi", 4);


    this.miSistema.prestarLibro("bTY3", 1);
    this.miSistema.prestarLibro("bTY3", 2);
    this.miSistema.prestarLibro("bTY3", 3);
    this.miSistema.prestarLibro("bTY3", 4);

    this.miSistema.devolverLibro("bTY3", 4);


    
    Retorno r = this.miSistema.cantidadPrestamosActivos("bTY3");
    assertEquals("3", r.valorString);
    }

    
      @Test
    public void testCantidadPrestamosActivosError1() {
      Retorno r = miSistema.agregarLibro("Ariel", "", "Ensayo", 3);
     
 
     r = this.miSistema.agregarEstudiante("Roberto", "Gurmendez", 1);
         r = this.miSistema.devolverLibro("", 1);
     assertEquals(Retorno.error1().resultado,r.resultado);
      
      
    }
    
    /*Libros mas prestados*/
    
    @Test
public void testLibrosMasPrestados() {
    this.miSistema.agregarLibro("Los Tres Mosqueteros", "t3P9", "Aventura", 4);
    this.miSistema.agregarLibro("Dune", "vYWU", "Ciencia ficción", 2);
    this.miSistema.agregarLibro("En el espiritu de Caballo Loco", "z09iI", "Historia", 3);
    this.miSistema.agregarLibro("Un siglo de Deshonor", "HHJ65", "Ciencias Sociales", 4);

    this.miSistema.agregarEstudiante("Miguel", "Tuckashevsky", 1);
    this.miSistema.agregarEstudiante("Norman", "Chowdhury", 2);
    this.miSistema.agregarEstudiante("Samuel", "Jueces", 3);
    this.miSistema.agregarEstudiante("Juan", "Pedro", 4);

    this.miSistema.prestarLibro("t3P9", 1);
    this.miSistema.prestarLibro("t3P9", 2);
    this.miSistema.prestarLibro("t3P9", 3);
    this.miSistema.prestarLibro("vYWU", 1);
    this.miSistema.prestarLibro("vYWU", 2);
    this.miSistema.prestarLibro("clk28", 1);
    this.miSistema.prestarLibro("z09iI", 2);


    Retorno r = this.miSistema.librosMasPrestados();

    assertEquals("Los Tres Mosqueteros#t3P9#Aventura#3", r.valorString);
}

    
    
    @Test
public void testDeshacerEliminaciones() {
    // Configuración inicial
    this.miSistema.agregarLibro("Los Tres Mosqueteros", "t3P9", "Aventura", 4);
    this.miSistema.agregarLibro("Dune", "vYWU", "Ciencia ficción", 2);
    this.miSistema.agregarLibro("En el espiritu de Caballo Loco", "z09iI", "Historia", 3);
    this.miSistema.agregarLibro("Un siglo de Deshonor", "HHJ65", "Ciencias Sociales", 4);
    
    this.miSistema.eliminarLibro("t3P9");
    this.miSistema.eliminarLibro("z09iI");
    this.miSistema.eliminarLibro("HHJ65");
    
    
    Retorno r = this.miSistema.deshacerEliminaciones(2);
    assertEquals("Un siglo de Deshonor#HHJ65#Ciencias Sociales|En el espiritu de Caballo Loco#z09iI#Historia", r.valorString);

}
    
    
    
    
    /*Deshacer ultimas eliminaciones*/
           @Test
    public void testUltimasEliminaciones() {
      
        
   
         this.miSistema.agregarLibro("Steve Jobs", "asde1", "Biografia", 2);
     this.miSistema.agregarLibro("Afghanistan", "at6v", "Historia", 1);
    this.miSistema.agregarLibro("La torre elevada", "vQ78", "Historia", 3);
    this.miSistema.agregarLibro("I Ching", "clk28", "Cultura", 4);
        
         this.miSistema.eliminarLibro("asde1");
       this.miSistema.eliminarLibro("at6v");
       this.miSistema.eliminarLibro("vQ78");
       this.miSistema.eliminarLibro("clk28");
     
     Retorno r = this.miSistema.deshacerEliminaciones(1);
        assertEquals(Retorno.Resultado.OK, r.resultado);

  
    }
    
    
    
    /*Ranking de categorias*/   
    
           @Test
    public void testRankingCategorias() {
      
        
    this.miSistema.agregarLibro("Los Tres Mosqueteros", "t3P9", "Aventura", 4);
    this.miSistema.agregarLibro("Dune", "vYWU", "Ciencia ficción", 2);
    this.miSistema.agregarLibro("En el espiritu de Caballo Loco", "z09iI", "Historia", 3);
    this.miSistema.agregarLibro("Metafisica", "HHJ65", "Filosofia", 14);
    
    

    this.miSistema.agregarEstudiante("Miguel", "Tuckashevsky", 1);
    this.miSistema.agregarEstudiante("Norman", "Chowdhury", 2);
    this.miSistema.agregarEstudiante("Samuel", "Jueces", 3);
    this.miSistema.agregarEstudiante("Juan", "Pedro", 4);

    this.miSistema.prestarLibro("t3P9", 1);
    this.miSistema.prestarLibro("vYWU", 2);
    this.miSistema.prestarLibro("vYWU", 3);
    this.miSistema.prestarLibro("z09iI", 1);
    this.miSistema.prestarLibro("z09iI", 2);
    
    
    this.miSistema.prestarLibro("HHJ65", 1);
    this.miSistema.prestarLibro("HHJ65", 4);
    this.miSistema.prestarLibro("HHJ65", 2);
    this.miSistema.prestarLibro("HHJ65", 3);

    
     
     Retorno r = this.miSistema.prestamosXCategoría();
        assertEquals(Retorno.Resultado.OK, r.resultado);
    assertEquals("Aventura#1|Ciencia ficción#2|Filosofia#4|Historia#2", r.valorString);

  
    }
    
    
    
    
    
    
    
}
