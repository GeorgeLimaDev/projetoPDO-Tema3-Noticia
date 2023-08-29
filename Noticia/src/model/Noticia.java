package model;

import java.util.ArrayList;
import java.util.List;

public class Noticia {
	private int id;
	private String titulo;
	private String datapublicacao;
	private String link;
	private List<Assunto> listaAssuntos = new ArrayList<>();

	public Noticia(int id, String titulo, String datapublicacao, String link) {
		this.id = id;
		this.titulo = titulo;
		this.datapublicacao = datapublicacao;
		this.link = link;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDatapublicacao() {
		return datapublicacao;
	}

	public void setDatapublicacao(String datapublicacao) {
		this.datapublicacao = datapublicacao;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void adicionar(Assunto assunto) {
		this.listaAssuntos.add(assunto);
	}

	public void remover(Assunto assunto) {
		this.listaAssuntos.remove(assunto);
	}

	public List<Assunto> listar() {
		return this.listaAssuntos;
	}

	public String localizar(String assuntoKey) {
		for (Assunto assunto : listaAssuntos) {
			if (assuntoKey.equals(assunto.getNome())) {
				return assunto.getNome();
			}
		}
		return "Assunto não encontrado";
	}
	
	@Override
	public String toString() {
		String assuntosNomes="";
    	for(Assunto n : this.listaAssuntos) {	
    		assuntosNomes += n.getNome() +" | ";
    	}
		return "id: " + id + ", titulo: " + titulo + ", Publicada: " + datapublicacao + ", link: " + link
				+ "\n Assuntos: " + assuntosNomes+ "";
	}
}
