$("#new_business").submitWithAjax();\n$("#new_business")[0].reset();\n$("#new_business").hide();\n\n// Render the updated table content\nvar tableContent = "<%= escape_javascript(render(:partial => 'business_table')) %>";\n\n// Replace the existing table content with the new content\n$("#unapproved table").replaceWith(tableContent);