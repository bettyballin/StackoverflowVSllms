$(document).ready(function () {\n    setTimeout(function() {\n        $.ajax({\n            type: "POST",\n            url: "YourPage.aspx/GetDelayedData",\n            data: "{}",\n            contentType: "application/json; charset=utf-8",\n            dataType: "json",\n            success: function(response) {\n                $('#delayContent').html(response.d);\n            },\n            failure: function(response) {\n                alert('Error loading data.');\n            }\n        });\n    }, 1000); // Delay for 1 second\n});