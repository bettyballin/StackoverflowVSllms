SELECT\n   XMLELEMENT("primaryName", A.Name) AS "PrimaryName",\n   xmlelement("synonyms",\n              (SELECT XMLAGG(XMLELEMENT("name", b.name))\n               FROM B\n               WHERE B.ID = A.ID)) AS "Synonyms"\nFROM A;