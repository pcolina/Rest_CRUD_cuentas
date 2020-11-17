package RSI.cursos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import RSI.cursos.model.Cuenta;

public interface CuentasJpaRepository extends JpaRepository<Cuenta, Integer>{
	@Transactional
	@Modifying
	@Query("Delete From Cuenta c Where c.tipoCuenta=?1")
	void deleteByTipo(String tipo);
	

	@Query("Select c From Cuenta c Where c.saldo>=?1 and c.saldo<=?2")
	List<Cuenta> findBySaldo(double v1, double v2);
	
	@Query("Select c From Cuenta c Where c.saldo>=?1 and c.saldo<=?2")
	List<Cuenta> d(double v1, double v2);
	

}
