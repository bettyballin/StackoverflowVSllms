<%= button_to_remote "Click Me",\n                     url: { action: 'example' },\n                     method: :post,\n                     with: "'extra_param=' + encodeURIComponent('value') + '&another_param=' + encodeURIComponent('another_value')"\n%>