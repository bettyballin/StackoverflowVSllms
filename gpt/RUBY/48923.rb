<div class="todo">\n    <li>\n        <%= check_box_tag "todo_ids[]", todo.id, false, id: "todo_ids_#{todo.id}" %>\n        <%=h todo.name %>\n        <%= link_to 'edit', edit_todo_path(todo) %>\n        <%= link_to 'delete', todo, confirm: 'Are you sure?', method: :delete %>\n    </li>\n</div>