//Implementation of Constructor Overloading and Static Methods.

/*Question: Write a program to  create a class called Box and by using constructor overloading, accept the parameters and values and calculate volume of Rectangle. Use static methods to calculate area of rectangle. */

import java.io.*;
class Box
{
	double width, height, length;

	static double CalArea(double x, double y)
	{
		return (x*y);
	}
	Box()
	{
		width=height=length=0;
	}

	Box(double len)
	{	
		width=height=length=len;
	}
	Box(double w, double h, double l)
	{
		width=w;
		height=h;
		length=l;
	}
	double volume()
	{
		return width*height*length;
	}
}

class CalBox
{
	public static void main(String args[])
	{
		double area=Box.CalArea(4.0,5.0);
		System.out.println("Area of Rectangle is " + area);

		Box boxVold=new Box();
		double vol=boxVold.volume();
		System.out.println("Volume is "+vol);

		Box boxVal=new Box(7);
		vol=boxVal.volume();
		System.out.println("Volume is " + vol);

		Box boxVol=new Box(10.25,20.15,15.75);
		vol=boxVol.volume();
		System.out.println("Volume is "+vol);
	}
}
_________________________________________________________________________________________

import java.io.*;
class Rectangle
{
	int len, wid;
	
	Rectangle(int x, int y)
	{
		len=x;
		wid=y;
	}
	int rectArea()
	{
		return (len*wid);
	}
}
class RectangleArea
{
	public static void main(String args[])
	{
		Rectangle rect=new Rectangle(15,10);
		int Rarea=rect.rectArea();
		System.out.println("Rectangle Area: "+ Rarea);
	}
}

_________________________________________________________________________________________

class Student
{
	static 
	{
		System.out.println("Static Block is invoked");
	}
	static String clgName="Nirmala";
	
	static void change()
	{
		System.out.println("College Name mis:"+ clgName);
		clgName="Nirmala Foundation Memorial College";
	}
	void Display()
	{
		System.out.println("College Name mis:" + clgName);
	}
	public static void main(String args[])
	{
		Student.change();
		Student s=new Student();
		s.Display();
	}
}
_________________________________________________________________________________________

// Practical 1B Aim: Implementation of Method Overriding

// Write a program using inheritance to calculate the hike of employee with overriding the methods for different category of employee.
// where basic salary is constant and hike of increment is increased by 0.2, permanent employee is increased by 0.5 and temporary employee gets increased by 0.35


class Employee
{
    float salary = 40000;

    void incrementSalary()
    {
        System.out.println("The Employee incremented salary is:" + (salary + ( salary * 0.2)));
    }
}
class TemporaryEmp extends Employee
{
    double hike = 0.35;
    void incrementSalary()
    {
        System.out.println("The Temporary Employee incremented salary is:" + (salary+(salary*hike)));
    }
}
class PermanentEmp extends Employee
{
    double hike = 0.5;
    void incrementSalary()
    {
        System.out.println("The Permanent Employee incremented salary is:" + (salary + (salary*hike)));
    }
}
public class AccEmp
{
    public static void main(String[] args)
    {
        Employee e=new Employee();
        e.incrementSalary();

        PermanentEmp p=new PermanentEmp();
        p.incrementSalary();

        TemporaryEmp t=new TemporaryEmp();
        t.incrementSalary();
    }
}

_________________________________________________________________________________________

/*Practical 2A 
Aim:- Write a program to implement the concept of Abstract classes and methods.

Write a program in java to calculate area of shapes using abstract class.
*/
abstract class Shape
{
    double side1;
    double side2;

    Shape(double a, double b)
    {
        side1=a;
        side2=b;
    }
    abstract double area();
}
class Rectangle extends Shape
{
    Rectangle(double a, double b)
    {
        super(a,b);
    }
    double area()
    {
        System.out.println("Area of Rectangle");
        return side1*side2;
    }
}

class Triangle extends Shape
{
    double half = 0.5;
    Triangle(double a, double b)
    {
        super(a,b);
    }
    double area()
    {
        System.out.println("Area of Triangle");
        return half*(side1*side2);
    }
}
class ShapeAreas
{
    public static void main(String[] args)
    {
        Rectangle r=new Rectangle(10.5,12.5);
        Triangle t=new Triangle(8.6,4.5);
        // The variable sh is declared as a reference to Abstract class shape it can be used to refer an object of any derived from Shape
        Shape sh;
        sh=r;
        System.out.println("Area is: "+ sh.area());
        sh=t;
        System.out.println("Area is: "+ sh.area());

    }
}

