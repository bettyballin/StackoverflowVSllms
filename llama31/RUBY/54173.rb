# button code\n<%= button_tag 'Click me', :onclick => "ajax_request()" %>\n\n# JavaScript code\nfunction ajax_request() {\n  new Ajax.Request('/controller/action', {\n    method: 'get',\n    onSuccess: function(response) {\n      eval(response.responseText);\n    }\n  });\n}