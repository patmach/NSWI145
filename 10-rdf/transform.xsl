<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    >
    <xsl:output method="text" encoding="UTF-8" indent="no"/>
    <xsl:variable name="prefix">http://tenderWS/tender/</xsl:variable>
   
   <xsl:template match="tender">
        @prefix rdf: &lt;http://www.w3.org/1999/02/22-rdf-syntax-ns#&gt; .
        @prefix rdfs: &lt;http://www.w3.org/2000/01/rdf-schema#&gt; .
        @prefix akt: &lt;http://www.aktors.org/ontology/portal#&gt; .
        @prefix myvoc: &lt;http://myvocabularyNSWI145.com#&gt; . 
        @prefix xsd: &lt;http://www.w3.org/2001/XMLSchema#&gt; . 
        <xsl:variable name="currentURI" select="concat($prefix, ID)"/>
        &lt;<xsl:value-of select="$currentURI"/>&gt; a myvoc:Tender ;
        rdfs:label &quot;<xsl:value-of select="name"/>&quot;^^xsd:string ;
        akt:Amount-Of-Money &quot;<xsl:value-of select="amount"/>&quot; .    
    
   
    </xsl:template>
    <xsl:template match="text()"/>
   
</xsl:stylesheet>
