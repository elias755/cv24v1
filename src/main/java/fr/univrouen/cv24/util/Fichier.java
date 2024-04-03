package fr.univrouen.cv24.util;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fichier {

    private Resource resource;

    public Fichier() {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        this.resource = resourceLoader.getResource("xml/smallCV.xml");
    }

    public String loadFileXML() {
        StringBuilder content = new StringBuilder();
        try {
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (IOException e) {
            return "Erreur lors de la lecture du fichier : " + e.getMessage();
        }
        return content.toString();
    }
}

