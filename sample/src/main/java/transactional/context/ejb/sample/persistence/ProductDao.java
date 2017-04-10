package transactional.context.ejb.sample.persistence;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Stateless
public class ProductDao {

	@PersistenceContext
	private EntityManager em;

	@EJB
	private ProductDao productDao;



	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case1(Product p1, Product p2) {
		em.persist(p1);
		productDao.case1_(p2);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case1_(Product p) {
		em.persist(p);

		throw new RuntimeException();
	}

	//
	//
	//
	//
	//
	//
	//
	//


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case2(Product p1, Product p2) {
		em.persist(p1);
		productDao.case2_(p2);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case2_(Product p) {
		em.persist(p);
		try {
			throw new RuntimeException();
		} catch (Exception e) {
		}
	}

	//
	//
	//
	//
	//
	//
	//
	//
	//


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case3(Product p1, Product p2) {
		em.persist(p1);
		try {
			productDao.throwExceptionInNewTransaction(p2);
		} catch (Exception e) {
		}
	}

	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case4(Product p1, Product p2) {
		em.persist(p1);
		productDao.throwExceptionInNewTransaction(p2);
	}

	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case5(Product p1, Product p2) {
		em.persist(p1);
		productDao.throwExceptionInNewTransactionButCatch(p2);
	}

	//
	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void case6(Product p1, Product p2) {
		productDao.case6_(p2);
		em.persist(p1);
		throw new RuntimeException();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void case6_(Product p) {
		em.persist(p);
	}

	//
	//
	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.NEVER)
	public void case7(Product p1, Product p2) {
		productDao.persistWithRequiredAnnotation(p1, p2);
	}

	//
	//
	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void case8(Product p1, Product p2) {
		productDao.persistWithRequiredAnnotation(p1, p2);
	}

	//
	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Transactional(rollbackOn = {Exception.class})
	public void case9(Product p1, Product p2) throws Exception {
		em.persist(p1);
		em.persist(p2);
		throw new Exception();
	}

	//
	//
	//
	//
	//

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void throwExceptionInNewTransaction(Product p) {
		em.persist(p);
		throw new RuntimeException();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void throwExceptionInNewTransactionButCatch(Product p) {
		em.persist(p);
		try {
			throw new RuntimeException();
		} catch (Exception e) {
		}
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void persistWithRequiredAnnotation(Product p1, Product p2) {
		em.persist(p1);
		em.persist(p2);
	}

	//

	public List<Product> getAllProducts() {
		TypedQuery<Product> query = em.createQuery("SELECT g FROM Product g ORDER BY g.id", Product.class);
		return query.getResultList();
	}
}