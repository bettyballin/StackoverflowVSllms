$.ajax({\n    url: "http://localhost:8803/StatisticService/GetOpenFlashChartStatistic_Json",\n    method: "GET",\n    data: { param1: 123, param2: 456 },\n    success: function(response) {\n        // Process the response from your server\n        console.log(response);\n    },\n    error: function(xhr, status, error) {\n        console.error("AJAX Error: " + status + error);\n    }\n});