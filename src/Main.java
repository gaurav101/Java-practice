import Products.SmartDevice;
import Products.SmartPhone;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.AllPermission;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String argc[]) throws IOException {
      //  DatabaseConnection();
       /// lambdaFunction();
        ArrayList <SmartPhone>phones=new ArrayList<>();
        phones.add(new SmartPhone("Iphone SE","Apple",30000));
        phones.add(new SmartPhone("Iphone 10","Apple",40000));

        phones.add(new SmartPhone("Iphone XR","Apple",500000));

        phones.add(new SmartPhone("Pixal","Google",30000));

        phones.add(new SmartPhone("Galexy","Samsung",45000));
        ///find by model
        findPhone(phones,(sm) -> {
            if(sm.getPrice()>=40000 && sm.getPrice()<=50000){
                return true;
            }
            return false;
        });
        findPhone(phones,(sm)->{
            if(sm.getModel().equals("Apple")){
                return true;
            }
            return false;
        });
        Function <SmartDevice,String> print=(sm)->{
          return sm.getModel();
        };
        System.out.println(print.apply(phones.get(1)));
        System.out.println("===========Streams===============");
        IntStream.range(1,10).skip(3).sorted().forEach((x)->{
            System.out.println(x*(x-1));
        });
        /// Find the Alphabatically smallest string in Dic
        Stream.of("Welcome","To","BBC","AAm","Apple","To","See","You","Here")
                .sorted()
                .findFirst()
                .ifPresent(n->{
                    System.out.println(n);
                });

       System.out.println( Arrays.stream(new int []{2,3,4,5})
                .map(m->m*m*m)
                .average());

       Stream<String> lines= Files.lines(Paths.get("out/production/TuteDude/100-stderr.txt"));
        lines.sorted()
               .forEach(l->{
                   System.out.println(l);
               });
       lines.close();
    }

    private static void findPhone(ArrayList<SmartPhone> sm, Predicate <SmartDevice>pd ){
        for(SmartPhone s :sm ){
            if(pd.test(s)){
                System.out.println("Found a smartphone "+s.toString());
            }
        }
    }
    private static void lambdaFunction() {
        send(()->{
            System.out.println("Hello from lambda function.....");
        });
        Messages m=()-> {
            System.out.println("Hello again form Messages....");
            System.out.println("2nd line....");
        };
        send(m);
        Print printHello=(int a)->{
            System.out.println("This is another example of Lambda expression...");
            return 10*a;
        };

        int num=printHello.print(20);
        System.out.println(num);
    }

    public static void send(Messages m){
        m.sendMessage();
    }
    private static void DatabaseConnection() {
        String dburl= "jdbc:mysql://127.0.0.1:3306/employee";
        try{
            Connection con = DriverManager.getConnection(dburl,"root","gauravkumar");
            Statement st= con.createStatement();

            int row=st.executeUpdate("INSERT INTO employee (emp_name,dept,salary) VALUES('GK','HR',60000)");
            System.out.println(row);
            ResultSet resultSet=st.executeQuery("SELECT * FROM employee");
            while (resultSet.next()){
                System.out.println(resultSet.getString(2));
            }
        }catch (SQLException e){
            System.out.println("Connection error");
            e.printStackTrace();
        }
    }

}

