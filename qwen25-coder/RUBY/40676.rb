# Start your rails console with `rails c`\nrequire 'action_controller/test_case'\nclass ControllerBase < ActionController::Base; end\ncontroller = ControllerBase.new\ncontroller.request = ActionDispatch::TestRequest.create('GET', '/test')\ncontroller.response = ActionDispatch::TestResponse.new\n\n# Define a method if needed and call it\nclass << controller\n  def example_method\n    "Hello from controller method!"\n  end\nend\n\nputs controller.example_method