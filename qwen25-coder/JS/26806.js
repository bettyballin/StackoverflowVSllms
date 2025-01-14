document.observe("dom:loaded", function() {\n  $('disable_button').observe('click', function(event) {\n    event.stop(); // Prevent the original form submission\n\n    var checkedPeople = $$('[name="your_checkbox_name"]:checked')\n      .map(function(checkbox) { return checkbox.value; })\n      .join(',');\n\n    new Ajax.Request('/people/disable/' + checkedPeople, {\n      method: 'post',\n      onSuccess: function(response) {\n        // Handle a successful response, if necessary\n      },\n      onFailure: function(response) {\n        // Handle a failed response, if necessary\n      }\n    });\n  });\n});