var oArgs = WScript.Arguments;\n\nif (oArgs.length == 0) {\n   WScript.Echo ("Usage : cscript xslt.js xml xsl");\n   WScript.Quit();\n}\nxmlFile = oArgs(0) + ".xml";\nxslFile = oArgs(1) + ".xsl";\n\n// Load the XML\nvar xml = new ActiveXObject("Microsoft.XMLDOM");\nxml.async = false;\nxml.load(xmlFile);\n\n// Load the XSL\nvar xsl = new ActiveXObject("Microsoft.XMLDOM");\nxsl.async = false;\nxsl.load(xslFile);\n\n// Transform using MSXML and write directly to a file with UTF-8 encoding\nvar adTypeText = 2;\nvar adSaveCreateOverWrite = 2;\n\n// Perform the transformation\nxml.transformNodeToObject(xsl, xml);\n\n// Save as UTF-8 explicitly\nxml.encoding = "UTF-8";\nxml.save("Output.xml");