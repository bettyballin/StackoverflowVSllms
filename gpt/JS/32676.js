$(document).ready(function() {\n       $('#your-element').editable(function(value, settings) {\n           // Callback function after submission\n           return value;\n       }, {\n           type: 'textarea',\n           onblur: 'submit',\n           onedit: function() {\n               // Recalculate scrollbar here\n               // Example: $('#scrollable-element').jScrollPane().reinitialise();\n           },\n           callback: function(value, settings) {\n               autosize.update($('#your-element'));\n           }\n       });\n   });