require 'mocha'\n\nclass TransporterTest < ActiveSupport::TestCase\n  def setup\n    # Stubbing set_initial_state to prevent it from overriding the state we set in factory\n    Transporter.any_instance.stubs(:set_initial_state)\n    @transporter = FactoryBot.create(:transporter, status: 'active')\n  end\n\n  test "should create transporter with active state" do\n    assert_equal 'active', @transporter.status\n  end\nend