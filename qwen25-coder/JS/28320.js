$(".fedex_status").each(function () {\n    var item = this;\n    // some code to construct tracking_url\n\n    console.log("Starting request for " + tracking_url);\n    $.ajax({\n        type: "GET",\n        url: tracking_url,\n        async: true,\n        cache: false,\n        success: function (data) { \n            console.log("Finished request for " + tracking_url);\n            $(item).html("(" + data + ")"); \n        },\n        error: function () { \n            console.log("Failed request for " + tracking_url);\n            $(item).html("request failed..."); \n        }\n    });\n});