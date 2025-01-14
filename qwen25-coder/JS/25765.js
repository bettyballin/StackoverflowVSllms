function get_stumbleupon() {\n    $.get("http://rss.stumbleupon.com/user/fredkelly/", function(data) {\n        // Find the first <item> element in the RSS feed\n        var latestItem = $(data).find('channel item').first();\n        \n        // Extract the title and link from the first <item>\n        var title = latestItem.find('title').text();\n        var link = latestItem.find('link').text();\n        \n        // Display the title (you can also do something with the link if needed)\n        alert(title);\n    }, "xml");\n}