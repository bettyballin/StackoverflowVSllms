function SelectedText(input) {\n  // Replace the currently selected text with the given value.\n  this.replace = function(text) {\n    var selection = this.get();\n\n    var pre = input.value.substring(0, selection.start);\n    var post = input.value.substring(selection.end, input.value.length);\n\n    input.value = pre + text + post;\n\n    this.set(selection.start, selection.start + text.length);\n\n    return this;\n  }\n\n  // Set the current selection to the given start and end points.\n  this.set = function(start, end) {\n    if (input.setSelectionRange) {\n      // Mozilla\n      input.focus();\n      input.setSelectionRange(start, end);\n    } else if (input.createTextRange) {\n      // IE\n      var range = input.createTextRange();\n      range.collapse(true);\n      range.moveEnd('character', end);\n      range.moveStart('character', start);\n      range.select();\n    }\n\n    return this;\n  }\n\n  // Get the currently selected region.\n  this.get = function() {\n    var result = new Object();\n\n    result.start = 0;\n    result.end = 0;\n    result.text = '';\n\n    if (input.selectionStart != undefined) {\n      // Mozilla\n      result.start = input.selectionStart;\n      result.end = input.selectionEnd;\n    } else {\n      // IE\n      var bookmark = document.selection.createRange().getBookmark()\n      var selection = inputBox.createTextRange()\n      selection.moveToBookmark(bookmark)\n\n      var before = inputBox.createTextRange()\n      before.collapse(true)\n      before.setEndPoint("EndToStart", selection)\n\n      result.start = before.text.length;\n      result.end = before.text.length + selection.text.length;\n    }\n\n    result.text = input.value.substring(result.start, result.end);\n\n    return result;\n  }\n}