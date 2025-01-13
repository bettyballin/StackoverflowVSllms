<%= submit_to_remote(\n  "save_widget",\n  "Save Widget & Generate Embed Code",\n  {\n    :url => widgets_url(:user_id => @user.id),\n    :update => "widget_form",\n    :method => :POST,\n    :html => {  :id => "save_widget_button", \n                :onclick => "this.value='Saving...'; this.disabled = 'true';",\n                :style => "width: 220px;"\n             },\n    :complete =>"\n      $('save_widget_button').disabled='';\n      $('save_widget_button').value='Save Widget & Generate Embed Code';\n      var last_id = $j('select#widget_id').children(':last').attr('value');\n      alert( widget_objects[last_id] );\n      ",\n    :success => "reportMessage('success', request.headerJSON.success, 'save_widget_status'); $('band_form').reset();",\n    :failure => "reportMessage('failure', request.headerJSON.errors, 'save_widget_status');",\n    :evalScripts => true\n  }\n) %>