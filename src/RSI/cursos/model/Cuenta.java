package RSI.cursos.model;

public class Cuenta {
	private long numeroCuenta;
	private double saldo;
	private String tipoCuenta;
	public Cuenta(long numeroCuenta2, double saldo, String tipoCuenta) {
		super();
		this.numeroCuenta = numeroCuenta2;
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
