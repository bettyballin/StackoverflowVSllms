using System.Drawing;\nusing System.Windows.Forms;\n\npublic class StringMeasurement\n{\n    public static Size MeasureString(string text, Font font, int maxWidth)\n    {\n        // Use TextRenderer to measure the size of the string\n        Size proposedSize = new Size(maxWidth, int.MaxValue);\n        Size textSize = TextRenderer.MeasureText(text, font, proposedSize, TextFormatFlags.WordBreak);\n\n        return textSize;\n    }\n}