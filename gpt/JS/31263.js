myNamespace.onSuccess = function(request) {\n    // request contains the raw html string returned from the server\n\n    // Parse the HTML string into a jQuery object\n    var parsedHTML = $(request);\n\n    // Find and iterate through each Workorder\n    parsedHTML.find('div.Workorders div.Workorder').each(function() {\n        // Do something with the Workorder DIV in 'this'\n        var workorderId = $(this).attr('id');\n        var partNumber = $(this).find('span.Pn').text();\n        var description = $(this).find('span.Description').text();\n        var shortages = $(this).find('span.Shortages').text();\n        var company = $(this).find('span.Company').text();\n\n        console.log('Workorder ID:', workorderId);\n        console.log('Part Number:', partNumber);\n        console.log('Description:', description);\n        console.log('Shortages:', shortages);\n        console.log('Company:', company);\n\n        // Additional processing can be done here\n    });\n}