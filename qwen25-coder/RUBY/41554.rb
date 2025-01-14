class UsersController < ApplicationController\n  def check_login\n    if User.valid_attribute?(:login, params[:login])\n      render json: { valid: true }\n    else\n      render json: { valid: false, errors: User.new(login: params[:login]).errors.full_messages_for(:login) }\n    end\n  end\nend