private void CombineMultiplePDFs( string[] fileNames, string outFile ) {\n    int pageOffset = 0;\n    ArrayList master = new ArrayList();\n    int f = 0;\n\n    Document document = null;\n    PdfCopy writer = null;\n    while ( f < fileNames.Length ) {\n        // we create a reader for a certain document\n        PdfReader reader = new PdfReader( fileNames[ f ] );\n        reader.ConsolidateNamedDestinations();\n        // we retrieve the total number of pages\n        int n = reader.NumberOfPages;\n        ArrayList bookmarks = SimpleBookmark.GetBookmark( reader );\n        if ( bookmarks != null ) {\n            if ( pageOffset != 0 ) {\n                SimpleBookmark.ShiftPageNumbers( bookmarks, pageOffset, null );\n            }\n            master.AddRange( bookmarks );\n        }\n        pageOffset += n;\n\n        if ( f == 0 ) {\n            // step 1: creation of a document-object\n            document = new Document( reader.GetPageSizeWithRotation( 1 ) );\n            // step 2: we create a writer that listens to the document\n            writer = new PdfCopy( document, new FileStream( outFile, FileMode.Create ) );\n            // step 3: we open the document\n            document.Open();\n        }\n        // step 4: we add content\n        for ( int i = 0; i < n; ) {\n            ++i;\n            if ( writer != null ) {\n                PdfImportedPage page = writer.GetImportedPage( reader, i );\n                writer.AddPage( page );\n            }\n        }\n        PRAcroForm form = reader.AcroForm;\n        if ( form != null && writer != null ) {\n            writer.CopyAcroForm( reader );\n        }\n        f++;\n    }\n    if ( master.Count > 0 && writer != null ) {\n        writer.Outlines = master;\n    }\n    // step 5: we close the document\n    if ( document != null ) {\n        document.Close();\n    }\n}