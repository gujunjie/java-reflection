package project01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Text {
	
	

	public static void main(String[] args) throws Exception{
		    
		Student student=new Student();
		Class stuclass=student.getClass();
		System.out.println(stuclass.getName());//通过object的公用方法getclass获取class对象
		
		Class  stuclass2=Student.class;
		System.out.println(stuclass==stuclass2);//第二种方式获取class对象
		
		
		Class stuclass3=Class.forName("project01.Student");//字符串内必须是类的真实路径,包含包名.类名
		System.out.println(stuclass3==stuclass);//通过class的forname方法获取class对象，
			                                         //这种方法是最为常用的
		
		System.out.println("获取所有的公有构造方法");
		Constructor[] constructorsArray=stuclass3.getConstructors();//获取所有的公有构造方法
		for(Constructor c:constructorsArray)
		{
			System.out.println(c);
		}
		
		System.out.println("获取所有的构造方法，包括私有，保护");
		Constructor[] constructorsArray2=stuclass3.getDeclaredConstructors();//获取所有的构造方法，
		                                                                     //包括私有，保护
		for(Constructor c:constructorsArray2)
		{
			System.out.println(c);
		}
		
		System.out.println("获取任意构造方法");
			Constructor constructor=stuclass3.getConstructor(null);
			System.out.println(constructor);
			constructor.setAccessible(true);//去除访问权限
		   constructor.newInstance();//调用构造方法
		   
		   System.out.println("获取所有公有属性");
		   Field[] field=stuclass3.getFields();//获取所有公有属性
		   for(Field f:field)
		   {
			   System.out.println(f);
		   }
		   
		   System.out.println("获取所有属性");
		   field=stuclass3.getDeclaredFields();
		   for(Field f:field)
		   {
			   System.out.println(f);
		   }
		   
		   System.out.println("获取某个属性");
		   Field field2=stuclass3.getDeclaredField("name");
		   System.out.println(field2);
		   
		   
		   //通过反射的方式实例化对象并更改对象属性
		   Object obj=stuclass3.getConstructor().newInstance();
		   field2.setAccessible(true);//暴力更改,破除访问权限
		   field2.set(obj,"google");
		   Student student2=(Student)obj;
		   
		   System.out.println(student2.getName());
		   
		   System.out.println("获取所有公有成员方法");
		   Method[] methods=stuclass3.getMethods();
		   for(Method m:methods)
		   {
			   System.out.println(m);
		   }
		   
		   System.out.println("获取所有成员方法");
		   methods=stuclass3.getDeclaredMethods();
		   for(Method m:methods)
		   {
			   System.out.println(m);
		   }
		   
		   System.out.println("获取某个公有成员方法");
		   Method method=stuclass3.getMethod("sum");
		   System.out.println(method);
		   Object object=stuclass3.getConstructor().newInstance();
		   method.invoke(object);
		   
		   System.out.println("获取某个成员方法");
		   method=stuclass3.getDeclaredMethod("add");
		   System.out.println(method);
		   object=stuclass3.getConstructor().newInstance();
		   method.setAccessible(true);//暴力访问成员方法，破除访问权限
		   method.invoke(object);
		   
		   
		   
		

	}

}
