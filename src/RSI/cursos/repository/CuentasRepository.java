package RSI.cursos.repository;

import java.util.List;

import RSI.cursos.model.Cuenta;

public interface CuentasRepository {
	public void saveCuenta(Cuenta cuenta);
	public Cuenta findCuenta(long l);
	public List<Cuenta> findAll();
	public void deleteByTipo(String tipo);
	public List<Cuenta> findBySaldo(double v1, double v2);
	public void deleteCuenta(int numeroCuenta);
	public void actualizarCuenta(Cuenta cuenta);

}
