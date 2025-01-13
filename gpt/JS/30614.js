function saveSelection() {\n    var sel;\n    if (window.getSelection) {\n        sel = window.getSelection();\n        if (sel.rangeCount > 0) {\n            return sel.getRangeAt(0);\n        }\n    } else if (document.selection && document.selection.createRange) {\n        return document.selection.createRange();\n    }\n    return null;\n}\n\nfunction restoreSelection(range) {\n    if (range) {\n        if (window.getSelection) {\n            var sel = window.getSelection();\n            sel.removeAllRanges();\n            sel.addRange(range);\n        } else if (document.selection && range.select) {\n            range.select();\n        }\n    }\n}\n\nfunction getSelectedText() {\n    var t;\n    if (window.getSelection) {\n        t = window.getSelection().toString();\n    } else if (document.selection && document.selection.type != "Control") {\n        t = document.selection.createRange().text;\n    }\n    if (!t || t == '') {\n        var a = document.getElementsByTagName('textarea');\n        for (var i = 0; i < a.length; ++i) {\n            if (a[i].selectionStart != undefined && a[i].selectionStart != a[i].selectionEnd) {\n                t = a[i].value.substring(a[i].selectionStart, a[i].selectionEnd);\n                break;\n            }\n        }\n    }\n    return t;\n}\n\n$("#dialog").dialog({\n    autoOpen: false,\n    bgiframe: false,\n    height: 60,\n    width: 80,\n    modal: false,\n    show: 'highlight',\n    title: 'wc',\n    open: function() {\n        restoreSelection(savedRange);\n    }\n});\n\nvar savedRange = saveSelection(); // Save the selection\nalert(getSelectedText()); // Text is here      \n$("#dialog").dialog("open"); // Open the dialog\nalert(getSelectedText()); // Text should still be selected here