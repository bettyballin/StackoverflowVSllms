module ResourcesHelper\n     def resource_table(resources)\n       content_tag :table do\n         concat(content_tag(:tr) do\n           concat(content_tag(:th, 'Name'))\n           concat(content_tag(:th, 'Description'))\n         end)\n         resources.each do |resource|\n           concat(content_tag(:tr) do\n             concat(content_tag(:td, resource.name))\n             concat(content_tag(:td, resource.description))\n           end)\n         end\n       end\n     end\n   end