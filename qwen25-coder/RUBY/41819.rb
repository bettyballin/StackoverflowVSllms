# config/routes.rb\nresources :users\n\n# app/controllers/users_controller.rb\nclass UsersController < ApplicationController\n  def index\n    render json: User.all\n  end\n\n  def show\n    render json: User.find(params[:id])\n  end\nend