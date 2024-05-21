package fr.univrouen.cv24.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
public class HelpController {

    @Value("classpath:static/help.html")
    private Resource helpHtml;

    @GetMapping(value = "/help", produces = "text/html; charset=UTF-8")
    public ResponseEntity<String> showHelpPage() {
        try {
            String htmlContent = StreamUtils.copyToString(helpHtml.getInputStream(), StandardCharsets.UTF_8);
            return ResponseEntity.status(HttpStatus.OK)
                    .header(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8")
                    .body(htmlContent);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
        }
    }
}
