success: function(request) {\n    try {\n        var jsonData = JSON.parse(request);\n        alert(jsonData.length);\n    } catch (e) {\n        alert('Invalid JSON');\n    }\n}