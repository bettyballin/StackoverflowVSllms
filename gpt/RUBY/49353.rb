# app/controllers/users_controller.rb\nclass UsersController < ApplicationController\n  def index\n    @users = User.all\n  end\nend