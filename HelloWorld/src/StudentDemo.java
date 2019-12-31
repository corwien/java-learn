
class Student {
	String name;
	int age;
	
	public void show() {
		System.out.println("姓名："+name);
		System.out.println("年龄："+age);
	}
}
public class StudentDemo {
	
	public static void main(String[] args) {
		Student s = new Student();
		s.show();
	}

}
