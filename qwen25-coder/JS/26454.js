$(document).ready(function() {\n       $.ajax({\n           url: '@Url.Action("GetPartialViewHtml", "YourController")',\n           type: 'POST',\n           success: function(result) {\n               $('#yourDivId').html(result);\n           },\n           error: function(xhr, status, error) {\n               console.error(error);\n           }\n       });\n   });