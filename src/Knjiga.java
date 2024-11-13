public interface Knjiga {
    String getNaslov();
    String getAutor();
    Integer getGodinaIzdavanja();
    Integer getBrojStranica();
    String getStanje();

    void posudi();

    void vratiti();

}