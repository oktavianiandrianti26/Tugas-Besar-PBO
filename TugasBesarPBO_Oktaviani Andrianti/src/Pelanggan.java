import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import java.util.zip.DataFormatException;
import java.sql.*;

public class Pelanggan extends Mobil{ //inhiritance

    String url = "jdbc:mysql://localhost:3306/showroom"; //koneksi ke database
    String namaPelanggan;
    Integer nomorPembelian,hargatotal;

     public Pelanggan(Integer id, String merk, String tipe, Integer harga, String status, String namaPelanggan, Integer nomorPembelian) { //constructor
        super(id, merk, tipe, harga, status); //super
        this.namaPelanggan = namaPelanggan;
        this.nomorPembelian = nomorPembelian;
    }


    @Override
    public void pelanggan(){
        System.out.print("Masukan Nama Pembeli\t:");
        namaPelanggan = input.next();
        System.out.print("Masukan Nomor Pembelian\t:");
        nomorPembelian = input.nextInt();
    }

    @Override
    public void totalharga(){
        System.out.println("catatan : Untuk mobil dengan id lama(1-4) akan diberikan diskon 10%");
        System.out.println("Masukan id Mobil yang akan dibeli :");
        id = input.nextInt();
        switch(id){ //percabangan
        case 1 :
        harga = this.harga;
        hargatotal = (int) (harga*0.90); //proses matematika
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 2 :
        hargatotal = (int) (harga*0.90); //proses matematika
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 3 :
        hargatotal = (int) (harga*0.90);
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 4 :
        hargatotal = (int) (harga*0.90);
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 5 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 6 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 7 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        case 8 :
        hargatotal = harga;
        System.out.println("harga Total adalah :" +hargatotal);
        break;

        default :
        System.out.println("Stok Mobil saat ini hanya 8 saja!!");
        break;
        }

    }

    public String tglPembelian() { //method string and date
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public void insertDBPelanggan() throws SQLException{ //CRUD
        String sql = "INSERT INTO pembeli (no_pembelian,nama_pembeli,id_mobil,merk,tipe,hargatotal,tgl) VALUES ('"+nomorPembelian+"','"+namaPelanggan+"', '"+id+"','"+merk+"','"+tipe+"','"+hargatotal+"','"+tglPembelian()+"')";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        statement.execute(sql);
        System.out.println("\nDATA BERHASIL DI INPUT !!!");
    }
    
    public void Show1() throws SQLException{ //CRUD
        String sql = "SELECT id_mobil, merk, tipe, harga, status FROM data_mobil";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()){ //perulangan
            System.out.println("\n");
            System.out.print("Id Mobil\t :\t");
            System.out.print(result.getInt("id_mobil"));
            System.out.print("\nMerk Mobil\t:\t");
            System.out.print(result.getString("merk"));
            System.out.print("\nTipe Mobil\t:\t");
            System.out.print(result.getString("tipe"));
            System.out.print("\nHarga Mobil\t:\t");
            System.out.print(result.getInt("harga"));
            System.out.print("\nStatus Mobil\t:\t");
            System.out.print(result.getString("status"));
           
        }
    }

    public void Show2() throws SQLException{ //CRUD
        String sql = "SELECT no_pembelian, nama_pembeli, id_mobil, tipe, hargatotal, tgl FROM pembeli";
        con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while(result.next()){ //perulangan
            System.out.println("\n");
            System.out.print("Nomor Pembelian\t:\t");
            System.out.print(result.getInt("no_pembelian"));
            System.out.print("\nNama Pembeli\t:\t");
            System.out.print(result.getString("nama_pembeli"));
            System.out.print("\nID Mobil\t:\t");
            System.out.print(result.getInt("id_mobil"));
            System.out.print("\nTipe Mobil\t:\t");
            System.out.print(result.getString("tipe"));
            System.out.print("\nHarga total\t:\t");
            System.out.print(result.getString("hargatotal"));
            System.out.print("\nTanggal Pembelian\t:\t");
            System.out.print(result.getString("tgl"));
        }
    }

    public void ubah() throws SQLException{ //CRUD
        try {
            System.out.print("\nMasukkan ID Mobil untuk mengubah data mobil: ");
            id = 0;
            id = input.nextInt();
            input.nextLine();

            String sql = "SELECT id_mobil, merk, tipe, harga, status FROM data_mobil  WHERE id_mobil = '"+id+"'"; //menampilkan 
            con = DriverManager.getConnection(url,"root","");
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);
        
            if (result.next()){
                System.out.print("Id mobil ["+result.getInt("id_mobil")+"]\t :");
                id = input.nextInt();

                System.out.print("Merk Mobil ["+result.getString("merk")+"]\t :");
                merk = input.next();

                System.out.print("Tipe Mobil ["+result.getString("tipe")+"]\t :");
                tipe = input.next();

                System.out.print("Harga ["+result.getString("harga")+"]\t :");
                harga = input.nextInt();

                System.out.print("Status Mobil ["+result.getString("status")+"]\t :");
                status = input.next();

                sql = "UPDATE data_mobil SET id_mobil ='"+id+"', merk='"+merk+"', tipe='"+tipe+"', harga='"+harga+"', status='"+status+"' WHERE id_mobil='"+id+"'";
                
                if(statement.executeUpdate(sql) > 0){ //nilai menjadi = 1 berarti  sudah berhasil diubah
                    System.out.println("Berhasil memperbaharui data ");
                }
            }
            statement.close();        //menutup statement
        } catch (SQLException e) { //exception untuk kesalahan dalam database
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }

    }

    public void search() throws SQLException{ //CRUD
        System.out.println("Mencari data mobil berdasarkan merk");
				
		System.out.print("\nMasukkan Nama merk mobil yang ingin dilihat : ");    
		String keyword = input.nextLine();
		
		String sql = "SELECT * FROM data_mobil WHERE merk LIKE '%"+keyword+"%'";
		con = DriverManager.getConnection(url,"root","");
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql); 
                
        while(result.next()){ //perulangan
        	System.out.print("\nID Mobil\t  : ");
            System.out.print(result.getInt("id_mobil"));
            System.out.print("\nMerk Mobil\t  : ");
            System.out.print(result.getString("merk"));
            System.out.print("\nTipe Mobil\t : ");
            System.out.print(result.getString("tipe"));
            System.out.print("\nHarga Mobil\t : ");
            System.out.print(result.getInt("harga"));
            System.out.print("\nStatus\t  : ");
            System.out.print(result.getString("status"));
            System.out.print("\n");
        }
	}   
    

    public void delete() { //CRUD
		String text4 = "\nHapus Daftar Mobil yang telah dibeli";
		System.out.println(text4.toUpperCase());
		
		try{
	        System.out.print("\nMasukan ID Mobil yang akan dihapus : ");
	        Integer id = Integer.parseInt(input.nextLine());
	        
	        String sql = "DELETE FROM data_mobil WHERE id_mobil = "+id;
	        con = DriverManager.getConnection(url,"root","");
	        Statement statement = con.createStatement();
	        
	        if(statement.executeUpdate(sql) > 0){
	            System.out.println("Berhasil menghapus data");
	        }
	   }
		catch(SQLException e){ //exception saat data gagal disambungkan
	        System.out.println("Terjadi kesalahan dalam menghapus data");
	    }
        catch(Exception e){ //exception errorhandling
            System.out.println("masukan data yang benar");
        }
	}

}
