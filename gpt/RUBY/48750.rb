<%= form_for @upload, html: { multipart: true } do |f| %>\n      <%= f.file_field :file %>\n      <%= f.submit "Upload" %>\n    <% end %>