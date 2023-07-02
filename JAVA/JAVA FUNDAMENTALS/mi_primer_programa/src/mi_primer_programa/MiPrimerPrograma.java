package mi_primer_programa;

public class MiPrimerPrograma {
	String name;
	int age;
	String city;

	public MiPrimerPrograma(String name, int age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public void showInfo() {
		System.out.println("Mi nombre es " + name);
		System.out.println("Tengo " + age + " años de edad.");
		System.out.println("Mi ciudad es " + city);
	}
}