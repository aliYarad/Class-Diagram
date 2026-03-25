# BUKU RESEP DIGITAL

## Deskripsi
Real-world case melalui pendekatan Object-Oriented Programming (OOP) berbentuk "Buku Resep Digital" yang memungkinkan pengguna untuk membuat dan menampilkan resep makanan berdasarkan kategori makanan nusantara atau mancanegara). 

Dengan catatan setiap resep memiliki atribut:
- Nama makanan
- Bahan-bahan
- Langkah pembuatan
- Waktu memasak
  
Selain itu, setiap resep juga memiliki metode memasak tersendiri, misalnya dengan digoreng atau direbus.

## Class Diagram  
Berikut adalah class diagramnya:
<img width="8192" height="3054" alt="Class Diagram BukuResep-2026-03-25-064332" src="https://github.com/user-attachments/assets/041945fb-e5ca-4887-a27f-edb1b6cee112" />

## Kode
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
        System.out.println("Instruksi : " + step);
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

## Output
Output saat program dijalankan:
<img width="801" height="309" alt="Screenshot 2026-03-25 134706" src="https://github.com/user-attachments/assets/995a3f00-99ed-4dfe-87f2-5db5769e6b13" />

## Penjelasan Kode
### 1.
