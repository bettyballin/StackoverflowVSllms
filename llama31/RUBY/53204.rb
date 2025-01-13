class ApplicationController < ActionController::Base\n  private\n\n  def oauth_callback(token, secret)\n    # Try to find an existing user\n    user = User.find_by_oauth_token(token)\n\n    # If no user is found, create a new one\n    if user.nil?\n      user = User.new\n      user.oauth_token = token\n      user.oauth_secret = secret\n      user.save!\n    end\n\n    # Log the user in\n    UserSession.create(user)\n  end\nend