DECLARE @Xml XML;\nSET @Xml = N'\n<Library>\n  <Novels>\n    <Novel category="1">Novel1</Novel>\n    <Novel category="2">Novel2</Novel>\n    <Novel>Novel3</Novel>\n    <Novel category="4">Novel4</Novel>\n  </Novels>\n  <Encyclopedias>\n    <Encyclopedia>\n      <Volume>A-F</Volume>\n      <Volume category="2">G-L</Volume>\n      <Volume category="3">M-S</Volume>\n      <Volume category="4">T-Z</Volume>\n    </Encyclopedia>\n  </Encyclopedias>\n  <Dictionaries category="1">\n    <Dictionary>Webster</Dictionary>\n    <Dictionary>Oxford</Dictionary>\n  </Dictionaries>\n</Library>';\n\nDECLARE @Category INT;\nSET @Category = 2; -- Example: looking for category 2\n\n-- Function to recursively check nodes\nWITH XmlNodes AS (\n    SELECT 1 AS lvl, T.c.query('*[not(@category) or @category=sql:variable("@Category")]') AS c\n    FROM @Xml.nodes('/*[not(@category) or @category=sql:variable("@Category")]') AS T(c)\n    UNION ALL\n    SELECT lvl+1, T.c.query('*[not(@category) or @category=sql:variable("@Category")]')\n    FROM XmlNodes\n    CROSS APPLY c.nodes('*[not(@category) or @category=sql:variable("@Category")]') AS T(c)\n)\n-- Filter and reconstruct XML structure\nSELECT c.query('for $i in * return node(*)')\nFROM XmlNodes\nPIVOT (\n  MAX((SELECT c FOR XML PATH(''), TYPE)) FOR lvl IN (1)\n) pvt\nWHERE lvl = (SELECT COUNT(*) FROM XmlNodes);