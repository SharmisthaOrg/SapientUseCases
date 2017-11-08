import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchObjectBasedOnCriteriaDynami8cally {

	public static void main(String[] args) {
		Employee e1 = new Employee(1,23,"M","Ricky","Beethovan");
		Employee e2 = new Employee(2,23,"F","Martina","Hengis");
		Employee e3 = new Employee(3,23,"M","Ricky","Martin");
		Employee e4 = new Employee(4,26,"M","Jon","Lowman");
		Employee e5 = new Employee(5,19,"F","Cristine","Maria");
		Employee e6 = new Employee(6,15,"M","David","Feezor");
		Employee e7 = new Employee(7,68,"F","Melissa","Roy");
		Employee e8 = new Employee(8,79,"M","Alex","Gussin");
		Employee e9 = new Employee(9,15,"F","Neetu","Singh");
		Employee e10 = new Employee(10,45,"M","Naveen","Jain");


		List<Employee> employees = new ArrayList<Employee>();
		employees.addAll(Arrays.asList(new Employee[]{e1,e2,e3,e4,e5,e6,e7,e8,e9,e10}));
		SearchCriteria<Employee> serachByname = new SearchCriteria<>();
		
		System.out.println(serachByname.filter(employees, (p)->p.firstname.equals("Ricky")));
		
		employees.stream().filter(p-> p.age == 23).collect(Collectors.toList());

	}



}

class SearchCriteria<T> {	
	public List<T> filter(List<T> t,Predicate<T> predicate){
		return t.stream().filter(predicate).collect(Collectors.toList());		
	}
}

class Employee{
	int id;
	int age;
	String gender;
	String firstname;
	String lastname;

	public Employee(int id, int age, String gender, String firstname, String lastname) {
		this.id = id;
		this.age = age;
		this.gender = gender;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", age=" + age + ", gender=" + gender + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}


}
