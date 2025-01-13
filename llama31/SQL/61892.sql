CREATE TABLE SoapMessages (\n    Id INT PRIMARY KEY,\n    Message XML (dbo.SoapMessageSchema)\n);\n\nCREATE XML SCHEMA COLLECTION dbo.SoapMessageSchema AS \n'<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema">\n  <xs:element name="Envelope">\n    <xs:complexType>\n      <xs:sequence>\n        <xs:element name="Body" type="xs:string" />\n      </xs:sequence>\n    </xs:complexType>\n  </xs:element>\n</xs:schema>';