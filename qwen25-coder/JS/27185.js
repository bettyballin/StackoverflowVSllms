$(function() {\n    var codeTextBox = $("#<%= codeTextBox.ClientID %>");\n\n    // Create the custom handle\n    var southHandle = $("<div class='resizable-s' style='width: 100%; height: 22px; background: red;'></div>");\n\n    // Append the custom handle to the textarea\n    codeTextBox.after(southHandle);\n\n    // Make the textarea resizable with a custom handle\n    codeTextBox.resizable({\n        handles: {\n            's': southHandle[0] // Use the DOM element, not jQuery object\n        },\n        minHeight: 80,\n        maxHeight: 400\n    });\n\n    // Position the custom handle correctly\n    southHandle.appendTo(codeTextBox.parent());\n\n    // Adjust the position of the custom handle if necessary\n    codeTextBox.on("resize", function() {\n        southHandle.width(codeTextBox.outerWidth());\n        southHandle.css('top', codeTextBox.outerHeight());\n    });\n});