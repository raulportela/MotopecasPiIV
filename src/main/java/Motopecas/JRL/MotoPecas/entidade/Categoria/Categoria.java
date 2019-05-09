/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.Categoria;

import Motopecas.JRL.MotoPecas.controller.produto.ProdutoController;
import java.util.HashSet;

/**
 *
 * @author Raul Portela
 */
public class Categoria {
    
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProdutos(HashSet<ProdutoController> hashSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
