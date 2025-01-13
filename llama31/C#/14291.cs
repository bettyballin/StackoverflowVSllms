using System.Text.RegularExpressions;\n\nstring content = "the brown fox jumped over <b>the</b> lazy dog over there";\nstring keyword = "the";\n\nstring pattern = $@"\b{Regex.Escape(keyword)}\b(?!.*<)";\nstring replacement = $"<span style=\"background-color:yellow;\">{keyword}</span>";\n\ncontent = Regex.Replace(content, pattern, replacement, RegexOptions.IgnoreCase);