package co.com.jgonzo.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import co.com.jgonzo.dominio.Articulo;
import co.com.jgonzo.servicios.ArticuloService;

@ManagedBean
@RequestScoped
public class ArticuloBean {

	
	//Creo una Instancia del EJB de la caoa de servicio
	@EJB
	private ArticuloService articuloService;
	
	List<Articulo> articulos;
	
	//Constructor vacio Obligatorio para los beans
	public ArticuloBean() {
		
	}

	@PostConstruct
	public void inicializar() {
		articulos = articuloService.listarArticulos();
	}

	public void editListener(RowEditEvent event) {
		Articulo articulo = (Articulo) event.getObject();
		articuloService.modificarArticulo(articulo);
	}
	
	
	//Seter y getter
	public List<Articulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	
	
	
	
	
	
}
