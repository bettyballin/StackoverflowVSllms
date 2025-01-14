# In application_controller.rb\n\nclass ApplicationController < ActionController::Base\n  helper_method :current_user\n    \n  private\n  \n  def current_user\n    @current_user ||= User.find_by(id: session[:user_id]) if session[:user_id]\n  end\nend