# spec/models/user_spec.rb\nrequire 'rails_helper'\n\nRSpec.describe User, type: :model do\n  it 'validates presence of username' do\n    user = User.new(username: nil)\n    expect(user).not_to be_valid\n  end\nend