// Get the value from the dropdown box\nvar fieldSize = $('#fieldSize').val(); // Correct method for getting selected value\n\n// Determine the size based on the option selected\nvar size;\nif (fieldSize === "small") {\n    size = 100;\n} else if (fieldSize === "medium") {\n    size = 200;\n} else if (fieldSize === "large") {\n    size = 400;\n}\n\n// Dynamically create and append the input element with the chosen width\nif (fieldType === "text") {\n    $('<input />', {\n        id: 'inputstr' + increment,\n        type: 'text',\n        css: { \n            'width': size + 'px'\n        }\n    }).appendTo("#fb_contentarea_col1down21").after('<br><br>');\n}