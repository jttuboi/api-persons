package repositories;

import java.util.List;

import com.google.gson.JsonElement;

import models.Person;

public interface IApiRepository {
	public abstract List<Person> getPersons();

	public abstract Person getPerson(Long id);

	public abstract void savePerson(Person person);

	public abstract void deletePerson(Long id);

	public abstract List<Person> getPersonsByQuery(String query);
}
