package RSI.cursos.service;

import java.util.List;

import RSI.cursos.model.Cuenta;

public interface CuentasService {
	public boolean	newCuenta(Cuenta cuenta);
	public List<Cuenta> allCuentas();

}
