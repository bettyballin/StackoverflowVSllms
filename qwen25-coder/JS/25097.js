$(document).ready(function() {\n    $('#myForm').ajaxForm({\n        beforeSubmit: function() {\n            // perform any pre-submit actions here\n        },\n        success: function(response) {\n            // handle successful form submission\n        },\n        error: function(jqXHR, textStatus, errorThrown) {\n            // handle errors in the request\n            console.error('Error:', textStatus, ', Details:', errorThrown);\n        }\n    });\n});