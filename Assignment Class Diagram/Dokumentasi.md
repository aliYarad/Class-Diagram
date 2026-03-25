# BUKU RESEP DIGITAL

## 1. Deskripsi
Real-world case melalui pendekatan Object-Oriented Programming (OOP) berbentuk "Buku Resep Digital" yang memungkinkan pengguna untuk membuat dan menampilkan resep makanan berdasarkan kategori makanan nusantara atau mancanegara). 

Dengan catatan setiap resep memiliki atribut:
- Nama makanan
- Bahan-bahan
- Langkah pembuatan
- Waktu memasak
  
Selain itu, setiap resep juga memiliki metode memasak tersendiri, misalnya dengan digoreng atau direbus.

## 2. Class Diagram  
Berikut adalah class diagramnya:
<img width="8192" height="3054" alt="Class Diagram BukuResep-2026-03-25-064332" src="https://github.com/user-attachments/assets/041945fb-e5ca-4887-a27f-edb1b6cee112" />

## 3. Kode
```java
// Abstarction
abstract class Resep {
    protected String makanan;
    protected String bahan;
    protected String step;
    private int waktu;
    protected MetodeMasak metodeMasak;

    public Resep() {
    }

    public Resep(String makanan, String bahan, String step, int waktu, MetodeMasak metodeMasak) {
        this.makanan = makanan;
        this.bahan = bahan;
        this.step = step;
        this.waktu = waktu;
        this.metodeMasak = metodeMasak;
    }

    public abstract void kategori();

    // Encapsulation
    public int getWaktu() {
        return waktu;
    }

    public void setWaktu(int waktu) {
        this.waktu = waktu;
    }

    public void masak() {
        if (metodeMasak != null) {
            metodeMasak.masak();
    } else {
        System.out.println("Metode memasak tidak ada");
    }
  }

    public void infoResep() {
        System.out.println("Nama : " + makanan);
        System.out.println("Bahan : " + bahan);
        System.out.println("Step : " + step);
        System.out.println("Waktu : " + waktu + " menit");
    }
}

// Interface
interface MetodeMasak {
  void masak();
}

class Menggoreng implements MetodeMasak {
  @Override
  public void masak() {
    System.out.println("Memasak menggunakan metode menggoreng");
  }
}

class Merebus implements MetodeMasak {
  @Override
  public void masak() {
    System.out.println("Memasak menggunakan metode merebus");
  }
}

// Inheritance
class ResepNusantara extends Resep {

    public ResepNusantara(String makanan, String bahan, String step, int waktu, MetodeMasak metodeMasak) {
        super(makanan, bahan, step, waktu, metodeMasak);
    }

    // Polymorphism
    @Override
    public void kategori() {
        System.out.println("Kategori : Resep Nusantara");
  }
}

class ResepMancanegara extends Resep {

    public ResepMancanegara(String makanan, String bahan, String step, int waktu, MetodeMasak metodeMasak) {
        super(makanan, bahan, step, waktu, metodeMasak);
    }

    // Polymorphism
    @Override
    public void kategori() { 
        System.out.println("Kategori : Resep Mancanegara");
    }
}

public class BukuResep {
    public static void main(String[] args) {

    MetodeMasak metode = new Menggoreng();

    Resep resep = new ResepNusantara(
        "Nasi Goreng",
        "Nasi, telur, ayam, bumbu halus, pelengkap",
        "Tumbuk bumbu halus, Panaskan minyak, Goreng semua bahan sampai dirasa matang",
        15,
        metode);

    System.out.println("RESEP NASI GORENG");
    resep.infoResep();

    System.out.println("\nKATEGORI (NUSANTARA/MANCANEGARA)");
    resep.kategori();

    System.out.println("\nMETODE MEMASAK (MENGGORENG/MEREBUS)");
    resep.masak();

    // Encapsulation
    System.out.println("\nUBAH WAKTU MEMASAK");
    resep.setWaktu(20);
    System.out.println("Waktu masak sekarang: " + resep.getWaktu() + " menit");
    }
}
```

## 4. Output
Output saat program dijalankan:  

<img width="752" height="303" alt="Screenshot 2026-03-25 142137" src="https://github.com/user-attachments/assets/b272fc39-1eb7-4e52-b2bb-842eab283963" />

## 5. Penjelasan Kode
### a. Abstraction
Class `Resep` merupakan abstract class yang berfungsi sebagai blueprint.
```java
abstract class Recipe {
    public abstract void showCategory();
}
```

### b. Encapsulation  
Encapsulation digunakan untuk membatasi akses langsung ke data dalam class.
Pada program ini, atribut seperti `waktuMasak` dibuat private, sehingga tidak bisa diakses atau diubah secara langsung dari luar class.

Akses dilakukan melalui method getter dan setter:
```java
private int waktuMasak;

public int getWaktuMasak() {
    return waktuMasak;
}

public void setWaktuMasak(int waktuMasak) {
    this.waktuMasak = waktuMasak;
}
```
### c. Inheritance
Inheritance digunakan agar class turunan dapat mewarisi atribut dan method dari class induk.  

Pada program ini, class `ResepNusantara` dan `ResepMancanegara` merupakan turunan dari class `Resep`.
```java
class ResepNusantara extends Resep {

    public ResepNusantara(String makanan, String bahan, String step, int waktu, MetodeMasak metodeMasak) {
        super(makanan, bahan, step, waktu, metodeMasak);
    }

    // Polymorphism
    @Override
    public void kategori() {
        System.out.println("Kategori : Resep Nusantara");
  }
}

class ResepMancanegara extends Resep {

    public ResepMancanegara(String makanan, String bahan, String step, int waktu, MetodeMasak metodeMasak) {
        super(makanan, bahan, step, waktu, metodeMasak);
    }

    // Polymorphism
    @Override
    public void kategori() { 
        System.out.println("Kategori : Resep Mancanegara");
    }
}
```
### d. Polymorphism
Polymorphism memungkinkan satu variabel memiliki banyak bentuk tergantung objek yang digunakan.
```java
Resep resep = new ResepNusantara(...);
resep.kategori();
```
Meskipun bertipe Resep, method yang dijalankan akan mengikuti implementasi dari `ResepNusantara`. Jika objeknya diganti, maka hasilnya juga akan berbeda.

### e. Interface  
Program ini menggunakan interface `MetodeMasak` untuk merepresentasikan cara memasak.
```java
interface MetodeMasak {
  void masak();
}
```
Interface ini nantinya diimplementasikan oleh class `Menggoreng` dan `Merebus`.

## 6. Keunikan Program
Program ini memiliki keunikan yaitu:
- Relasi antara `Resep` dan `MetodeMasak` memungkinkan metode memasak diganti secara fleksibel tanpa mengubah struktur utama program
- Kategori resep yang dibedakan berdasarkan domainnya yaitu nusantara dan mancanegara
