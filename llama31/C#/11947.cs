XslCompiledTransform transform = new XslCompiledTransform();\nXsltSettings settings = new XsltSettings();\nsettings.MaxStackSize = 1024000;\ntransform.Load("your_xslt_file.xslt", settings, new XmlUrlResolver());