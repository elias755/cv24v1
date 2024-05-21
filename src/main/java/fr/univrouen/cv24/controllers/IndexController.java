package fr.univrouen.cv24.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	
	@Value("classpath:static/index.html")
    private Resource indexHtml;

    @GetMapping(value = "/", produces = "text/html; charset=UTF-8")
    public ResponseEntity<String> index() {
        try {
            String htmlContent = StreamUtils.copyToString(indexHtml.getInputStream(), StandardCharsets.UTF_8);
            return ResponseEntity.status(HttpStatus.OK)
                    .header(HttpHeaders.CONTENT_TYPE, "text/html; charset=UTF-8")
                    .body(htmlContent);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
        }
    }
    
}
