function updateByQuery(layer, query) {\n   var url = "get_records.php?cmd=GetRecordSet&query=" + encodeURIComponent(query) + "&sid=" + Math.random();\n   console.log("Requesting URL: ", url); // Debugging line\n   update(layer, url);\n}