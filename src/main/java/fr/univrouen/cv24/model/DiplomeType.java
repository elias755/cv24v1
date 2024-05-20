//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:42:03 AM CEST 
//


package fr.univrouen.cv24.model;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour diplomeType complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="diplomeType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="intitule" type="{http://univ.fr/cv24}String32"/&gt;
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="institut" type="{http://univ.fr/cv24}String32" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="niveau" use="required" type="{http://univ.fr/cv24}NiveauType" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "diplomeType", propOrder = {
    "intitule",
    "date",
    "institut"
})
public class DiplomeType {

    @XmlElement(required = true)
    protected String intitule;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar date;
    protected String institut;
    @XmlAttribute(name = "niveau", required = true)
    protected int niveau;

    /**
     * Obtient la valeur de la propriété intitule.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntitule() {
        return intitule;
    }

    /**
     * Définit la valeur de la propriété intitule.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntitule(String value) {
        this.intitule = value;
    }

    /**
     * Obtient la valeur de la propriété date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Définit la valeur de la propriété date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtient la valeur de la propriété institut.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitut() {
        return institut;
    }

    /**
     * Définit la valeur de la propriété institut.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitut(String value) {
        this.institut = value;
    }

    /**
     * Obtient la valeur de la propriété niveau.
     * 
     */
    public int getNiveau() {
        return niveau;
    }

    /**
     * Définit la valeur de la propriété niveau.
     * 
     */
    public void setNiveau(int value) {
        this.niveau = value;
    }

}
