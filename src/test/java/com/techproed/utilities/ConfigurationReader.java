package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    // ConfigurationReader class'ını projemizin heryerinden
    // nesne üretmeden, miras almadan kullanabilecek şekilde tasarlayalım.
    // static : program çalışır çalışmaz, bellekte yer tutmaya yarayan keyword
    static Properties properties;
    static{
        /* okumak istediğimiz configuration.properties file'ın dosya yolu
        bu yolu sag tiklayip copy path den aldik
         C:\Users\isimsiz\IdeaProjects\TestNGProje\configuration.properties */
        String path = "configuration.properties";
        /* try-catch==>dene - hata varsa yakala.
           bu işlemi DENE eğer hata alırsan, PROGRAMI DURDURMA*/
        try{
            // okumak istediğiniz dosyanın path(adres)'ini yazıyorsun
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            // fileInputStream'dan ürettiğim file dosyası burada, bunu kullanabilirsin
            properties.load(file);
        }catch (Exception e){
            System.out.println("Aranan yol yanlis veya dosya silinmis");
        }
    }
    //properties.getProperty("username");==>manager2'yi verir
    public static String getProperty(String key){
        return  properties.getProperty(key);
    }
}
