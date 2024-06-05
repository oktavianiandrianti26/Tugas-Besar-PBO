import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.InputMismatchException;
import com.mysql.cj.protocol.Resultset;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Program {
    static Connection con;
    public static void main(String[] args) throws Exception {
        Pelanggan beli = new Pelanggan(0, null, null, 0, null, null, 0); //panggil class dan constructor
        Scanner input = new Scanner(System.in);
        boolean lanjutkan = true;
        int pilihan;
        int a = 0;

        Date datenow = new Date(); //String and date
		SimpleDateFormat tgl = new SimpleDateFormat("E, dd/MM/yyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss zzz");

        String url = "jdbc:mysql://localhost:3306/showroom";
        try {
            
			System.out.println("Tanggal \t: " + tgl.format(datenow));
			System.out.println("Waktu \t\t: " + time.format(datenow));
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,"root","");
            System.out.println("Database Terhubung!");


            while (lanjutkan){
                System.out.println("");
                System.out.println("========================================");
                System.out.println("          PROGRAM SHOWROOM MOBIL        ");
                System.out.println("=========================================");
                System.out.println("1. Masukan Data Mobil ");
                System.out.println("2. Antrian Customer");
                System.out.println("3. Pembelian Mobil");
                System.out.println("4. Ubah Data Mobil");
                System.out.println("5. Cek Data Mobil yang ada"); 
                System.out.println("6. Cek Data Pembelian"); 
                System.out.println("7. Hapus data Mobil yang sudah Dibeli");
                System.out.println("8. Cari Mobil");
                System.out.println("9. Exit Program");
                System.out.println("=========================================");
                System.out.println("");
                System.out.print("Masukkan Pilihan : ");
                pilihan = input.nextInt();

            switch (pilihan){
                case 1 : 
                beli.idMobil();
                beli.merkMobil();
                beli.tipeMobil();
                beli.Harga();
                beli.statusMobil();
                beli.InsertDbMobil();
                break;

                case 2 :
                Antrian antrian = new Antrian(5);
                antrian.CreateQueue();
                antrian.displayQue();
                a++;
                break;

                case 3 : 
                beli.pelanggan();
                beli.totalharga();
                beli.tglPembelian();
                beli.insertDBPelanggan();
                break;   

                case 4 :
                beli.Show1();
                beli.ubah();
                break;
                
                case 5 : 
                beli.Show1();
                break;

                case 6 :
                beli.Show2();
                break;

                case 7 :
                beli.Show1();
                beli.delete();
                break;

                case 8 :
                beli.search();
                break;

                case 9 :
                System.exit(0);
                break;

                default :
                System.out.println("Masukan Inputan yang benar!!!");
                break;
                    
            }

            }

        }catch(ClassNotFoundException ex) {
            System.err.println("Driver eror");
            System.exit(0);
        }
        catch(SQLException e){ //exception
            System.err.println("Tidak berhasil Koneksi");
        }
        
                
       }
    }
