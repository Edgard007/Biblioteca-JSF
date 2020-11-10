/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.dao.DaoLibro;
import com.modelo.Libro;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 * Nombre de la clase:ComprasBean
 * Fecha:12/07/2018
 * Versión:1.0
 * CopyRight:Biblioteca
 * @author Edgard Palacios
 */

@Named(value = "comprasBean")
@ViewScoped
public class ComprasBean implements Serializable{

    //Atributos generales
    private Libro lb = new Libro();
    private List<Libro> listarLb;
    DaoLibro dao = new DaoLibro();
    
    
    public ComprasBean() {
    }

    public Libro getLb() {
        return lb;
    }

    public void setLb(Libro lb) {
        this.lb = lb;
    }

    public List<Libro> getListarLb() {
        return listarLb;
    }

    public void setListarLb(List<Libro> listarLb) {
        this.listarLb = listarLb;
    }

    public DaoLibro getDao() {
        return dao;
    }

    public void setDao(DaoLibro dao) {
        this.dao = dao;
    }
    
    
    
    public void listarLb() throws Exception{
        DaoLibro dao;
        
        dao = new DaoLibro();
        this.listarLb = dao.mostrarLibros();
        this.lb = new Libro();
    }
    
    public void sacarId(int id) throws Exception{
        this.lb = new Libro();
        lb.setIdLibro(id);
    }
    
    
    public void modificarLb() throws Exception{
        DaoLibro dao;
        
        int id=lb.getIdLibro();
        int n=lb.getCantidad();
        
        dao = new DaoLibro();
        int r=dao.modificarLb(id,n);
        
        listarLb();
        
        if(r==1)
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Exito","Cantidad Agregada"));
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("error","FAIL"));
        }
        
    }
    
}