_________________________________________________________________________________________

// Practical 2B Implementation of Interface in java

// Write a program in java to calculate the area of Shapes using interface, take Polygon as shape as a interface implements two different shapes
// called Rectangle and Square. Shape classes are having methods that can be overridden called getArea(). Use methods and default methods.

interface Polygon
{
    void getArea();
    default void getSlides()
    {
        System.out.println("I can get sides of a polygon.");
    }

}    
class Rectangle implements Polygon
{
    public void getArea() 
    {
        int length = 6;    
        int breadth = 5;
        int area = length * breadth;

        System.out.println("The area of the rectangle is " + area);
    }
    public void getSlides()
    {
        System.out.println("I have 4 slides.");
    }
}
class Square implements Polygon
{
    public void getArea()
    {
        int sides = 10;
        int area = sides*sides;
        System.out.println("The area of the square is " + area);
    }
    public void getSlides()
    {
        System.out.println("I have all four sides equal");
    }
}

class AreaInterface
{
    public static void main(String[] args) 
    {
        Rectangle r1 = new Rectangle();
        r1.getArea();
        r1.getSlides();

        Square s1 = new Square();
        s1.getArea();
        s1.getSlides();
    }
}


_________________________________________________________________________________________

/*Practical 3 AIM: WAP to define user defined exceptions and raise then as per the requirements.

WAP for checking the appropriate age of voter to vote and apply exception for Invalid age if the age is below 18 */
import java.util.*;

class InvalidAgeException extends Exception
{
    public InvalidAgeException(String str)
    {
        super(str); //calling the constructor of parent Exception
    }
}
public class UserException
{
        static void validate(int age)throws InvalidAgeException
        {
            if(age<18 || age>120)
            {
                throw new InvalidAgeException("age is not valid to vote");//throw an object of user defined exception
            }
            else
            {
                System.out.println("welcome to vote");
            }
        }
        public static void main(String args[])
        {
            Scanner sc=new Scanner(System.in);
            System.out.println("Type your age:");
            int age=sc.nextInt();
            try
            {
                validate(age);
            }
            catch(InvalidAgeException ex)
            {
                System.out.println("Caught the exception");
                //printing the message from InvalidAgeException object
                System.out.println("Exception occured:"+ ex);
            }
            System.out.println("rest of the code...");
            
        }        
}

_________________________________________________________________________________________

/*  Practical 3B Implementation of Multiple Catch
Divide the number by zero 

*/
import java.util.*;
public class MultipleDivide
{
    public static void main(String[] args)
    {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter Operation");
        int b=ob.nextInt();
        try
        {
            int a[]=new int[5];
            a[6]=b;
        }
        catch(ArithmeticException e)
        {
            System.out.println("Arthimetic Exception occurs");
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("ArrayIndexOutOfBounds Exception occurs");
        }
        catch(Exception e)
        {
            System.out.println("Parents Exception occurs");
        }
        System.out.println("rest of the code");
    }
}

_________________________________________________________________________________________

/* Practical 4
Aim WAP to Demonstrate the methods of 
1) List Interface 
2) Set Interface 
3) Map Interface

List Interface:
The List interface in Java provides a way to store the ordered 
collection. It is a child interface of collection. It is an ordered collection of object in which duplicate values can be stored. 

Question: WAP to add and remove value in the List using List Interface
*/
import java.util.*;

class ListInterface
{
    public static void main(String[] args) 
    {
        List<String> a1=new ArrayList<>();
        
        a1.add("Orange");
        a1.add("Apple");
        a1.add("Banana");
        a1.add("Grapes");
        a1.add("Pineapple");
        System.out.println("InitialArrayList " + a1);
        a1.add(1,"Cherry");
        System.out.println("Adding Cherry " + a1);
        
        a1.remove(3);
        a1.add(3,"JackFruit");

        System.out.println("Removing Banana and Adding JackFruit " + a1);


    }

}

_________________________________________________________________________________________

import java.util.*;

public class SetInterface
{
    public static void main(String[] args) 
    {
        Set <Integer> s1=new HashSet<Integer>();
        s1.add(2);    
        s1.add(3);    
        s1.add(5);
        System.out.println("Set 1 Value"+s1);
        Set<Integer> s2=new HashSet<Integer>();
        s2.add(1);
        s2.add(2);
        System.out.println("Set 2 values" + s2);

        s2.addAll(s1);
        System.out.println("Union of set 1 and set 2"+s2);
        
        s1.retainAll(s2);
        System.out.println("Intersection of set 1 and set 2"+s2);
        
        s1.containsAll(s2);
        System.out.println("Subset of set 1 and set 2"+s2);
    }    
}

