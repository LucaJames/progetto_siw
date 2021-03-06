package it.uniroma3.facade;

import it.uniroma3.clinic.Esame;
import it.uniroma3.clinic.Medico;
import it.uniroma3.clinic.Paziente;
import it.uniroma3.clinic.TipologiaEsame;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;


	@Stateless
	public class EsameFacade {
		
	    @PersistenceContext(unitName = "exams-unit")
	    private EntityManager em;
	    
		public Esame createEsame(Date dataPrenotazione, TipologiaEsame tipologia, Paziente paziente, Medico medico) {
			Esame e = new Esame(dataPrenotazione, tipologia, paziente, medico);
			em.persist(e);
			return e;
		}
		
		
		public Esame getEsame(Long id) {
		    Esame e = em.find(Esame.class, id);
			return e;
		}
		
		public List<Esame> getAllEsami() {
	        CriteriaQuery<Esame> cq = em.getCriteriaBuilder().createQuery(Esame.class);
	        cq.select(cq.from(Esame.class));
	        List<Esame> esami = em.createQuery(cq).getResultList();
			return esami;
		}

		public void updateEsame(Esame e) {
	        em.merge(e);
		}
		
	    private void deleteEsame(Esame esame) {
	        em.remove(esame);
	    }

		public void deleteEsame(Long id) {
	        Esame esame = em.find(Esame.class, id);
	        deleteEsame(esame);
		}


		public List<Esame> getEsamiPaziente(Long id) {
			TypedQuery<Esame> q = em.createQuery("SELECT e FROM Esame e WHERE e.paziente = ?", Esame.class);
			q.setParameter(1, id);
			List<Esame> esamiPaziente = q.getResultList();
			return esamiPaziente;
			
		}
}