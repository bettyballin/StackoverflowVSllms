$.ajax({\n  url: 'http://searchprovider.com/search?q=' + encodeURIComponent(searchQuery),\n  crossDomain: true,\n  success: function(data) {\n    // handle the response data\n  }\n});