package farkasnorbert.sapientia.ms.gepkocsiparkmanagementje.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SetData {
    private String data;
    private URLConnection conn;

    private void send() {
        try {

            // Defined URL  where to send data
            URL url = new URL("/update.php");

            // Send POST data request

            conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String result(String table,String col,String where,String data){
        try {
            this.data = URLEncoder.encode("table", "UTF-8")
                    + "=" + URLEncoder.encode(table, "UTF-8");
            this.data += "&" + URLEncoder.encode("col", "UTF-8") + "="
                    + URLEncoder.encode(col, "UTF-8");
            this.data += "&" + URLEncoder.encode("where", "UTF-8") + "="
                    + URLEncoder.encode(where, "UTF-8");
            this.data += "&" + URLEncoder.encode("data", "UTF-8") + "="
                    + URLEncoder.encode(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        send();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
