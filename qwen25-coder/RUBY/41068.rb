ActionController::Routing::Routes.draw do |map|\n  map.resources :questions, \n                :has_one => :section, \n                :collection => { :sort => :post },\n                :member => { :destroy => :delete } # Ensure destroy is a member route\n\n  map.resources :sections, \n                :has_many => :questions, \n                :has_one => :form, \n                :collection => { :sort => :post },\n                :member => { :destroy => :delete } # Ensure destroy is a member route\n\n  map.resources :forms, \n                :has_many => :sections\n\n  # Default root route\n  map.root :controller => "forms"\n\n  # Legacy routes (if needed)\n  map.connect ':controller/:action/:id'\n  map.connect ':controller/:action/:id.:format'\nend