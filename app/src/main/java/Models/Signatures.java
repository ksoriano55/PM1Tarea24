package Models;

public class Signatures {
    private int Id;
    private String Descripcion;
    private byte[] FirmaDigital;
    public Signatures() {
    }

    public Signatures(int id,String descripcion, byte[] firmaDigital) {
        Id = id;
        Descripcion = descripcion;
        FirmaDigital = firmaDigital;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public byte[] getFirmaDigital() {
        return FirmaDigital;
    }

    public void setFirmaDigital(byte[] firmaDigital) {
        FirmaDigital = firmaDigital;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
