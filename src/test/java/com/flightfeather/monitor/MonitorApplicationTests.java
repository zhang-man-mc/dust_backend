package com.flightfeather.monitor;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class MonitorApplicationTests {

    @Test
    void contextLoads() throws ParseException {

            String oldDateStr ="2023-05-01T16:00:00.000Z";
            Date date1 = null;
            SimpleDateFormat df2 = null;

                oldDateStr = oldDateStr.replace("Z", " UTC");
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
                Date date = df.parse(oldDateStr);
                SimpleDateFormat sdf = new SimpleDateFormat ("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
                date1 = sdf.parse(date.toString());
                df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.print(date1);
            //return df2.format(date1);

    }


//    @Test
//    void exceeding(){
//
//    }

}
