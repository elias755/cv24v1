<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cv24="http://univ.fr/cv24">
	<xsl:output method="html" encoding="UTF-8"/>
	
	<xsl:template match="/">
		<html>
            <head>
                <title>CV24 - Détail</title>
                <link rel="stylesheet" href="/cv.css"/>
            </head>
            <body>
                <h1>CV24</h1>
		  		<xsl:apply-templates select="cv24:cv24/cv24:identite"/>
		  		<xsl:apply-templates select="cv24:cv24/cv24:objectif"/>
		  		<xsl:apply-templates select="cv24:cv24/cv24:prof"></xsl:apply-templates>
		  		<xsl:apply-templates select="cv24:cv24/cv24:competences"></xsl:apply-templates>
		  		<xsl:apply-templates select="cv24:cv24/cv24:divers"></xsl:apply-templates>
            </body>
        </html>
	</xsl:template>

	<xsl:template match="/cv24:cv24/cv24:identite">
		<h2>
			<xsl:value-of select="cv24:genre" /><xsl:text> </xsl:text>
			<xsl:value-of select="cv24:nom" /><xsl:text> </xsl:text>
			<xsl:value-of select="cv24:prenom" />
		</h2>
		<p>Tel: <xsl:call-template name="formatPhoneNumber">
        <xsl:with-param name="phone" select="cv24:tel"/>
    </xsl:call-template> <br/> Mail: <xsl:value-of select="cv24:mail"/> </p>
	</xsl:template>
	
	<xsl:template match="/cv24:cv24/cv24:objectif">
		<h2><xsl:value-of select="."/></h2>
		<p>Demande de <xsl:value-of select="@statut"></xsl:value-of></p>
	</xsl:template>
	
	<xsl:template match="/cv24:cv24/cv24:prof">
		<h2>Expériences Professionnelles</h2>
		<ol>
			<xsl:for-each select="cv24:detail">
				<li><xsl:value-of select="cv24:titre"/> (du 
				<xsl:call-template name="formatDate">
        			<xsl:with-param name="date" select="cv24:datedeb"/>
   				</xsl:call-template> au 
   				<xsl:call-template name="formatDate">
        			<xsl:with-param name="date" select="cv24:datefin"/>
    			</xsl:call-template>)
    			</li>
			</xsl:for-each>
		</ol>
	</xsl:template>
	
	<xsl:template match="/cv24:cv24/cv24:competences">
		<div>
			<h2>Diplômes</h2>
			<table>
				<xsl:for-each select="cv24:diplome">
					<tr>
						<td><xsl:call-template name="formatDate">
        						<xsl:with-param name="date" select="cv24:date"/>
    						</xsl:call-template>
    					</td>
						<td><xsl:value-of select="cv24:intitule"/></td>
						<td>(Niveau <xsl:value-of select="@niveau"/>)</td>
						<td><xsl:value-of select="cv24:institut"/></td>
					</tr>
				</xsl:for-each>
			</table>
		</div>
		<div>
			<h2>Certifications</h2>
			<table>
				<xsl:for-each select ="cv24:certif">
					<tr>
						<td><xsl:call-template name="formatDate">
        						<xsl:with-param name="date" select="cv24:datedeb"/>
    						</xsl:call-template> - 
    						<xsl:call-template name="formatDate">
        						<xsl:with-param name="date" select="cv24:datefin"/>
    						</xsl:call-template></td>
						<td><xsl:value-of select="cv24:titre"/></td>
					</tr>
				</xsl:for-each>
			</table>
		</div>
	</xsl:template>
	
	<xsl:template match="/cv24:cv24/cv24:divers">
		<div>
			<h2>Langues</h2>
			<ul>
				<xsl:for-each select="cv24:lv">
					<li><xsl:value-of select="@lang"/>: <xsl:value-of select="@cert"/>(<xsl:choose>
                        <xsl:when test="@nivi">
                            <xsl:value-of select="@nivi"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="@nivs"/>
                        </xsl:otherwise>
                    </xsl:choose>)</li>
				</xsl:for-each>
			</ul>
		</div>
			
		<div>
			<h2>Divers</h2>
			<ul>
				<xsl:for-each select="cv24:autre">
					<li><xsl:value-of select="@titre"/>: <xsl:value-of select="@comment"/></li>
				</xsl:for-each>
			</ul>
		</div>
	</xsl:template>
	
	<xsl:template name="formatDate">
    <xsl:param name="date"/>
    <xsl:variable name="year" select="substring($date, 1, 4)"/>
    <xsl:variable name="month" select="substring($date, 6, 2)"/>
    <xsl:variable name="day" select="substring($date, 9, 2)"/>
    
    <xsl:variable name="monthName">
        <xsl:choose>
            <xsl:when test="$month = '01'">Janv</xsl:when>
            <xsl:when test="$month = '02'">Fevr</xsl:when>
            <xsl:when test="$month = '03'">Mar</xsl:when>
            <xsl:when test="$month = '04'">Avr</xsl:when>
            <xsl:when test="$month = '05'">Mai</xsl:when>
            <xsl:when test="$month = '06'">Juin</xsl:when>
            <xsl:when test="$month = '07'">Jui</xsl:when>
            <xsl:when test="$month = '08'">Aout</xsl:when>
            <xsl:when test="$month = '09'">Sept</xsl:when>
            <xsl:when test="$month = '10'">Oct</xsl:when>
            <xsl:when test="$month = '11'">Nov</xsl:when>
            <xsl:when test="$month = '12'">Dec</xsl:when>
        </xsl:choose>
    </xsl:variable>
    
    <xsl:value-of select="concat($day, ' ', $monthName, ' ', $year)"/>
</xsl:template>

<xsl:template name="formatPhoneNumber">
    <xsl:param name="phone"/>
    <xsl:variable name="trimmedPhone" select="translate($phone, ' ', '')"/>
    <xsl:choose>
        <xsl:when test="starts-with($trimmedPhone, '+33')">
            <xsl:value-of select="concat('+33 (0)', substring($trimmedPhone, 4, 1), ' ', substring($trimmedPhone, 5, 2), ' ', substring($trimmedPhone, 7, 2), ' ', substring($trimmedPhone, 9, 2), ' ', substring($trimmedPhone, 11, 2))"/>
        </xsl:when>
        <xsl:otherwise>
            <xsl:value-of select="$phone"/>
        </xsl:otherwise>
    </xsl:choose>
</xsl:template>

	
</xsl:stylesheet>