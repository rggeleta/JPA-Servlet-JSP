package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.ListOfTemp;

/**
 * rggeleta@dmacc.edu roman
 * CIS175-Fall2021
 * Oct 5, 2021
 */
public class ListTempHelper {
private static final List<ListOfTemp> foundItems = null;
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleWeek5");
	
	
	public void insertItem(ListOfTemp lt) {
		EntityManager em = emfactory.createEntityManager();
		
		ListTempHelper dao = new ListTempHelper();
		dao.insertItem(lt);
		em.getTransaction().begin();
		em.persist(lt);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<ListOfTemp> showAllItems(){
		
		EntityManager em = emfactory.createEntityManager();
		List<ListOfTemp> allItems = em.createQuery("SELECT i from ListOfTemp i").getResultList();
		return allItems;
		
	}

	public void deleteItem(ListOfTemp toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOfTemp> typedQuery = em.createQuery("select lt from ListOfTemp li where li.Temperature = :selectedTemperature and li.fromTo = :selectedFromTo", ListOfTemp.class);
		
		typedQuery.setParameter("selectedTemerature", toDelete.getTemperature());
		typedQuery.setParameter("selectedFromTo", toDelete.getFromTo());
		
		typedQuery.setMaxResults(1);
		
		ListOfTemp result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public ListOfTemp searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		ListOfTemp found = em.find(ListOfTemp.class, idToEdit);
		em.close();
		return found;
	}

	public void updateItem(ListOfTemp toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListOfTemp> searchForItemByStore(int Temperature) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOfTemp> typedQuery = em.createQuery("select li from ListOfTemp li where li.Temp = :selectedTemperature", ListOfTemp.class);
		
	
		em.close();
		return foundItems;
	}

	public List<ListOfTemp> searchForItemByItem(int Temerature) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListOfTemp> typedQuery = em.createQuery("select li from ListOfTemp li where li.temerature = :selectedItem", ListOfTemp.class);
		em.close();
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}

}
