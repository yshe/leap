package com.yabushan.test.util.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;

import org.junit.Test;
/**
 * 
 * @author yabushan
 * 1.Class 是一个类，一个描述类的类，封装了描述方法的Method，描述字段的Filed
 * 描述构造器的Constructor 等属性
 * 
 * 2.如何得到Class对象：
 * Person.class
 * Person.getClass()
 * Class.forName("com.Person")
 * 
 * 3.关于Method：
 * 如何获取Method：
 * getDeclardMethods：得到Method的数组
 * getDeclardMethod(String methodName,Class ... parameterTypes)
 * 
 * 如何调用Method:
 *1. 如果方法是private修饰的，需要先调用Method的setAccessible(true)
 *使其变为可访问
 * 2.method.invoke(obj,Object ... args);
 * 
 * 
 * 4.关于Field：
 * 如何获取Field：getField(string fieldName)
 * 
 * 如何获取Field的值：
 * setAccessible(true)
 * field.get(Object obj)
 * 
 * 如何设置Field的值：
 * field.set(Object obj,Object val)
 * 
 * 5.了解constructor和Annotation
 * 
 * 6.反射和泛型
 * 6.1getGenericSuperClass：获取带泛型参数的父类，返回值为：BaseDao<Employee,String>
 * 6.2 Type的子接口：ParameterizedType
 * 6.3 可以调用ParameterizedType的Type[] getActualTypeArguments()	
 * 获取泛型参数的数组
 * 
 * 
 * 
 * 
 *
 */
public class ReflectUtils {
	
	/***********************方法Start*****************************/
	/**
	 * 
	 * @param obj 方法执行的那个对象
	 * @param methodName
	 * @param args
	 * @return
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static  Object invoke(Object obj,String methodName,Object ... args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		//获取方法
		Class[] parameterTypes=getParameterTypes(args);
		try {
		//	Method method=obj.getClass().getMethod(methodName, parameterTypes);
			Method method=getMethod(obj.getClass(), methodName, parameterTypes);
			//设置私有方法可被访问
			method.setAccessible(true);
			//执行方法
			return method.invoke(obj, args);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 
	 * @param className
	 * @param methodName
	 * @param args
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static  Object invoke(String className,String methodName,Object ...args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
		Object object=null;
		object=Class.forName(className).newInstance();
		Class[] parameterTypes=getParameterTypes(args);
		try {
			//Method method=object.getClass().getMethod(methodName, parameterTypes);
			Method method=getMethod(object.getClass(), methodName, parameterTypes);
			//设置私有方法可被访问
			method.setAccessible(true);
			return method.invoke(object, args);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	/**
	 * 循环获取要执行对象的方法，包括父类
	 * @param clazz
	 * @param methodName
	 * @param args
	 * @return
	 */
	public static Method getMethod(Class clazz,String methodName,Class ... parameterTypes){
		
		for(;clazz!=Object.class;clazz=clazz.getSuperclass()){
			try {
				Method method=clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return null;
	}
	
	/**
	 * 获取参数
	 * @param args
	 * @return
	 */
	public static Class[] getParameterTypes(Object ... args){
		Class[]  parameterTypes = new Class[args.length];
		for(int i=0;i<args.length;i++){
			parameterTypes[i]=args.getClass();
		}
		return parameterTypes;
	}
	/***********************方法End*****************************/

	
	
	/************字段操作********/
	/**
	 * 获取一个字段
	 * @param clazz
	 * @param fieldName
	 * @return
	 */
	public Field getField(Class clazz,String fieldName){
		Field field=null;
		for(Class clazz2 =clazz;clazz2!=Object.class;clazz2=clazz2.getSuperclass()){
			try {
				field=clazz2.getDeclaredField(fieldName);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return field;
	}
	
	
	
	
	/**
	 * * 通过反射，获得定义Class时声明的父类的泛型参数的类型
	 * 如：public EmployeeDao extends BaseDao<Employee,string>
	 * @param clazz 子类对应的class对象
	 * @param index：子类继承父类时传入的泛型索引，从0开始
	 * @return
	 */
	
	public static Class getSuperClassGenericType(Class clazz,int index){
		Type genType=clazz.getGenericSuperclass();
		if(!(genType instanceof ParameterizedType)){
			return Object.class;
		}
		
		//Type[] params=((ParameterizedType)genType).getActualTypeArguments();
		
		ParameterizedType parameterizedType=(ParameterizedType) genType;
		Type[] params=parameterizedType.getActualTypeArguments();
		
		if(params==null){return null;}
		if(index>=params.length || index<0){
			return Object.class;
		}
		if((params[index] instanceof Class)){
			return (Class) params[index];
		}
		
		return null;
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static<T> Class<T> GetSuperGenericType2(Class clazz ,int index){
		return getSuperClassGenericType(clazz, index);
	}
	
	
	
	/***
	 * 通过反射，获得定义Class时声明的父类的泛型参数的类型测试
	 * **/
	@Test
	public void testGetSuperClassGenricType(){
		Class clazz=EmployeeDao.class;
		Class argClazz = getSuperClassGenericType(clazz, 0);
		System.out.println(argClazz);
		argClazz=getSuperClassGenericType(clazz, 1);
		System.out.println(argClazz.getName());
	}
	/**************************end*********/
	
	
	/***************测试方法*****************/
	@Test
	public void testMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		Class clazz=Class.forName("reflect.Person");
		//1.得到clazz对应类中的方法，不能获取private方法
		Method[] methods=clazz.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		//2.获取所有方法，包括private方法.且只能获取当前类申明的方法
		Method[] methods2=clazz.getDeclaredMethods();
		for (Method method : methods2) {
			System.out.println(method.getName());
		}
		
		
		//3.获取指定的方法
		Method method=clazz.getMethod("personTest");
		System.out.println(method);
		Method method2=clazz.getMethod("setName",String.class,Integer.class);
		System.out.println(method2);
		
		
		
		/**
		 * 4.执行方法
		 */
		Object obj = clazz.newInstance();
		
		String result=(String) method2.invoke(obj, "雅布珊",13);
		System.out.println("result:"+result);
		
		//调用方法执行
		ReflectUtils reflectUtils=new ReflectUtils();
		Object object =new Person();
		System.out.println(reflectUtils.invoke(obj, "setName", "雅布珊",12));
		System.out.println(reflectUtils.invoke("reflect.Person", "setName","帅哥", 15));
		//System.out.println(reflectUtils.invoke("reflect.Person", "personTest"));
		
		
		
		System.out.println(ReflectUtils.invoke("java.text.SimpleDateFormat", "format", new Date()));
		
	}
	
	/************************************/
	
	
	
	
	/**测试字段
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException **/
	@Test
	public void testClassField() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		String classNmae="reflect.Student";
		String fieldName ="age";//可能为私有，可能在其父类中
		Object val=20;
		
		//创建className对应的对象，并未器fieldName赋值为val
		Object object=null;
		
		Class clazz=Class.forName(classNmae);
		Field field=getField(clazz, fieldName);
		
		object=clazz.newInstance();
		setFieldValue(val, object, field);
		
		Student student=(Student) object;
		System.out.println(student.age);
	}

	private void setFieldValue(Object val, Object object, Field field)
			throws IllegalAccessException {
		field.setAccessible(true);
		field.set(object, val);
	}
	
	public Object getFieldValue( Object object, Field field) throws IllegalArgumentException, IllegalAccessException{
		field.setAccessible(true);
		return field.get(object);
	}
	
	
}
