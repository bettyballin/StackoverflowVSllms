// In app/views/businesses/create.js.erb\n\n   $('#unapproved table').append("<%= j(render @business) %>");\n   $("#new_business").submitWithAjax();\n   $("#new_business")[0].reset();\n   $("#new_business").hide();