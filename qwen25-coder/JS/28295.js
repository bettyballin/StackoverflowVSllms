$.ajax({\n    url: 'your_url_here', // URL to fetch data from\n    method: 'GET', // or POST if needed\n    dataType: 'html',\n    success: function(response) {\n        $('#A').html(response); // Assuming response is the HTML content\n\n        // Now you can safely access elements inside #A\n        $('#A').find('.child-element-class').each(function() {\n            console.log($(this).text());\n        });\n    },\n    error: function(xhr, status, error) {\n        console.error('Error fetching data:', error);\n    }\n});