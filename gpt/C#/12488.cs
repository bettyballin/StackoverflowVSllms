if (comObject != null)\n   {\n       while (Marshal.ReleaseComObject(comObject) > 0) ;\n       comObject = null;\n   }