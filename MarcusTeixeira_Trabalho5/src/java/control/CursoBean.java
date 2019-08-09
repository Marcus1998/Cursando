/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Curso;
import classes.Instituicao;
import classes.Status;
import javax.inject.Named;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.net.ssl.SSLEngineResult;

/**
 *
 * @author 0767174
 */
@ManagedBean
@SessionScoped
public class CursoBean implements Serializable {
    private static final long serialVersionUID = 2L;
    private Curso curso = new Curso();
    private List<Curso> cursos = new LinkedList<>();
    private boolean editando;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getCursos() {
        cursos = curso.buscarTodos();
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
    
    public Status[] getStatus(){
        return Status.values();
    }
    
    public String limpar(String pagina) {
        this.curso = new Curso();
        return pagina;
    }
    public String editar(Curso cur){
        this.curso = cur;
        this.setEditando(true);
        return "atualizarCurso";
    }
    
    public String cadastrar(){
        System.out.println(isEditando());
        if (isEditando()) {
            curso.atualizar();
        } else {
            curso.salvar();
        }
        this.curso = new Curso();
        setEditando(false);
        return "menu";
    }
    
    public String remover(Curso cur){
        this.curso = cur;
        curso.remover();
        return "menu";
    }
    
}
