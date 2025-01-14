var request = new XMLHttpRequest();\nrequest.open("GET", url, false);\nrequest.send();\nif (request.status == 200) {\n    doc = request.responseXML;\n    tracks = doc.evaluate("/lfm/recenttracks/track", doc, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);\n\n    for (var i = 0; i < tracks.snapshotLength; i++) {\n        var track = tracks.snapshotItem(i);\n        \n        // Extracting individual elements using XPath\n        var artist = doc.evaluate("artist/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var name = doc.evaluate("name/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var streamable = doc.evaluate("streamable/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var mbid = doc.evaluate("mbid/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var album = doc.evaluate("album/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var url = doc.evaluate("url/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n\n        // Extracting image URLs of different sizes\n        var smallImage = doc.evaluate("image[@size='small']/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var mediumImage = doc.evaluate("image[@size='medium']/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n        var largeImage = doc.evaluate("image[@size='large']/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n\n        var date = doc.evaluate("date/text()", track, null, XPathResult.STRING_TYPE, null).stringValue;\n\n        // Print or process the data\n        print("Track " + (i + 1) + ":");\n        print("Artist: " + artist);\n        print("Name: " + name);\n        print("Streamable: " + streamable);\n        print("MBID: " + mbid);\n        print("Album: " + album);\n        print("URL: " + url);\n        print("Small Image: " + smallImage);\n        print("Medium Image: " + mediumImage);\n        print("Large Image: " + largeImage);\n        print("Date: " + date);\n    }\n}