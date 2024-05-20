package fr.univrouen.cv24.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @GetMapping("/")
    public @ResponseBody String index() {
        String nomProjet = "Projet cv24 XML";
        String numeroVersion = "1";
        
        String[] membresEquipe = {"Elias LARBI"};
        
        String logoUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/df/Universit%C3%A9_de_Rouen.png/800px-Universit%C3%A9_de_Rouen.png";
        
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<!DOCTYPE html>");
        htmlBuilder.append("<html lang='fr'>");
        htmlBuilder.append("<head>");
        htmlBuilder.append("<meta charset=\"utf-8\">");
        htmlBuilder.append("<title>Index</title>");
        htmlBuilder.append("</head>");
        htmlBuilder.append("<body>");
        htmlBuilder.append("<h1>").append(nomProjet).append("</h1>");
        htmlBuilder.append("<p>Version: ").append(numeroVersion).append("</p>");
        htmlBuilder.append("<p>Membres de l'équipe:</p>");
        htmlBuilder.append("<ul>");
        for (String membre : membresEquipe) {
            htmlBuilder.append("<li>").append(membre).append("</li>");
        }
        htmlBuilder.append("</ul>");
        htmlBuilder.append("<img src='").append(logoUrl).append("' width=\"200\" height=\"100\" alt='Logo Université de Rouen'>");
        htmlBuilder.append("</body>");
        htmlBuilder.append("</html>");

        return htmlBuilder.toString();
    }
}
