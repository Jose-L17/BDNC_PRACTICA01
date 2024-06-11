/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.dapp01practica01;

import java.util.List;

/**
 *
 * @author francisco
 */
public interface IDAOgeneral<T> {//ID
    public boolean Save (T p);
    public boolean Edit (T p);
    public boolean Delete (long id);// T pojo, ID id
    public List <T>  Findbyid (long id); //    public T <T>  Findbyid (ID id);
    public List <T> FindAll();
    
    
}
