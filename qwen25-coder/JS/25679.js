function removeArticle(id) {\n    if (myDelete) {\n        try {\n            var deletUrl = "delete.php";\n            var query = deletUrl + "?theid=" + id;\n            myDelete.open("GET", query, true); // No need to put this in an if statement\n            myDelete.onreadystatechange = removeArticleResponse; // Set this before sending the request\n            myDelete.send(null);\n        } catch (e) {\n            alert("Unable to connect to the server:\n" + e.toString());\n        }\n    } else {\n        alert("Bad! Very BAD!");\n    }\n}