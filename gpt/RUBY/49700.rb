require File.dirname(__FILE__) + '/../spec_helper'\ninclude ApplicationHelper\ninclude UsersHelper\ninclude AuthenticatedTestHelper\n\ndescribe "bidding on an item" do\n  controller_name :items\n\n  before(:each) do\n    @user = FactoryBot.create(:user)\n    @auction = FactoryBot.create(:auction)\n    allow(controller).to receive(:current_user).and_return(@user)\n  end\n\n  it "should work" do\n    post :bid, params: { bid: { auction_id: @auction.id, user_id: @user.id, point: 1 } }\n    expect(assigns(:bid)).to be_persisted\n  end\nend