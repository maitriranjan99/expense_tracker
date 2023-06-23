package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.db.FactoryProvider;
import com.entity.Expense;
import com.entity.User;

public class ExpenseDao {
	private EntityTransaction transaction = null;
	private EntityManager manager = null;

	public boolean saveExpense(Expense ex) {
		boolean f = false;
		try {
			manager = FactoryProvider.getFactory().createEntityManager();
			transaction = manager.getTransaction();

			manager.persist(ex);
			transaction.begin();
			transaction.commit();
			f = true;

		} catch (Exception e) {
			if (transaction != null) {
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}
	public boolean updateExpense(Expense ex) {
		boolean f = false;
		try {
			manager = FactoryProvider.getFactory().createEntityManager();
			transaction = manager.getTransaction();

			manager.merge(ex);
			transaction.begin();
			transaction.commit();
			f = true;

		} catch (Exception e) {
			if (transaction != null) {
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}
	public boolean deleteExpense(int id) {
		boolean f = false;
		try {
			manager = FactoryProvider.getFactory().createEntityManager();
			transaction = manager.getTransaction();
			
			Expense ex = manager.find(Expense.class, id);
			manager.remove(ex);
			transaction.begin();
			transaction.commit();
			f = true;
			
		} catch (Exception e) {
			if (transaction != null) {
				f = false;
				e.printStackTrace();
			}
		}
		return f;
	}

	public List<Expense> getAllExpenseByUser(User u) {
		List<Expense> list = new ArrayList<Expense>();
		try {
			manager = FactoryProvider.getFactory().createEntityManager();

			Query q = manager.createQuery("select e from Expense e where user=?1");
			q.setParameter(1, u);

			list = q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Expense getExpenseById(int id) {
		Expense ex = null;
		try {
			manager = FactoryProvider.getFactory().createEntityManager();
			Query q = manager.createQuery("select e from Expense e where id=?1");
			q.setParameter(1, id);
			ex = (Expense) q.getSingleResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ex;
	}

}
