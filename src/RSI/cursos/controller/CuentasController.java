package RSI.cursos.controller;

import java.awt.print.Printable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import RSI.cursos.model.Cuenta;
import RSI.cursos.service.CuentasService;

@Controller
public class CuentasController {

	@Autowired	
	CuentasService service;
	
	@PostMapping(value="cuenta")
	public String nuevaCuenta(@RequestParam("numeroCuenta") int numeroCuenta,
			@RequestParam("saldo") double saldo ,
			@RequestParam("tipoCuenta") String tipo )
			{
		Cuenta cuenta = new Cuenta(numeroCuenta, saldo, tipo);
		if(service.newCuenta(cuenta)) {
			return "menu";
		}else {
			return "error";
		}
	}
	
	@GetMapping(value="cuentas")
	public String listaCuenta(HttpServletRequest request) {

        System.out.println(">> listaCuenta");
		List<Cuenta> cuentas=service.allCuentas();

        System.out.println(">>>>"+cuentas);
		request.setAttribute("cuentas", cuentas);
		request.setAttribute("nombre", "Pablo");
		return "cuentas";
	}
}
