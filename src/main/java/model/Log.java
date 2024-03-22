package model;

public class Log {
    private int ip;
    private String level;
    private String address;
    private String PreValue;
    private String value;
    private int national;

    public Log(int ip, String level, String address, String preValue, String value, int national) {
        this.ip = ip;
        this.level = level;
        this.address = address;
        PreValue = preValue;
        this.value = value;
        this.national = national;
    }
}
