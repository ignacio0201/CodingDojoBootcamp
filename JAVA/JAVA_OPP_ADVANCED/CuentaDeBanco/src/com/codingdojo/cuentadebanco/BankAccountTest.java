package com.codingdojo.cuentadebanco;

public class BankAccountTest {

	public static void main(String[] args) {
		
		//Crear cuenta
		BankAccount ctaJackieChan = new BankAccount("Jackie Chan");
		BankAccount ctaIgnacioMiranda = new BankAccount("Ignacio Miranda");
		
		//Obtener número de cuenta
		ctaIgnacioMiranda.getNumDeCuenta();
		ctaJackieChan.getNumDeCuenta();

		//Depositar dinero
			//Depositar a la Cta. Corriente
		ctaJackieChan.depositarDinero("corriente", 700.00);
		ctaJackieChan.depositarDinero("corriente", 50.00);
		ctaJackieChan.retirarDinero("corriente", 698.50); //this
		ctaIgnacioMiranda.depositarDinero("corriente", 1750.00);
			//Depositar a la Cta. de Ahorros
		ctaJackieChan.depositarDinero("ahorros", 1200.00);
		
		//Retirar dinero
			//Retirar dinero de la Cta. Corriente
		ctaJackieChan.retirarDinero("corriente", 698.50);
			//Retirar dinero de la Cta. de Ahorros
		ctaJackieChan.retirarDinero("ahorros", 200.20);
		
		//Obtener saldo
			//Obtener saldo Cta. Corriente
		ctaJackieChan.getSaldoCtaCorriente();
			//Obtener saldo Cta. de Ahorros
		ctaJackieChan.getSaldoCtaAhorros();
		
		//Mostrar saldo total entre ambas cuentas (Corriente + Ahorros)
		ctaJackieChan.mostrarSaldoTotal();
		
		//Mostrar el total de cuentas creadas
		System.out.println("El número total de cuentas creadas es: " + BankAccount.getNumCtasCreadas());
		
		//Motrar el total del dinero almacenado de cada cuenta
		System.out.println("Total de dinero almacenado para " + ctaJackieChan.getNombre()+ " es: " + ctaJackieChan.getCantidadDineroCta());
		System.out.println("Total de dinero almacenado para " + ctaIgnacioMiranda.getNombre()+ " es: " + ctaIgnacioMiranda.getCantidadDineroCta());
	}
}
