<%= form_for @story, url: custom_create_path, method: :post do |f| %>\n  <%= f.text_field :title %>\n  <%= f.text_area :content %>\n  <%= f.submit "Submit" %>\n<% end %>