import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyWidget {

    private Label lb = new Label();
    private CalendarWidget calendar = new CalendarWidget();
    private Panel fp = new Panel();

    public MyWidget() {
        setupCalendar();
    }

    private void setupCalendar() {
        // Assuming you have a calendar widget with addListener method
        calendar.addListener(this);
        fp.add(calendar);
        fp.add(lb);
    }

    // Assuming we implement a ChangeListener interface
    public void onChange(ChangeEvent event) {
        lb.setText("Date selected: " + calendar.getDate());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String current = df.format(calendar.getDate());

        try {
            String urlParameters = "date=" + current;
            byte[] postData = urlParameters.getBytes("UTF-8");
            int postDataLength = postData.length;
            String requestURL = "http://www.kbehr.com/calendar/view_duty.php";

            URL url = new URL(requestURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();           
            conn.setDoOutput(true);
            conn.setInstanceFollowRedirects(false); 
            conn.setRequestMethod("POST"); 
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); 
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);

            try (java.io.DataOutputStream wr = new java.io.DataOutputStream(conn.getOutputStream())) {
               wr.write(postData);
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responseText = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                responseText.append(inputLine);
            }
            in.close();

            processResults(responseText.toString());

        } catch (Exception ex) {
            requestFailed(ex);
        }
    }

    private void processResults(String something) throws Exception {
        JSONArray jsonArray = new JSONArray(something);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String id = jsonObject.getString("id");
            // Similarly, extract other fields
            System.out.println("ID: " + id); // Example of processing the data
        }
    }

    private void requestFailed(Throwable exception) {
        Logger.getLogger(MyWidget.class.getName()).severe(exception.getMessage());
        System.err.println("Request failed: " + exception.getMessage());
    }

    public static void main(String[] args) {
        // Create instance
        MyWidget widget = new MyWidget();
        // Simulate a change event
        widget.onChange(null);
    }

    // Dummy implementations of classes/interfaces that are not defined
    class Label {
        void setText(String text) {
            System.out.println(text);
        }
    }

    class CalendarWidget {
        void addListener(MyWidget widget) {
            // Implementation here
        }

        Date getDate() {
            return new Date(); // Return current date for simplicity
        }
    }

    class Panel {
        void add(Object obj) {
            // Implementation here
        }
    }

    interface ChangeEvent {
        // Interface methods here
    }
}