package es.canamito.persistance.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Clase que ofrece la capa de acceso a datos sobre la base de datos de Cañamito
 * Bike
 * 
 * @author wkl
 * @version 1.210522 - Implementación y documentación inicial
 */
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
			setEntityManagerFactory(Persistence.createEntityManagerFactory("HypersistenceOptimizer"));
			setEntityManager(getEntityManagerFactory().createEntityManager());
			setEntityTransaction(getEntityManager().getTransaction());
		} catch (PersistenceException e) {
			log.fatal(e.getClass() + ": " + e.getMessage());
		}
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public EntityTransaction getEntityTransaction() {
		return this.tx;
	}

	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}

	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public void setEntityTransaction(EntityTransaction tx) {
		this.tx = tx;
	}
}
