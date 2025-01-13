require 'rails_helper'\n\nRSpec.describe Product, type: :model do\n  it 'validates that the permalink does not overlap with reserved routes' do\n    product = Product.new(name: 'Specials')\n    expect(product).not_to be_valid\n    expect(product.errors[:permalink]).to include('is reserved and cannot be used')\n\n    product.name = 'New-in-stock'\n    expect(product).not_to be_valid\n    expect(product.errors[:permalink]).to include('is reserved and cannot be used')\n\n    product.name = 'ValidName'\n    expect(product).to be_valid\n  end\nend