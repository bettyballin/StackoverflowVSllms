<%= form_with(model: @email) do |form| %>\n     <%= form.label :subject %>\n     <%= form.text_field :subject %>\n     \n     <%= form.label :body %>\n     <%= form.text_area :body %>\n     \n     <%= form.submit %>\n   <% end %>