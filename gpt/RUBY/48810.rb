<%= form_with(url: some_path, remote: true) do |form| %>\n     <%= form.text_field :name %>\n     <%= form.submit %>\n   <% end %>