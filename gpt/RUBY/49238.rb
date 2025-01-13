# spec/factories/users.rb\nFactoryBot.define do\n  factory :user do\n    name { "John Doe" }\n    email { "john.doe@example.com" }\n    \n    trait :admin do\n      role { "admin" }\n    end\n    \n    trait :with_posts do\n      after(:create) do |user|\n        create_list(:post, 3, user: user)\n      end\n    end\n  end\nend\n\n# Usage in tests\nRSpec.describe User, type: :model do\n  it "creates a user with default attributes" do\n    user = create(:user)\n    expect(user).to be_valid\n  end\n\n  it "creates an admin user" do\n    admin_user = create(:user, :admin)\n    expect(admin_user.role).to eq("admin")\n  end\n\n  it "creates a user with posts" do\n    user_with_posts = create(:user, :with_posts)\n    expect(user_with_posts.posts.count).to eq(3)\n  end\nend