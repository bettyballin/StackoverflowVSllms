module Authentication\n  mattr_accessor :current_user\n\n  def login\n    self.current_user = session[:user_id] || nil\n  end\nend