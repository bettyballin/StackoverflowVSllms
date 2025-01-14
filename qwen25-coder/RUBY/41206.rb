# app/controllers/sessions_controller.rb\nclass SessionsController < ApplicationController\n  def create\n    user = User.authenticate(params[:login], params[:password])\n    if user\n      session[:user_id] = user.id\n      redirect_to root_path, notice: 'Logged in successfully'\n    else\n      flash.now.alert = "Invalid email or password"\n      render :new\n    end\n  end\n\n  def destroy\n    session.delete(:user_id)\n    redirect_to login_url, alert: 'Logged out successfully'\n  end\n\n  private\n\n  # Redirect after successful login.\n  def redirect_after_login\n    redirect_to root_path if current_user\n  end\nend