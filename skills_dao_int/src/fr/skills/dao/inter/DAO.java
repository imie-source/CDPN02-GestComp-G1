package fr.skills.dao.inter;

import java.util.List;

public interface DAO<T> {

	public abstract List<T> findAll();

	public abstract T create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T find(int id);
}