<%= drop_receiving_element "move_drop_zone_" + node.id.to_s,\n  :update => "users",\n  :url => move_user_path(:id => node.id),\n  :method => :put,\n  :accept => "move_user",\n  :with => "'user_id=' + encodeURIComponent(element.id.split('_')[2]) + '&from_node_id=' + encodeURIComponent(element.id.split('_')[3])"\n%>