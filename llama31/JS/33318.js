div.load("../Lib/handlers/GetPrice.aspx?answers="+queryValues+"&item="+modelId,{ symbol: $("#txtSymbol" ).val() },function(data)\n{\n    var jsonData = JSON.parse(data);\n    $(this).html(jsonData.html);\n    var additionalNumber = jsonData.additionalNumber;\n    // Do something with the additional number\n    $(this).fadeIn('slow');\n});