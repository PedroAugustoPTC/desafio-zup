package br.com.zup.desafio.config.validacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsValidator implements ConstraintValidator<Exists, Object> {

	private String domainAttribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(Exists params) {
		this.domainAttribute = params.campo();
		this.klass = params.classe();
	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext context) {
		if (o == null) {
			return true;
		}
		Query query = entityManager
				.createQuery("select 1 from " + klass.getName() + " where " + domainAttribute + " = :value");
		query.setParameter("value", o);
		List<?> list = query.getResultList();

		return !list.isEmpty();
	}

}
