# config/application.rb\nconfig.middleware.use "MyMiddleware"\n\nclass MyMiddleware\n  def initialize(app)\n    @app = app\n  end\n\n  def call(env)\n    # Request manipulations here\n    status, headers, response = @app.call(env)\n    # Response manipulations here\n    [status, headers, response]\n  end\nend