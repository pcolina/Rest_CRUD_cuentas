package RSI.cursos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RSI.cursos.model.Cuenta;
import RSI.cursos.service.CuentasService;

@RestController
public class CuentasController {

	@Autowired	
	CuentasService service;
	
	@PostMapping(value="cuenta", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.TEXT_PLAIN_VALUE)
	public String nuevaCuenta(@RequestBody Cuenta cuenta){ 
		if(service.newCuenta(cuenta)) {
			return "creada";
		}else {
			return "no creada";
		}
	}
	
	@GetMapping(value="cuentas", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Cuenta> listaCuenta() {
		return service.allCuentas();
	}
	
	@GetMapping(value="cuenta/{numCuenta}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Cuenta cuenta(@PathVariable("numCuenta") int numeroCuenta) {
		return service.findCuenta(numeroCuenta);
	}
	
	@DeleteMapping(value="cuenta/{numCuenta}")
	public void eliminarCuenta(@PathVariable("numCuenta") int numeroCuenta) {
		service.deleteCuenta(numeroCuenta);
	}
		
		
	@PutMapping(value="cuenta/{numCuenta}/{saldo}")
	public void actualizarCuenta(@PathVariable("numCuenta")int numeroCuenta,
								@PathVariable("saldo") double saldo) {

		System.out.println("numero de la cuenta: "+numeroCuenta+" saldo: "+saldo);
		service.updateCuenta(numeroCuenta,  saldo);
		
	}
}
