package RSI.cursos.repository;

import java.util.List;

import RSI.cursos.model.Cuenta;

public interface CuentasRepository {
	public void saveCuenta(Cuenta cuenta);
	public Cuenta findCuenta(long l);
	public List<Cuenta> findAll();

}
