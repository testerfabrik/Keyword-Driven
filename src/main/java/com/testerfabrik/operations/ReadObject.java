package com.testerfabrik.operations;

import java.io.*;
import java.util.Properties;

public class ReadObject {
    Properties p = new Properties();

    public Properties getObjectRepository() throws IOException {
        // Lee el archivo de propiedades
        InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+ "/resources/object.properties"));
        // Carga todas las propiedades para poder manipularlas
        p.load(stream);
        return p;
    }
}
