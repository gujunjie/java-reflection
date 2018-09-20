package project01;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Text {
	
	

	public static void main(String[] args) throws Exception{
		    
		Student student=new Student();
		Class stuclass=student.getClass();
		System.out.println(stuclass.getName());//ͨ��object�Ĺ��÷���getclass��ȡclass����
		
		Class  stuclass2=Student.class;
		System.out.println(stuclass==stuclass2);//�ڶ��ַ�ʽ��ȡclass����
		
		
		Class stuclass3=Class.forName("project01.Student");//�ַ����ڱ����������ʵ·��,��������.����
		System.out.println(stuclass3==stuclass);//ͨ��class��forname������ȡclass����
			                                         //���ַ�������Ϊ���õ�
		
		System.out.println("��ȡ���еĹ��й��췽��");
		Constructor[] constructorsArray=stuclass3.getConstructors();//��ȡ���еĹ��й��췽��
		for(Constructor c:constructorsArray)
		{
			System.out.println(c);
		}
		
		System.out.println("��ȡ���еĹ��췽��������˽�У�����");
		Constructor[] constructorsArray2=stuclass3.getDeclaredConstructors();//��ȡ���еĹ��췽����
		                                                                     //����˽�У�����
		for(Constructor c:constructorsArray2)
		{
			System.out.println(c);
		}
		
		System.out.println("��ȡ���⹹�췽��");
			Constructor constructor=stuclass3.getConstructor(null);
			System.out.println(constructor);
			constructor.setAccessible(true);//ȥ������Ȩ��
		   constructor.newInstance();//���ù��췽��
		   
		   System.out.println("��ȡ���й�������");
		   Field[] field=stuclass3.getFields();//��ȡ���й�������
		   for(Field f:field)
		   {
			   System.out.println(f);
		   }
		   
		   System.out.println("��ȡ��������");
		   field=stuclass3.getDeclaredFields();
		   for(Field f:field)
		   {
			   System.out.println(f);
		   }
		   
		   System.out.println("��ȡĳ������");
		   Field field2=stuclass3.getDeclaredField("name");
		   System.out.println(field2);
		   
		   
		   //ͨ������ķ�ʽʵ�������󲢸��Ķ�������
		   Object obj=stuclass3.getConstructor().newInstance();
		   field2.setAccessible(true);//��������,�Ƴ�����Ȩ��
		   field2.set(obj,"google");
		   Student student2=(Student)obj;
		   
		   System.out.println(student2.getName());
		   
		   System.out.println("��ȡ���й��г�Ա����");
		   Method[] methods=stuclass3.getMethods();
		   for(Method m:methods)
		   {
			   System.out.println(m);
		   }
		   
		   System.out.println("��ȡ���г�Ա����");
		   methods=stuclass3.getDeclaredMethods();
		   for(Method m:methods)
		   {
			   System.out.println(m);
		   }
		   
		   System.out.println("��ȡĳ�����г�Ա����");
		   Method method=stuclass3.getMethod("sum");
		   System.out.println(method);
		   Object object=stuclass3.getConstructor().newInstance();
		   method.invoke(object);
		   
		   System.out.println("��ȡĳ����Ա����");
		   method=stuclass3.getDeclaredMethod("add");
		   System.out.println(method);
		   object=stuclass3.getConstructor().newInstance();
		   method.setAccessible(true);//�������ʳ�Ա�������Ƴ�����Ȩ��
		   method.invoke(object);
		   
		   
		   
		

	}

}
