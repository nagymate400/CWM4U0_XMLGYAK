<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <body>
                <h2>student</h2>
                <table border="2">
                    <tr bgcolor="green">
                        <th>ID</th>
                        <th>Keresztnev</th>
                        <th>Vezeteknev</th>
                        <th>Becenev</th>
                        <th>Kor</th>
                        <th>Fizetes</th>
                        <th>Fokozat</th>
                    </tr>
                    <xsl:for-each select="class/student">
                        <tr>
                            <td>
                                <xsl:value-of select="@id" />
                            </td>
                            <td>
                                <xsl:value-of select="vezeteknev"/>
                            </td>
                            <td>
                                <xsl:value-of select="keresztnev"/>
                            </td>
                            <td>
                                <xsl:value-of select="becenev"/>
                            </td>
                            <td>
                                <xsl:value-of select="kor"/>
                            </td>
                            <td>
                                <xsl:value-of select="fizetes"/>
                            </td>

                                <xsl:choose>
                                    <xsl:when test="fizetes &gt; 600000">
                                        <td bgcolor="white">
                                            Magas
                                        </td>
                                    </xsl:when>
                                    <xsl:when test="fizetes &gt; 500000">
                                        <td bgcolor="white">
                                            Kozep</td>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <td>Alacsony</td>
                                    </xsl:otherwise>
                                </xsl:choose>

                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>