var data;\n\nfunction fetchData(callback) {\n    $.getJSON("panorama.json", function(json) {\n        data = json.images[0].src;\n        callback(data);\n    });\n}\n\n$(document).ready(function() {\n    fetchData(function imageDataReady(imageData) {\n        console.log(imageData); // This line will log the correct data\n        // You can now use `imageData` throughout your application\n    });\n\n    //console.log(data); // Avoid using `data` here as it may not be set yet\n});