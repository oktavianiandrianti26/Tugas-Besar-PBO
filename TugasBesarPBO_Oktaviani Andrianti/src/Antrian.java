import java.util.*;

public class Antrian { //collection framework
    public static String queue[]= new String[5];
    public static int a = 0;

    Scanner data = new Scanner(System.in);
    //Constructure Kosong
    public Antrian (int i){

    }

    public boolean queueStorage(){
        if (a < queue.length){
            return true;
        }else
        {
            return false;
        }
    }

    public void CreateQueue(){
        String nama;
        System.out.print("Masukkan Nama Pembeli : ");
        nama = data.nextLine();
        queue[a] = nama;
        a++;        
    }

    public void removeQueue(){
        a--;
        for(int i=0; i<a; i++){
            queue[i] = queue [i+1];
        }
    }

    public void displayQue(){
        System.out.println("Daftar Antrian : ");
        for (int i = 0; i < a; i++){
            System.out.println(+i+1+ "." +queue[i]);
        }
        System.out.println("");
    }
}
