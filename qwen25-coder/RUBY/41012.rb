<%= f.collection_select(:category_id, @categories, :id, :name, { prompt: 'Please select a category' }) %>\n <%= concat '<option value="new">..or create a new one</option>'.html_safe %>