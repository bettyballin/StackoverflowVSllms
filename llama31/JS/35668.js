this.req.onreadystatechange = () => {\n    if (this.req.readyState == 4) {\n        // todo: using eval for json is dangerous\n        var response = eval("(" + this.req.responseText + ")");\n        alert(response);\n    }\n}