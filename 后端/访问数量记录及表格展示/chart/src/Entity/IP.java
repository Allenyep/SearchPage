package Entity;

/**
 * Created by allen on 2017/4/9.
 */
public class IP {
    private String ip;
    private int number;
    public IP() {
    }

    public IP(String ip, int number) {
        this.ip = ip;
        this.number = number;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
