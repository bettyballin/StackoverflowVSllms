def logout\n  # Clear all cookies\n  cookies.delete :fbsetting_0b78c8f2c95ce671470bdcb1c19e5070\n  # Clear the session\n  reset_session\n\n  # Optionally, redirect to Facebook's logout URL if needed\n  # Redirecting to FB logout might not be necessary for your app but it ensures user is logged out of FB as well.\n  # fb_logout_url = "https://www.facebook.com/logout.php?access_token=#{session[:oauth]['token']}&next=#{logout_redirect_path}"\n  # redirect_to fb_logout_url\n\n  # Redirect to your home or login page\n  redirect_to root_path, notice: 'Logged out successfully'\nend