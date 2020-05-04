package conversor;

import java.util.Scanner;

public class ConversorMain {
	
	public static void main (String[] args) { 
		seguimiento();
	}
	
	private static void seguimiento() {
		Moneda[] monedasArrayObj=crearArrayMonedas();
		//entrada();
		ejecucion_exc(monedasArrayObj);
		
	}

	private static Moneda[] crearArrayMonedas() {
		Moneda monedasArrayObj[]=new Moneda[3];

		monedasArrayObj[0]=new Euro("EUR");
		monedasArrayObj[1]=new Dolar("USD");
		monedasArrayObj[2]=new FrancoSuizo("CHF");
		
		return monedasArrayObj;
	}
	
	
	private static void ejecucion_exc(Moneda[]a) {
		boolean a1, a2=false;
		do {
			a1 = inicio(a);
			if (a1 == false) {
				a2 = al_princ();
			}
		} while (a1 == false && a2 == false);
		texto("Hasta pronto!");
		texto("Fin de ejecuci�n.");
	}
	
	private static boolean al_princ() {
		int a = 0;
		boolean bl;
		texto("�Salir al menu principal?");
		texto("1. Si");
		texto("2. No, y salir del programa");
		a = valor(2);
		if(a == 1) {
			bl = false;
		}else {
			bl = true;
		}
		return bl;
	}

