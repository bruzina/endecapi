package cz.bruzina.endecapi;

public interface Cipher {

    public String getName();

    public void setParams(String[] params);

    public String[] getParams();

    public String encrypt(String payload);

    public String decrypt(String payload);

}
