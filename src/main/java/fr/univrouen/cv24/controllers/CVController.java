package fr.univrouen.cv24.controllers;

import fr.univrouen.cv24.model.Cv24;
import fr.univrouen.cv24.service.CVService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

@RestController
@RequestMapping("/cv24")
public class CVController {

    private final CVService cvService;

    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> insertCV(@RequestBody String xmlData) {
    	try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Cv24.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new File("src/main/resources/xsd/cv24.xsd"));

            unmarshaller.setSchema(schema);

            Cv24 cv = (Cv24) unmarshaller.unmarshal(new StringReader(xmlData));

            return cvService.insertCV(cv, xmlData);
        } catch (JAXBException e) {
        	e.printStackTrace();
        	return ResponseEntity.badRequest().body("<response><status>ERROR</status><detail>INVALID</detail></response>");
        } catch (SAXException e) {
        	return ResponseEntity.badRequest().body("<response><status>ERROR</status><detail>INVALID</detail></response>");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status><detail>SERVER_PROBLEM</detail></response>");
        }
    }
    
    @DeleteMapping(value = "/delete", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> deleteCV(@RequestBody String id) {
        try {
            boolean isDeleted = cvService.deleteCV(id);
            if (isDeleted) {
                return ResponseEntity.ok("<response><id>" + id + "</id><status>DELETED</status></response>");
            } else {
                return ResponseEntity.badRequest().body("<response><status>ERROR</status></response>");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
        }
    }
    
    @GetMapping(value = "/resume", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> resumeCV() {
		return cvService.resume("resumehtml.xslt", "html");
    	
    }
    
    @GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> resumeCVXML() {
		return cvService.resume("resumexml.xslt", "xml");
    }
    
    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getCV(@RequestParam("id") String id) {
        return cvService.getCVById(id);    
    }
    
    @GetMapping(value = "/html", produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> getCVHtml(@RequestParam("id") String id) {
        return cvService.getCVByIdHTML(id);    
    }
}
