string specialChars = "Ω π ℵ ∞ ♣ ♥ ♈ ♉ ♊ ♋ ♌ ♍ ♎ ♏ ♐ ♑ ♒ ♓";\nstring encodedString = CustomHtmlEncoder.EncodeToNumberedEntities(specialChars);\nConsole.WriteLine(encodedString); // Outputs: &#937; &#960; &#8501; &#8734; &clubs; &hearts; &#9800; &#9801; &#9802; &#9803; &#9804; &#9805; &#9806; &#9807; &#9808; &#9809; &#9810; &#9811;