div.fadeOut('slow', function() {        \n    div.load(\n        "GetResults.aspx?mode=bymanu&mid="+manuId,\n        { symbol: $("#txtSymbol" ).val() },\n        function() {\n            $(this).fadeIn('slow');                               \n        }\n    );\n});