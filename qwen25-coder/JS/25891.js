function display(id, callback) {\n    $.ajax({\n        type: 'POST',\n        url: 'ajax.php',\n        data: 'id=' + id,\n        success: function(data) {\n            $("#response").html(data);\n            if (typeof callback === 'function') {\n                callback(data); // Pass the received data to the callback\n            }\n        } //success\n    }); //Ajax\n}