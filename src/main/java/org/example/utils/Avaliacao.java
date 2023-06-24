package org.example.utils;

public class Avaliacao {
    private String usuarioQueEnviou;
    private int nota;
    private String comentario;

    public Avaliacao(String usuarioQueEnviou, int nota, String comentario){
        this.usuarioQueEnviou = usuarioQueEnviou;
        this.nota = nota;
        this.comentario = comentario;
    }

    @Override
    public String toString(){
        return "Usuario que enviou -> " + this.usuarioQueEnviou + " | nota -> " + this.nota + " \n| comentario -> " + this.comentario + "|\n";
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUsuarioQueEnviou() {
        return usuarioQueEnviou;
    }
    
    public void setUsuarioQueEnviou(String usuarioQueEnviou) {
        this.usuarioQueEnviou = usuarioQueEnviou;
    }
}