	private static boolean inicio(Moneda[]a) {
		boolean bl = false;
		int b;
		texto("PULSA LA TECLA DE LA OPERACI�N QUE DESEA REALIZAR.");
		texto("1. La tasa de cambio actual.");
		texto("2. Calcular la tasa de cambio.");
		texto("3. Salir.");
		b = valor(3);
		switch (b) {
		case 1:
			tasa_act(a);
			break;
		case 2:
			calculo(a);
			break;
		case 3:
			bl = true;
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + b);
		}
		return bl;
	}

	private static void tasa_act(Moneda[]a) {
		texto("LA TASA DEL CAMBIO ACTUAL ES:");
		//La plantilla con el formato necesario para el m�todo System.out.format. Aqu� usado el formato "leftAlignFormat":
		//2 caracteres de tipo String | 12 caracteres de tipo String | 10 caracteres digitos: 6 para enteros y 4 para decimales | etc
		String str = "%-2s | %-12s | %-6.4f | %-2s | %-12s | %-6.2f |%n";
		//las cabeceras de las tablas
		System.out.format("   +--------------+--------+    +--------------+--------+%n");
		System.out.format("   |    COMPRA    |  TASA  |    |    VENTA     |  TASA  |%n");
		System.out.format("   +--------------+--------+    +--------------+--------+%n");
		System.out.format("   | 1 XAF -> EUR/USD/etc. |    | 1 EUR/USD/etc. -> XAF |%n");
		System.out.format("   +--------------+--------+    +--------------+--------+%n");
		//recorrido para imprimir todos los valores de los arrays con el m�todo .format
		for (int i = 0; i < a.length; i++) {
			System.out.format(str,"", i+1 + ". " + a[i].getNombre(), a[i].getTasaCompra(), "", i+1 + ". " + a[i].getNombre(), a[i].getTasaVenta());
		}
		// Los pies de la tabla
		System.out.format("   +--------------+--------+    +--------------+--------+%n");
	}
	
	private static void calculo (Moneda[] arr) {
		double a=0, c; // variable a para el resultado final del c�lculo // variable c para el valor de cantidad de XAF (monedas de Gabon)
		int b, opc; // variable b para el opci�n de compra o venta // variable opc para la opci�n de tipo de moneda elegida

		texto(" �QU� OPERACI�N DE CAMBIO QUIERES REALIZAR?"); // La cabecera del men�
		texto("1. Compra (XAF a EUR/USD/etc)"); // Las opciones del men�
		texto("2. Venta (EUR/USD/etc a XAF");
		b = valor(2);
		opc = opc_monedas(arr);
		if (b == 1) {										/* opci�n 1 para la opci�n de compra */
			c = cant_XAF("Cuantos XAF quieres comprar?");		/* invoca el m�todo cant_XAF (cantidad de XAF) */
			a = arr[opc-1].comprar(c);								/* el c�lculo final de compra: variable final = cantidad de XAF multiplicamos por la opci�n 
																de tasa de moneda necesaria (pasamos como par�metro el n�mero de la posici�n del array 
																(menos 1 porque el array empieza desde 0)) */
		}else if (b == 2) {									/* opci�n 2 para la opci�n de venta */
			c = cant_XAF("Cuantos XAF quieres vender?");		/* invoca el m�todo cant_XAF (cantidad de XAF) */
			a = arr[opc-1].vender(c);;								/* el c�lculo final de compra: variable final = cantidad de XAF dividimos por la opci�n 
																de tasa de moneda necesaria (pasamos como par�metro el n�mero de la posici�n del array 
																(menos 1 porque el array empieza desde 0)) */
		}else {												/* opci�n "otros" para el n�mero equivocado (validaci�n de datos) */
			texto("Tienes que escribir '1' si quieres comprar y '2' si quieres vender");
		}
		String s = String.format ("%.2f", a);  // Formateo de double a a variable s de tipo String para poder imprimir luego y adem�s 
		// Esto formateara el n�mero desde la coma hasta 2 decimales
		texto("Tienes que pagar " +  s + " " + arr[opc-1].getNombre()); // imprimir el resultado final
	}
	
	private static double cant_XAF (String mens) {
		double a = 0; // para cantidad de XAF (moneda de Gabon)
		boolean error; // para validaci�n de datos 
		@SuppressWarnings("resource") // para suprimir el error de Scanner sin cerrar
		Scanner sc = new Scanner (System.in);

		//el bucle do/while para obtener el valor con validaci�n de datos con try/catch dentro
		do {
			error = false;			 // valor inicial de variable boolean de error
			try {					 // El c�digo se ejecuta dentro de este bloque
				texto(mens);
				a = sc.nextDouble(); // recogida de datos final
			} catch (Exception e) {  //condici�n de captura de error si se lanza el error de ejecuci�n dentro del bloque try
				error = true;
				texto("Error: tiene que ser solo num�rico, con una coma (,) si necesario");
				sc.next();			 // vaciar el buffer
			}
			if (a <= 0) {		 // condici�n si el valor de datos es menor o igual a cero
				texto("Error: Tiene que ser m�s que cero");
				error = true;
			}
		} while (error == true); // condici�n de salida del bucle
		return a;
	}
	
	private static int opc_monedas (Moneda[] arr) {
		int a = 0; // variable para el valor de elegida de nombre de moneda
		texto("�QUE MONEDAS QUIERES CONVERTIR? ELIGE POR SU NUMERO.");
		//recorrida de array con los nombres de monedas
		for (int i = 0; i < arr.length; i++) {
			texto(i+1 + ". " + arr[i].getNombre());
		}
		a = valor(arr.length);
		return a;
	}

	private static int valor(int x){
		int a = 0; // el valor de la opci�n del men�
		boolean error; // para validaci�n de datos 
		@SuppressWarnings("resource") // para suprimir el error de Scanner sin cerrar
		Scanner sc = new Scanner (System.in);
		//el bucle do/while para obtener el valor con validaci�n de datos con try/catch dentro
		do {
			error = false;			// valor inicial de variable boolean de error
			try { 					// El c�digo se ejecuta dentro de este bloque
				a = sc.nextInt(); 	// recogida de datos final

			} catch (Exception e) {	//condici�n de captura de error si se lanza el error de ejecuci�n dentro del bloque try
				error = true;
				texto("Error: Solo tiene que ser un numero de 1 a " + x + ".");
				sc.next();			 // vaciar el buffer
			}

			if (a > x || a <= 0) {	// condici�n si el valor de datos es mayor que opciones disponibles (x) y es menor o igual a cero
				texto("Error: Solo tiene que ser la operaci�n disponible.");
				error = true;
			}
		} while (error == true);
		return a;
	}

	private static void texto(String mns) {
		final int ALT = 3; //cantidad de lines de altura de header
		int anch = 60;//cantidad de lines de anchura de header
		int esp = (anch - mns.length() - 2) / 2;
		esp++; //Para tener en cuenta el asterisco de l�mite
		for(int i = 1; i <= ALT; i++) { //recorrer lineas por cantidad de lineas cabecera
			for(int j = 1; j <= anch; j++) { //recorrer por la longitud de anchura de cabecera
				if(i == ALT || i == 1 || j == anch || j == 1) { /* condici�n para poner el asterisco donde tiene que ser el marco */
					System.out.print("*");
				}else if((j > esp) && ((j - esp - 1) < mns.length())) { /* condici�n para poner letra por letra del mensaje */
					System.out.print(mns.charAt(j-esp - 1));
				}else { 
					System.out.print(" "); /* para el espacio en blanco */
				}
			}
			System.out.println("");/* para saltar la linea */
		}
	}
	
	private static void entrada() {
		texto("BIENVENIDO A CAJERO DE BANCO MUNDIAL EN �FRICA CENTRAL!");
		//dibujo en ASCII //con rastros eliminados de caracteres ofensivos que podr�an impedir la compilaci�n (Java Escape/Unescape)
		System.out.println("             _._._                       _._._\n            _|   |_                     _|   |_\n            "
				+ "| ... |_._._._._._._._._._._| ... |\n            | ||| |  o MUNDIAL BANK o   | ||| |\n            | \"\"\" |  \"\"\"  "
				+ "  \"\"\"    \"\"\"  | \"\"\" |\n       ())  |[-|-]| [-|-]  [-|-]  [-|-] |[-|-]|  ())\n      (())) |     |-------------"
				+ "--------|     | (()))\n     (())())| \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |(())())\n     (()))()|[-|-]|  :::"
				+ "   .-\"-.   :::  |[-|-]|(()))()\n     ()))(()|     | |~|~|  |_|_|  |~|~| |     |()))(()\n        ||  |_____|_|_|_|__|_"
				+ "|_|__|_|_|_|_____|  ||\n     ~ ~^^ @@@@@@@@@@@@@@/=======\\\\@@@@@@@@@@@@@@ ^^~ ~\n          ^~^~                     "
				+ "           ~^~^");
		texto("FOLLOW THE WHITE RABBIT");
	}

}
