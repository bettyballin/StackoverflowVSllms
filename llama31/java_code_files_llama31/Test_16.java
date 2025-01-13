/*
 * Decompiled with CFR 0.152.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Test_16 {
    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void main(String[] stringArray) {
        String string = "0";
        URL uRL = null;
        HttpURLConnection httpURLConnection = null;
        FilterInputStream filterInputStream = null;
        FilterOutputStream filterOutputStream = null;
        try {
            uRL = new URL("http://www.something.com/myscript?param=xy");
            httpURLConnection = (HttpURLConnection)uRL.openConnection();
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            filterInputStream = new DataInputStream(httpURLConnection.getInputStream());
            filterOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            String string2 = "param=xy";
            ((DataOutputStream)filterOutputStream).writeBytes(string2);
            ((DataOutputStream)filterOutputStream).flush();
            filterOutputStream.close();
            filterInputStream.close();
            int n = httpURLConnection.getResponseCode();
            System.out.println("Response Code : " + n);
        }
        catch (MalformedURLException malformedURLException) {
            System.out.println("1. MalformedURLException");
            malformedURLException.printStackTrace();
        }
        catch (IOException iOException) {
            System.out.println("2. IOException");
            iOException.printStackTrace();
        }
        finally {
            if (filterInputStream != null) {
                try {
                    filterInputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (filterOutputStream != null) {
                try {
                    filterOutputStream.close();
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                }
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
    }
}
