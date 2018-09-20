package project01;

public class Student {
	
  private String name="";
  
  private int age=0;
  
  public Student()
  {
	  System.out.println("haha");
  }
  
  public Student(String name)
  {
	  System.out.println("String");
  }
  
  public Student(String name,int age)
  {
	  
  }
  
  private Student(int age)
  {
	  System.out.println("nima");
  }
  
  protected Student(boolean b)
  {
  }
  
  public String getName() {
	return name;
  }
  
  public int getAge() {
	return age;
}
  
  public void sum()
  {
	  System.out.println("sum");
  }
  
  private void add() {
	  System.out.println("add");
  }
}
