$(function() {\n    $.get('checkfordocument.aspx',null,function(data) {\n        if (!data.Success) {\n           UpdateControls(data.Message);\n        }\n        else {\n           UpdateControls('');\n           $("<a href='"\n                + data.Url\n                + "' target='_blank' class='docLink'>"\n                + "Click here if your document does not start downloading</a>")\n             .appendTo('#txtInfo')\n             .trigger('click');\n    }\n    ,'json');\n});