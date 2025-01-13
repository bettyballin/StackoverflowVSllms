xml = <<XML\n<samlp:LogoutRequest xmlns:samlp="urn:oasis:names:tc:SAML:2.0:protocol"\n                     xmlns:saml="urn:oasis:names:tc:SAML:2.0:assertion"\n                     ID="123456789" Version="2.0" IssueInstant="200904051217">\n  <saml:NameID>@NOT_USED@</saml:NameID>\n  <samlp:SessionIndex>abcdefg</samlp:SessionIndex>\n</samlp:LogoutRequest>\nXML\n\ndoc = Nokogiri::XML(xml)\nXPATH_QUERY = "//samlp:LogoutRequest[@ID][@Version='2.0'][@IssueInstant]/samlp:SessionIndex"\n\nresult = doc.xpath(XPATH_QUERY, 'saml' => 'urn:oasis:names:tc:SAML:2.0:assertion', 'samlp' => 'urn:oasis:names:tc:SAML:2.0:protocol')\n\nputs result.text # prints "abcdefg"