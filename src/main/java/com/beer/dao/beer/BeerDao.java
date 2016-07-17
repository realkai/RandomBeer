package com.beer.dao.beer;

import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.beer.dao.HibernateDao;
import com.beer.domain.Beer;

@Repository
public class BeerDao extends HibernateDao<Beer> implements IBeerDao {

    @Override
    public Beer getById(Long id) {
	String stmt = "from Beer b where id=:id";

	Query query = getSession().createQuery(stmt);

	query.setParameter("id", id);

	return (Beer) query.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Beer> getAll() {
	String stmt = "from Beer b";
	Query query = getSession().createQuery(stmt).setCacheable(true);

	return query.list();
    }

    @Override
    public void deleteById(Long id) {
	String stmt = "delete from Beer where id=:id";
	getSession().createQuery(stmt).setParameter("id", id);
    }

    @Override
    public void update(Beer beer) {
	getSession().update(beer);
    }

    @Override
    public Beer getRandomBeer() {
	String stmt = "select * from Beer order by random() limit 1";
	Query query = getSession().createSQLQuery(stmt).addEntity(Beer.class);
	return (Beer) query.uniqueResult();
    }

}
