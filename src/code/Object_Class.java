package code;

public class Object_Class {
	public static void main(String[] args) {

		Student[] students = new Student[5];

		Student naveen = new Student();
		Student kumar = naveen;
		
		System.out.println(kumar.no   +"kumar");
		
		
		naveen.demoFunction();
		
		//naveen.changeName("Praveen");

		System.out.println(naveen.name);
		System.out.println(naveen.rollNo);
		System.out.println(naveen.no);
	

	}

}

class Student {

	int rollNo ;
	String name;
	int no ;
	String stname ;

	Student() {
		// this is how you call a constructor from another constructor
        // internally: new Student (13, "default person", 100.0f);
		this(33,"323",424);
	}
	
	Student(int rolno,String name ,int no){
		this.name = name;
		this.rollNo = rolno;
		this.no = no;
		
	}

	void demoFunction() {
		System.out.println("Hello this is " + this.stname);
	}

	void changeName(String name) {
		this.name = name;
	}
}
