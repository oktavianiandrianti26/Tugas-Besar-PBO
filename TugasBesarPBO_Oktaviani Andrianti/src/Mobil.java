import java.util.Scanner;
import java.sql.*;
import java.text.*;
import java.io.*;

public class Mobil implements Showroom { //interface
    static Connection con;
    String url = "jdbc:mysql://localhost:3306/showroom";
    String merk,tipe,status;
    Integer id,harga;
    Scanner input = new Scanner(System.in);

    public Mobil(Integer id, String merk, String tipe, Integer harga, String status){
        this.id = id;
        this.merk = merk;
        this.tipe = tipe;
        this.harga = harga;
        this.status = status;
    } //constructor
    
    @Override
    public void idMobil(){
        System.out.print("Masukan ID Mobil\t:");
        id = input.nextInt();
    }

    @Override
    public void merkMobil(){
        System.out.print("Masukan Merk Mobil\t:");
        merk = input.next();
    }

    @Override
    public void tipeMobil(){
        System.out.print("Masukan Tipe Mobil\t:");
        tipe = input.next();
    }
    
    @Override
    public void Harga(){
        System.out.print("masukan harga Mobil\t:");
        harga = input.nextInt();
    }

    @Override
    public void statusMobil(){
        System.out.print("Status mobil saat ini\t:");
        status = input.next();
    }

    public void totalharga(){}

    public void pelanggan(){}

    public void InsertDbMobil() throws SQLException{
        String sql = "INSERT INTO data_mobil (id_mobil,merk,tipe,harga,status) VALUES ('"+id+"', '"+merk+"','"+tipe+"','"+harga+"','"+status+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);   
        System.out.println("\nDATA BERHASIL DI INPUT !!!"); 
    }
}
