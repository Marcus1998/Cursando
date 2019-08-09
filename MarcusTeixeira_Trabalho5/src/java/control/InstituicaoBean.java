/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import classes.Instituicao;
import java.util.LinkedList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Roberta
 */
@ManagedBean
@SessionScoped
public class InstituicaoBean {
    private static final long serialVersionUID = 2L;
    private Instituicao usuarioLogado = new Instituicao();
    private Instituicao usuario = new Instituicao();
    private LinkedList<Instituicao> usuarios = new LinkedList();
    private boolean editando;

    public Instituicao getInstituicaoLogado() {
        return usuarioLogado;
    }

    public void setInstituicaoLogado(Instituicao usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Instituicao getInstituicao() {
        return usuario;
    }

    public void setInstituicao(Instituicao usuario) {
        this.usuario = usuario;
    }

    public LinkedList<Instituicao> getInstituicaos() {
        return usuarios;
    }

    public void setInstituicaos(LinkedList<Instituicao> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean isEditando() {
        return editando;
    }

    public void setEditando(boolean editando) {
        this.editando = editando;
    }
    
    public String cadastrarInstituicao(){
        return "cadastrarInstituicao";
    }
    
    public String limpar(String pagina) {
        this.usuario = new Instituicao();
        return pagina;
    }
    
    public String logar() {
        /*if (usuario.logar()) {
            this.usuarioLogado = usuario;    
            usuario = new Instituicao();
            return "menu";
        } else {
            return "invalido";
        }*/
        usuario = usuario.logar();
        if(usuario != null){
            this.usuarioLogado = usuario;
            return "menu";
        }else{
            return "invalido";
        }
    }
    
    public String editar() {
        setEditando(true);
        return "atualizarInstituicao";
    }
    
    public String cadastrar(){
        if (!editando) {
            usuario.salvar();
        } else {
            usuarioLogado.atualizar();
            setEditando(false);
            return "menu";
        }
        this.usuario = new Instituicao();
        setEditando(false);
        return "index";
    }
    
    public String sair(){
        usuarioLogado = new Instituicao();
        return "index";
    }
    
    public String excluir(){
        usuarioLogado.remove();
        usuarioLogado = new Instituicao();
        return "index";
    }
}
