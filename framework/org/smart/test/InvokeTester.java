package org.smart.test;

import java.lang.reflect.Method;

public class InvokeTester {

private String name;
    
    public void setName(String name){
        this.name = name;
    }    
    public String getName(){
        return name;
    }    
    
    public InvokeTester() {
    }
    public int add(int param1, int param2) {
        return param1 + param2;
    }
    public String echo(String mesg) {
        return "echo" + mesg;
    }
    public static void main(String[] args) {
        Class classType = InvokeTester.class;
        try {
            Object invokertester = classType.newInstance();   //1
            System.err.println(invokertester);
            Method addMethod = classType.getMethod("add", new Class[] { int.class, int.class });
            Object result = addMethod.invoke(invokertester, new Object[]{new Integer(100), new Integer(200)});
            System.out.println("result:"+result);
            System.err.println();
        }catch (Exception e) {
			// TODO: handle exception
		}
    }
}
