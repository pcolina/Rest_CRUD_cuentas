package RSI.cursos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RSI.cursos.model.Cuenta;
import RSI.cursos.repository.CuentasRepository;

@Service
public class CuentasServiceImpl implements CuentasService {
	@Autowired
	CuentasRepository repository;
	@Override
	public boolean newCuenta(Cuenta cuenta) {
		if (repository.findCuenta(cuenta.getNumeroCuenta())==null){ //to avoid that it already exists 
			repository.saveCuenta(cuenta);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Cuenta> allCuentas() {
		return repository.findAll();
	}

	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		// TODO Auto-generated method stub
		return repository.findCuenta(numeroCuenta);
	}

	@Override
	public void deleteCuenta(int numeroCuenta) {
		Cuenta cuenta=repository.findCuenta(numeroCuenta);
		if (cuenta!=null) {
			repository.deleteCuenta(numeroCuenta);
		}
		
	}

	@Override
	public void updateCuenta(int numeroCuenta, double saldo) {
		Cuenta cuenta=repository.findCuenta(numeroCuenta);
		if (cuenta!=null) {
			cuenta.setSaldo(saldo);
			repository.saveCuenta(cuenta);
		}
		
	}

}
