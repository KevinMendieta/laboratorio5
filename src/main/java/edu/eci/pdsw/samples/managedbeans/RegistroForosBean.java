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
package edu.eci.pdsw.samples.managedbeans;


import edu.eci.pdsw.samples.entities.*;
import edu.eci.pdsw.samples.services.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "registroForoBean")
@SessionScoped
public class RegistroForosBean implements Serializable{
    
    int idActual;
    String contenidoActual, emailActual, nombreActual;
    ServiciosForo sp=ServiciosForo.getInstance();
    
    public void RegistroForosBean(){
        idActual = 1;
    }
    
    public List<Comentario> getComentariosEntrada() throws ExcepcionServiciosForos{
        return new ArrayList<Comentario>(sp.consultarEntradaForo(idActual).getRespuestas());
    }
    
    public void addRespuesta()throws ExcepcionServiciosForos{
        EntradaForo entrada = sp.consultarEntradaForo(idActual);
        Usuario usuario = new Usuario(emailActual,nombreActual);
        Date fecha = new Date(java.util.Calendar.getInstance().getTime().getTime());
        entrada.getRespuestas().add(new Comentario(usuario,contenidoActual,fecha));
    }

    public void setIdActual(int idActual) {
        this.idActual = idActual;
    }

    public void setContenidoActual(String contenidoActual) {
        this.contenidoActual = contenidoActual;
    }

    public void setEmailActual(String emailActual) {
        this.emailActual = emailActual;
    }

    public void setNombreActual(String nombreActual) {
        this.nombreActual = nombreActual;
    }

    public int getIdActual() {
        return idActual;
    }

    public String getContenidoActual() {
        return contenidoActual;
    }

    public String getEmailActual() {
        return emailActual;
    }

    public String getNombreActual() {
        return nombreActual;
    }
}
