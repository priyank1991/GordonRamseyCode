import java.util.*;

enum TestEnum{
  RED,GREEN,BLUE;

  private TestEnum(){
    System.out.println("private constructor of enum called for : "+this.toString());
  }

  public void colorInfo(){
    System.out.println("Universal Color");
  }
}

enum TrafficSignal
{
    // This will call enum constructor with one
    // String argument
    RED("STOP"), GREEN("GO"), ORANGE("SLOW DOWN");

    // declaring private variable for getting values
    private String action;

    // getter method
    public String getAction()
    {
        return this.action;
    }

    // enum constructor - cannot be public or protected
    private TrafficSignal(String action)
    {
        this.action = action;
    }
}


public class ExceptionDemo{


  public static  void fun1(){
    int x = 0;
    int y=1;

    try{
      System.out.println("Before call-1");
      int z = y/x;
      System.out.println("After call-1");

    }
    catch(ArithmeticException ex){
      System.out.println("In Exception Block-1");
      ex.printStackTrace();
      System.out.println("In Exception Block-2");
    }
    finally{
      System.out.println("Finally Block called");
    }


  }

    public  void fun2(){

      try{
        System.out.println("About to raise Custom Exception");
        throw new MyException("errorneos state");
      }
      catch(MyException ex){
        ex.printStackTrace();
      }
      finally{
        System.out.println("Inside the finally block");
      }

    }

    class MyException extends Exception{

      public MyException(){
        System.out.println("Default Constructor called for Custom Exception");
      }

      public MyException(String message){
        super(message);
        System.out.println("Parameterized Constructor called for Custom Exception");
      }
    }

  public static void main(String args[]){

    TestEnum enumArray[] = TestEnum.values();

    for(TestEnum t1 : enumArray){
      System.out.println(t1 +":at index:"+t1.ordinal());
    }

    TrafficSignal[] signals = TrafficSignal.values();

        for (TrafficSignal signal : signals)
        {
            // use getter method to get the value
            System.out.println("name : " + signal.name() +
                        " action: " + signal.getAction() );
        }

    ExceptionDemo demo = new ExceptionDemo();
    demo.fun2();

  }


}
