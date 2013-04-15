/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.dao;

import controller.dao.db.Connection;
import controller.dao.model.FuncionarioDAO;
import model.Funcionario;



/**
 *
 * @author Adriano
 */
public class Main {
    public static void main(String[] args) {
        FuncionarioDAO f = new FuncionarioDAO(Funcionario.class);
        for (Funcionario fd : f.selectAtivo()) {
            System.out.println(fd);
        }
    }
}
