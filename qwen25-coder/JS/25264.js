jQuery.get(contenturl, function(data) {\n    // Parse the entire data as HTML using jQuery\n    var $html = $(data);\n    \n    // Find the style tag within the parsed HTML\n    var css = $html.find('style').text();\n    \n    // Check if CSS was found and then append it to the head of your document\n    if (css) {\n        $('head').append('<style>' + css + '</style>');\n    } else {\n        console.log("No style tag found in the remote page.");\n    }\n});