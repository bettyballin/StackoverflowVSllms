using System.Windows.Media;\n\n// ...\n\nstring text = "Case 1, blah blah";\ndouble availableWidth = 100; // replace with your available width\n\nvar typeface = new Typeface("Arial"); // replace with your font\nvar ft = new FormattedText(text, CultureInfo.CurrentCulture, FlowDirection.LeftToRight, typeface, 12, Brushes.Black);\n\nvar width = ft.Width;\nif (width > availableWidth)\n{\n    // shorten the text until it fits\n    while (width > availableWidth && text.Length > 0)\n    {\n        text = text.Substring(0, text.Length - 1);\n        ft = new FormattedText(text + "..", CultureInfo.CurrentCulture, FlowDirection.LeftToRight, typeface, 12, Brushes.Black);\n        width = ft.Width;\n    }\n}\n\n// use the shortened text