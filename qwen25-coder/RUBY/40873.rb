# spec/factories/parents.rb\nFactoryBot.define do\n  factory :parent do\n    # define attributes here\n\n    children { create_list(:child, rand(1..5)) } # Random number of children between 1 and 5\n  end\nend\n\n# spec/factories/children.rb\nFactoryBot.define do\n  factory :child do\n    # define attributes here\n  end\nend