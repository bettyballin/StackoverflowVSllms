function removeArticleResponse () {\n    if (myDelete.readyState == 4) {\n        if (myDelete.status == 200) {\n            try {\n                response = myDelete.responseText;\n                document.getElementById('displaynewsletterarticleresult').innerHTML = response;\n            } catch(e) {\n                alert("An error occured while reading the response:" + e.toString());\n            }\n        } else {\n            alert ("An error occured when attempting to retrieve the data:\n" + myDelete.statusText);\n        }\n    }\n}