def simulate_login_as(user)\n  @request.session[:user_id] = user ? user.id : nil\nend