package repositories;

import java.util.List;

import javax.persistence.Query;

import models.Person;
import utils.Connection;

public class ApiRepository implements IApiRepository {

	Connection connection = new Connection();
	
	@Override
	public List<Person> getPersons() {
		List<Person> persons = null;
		
		try {
			connection.open();
			Query query = connection.em.createQuery("SELECT p FROM Person p");
			persons = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return persons;
	}

	@Override
	public Person getPerson(Long id) {
		Person person = null;
		
		try {
			connection.open();
			Query query = connection.em.createQuery("SELECT p FROM Person p WHERE p.id = :id").setParameter("id", id);
			person = (Person) query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return person;
	}

	@Override
	public void savePerson(Person person) {
		try {
			connection.open();
			if (person.getId() == -1) {
				person.setId((long) 0);
				connection.em.getTransaction().begin();
				connection.em.persist(person);
				connection.em.getTransaction().commit();
			} else {
				if (connection.em.find(Person.class, person.getId()) == null) {
					throw new Exception("Erro ao atualizar a palestra!");
				}
				connection.em.merge(person);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void deletePerson(Long id) {
		try {
			connection.open();
			Person person = connection.em.find(Person.class, id);
			connection.em.remove(person);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public List<Person> getPersonsByQuery(String query) {
		List<Person> persons = null;
		try {
			connection.open();
			Query queryResult = connection.em.createQuery("SELECT p FROM Person p WHERE p.name LIKE %:query%").setParameter("query", query);
			persons = queryResult.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return persons;
	}

}
