package fr.univrouen.cv24.service;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import fr.univrouen.cv24.model.Cv24;
import fr.univrouen.cv24.model.Identite;

@Service
public class CVService {
    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://by3e2k93tqzmrmwemybh-mysql.services.clever-cloud.com:3306/by3e2k93tqzmrmwemybh?autoReconnect=true&useSSL=false", "ux4fnzz2sqtlp55h", "sGVud7zPMI67CJfr3ogS");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static int CV_ID = getMaxId();

    public ResponseEntity<String> insertCV(Cv24 cv, String xmlData) {
        try {
            if (cvExists(cv.getIdentite())) {
                return ResponseEntity.badRequest().body("<response><status>ERROR</status><detail>DUPLICATED</detail></response>");
            }
            String query = "INSERT INTO cv (id, genre, prenom, nom, tel, xml) VALUES (?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                Identite id = cv.getIdentite();
                preparedStatement.setInt(1, CV_ID);
                preparedStatement.setString(2, id.getGenre().value());
                preparedStatement.setString(3, id.getPrenom());
                preparedStatement.setString(4, id.getNom());
                preparedStatement.setString(5, id.getTel());
                preparedStatement.setString(6, xmlData);

                int rowsInserted = preparedStatement.executeUpdate();

                if (rowsInserted > 0) {
                    CV_ID++;
                    return ResponseEntity.ok("<response><status>INSERTED</status><id>" + (CV_ID - 1) + "</id></response>");
                } else {
                    return ResponseEntity.badRequest().body("<response><status>ERROR</status><detail>INVALID</detail></response>");
                }
            }
        } catch (SQLException e) {
            return ResponseEntity.badRequest().body("<response><status>ERROR</status><detail>INVALID</detail></response>");
        }
    }
    
    public boolean deleteCV(String id) {
    	 try {
             String query = "DELETE FROM cv WHERE id = ?";
             try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                 preparedStatement.setString(1, id);
                 int rowsDeleted = preparedStatement.executeUpdate();
                 return rowsDeleted > 0;
             }
         } catch (SQLException e) {
             return false;
         }
	}
    
    public ResponseEntity<String> getCVById(String id) {
    	String query = "SELECT xml FROM cv WHERE id = ?";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    		preparedStatement.setString(1, id);
    		try (ResultSet resultSet = preparedStatement.executeQuery()) { 
    			if (resultSet.next()) {
    				return ResponseEntity.ok(resultSet.getString("xml"));
    			} else {
    				return ResponseEntity.badRequest().body("<response><id>"+ id + "</id><status>ERROR</status></response>");
    			}
    		}
    	} catch (SQLException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
		}
	}
    
    public ResponseEntity<String> getCVByIdHTML(String id) {
    	String query = "SELECT xml FROM cv WHERE id = ?";
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    		preparedStatement.setString(1, id);
    		try (ResultSet resultSet = preparedStatement.executeQuery()) { 
    			if (resultSet.next()) {
    				TransformerFactory factory = TransformerFactory.newInstance();
    		    	Source xslt = new StreamSource(new File("src/main/resources/xslt/detail.xslt"));
    		    	try {
						Transformer transformer = factory.newTransformer(xslt);
						transformer.setOutputProperty(OutputKeys.METHOD, "html");
						transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			            StringWriter writer = new StringWriter();
			            Source text = new StreamSource(new StringReader(resultSet.getString("xml")));
                        transformer.transform(text, new StreamResult(writer));
                        return ResponseEntity.ok(writer.toString());
					} catch (TransformerConfigurationException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
					} catch (TransformerException e) {
						return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
					}   				
    			} else {
    				return ResponseEntity.badRequest().body("<response><id>"+ id + "</id><status>ERROR</status></response>");
    			}
    		}
    	} catch (SQLException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
		}
	}
    
    public ResponseEntity<String> resume(String filename, String output) {
    	
    	String query = "SELECT id, xml FROM cv";
    	StringBuilder result = null;
    	if (output.equals("xml")) {
    		result = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<resume>\n");
    	} else {
    		result = new StringBuilder("<!DOCTYPE html>\n<html lang='fr'>\n" +
    	            "    <head>\n" +
    				"<meta charset=\"UTF-8\">\n" +
    	            "        <title>CV Résumé</title>\n" +
    	            "        <link rel=\"stylesheet\" href=\"/resume.css\">\n" +
    	            "    </head>\n" +
    	            "    <body>\n<h1 id='main'>Résumé des CV</h1>\n");
    	}
    	 
    	TransformerFactory factory = TransformerFactory.newInstance();
    	Source xslt = new StreamSource(new File("src/main/resources/xslt/" + filename));
    	Transformer transformer;
    	try {
			transformer = factory.newTransformer(xslt);
			transformer.setOutputProperty(OutputKeys.METHOD, output);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            if (output.equals("xml")) {
            	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            }
		} catch (TransformerConfigurationException e1) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
		}
    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {          	
            	while (resultSet.next()) {
            		StringWriter writer = new StringWriter();
            		String xmlData = resultSet.getString("xml");
            		if (output.equals("xml")) {
            			result.append("<id>" + resultSet.getString("id") + "</id>\n");
            			result.append("<cv>\n");		
            		} else {
            			result.append("<h1>CV de ID  " + resultSet.getString("id") + "</h1>\n");
            			result.append("<div class = 'cv'>\n");
            		}
            		
            		try {
                        Source text = new StreamSource(new StringReader(xmlData));
                        transformer.transform(text, new StreamResult(writer));
                    } catch (TransformerException e) {
                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
                    }
            		result.append(writer.toString());
            		if (output.equals("xml")) {
	            		result.append("</cv>");
            		} else {  			
            			result.append("</div>");
            		}
            	}
            }
    	} catch (SQLException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("<response><status>ERROR</status></response>");
        }
    	if (output.equals("xml")) {
    		result.append("</resume>");
    	} else {
    		result.append("\n</body>\n" +
    	            "</html>");
    	}
		return ResponseEntity.ok(result.toString());
    }
    

    private boolean cvExists(Identite identite) throws SQLException {
        String query = "SELECT COUNT(*) FROM cv WHERE genre = ? AND prenom = ? AND nom = ? AND tel = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, identite.getGenre().value());
            preparedStatement.setString(2, identite.getPrenom());
            preparedStatement.setString(3, identite.getNom());
            preparedStatement.setString(4, identite.getTel());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

    private static int getMaxId() {
        int maxId = -1;

        try {
            String query = "SELECT MAX(id) FROM cv";

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        maxId = resultSet.getInt(1);
                    }
                }
            }
        } catch (SQLException e) {

        }

        return maxId+1;
    }

	
	
}
