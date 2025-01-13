# Gemfile\n   gem 'pundit'\n\n   # Run bundle install and setup pundit\n   rails generate pundit:install\n\n   # Define policies\n   class UserPolicy < ApplicationPolicy\n     def update?\n       user.admin? || record.id == user.id\n     end\n   end\n\n   # Apply policies in controllers\n   class UsersController < ApplicationController\n     include Pundit\n\n     def update\n       user = User.find(params[:id])\n       authorize user\n       if user.update(user_params)\n         render json: user\n       else\n         render json: user.errors, status: :unprocessable_entity\n       end\n     end\n\n     private\n\n     def user_params\n       params.require(:user).permit(:name, :email)\n     end\n   end