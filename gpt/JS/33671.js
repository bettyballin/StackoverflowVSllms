$(document).ready(function() {\n  $('#valueForm').on('submit', function(event) {\n    event.preventDefault(); // Prevent the default form submission\n\n    $.ajax({\n      type: 'POST',\n      url: '/add_value',\n      data: {'test': 'test'},\n      dataType: 'text',\n      success: function(data) {\n        $('#add_value_form').empty().append(data); \n      },\n      error: function(jqXHR, textStatus, errorThrown) {\n        console.error('Error: ' + textStatus, errorThrown);\n      }\n    });\n  });\n});