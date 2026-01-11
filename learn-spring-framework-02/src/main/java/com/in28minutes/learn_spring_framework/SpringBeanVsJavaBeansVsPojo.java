package com.in28minutes.learn_spring_framework;

// Essentially any Java object is a POJO
class Pojo{
    private String text;
    private int number;

    @Override
    public String toString() {
        return text +" : "+ number;
    }
}
//EJB - not much Popular now.
class JavaBean {
    private String text;
    private int number;
// Constraints -
    //1. public no-args Constructor - can also be default Constructors
    //2. Getters and Setters
    //3. Class should implement Serializable

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

/*
Any Java Object that is managed by Spring is called Java Beans.
Spring usages IOC Container (Bean Factory or Application Context) to manages those Objects.
 */


public class SpringBeanVsJavaBeansVsPojo {
    public static void main(String[] args) {
        var pojo = new Pojo();
        System.out.println(pojo); // OP- null : 0
    }
}
