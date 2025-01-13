function submitForm() {\n     var form = document.getElementById('people_form');\n     var formData = new FormData(form);\n     var peopleIds = [];\n\n     for (var pair of formData.entries()) {\n       if (pair[0].startsWith('checkbox_name') && pair[1] !== "") {\n         peopleIds.push(pair[1]);\n       }\n     }\n\n     var disableUrl = '/people/disable/' + peopleIds.join(',');\n\n     // Now make the XHR request\n     var xhr = new XMLHttpRequest();\n     xhr.open('POST', disableUrl, true);\n     xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');\n\n     xhr.onreadystatechange = function() {\n       if (xhr.readyState === 4 && xhr.status === 200) {\n         // Handle success\n         console.log('People disabled successfully');\n       }\n     };\n\n     xhr.send();\n   }