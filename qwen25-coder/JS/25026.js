// Assuming you have dynamic text to insert\nvar dynamicText = "Click me!";\n\n// Append a new div with dynamic content and attach a click event\n$('#myID').append('<div>' + dynamicText + '</div>').on('click', 'div:last-child', function() {\n    alert('Div clicked!');\n});