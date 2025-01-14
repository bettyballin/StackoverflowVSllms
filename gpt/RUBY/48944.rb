# app/helpers/application_helper.rb\n   module ApplicationHelper\n     def link_to_add_fields(name, f, association)\n       new_object = f.object.send(association).klass.new\n       id = new_object.object_id\n       fields = f.fields_for(association, new_object, child_index: id) do |builder|\n         render(association.to_s.singularize + "_fields", f: builder)\n       end\n       link_to(name, '#', class: "add_fields", data: {id: id, fields: fields.gsub("\n", "")})\n     end\n\n     def link_to_remove_fields(name, f)\n       f.hidden_field(:_destroy) + link_to(name, '#', class: "remove_fields")\n     end\n   end