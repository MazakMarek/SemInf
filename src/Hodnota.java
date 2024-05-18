public enum Hodnota {
    NULA(0),
    JEDNA(1),
    DVA(2),
    TRI(3),
    STYRI(4),
    PAT(5),
    SEST(6),
    SEDEM(7),
    OSEM(8),
    DEVAT(9),
    AKCNA(20);

    private final Object value;

    Hodnota(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return this.value;
    }
}