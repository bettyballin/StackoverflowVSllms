const wrap = require('word-wrap');\n\nconst text = "This is a long piece of text that we want to wrap within a certain column width.";\nconst wrappedText = wrap(text, { width: 20 });\nconsole.log(wrappedText);