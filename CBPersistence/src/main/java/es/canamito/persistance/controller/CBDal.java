package es.canamito.persistance.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CBDal {

	private static final Logger log = LogManager.getLogger();

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;

	/**
	 * Obtiene la unidad de persistencia usada en la aplicacion y define un
	 * EntityManager y un EntityTransaction
	 *
	 * @throws PersistenceException
	 */
	public CBDal() {
		try {
			setEntityManagerFactory(Persistence.createEntityManagerFactory("TallerMecanicoSinSpringPU"));
			setEntityManager(getEntityManagerFactory().createEntityManager());
			setEntityTransaction(getEntityManager().getTransaction());
		} catch (PersistenceException pe) {
			log.fatal(pe.getLocalizedMessage());
		}
	}

	private EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}

	private EntityManager getEntityManager() {
		return this.em;
	}

	private EntityTransaction getEntityTransaction() {
		return this.tx;
	}

	private void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	private void setEntityManager(EntityManager em) {
		this.em = em;
	}

	private void setEntityTransaction(EntityTransaction tx) {
		this.tx = tx;
	}
}
