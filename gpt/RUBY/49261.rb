# config/routes.rb\nRails.application.routes.draw do\n  # Other routes...\n\n  # Routes for password resets\n  resources :password_resets, only: [:new, :create, :edit, :update]\nend