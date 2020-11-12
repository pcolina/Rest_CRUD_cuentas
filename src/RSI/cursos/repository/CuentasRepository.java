package RSI.cursos.repository;

import java.util.List;

import RSI.cursos.model.Cuenta;

public interface CuentasRepository {
	public void saveCuenta(Cuenta cuenta);
	public Cuenta findCuenta(int numerocuenta);
	public List<Cuenta> findAll();

}
