/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package database;

import java.util.List;

import com.db4o.query.Query;

import model.Noticia;

public class DAONoticia extends DAO<Noticia> {

	public Noticia read(Object key) {
		int id = (int) key;
		Query q = manager.query();
		q.constrain(Noticia.class);
		q.descend("id").constrain(id);
		List<Noticia> resultados = q.execute();
		if (resultados.size() > 0)
			return resultados.get(0);
		else
			return null;
	}

	// metodo da classe DAO sobrescrito DAONoticia para
	// criar "id" sequencial
	public void create(Noticia obj) {
		int novoid = super.gerarId(); // gerar novo id da classe
		obj.setId(novoid); // atualizar id do objeto antes de grava-lo no banco
		manager.store(obj);
	}

	// --------------------------------------------
	// consultas de Noticia
	// --------------------------------------------

	public List<Noticia> getNoticiasPorDataPublicacao(String dataBuscada) {
		Query q = manager.query();
		q.constrain(Noticia.class);

		q.descend("dataPublicacao").constrain(dataBuscada);
		return q.execute();
	}

	public List<Noticia>  getNoticiasPorTitulo(String titulo) {
		Query q = manager.query();
		q.constrain(Noticia.class);
		q.descend("titulo").constrain(titulo);
		return q.execute();
	}

}
