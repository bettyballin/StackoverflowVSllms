# config/routes.rb\nresources :sites do\n  resources :buildings, only: [:new, :create, :edit, :update, :destroy] do\n    resources :meters, only: [:new, :create, :edit, :update, :destroy] do\n      resources :values, only: [:new, :create, :edit, :update, :destroy]\n    end\n  end\nend