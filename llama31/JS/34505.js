$.ajax({\n  type: 'GET',\n  url: 'http://www.eventsinindia.com/cities/mumbai/events.js?month=2009-05',\n  dataType: 'jsonp',\n  success: function(data) {\n    console.log(data);\n  }\n});