$(document).ready(function() {\n        $('#content').html('');\n        $.ajax({\n            url: 'http://localhost:3000/proxy',\n            dataType: "json",\n            success: function(data) {\n                $('#content').append('<p>'+data.rank+'</p>');\n            }\n        });\n    });