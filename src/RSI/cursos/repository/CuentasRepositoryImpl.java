package RSI.cursos.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import RSI.cursos.model.Cuenta;
@Repository
public class CuentasRepositoryImpl implements CuentasRepository {

	@Autowired
	CuentasJpaRepository repository;
	
	@Transactional
	@Override
	public void saveCuenta(Cuenta cuenta) {
		repository.save(cuenta);
	}

	@Override
	public Cuenta findCuenta(long numeroCuenta) {
		return repository.findById((int) numeroCuenta).orElse(null);  
	}

	@Override
	public List<Cuenta> findAll() {
		return repository.findAll();
	}

	@Override
	public void deleteByTipo(String tipo) {
		repository.deleteByTipo(tipo);
		
	}

	@Override
	public List<Cuenta> findBySaldo(double v1, double v2) {
		return repository.findBySaldo(v1, v2);
	}

}
