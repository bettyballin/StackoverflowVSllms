$(function () {\n    $('#fileUploadForm').fileupload({\n        dataType: 'json',\n        done: function (e, data) {\n            $.each(data.result.files, function (index, file) {\n                $('<p/>').text(file.name).appendTo('#uploadedFiles');\n            });\n        }\n    });\n});