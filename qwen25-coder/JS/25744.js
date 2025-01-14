// Assuming 'newHtml' contains your HTML including <td> and <img> tags.\n$('#yourContainerElement').append(newHtml);\n\n// Bind the click event to td elements with a specific class or data attribute after appending\n$('td.yourClass, img.yourImageClass').off('click').on('click', function() {\n    // Check if it's the td element\n    if ($(this).is('td')) {\n        var data = $(this).data('value'); // Use a data attribute to pass values securely\n        toggleDay(data, this, 'tue');\n    }\n    // Check if it's the img element\n    else if ($(this).is('img')) {\n        var data = $(this).data('alarm-value'); // Use a different data attribute for images\n        deleteAlarm(data);\n    }\n});