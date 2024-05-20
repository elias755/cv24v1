<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:cv="http://univ.fr/cv24" exclude-result-prefixes="cv cv24">

    <xsl:template match="/">
                <div>
                    <h2>Identité</h2>
                    <p><strong>Genre: </strong> <xsl:value-of select="cv:cv24/cv:identite/cv:genre"/></p>
                    <p><strong>Prénom: </strong> <xsl:value-of select="cv:cv24/cv:identite/cv:prenom"/></p>
                    <p><strong>Nom: </strong> <xsl:value-of select="cv:cv24/cv:identite/cv:nom"/></p>
                </div>

                <div>
                    <h2>Objectif</h2>
                    <p><strong>Statut: </strong> <xsl:value-of select="cv:cv24/cv:objectif/@statut"/></p>
                    <p><strong>Description: </strong> <xsl:value-of select="cv:cv24/cv:objectif"/></p>
                </div>
                
                <xsl:for-each select="cv:cv24/cv:competences/cv:diplome">
    				<xsl:sort select="@niveau" order="descending" data-type="number"/>
    				<xsl:sort select="cv:date" order="descending"/>
    				<xsl:if test="position() = 1">
				    	<div>			
				        	<h2>Diplôme le plus élevé (ou plus récent)</h2>
				        	<p><strong>Niveau: </strong> <xsl:value-of select="@niveau"/></p>
				            <p><strong>Intitulé: </strong><xsl:value-of select="cv:intitule"/></p>
				            <p><strong>Date: </strong><xsl:value-of select="cv:date"/></p>
				            <p><strong>Institut: </strong><xsl:value-of select="cv:institut"/></p>
						</div>
    				</xsl:if>
				</xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
