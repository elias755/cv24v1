<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0"
                xmlns:cv="http://univ.fr/cv24" exclude-result-prefixes="cv cv24">

    <xsl:template match="/">
        <content>
            <identite>
                <genre><xsl:value-of select="cv:cv24/cv:identite/cv:genre"/></genre>
                <prenom><xsl:value-of select="cv:cv24/cv:identite/cv:prenom"/></prenom>
                <nom><xsl:value-of select="cv:cv24/cv:identite/cv:nom"/></nom>
            </identite>

            <objectif statut="{cv:cv24/cv:objectif/@statut}">
                <xsl:value-of select="cv:cv24/cv:objectif"/>
            </objectif>
            
            <xsl:for-each select="cv:cv24/cv:competences/cv:diplome">
			    <xsl:sort select="@niveau" order="descending" data-type="number"/>
			    <xsl:sort select="cv:date" order="descending"/>
			    <xsl:if test="position() = 1">
        			<diplome niveau="{@niveau}">
			            <intitule><xsl:value-of select="cv:intitule"/></intitule>
			            <date><xsl:value-of select="cv:date"/></date>
			            <institut><xsl:value-of select="cv:institut"/></institut>
			        </diplome>
			    </xsl:if>
			</xsl:for-each>
            
        </content>
    </xsl:template>
</xsl:stylesheet>
