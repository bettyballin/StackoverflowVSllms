jQuery.fn.line = function(line) {\n\n    var dummy = this.clone().css({\n            top: -9999,\n            left: -9999,\n            position: 'absolute',\n            width: this.width()\n        }).appendTo(this.parent()),\n        text = dummy.text().match(/\S+\s+/g);\n\n    var words = text.length,\n        lastTopOffset = 0,\n        lineNumber = 0,\n        ret = '',\n        found = false;\n\n    for (var i = 0; i < words; ++i) {\n\n        dummy.html(\n            text.slice(0,i).join('') +\n            text[i].replace(/(\S)/, '$1<span/>') +\n            text.slice(i+1).join('')\n        );\n\n        var topOffset = jQuery('span', dummy).offset().top;\n\n        if (topOffset !== lastTopOffset) {\n            lineNumber += 1;\n        }\n\n        lastTopOffset = topOffset;\n\n        if (lineNumber === line) {\n\n            found = true;\n            ret += text[i];\n\n        } else {\n\n            if (found) {\n                break;\n            }\n\n        }\n\n    }\n\n    dummy.remove();\n    return ret;\n\n};