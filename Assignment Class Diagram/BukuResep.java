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
