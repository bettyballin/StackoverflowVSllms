$("#add_video").dialog({\n  autoOpen: false,\n  buttons: {\n    "Ok": function() {\n      $(this).dialog("close");\n      $("#myForm").attr('action', '/path/to/upload/directory'); // set form action\n      $("#myForm").submit(); // submit the form\n    }\n  }\n});