try {\n    XslCompiledTransform xslt = new XslCompiledTransform();\n    xslt.Load("yourStyleSheet.xslt");\n    // Apply the transformation\n} catch (StackOverflowException ex) {\n    // Handle exception or report error\n}