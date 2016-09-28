/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.tests;

import edu.eci.pdsw.samples.services.ExcepcionServiciosForos;
import edu.eci.pdsw.samples.services.ServiciosForo;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.ServiciosForoStub;

/**
 *
 * @author hcadavid
 */
public class ComentariosTest {

    /*public ComentariosTest() {
         
    PRUEBAS DE EQUIVALENCIA
   
    - El identificador no corresponde al usuario TIPO:error
    - Si el comentario es vacio no deberia agregar TIPO: error
    - El foro exista TIPO: Correcto
    }
    */
    
    @Before
    public void setUp() {
    }
     
     @Test
     public void registroPacienteTestComentario() throws ExcepcionServiciosForos{
         ServiciosForoStub foro= new ServiciosForoStub() ;
         Usuario autor= new Usuario();
         Comentario ComentarioNuevo = new Comentario(autor,"Comentario Usuario ",java.sql.Date.valueOf("2000-01-01"));
         foro.agregarRespuestaForo(0, ComentarioNuevo);  
         assertEquals("El comentario no se agrego",1,foro.consultarEntradaForo(0).getRespuestas().size());
     } 

    @Test
     public void registroPacienteTestVacio() throws ExcepcionServiciosForos{
         ServiciosForoStub foro= new ServiciosForoStub() ;
         System.out.println("A");
         Usuario autor= new Usuario();
         System.out.println("B");
         Comentario ComentarioNuevo = new Comentario(autor,"",java.sql.Date.valueOf("2000-01-01"));
         System.out.println("C");
         foro.agregarRespuestaForo(1, ComentarioNuevo);  
         System.out.println("D");
         assertEquals("El comentario esta vacio",0,foro.consultarEntradaForo(1).getRespuestas().size());
     }    


}
    
    
    

