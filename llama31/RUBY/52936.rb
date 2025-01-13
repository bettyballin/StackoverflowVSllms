# test/functional/my_controller_test.rb\nrequire 'test_helper'\nrequire 'support/dynamic_test_generator'\n\nclass MyControllerTest < ActionController::TestCase\n  setup do\n    DynamicTestGenerator.generate_tests(self, {\n      :index => :get,\n      :show => :get,\n      :edit => :get,\n      :update => :put\n    })\n  end\n\n  # ... other tests ...\nend