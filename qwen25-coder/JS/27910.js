document.getElementById('comment').addEventListener('input', function() {\n    var converter = new showdown.Converter();\n    var text      = converter.makeHtml(this.value);\n    \n    // Custom sanitization: replace <br> with <br /> for XHTML compliance\n    text = text.replace(/<br>/g, '<br />');\n    \n    document.getElementById('preview').innerHTML = text;\n});