_________________________________________________________________________________________

/*
 * 4c
 * The Map interface of the java collection framework provides the functionality
 * of the map data structure
 * 
 * In Java, element of Map are stored in key/value pairs. Keys are unique values
 * associated with individual Values
 * 
 * Questions: Print the values according key. Map the values of key and display it. 
 */

 import java.util.*;

 class HashMapInterface
 {
    public static void main(String[] args)
    {
        HashMap<Integer,String> language = new HashMap<>();
        
        language.put(1,"Java");
        language.put(2,"Python");
        language.put(3,"JavaScript");
        System.out.println("HashMap:" + language);

        System.out.println("Key: "+language.keySet());
        System.out.println("Key: "+language.values());
        System.out.println("Key/Value mappinga: "+language.entrySet());
    }
 }

 _________________________________________________________________________________________

 //Practical 5
//Aim:- WAP using various AWT Component design Java Application to accept a student's resume. (Design Form)
//Accept Name,Age,Address of Student. Selection 

package studentresume;
import java.awt.*;
public class StudentResume extends Frame
{
    Label lname, lage, lgender,lqual,laddr;
    TextField tname,tage;
    Checkbox m,f,q1,q2,q3,q4;
    CheckboxGroup cbg;
    TextArea tr;
    Button b;
    
    public StudentResume()
    {
        lname = new Label("Name");
        lage = new Label("Age");
        laddr = new Label("Address");
        lgender = new Label("Gender");
        lqual = new Label("Qualification");
        
        tname = new TextField(20);
        tage = new TextField(10);
        
        cbg = new CheckboxGroup();
        m = new Checkbox("Male",false,cbg);
        f = new Checkbox("Female",false,cbg);
        
        q1 = new Checkbox("MSc");
        q2 = new Checkbox("MSc IT");
        q3 = new Checkbox("MCom");
        q4 = new Checkbox("MA");
        
        tr = new TextArea(5,20);
        
        b = new Button("Submit");
        add(lname);
        add(tname);
        add(lage);
        add(tage);
        add(tr);
        add(lgender);
        add(m);
        add(f);
        add(lqual);
        add(q1);
        add(q2);
        add(q3);
        add(q4);
        
        add(b);
        setSize(200, 300);
        setVisible(true);
        
    }

    public static void main(String[] args) 
    {
        StudentResume sr=new StudentResume();
        sr.setSize(300,300);
        sr.setVisible(true);
        sr.setLayout(new FlowLayout());
    }
    
}

_________________________________________________________________________________________

package jdbcdemo;
import java.sql.*;
public class JDBCDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
      Class.forName("org.apache.derby.jdbc.ClientDriver");
      Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/EmployeeDemo","SYCS1","max");
      String sql="insert into Employee values(?,?)";
      
      PreparedStatement ps=con.prepareStatement(sql);
      
      ps.setString(1,"E101");
      ps.setString(2,"Hiral");
      ps.setString(1,"E102");
      ps.setString(2,"Ram");
      
      ps.executeUpdate();
      con.close();
      
    }
    
}


_________________________________________________________________________________________

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
    </body>
</html>

<!DOCTYPE html>
<html>
    <head>
        <title>To count Session</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form name="Check Session Visit" method="post" action="http://localhost:8080/SessionVisit/Session">
            <input type="Submit" value="check session visit">
        </form>
    </body>
</html>

_________________________________________________________________________________________
import java.awt.*;  
import java.awt.event.*;  
public class ActionListenerExample {  
public static void main(String[] args) {  
    Frame f=new Frame("ActionListener Example");  
    final TextField tf=new TextField();  
    tf.setBounds(50,50, 150,20);  
    Button b=new Button("Click Here");  
    b.setBounds(50,100,60,30);  
  
    b.addActionListener(new ActionListener(){  
    public void actionPerformed(ActionEvent e){  
            tf.setText("Welcome to Javatpoint.");  
    }  
    });  
    f.add(b);f.add(tf);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);   
}  
}  

_________________________________________________________________________________________

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out=response.getWriter()) {
            String uname = request.getParameter("t1");
            String pswd = request.getParameter("t2");
            if (uname.equals("admin") && pswd.equals("123456"))
            {
                out.println("Hello!!!");
            }
            else
            {
                out.println("Login Failed");    
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


