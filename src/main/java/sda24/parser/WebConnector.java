package sda24.parser;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Logger;

/**
 * Created by RENT on 2017-03-03.
 */
@Component
public class WebConnector {

    private final Logger LOGGER = Logger.getLogger(this.getClass().toString());

    public String getHTML(String url){
        StringBuffer sb = new StringBuffer();
        try {
            URL html = new URL(url);
            URLConnection urlConnection = html.openConnection();
            InputStream is = urlConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);

            int numCharsRead;
            char[] charArray = new char[1024];
            sb = new StringBuffer();
            while ((numCharsRead = isr.read(charArray)) > 0) {
                sb.append(charArray, 0, numCharsRead);
            }
        } catch (IOException e) {
            LOGGER.info(getClass() + e.getMessage());
        }
        return sb.toString();
    }
}
