<!-- app/views/assets/_thumbnail.html.erb -->\n<div class="thumbnail">\n  <%= link_to 'Edit', edit_asset_path(asset), remote: true, data: { target: '#preview' } %>\n  <%= image_tag asset.thumbnail_url %>\n</div>