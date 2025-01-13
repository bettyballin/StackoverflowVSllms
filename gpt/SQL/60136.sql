DECLARE @Xml XML\nSET @Xml = N'\n<Library>\n  <Novels>\n    <Novel category="1">Novel1</Novel>\n    <Novel category="2">Novel2</Novel>\n    <Novel>Novel3</Novel>\n    <Novel category="4">Novel4</Novel>\n  </Novels>\n  <Encyclopedias>\n    <Encyclopedia>\n      <Volume>A-F</Volume>\n      <Volume category="2">G-L</Volume>\n      <Volume category="3">M-S</Volume>\n      <Volume category="4">T-Z</Volume>\n    </Encyclopedia>\n  </Encyclopedias>\n  <Dictionaries category="1">\n    <Dictionary>Webster</Dictionary>\n    <Dictionary>Oxford</Dictionary>\n  </Dictionaries>\n</Library>'\n\nDECLARE @Category INT\nSET @Category = 1\n\n;WITH XMLNAMESPACES(DEFAULT 'http://www.w3.org/1999/xhtml')\nSELECT @Xml.query('\n  for $node in (//node()[not(ancestor-or-self::*[@category != sql:variable("@Category")])])\n  return $node\n') AS Result