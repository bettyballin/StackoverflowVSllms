function htmlDecode(input) {\n    var doc = new DOMParser().parseFromString(input, "text/html");\n    return doc.documentElement.textContent;\n}\n\nvar text = "&lt;&lt;&lt;&amp;&amp;&amp;";\nconsole.log(htmlDecode(text)); // Outputs: <<<&&&