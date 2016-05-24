package it.uniroma3.clinic;

import java.util.LinkedList;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="findAllTipologies", query = "SELECT t FROM TipologiaEsame t")
public class TipologiaEsame {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String descrizione;
	@Column(nullable = false)
	private double price;
	@OneToMany
	@JoinColumn(name = "prequerisiti_tipologia")
	private List<Prerequisito> prerequisiti;
	@OneToMany
	@JoinColumn(name = "risultati_tipologia")
	private List<Risultato> risultati;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	

	public TipologiaEsame(String nome, String descrizione, double price) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.price = price;
		this.risultati = new LinkedList<Risultato>();
	}
}
