describe Foo do\n  before(:each) do\n    @valid_attributes = {\n      :bar => 12345\n    }\n  end\n\n  it "should create a new instance given valid attributes" do\n    foo = Foo.new(@valid_attributes)\n    foo.save\n    puts "sleeping..."\n    sleep(20)\n    puts Foo.count # This will print 1\n  end\nend