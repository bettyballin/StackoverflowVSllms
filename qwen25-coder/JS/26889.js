$('#searchButton').click(function() {\n    var url = '/portal/?f=searchBilling&pid=' + $('#query').val();\n    $('#inquiry').load(url + '&_=' + new Date().getTime());\n});