//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2024.05.20 à 02:42:03 AM CEST 
//


package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;all&gt;
 *         &lt;element ref="{http://univ.fr/cv24}identite"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}objectif"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}prof" minOccurs="0"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}competences"/&gt;
 *         &lt;element ref="{http://univ.fr/cv24}divers" minOccurs="0"/&gt;
 *       &lt;/all&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "cv24")
public class Cv24 {

    @XmlElement(required = true)
    protected Identite identite;
    @XmlElement(required = true)
    protected Objectif objectif;
    protected Prof prof;
    @XmlElement(required = true)
    protected Competences competences;
    protected Divers divers;

    /**
     * Obtient la valeur de la propriété identite.
     * 
     * @return
     *     possible object is
     *     {@link Identite }
     *     
     */
    public Identite getIdentite() {
        return identite;
    }

    /**
     * Définit la valeur de la propriété identite.
     * 
     * @param value
     *     allowed object is
     *     {@link Identite }
     *     
     */
    public void setIdentite(Identite value) {
        this.identite = value;
    }

    /**
     * Obtient la valeur de la propriété objectif.
     * 
     * @return
     *     possible object is
     *     {@link Objectif }
     *     
     */
    public Objectif getObjectif() {
        return objectif;
    }

    /**
     * Définit la valeur de la propriété objectif.
     * 
     * @param value
     *     allowed object is
     *     {@link Objectif }
     *     
     */
    public void setObjectif(Objectif value) {
        this.objectif = value;
    }

    /**
     * Obtient la valeur de la propriété prof.
     * 
     * @return
     *     possible object is
     *     {@link Prof }
     *     
     */
    public Prof getProf() {
        return prof;
    }

    /**
     * Définit la valeur de la propriété prof.
     * 
     * @param value
     *     allowed object is
     *     {@link Prof }
     *     
     */
    public void setProf(Prof value) {
        this.prof = value;
    }

    /**
     * Obtient la valeur de la propriété competences.
     * 
     * @return
     *     possible object is
     *     {@link Competences }
     *     
     */
    public Competences getCompetences() {
        return competences;
    }

    /**
     * Définit la valeur de la propriété competences.
     * 
     * @param value
     *     allowed object is
     *     {@link Competences }
     *     
     */
    public void setCompetences(Competences value) {
        this.competences = value;
    }

    /**
     * Obtient la valeur de la propriété divers.
     * 
     * @return
     *     possible object is
     *     {@link Divers }
     *     
     */
    public Divers getDivers() {
        return divers;
    }

    /**
     * Définit la valeur de la propriété divers.
     * 
     * @param value
     *     allowed object is
     *     {@link Divers }
     *     
     */
    public void setDivers(Divers value) {
        this.divers = value;
    }

}
