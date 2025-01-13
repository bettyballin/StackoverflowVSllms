<%= form_remote_tag(:update => "recipe-status",\n                    :before => "Element.show('wait-indicator')",\n                    :success => "handleResponse(request)",\n                    :complete => visual_effect(:appear, "recipe-status"),\n                    :url => { :action => 'import', :id => @recipe.id },\n                    :failure => "alert('Unable to import recipes at present')") %>