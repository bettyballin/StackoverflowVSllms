setInterval(function() {\n    $.ajax({\n        url: "update.php", // URL of your PHP script\n        type: "POST",\n        success: function(response) {\n            console.log("Entry updated");\n        },\n        error: function(error) {\n            console.error("Error updating entry:", error);\n        }\n    });\n}, 10000); // 10 seconds interval