import Classes.Cl1;
import Classes.Cl2;
import Classes.int1;
import Products.SmartDevice;
import Products.SmartPhone;
import Products.SmartWatch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public  class misc {
    public static  int [] kWeakestRows(int[][] mat, int k) {
        //  ArrayList<Integer> strengthOrder=new ArrayList<>(mat.length);

        SortedMap<Integer,Integer> map=new TreeMap<>() ;

        int strength=0;
        int i=0;
        for( i=0;i<mat.length;i++){
            strength=0;
            for(int j=0;j<mat[i].length;j++){
                strength+=mat[i][j];
            }
            map.put(i,strength);

        }
        int [] returnArray=new int[map.size()];
        i=0;
        for (Map.Entry mapElement : map.entrySet()) {
            int key = (int)mapElement.getKey();
            returnArray[i]=key;
            // Finding the value
            String value = (String)mapElement.getValue();

            System.out.println(key + " : " + value);
        }
        return  returnArray;
    }
    public  static  boolean Palindrom(int x){
        int y=0;
        int digit=0;
        int z=x;
        boolean returnValue=false;
        if(x<10 && x>0){
            return true;
        }
        else if(x%10>=0){
            do{
                digit=z%10;
                y=y*10+digit;
                z=z/10;
            }while(z>0);
            returnValue=(y==x);
        }else{
            return false;
        }
        return returnValue;
    }
    public static int[] runningSum(int[] nums) {

        int [] sums =new int[nums.length];
        int length=nums.length;
        for(int i=0;i<length;i++){
            if((i-1)>=0){
                sums[i]=sums[i-1]+nums[i];
            }else{
                sums[i]=nums[i];
            }
        }

        return sums;
    }
    private static void hashMapExample() {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"One");
        map.put(2,"Two");
        map.put(4,"Four");
        map.put(9,"Nine");
        for(Integer i:  map.keySet()){
            System.out.println(map.get(i));
        }
        for(Map.Entry<Integer,String >m:map.entrySet()){
            System.out.println(m.getKey()+"=====>"+m.getValue());
        }
    }

    private static void methodsOfCollection() {
        ArrayList<SmartPhone> arr= new ArrayList<>();
        arr.add(new SmartPhone("Iphone11","Apple",40000));
        arr.add(new SmartPhone("Iphone13","Apple",50000));
        arr.add(new SmartPhone("Iphone14","Apple",90000));


        ArrayList<SmartPhone> arr2=new ArrayList<>();
        arr2.add(new SmartPhone("Samsung","Note11",40000));
        arr2.add(new SmartPhone("Iphone11","Apple",40000));
        arr2.add(new SmartPhone("Iphone14","Apple",90000));
        arr2.add(new SmartPhone("Samsung","Note11",40000));
        //-------
        arr.addAll(arr2);
        Collections.sort(arr);//addAll(arr2);
        System.out.println(arr);
        arr.removeAll(arr2);
        System.out.println(arr);
    }

    private static void linkedlistDEmo() {
        // fileRead();
        LinkedHashSet<SmartPhone> arr=new LinkedHashSet<SmartPhone>();
        arr.add(new SmartPhone("Iphone11","Apple",40000));
        arr.add(new SmartPhone("Iphone13","Apple",50000));
        arr.add(new SmartPhone("Iphone14","Apple",90000));
        arr.add(new SmartPhone("Samsung","Note11",40000));
        arr.add(new SmartPhone("Iphone11","Apple",40002));
        arr.add(new SmartPhone("Iphone14","Apple",90000));
        arr.add(new SmartPhone("Samsung","Note11",40000));


        for(Object x : arr){
            System.out.println(x);
        }
    }

    private static void fileRead() throws IOException {
        // practice1();
        //readKayboard();
        File txt=new File("out/production/TuteDude/100-stderr.txt");
        Scanner fileReadScanner=new Scanner(txt);
        while (fileReadScanner.hasNext()){
            System.out.println(fileReadScanner.nextLine());
        }
        //Reading file form BufferReader
        System.out.println("----Reading through Buffer reader-----");
        FileReader fr=new FileReader(txt);
        BufferedReader bf1=new BufferedReader(fr);
        try{

            String f=bf1.readLine();
            while(f!=null) {
                System.out.println(f);
                f=bf1.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        } finally {
            bf1.close();
        }
    }

    private static void readKayboard() {
        Scanner readKeyboardInput=new Scanner(System.in);
        System.out.print("Please enter your name: ");
        int keyBoardInputString=readKeyboardInput.nextInt();
        System.out.println("Hello: "+keyBoardInputString);
    }


    private static void practice1() {
        System.out.println("Hello World");
        SmartDevice d1=new SmartPhone("IPhone","16",2000000);
        d1.TurnOn();
        SmartDevice d2= new SmartWatch("IWatch","3",500000);
        d2.TurnOn();
        getDetails(d1);
        getDetails(d2);
        PlayGames(d1);
        PlayGames(d2);
        Cl1 cl=new Cl1();
        Cl2 cl2=new Cl2();
        cl.method1();
        cl2.method1();
        callMethod(cl);
        callMethod(cl2);
    }

    static  void getDetails(SmartDevice sm){
        sm.getDetails();;
    }
    static  void PlayGames(SmartDevice sm){
        sm.PlayGame();

    }
    static void callMethod(int1 obj){
        obj.method1();
    }
}
