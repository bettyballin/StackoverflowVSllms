var div = $("#divPrice");\ndiv.fadeOut('slow', function () {\n    $.ajax({\n        url: "../Lib/handlers/GetPrice.aspx?answers=" + queryValues + "&item=" + modelId,\n        data: { symbol: $("#txtSymbol").val() },\n        type: 'GET',\n        dataType: 'json', // Expect JSON response\n        success: function (data) {\n            div.html(data.Html); // Update the content with HTML part of the response\n            console.log("Received number:", data.Number); // Log or use the number as needed\n\n            div.fadeIn('slow');\n        },\n        error: function () {\n            alert("An error occurred while fetching the price.");\n        }\n    });\n});\n\n$("#divBtns").fadeIn('slow');