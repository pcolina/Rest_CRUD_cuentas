package RSI.cursos.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {
	@Id
	private long numeroCuenta;
	private double saldo;
	private String tipoCuenta;
	public Cuenta() {
		super();
	}
	public Cuenta(long numeroCuenta, double saldo, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipoCuenta = tipoCuenta;
	}
	public long getNumeroCuenta(){
		return numeroCuenta;
	}
	public void setNumeroCuenta(long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getTipoCuenta() {
		return tipoCuenta;
	}
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	
}
