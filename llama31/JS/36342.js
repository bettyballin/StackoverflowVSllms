$.ajax({\n  url: "external-page.html",\n  type: "GET",\n  success: function(data) {\n    var cont = data;\n    // now you can pass it to the bt() function\n    $('.class').bt(cont, {\n      fill: '#2a4d6b',\n      cssStyles: {color: 'orange', fontWeight: 'bold', width: 'auto'}\n    });\n  }\n});