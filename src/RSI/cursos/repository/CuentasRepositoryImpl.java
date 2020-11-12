package RSI.cursos.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import RSI.cursos.model.Cuenta;
@Repository
public class CuentasRepositoryImpl implements CuentasRepository {

	@Autowired
	JdbcTemplate template;
	
	@Override
	public void saveCuenta(Cuenta cuenta) {
		String sql ="insert into cuentas (numeroCuenta, saldo, tipoCuenta) values (?,?,?)";
		template.update(sql, cuenta.getNumeroCuenta(), cuenta.getSaldo(), cuenta.getTipoCuenta());
	}

	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		String sql= "select * from cuentas where numeroCuenta=?";
		List<Cuenta> cuentas= template.query(sql, (rs, f) -> new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipoCuenta")), numeroCuenta);
		return cuentas.size()>0 ? cuentas.get(0):null;
	}

	@Override
	public List<Cuenta> findAll() {
		String sql= "select * from cuentas";
		return template.query(sql, (rs, f) -> new Cuenta(rs.getInt("numeroCuenta"), rs.getDouble("saldo"), rs.getString("tipoCuenta")));
	}

}
