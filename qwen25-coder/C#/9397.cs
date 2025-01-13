using WebSupergoo.ABCpdf10;\n\npublic void CreatePDF()\n{\n    Doc doc = new Doc();\n    \n    // Settings for chaining text with indentation\n    int font = doc.AddFont("Helvetica");\n    double indentSize = 25;\n    \n    // Set the paragraph start settings before adding chains\n    doc.Text.SetParaDefaults();\n    doc.Text.ParaIndentFirst = indentSize; // Set first line indent\n    \n    // Add your content areas and chain text here...\n    // ...\n\n    // Function to handle chaining and resetting indent after a new column starts\n    void ChainText(string text)\n    {\n        int textId = doc.AddText(text);\n        \n        while (doc.Chainable(textId))\n        {\n            doc.Page += 1;\n            \n            // Reset paragraph indent for the start of the new page/column\n            doc.Text.ParaIndentFirst = 0; // No indent on first line after chaining\n            \n            doc.FrameRect(doc.Width / 2, doc.Height - 50, doc.Right, 50); \n            textId = doc.ChainText(textId);\n            \n            // Optionally reset the normal paragraph indentation if necessary\n            doc.Text.ParaIndentFirst = indentSize; // Restore for subsequent paragraphs\n        }\n    }\n\n    string content = "Your long text that spans multiple columns and needs proper indentation handling.";\n    \n    ChainText(content);\n\n    // Save the document\n    doc.Save(Server.MapPath("output.pdf"));\n    doc.Clear();\n}