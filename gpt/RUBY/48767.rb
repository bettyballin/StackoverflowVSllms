<% @images.each do |image| %>\n  <div class="image-container">\n    <%= image_tag image.url, id: "image-#{image.id}", class: 'image-click', data: { id: image.id } %>\n    <p id="status-<%= image.id %>"></p>\n  </div>\n<% end %>