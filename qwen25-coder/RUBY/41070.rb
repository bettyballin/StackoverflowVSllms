require File.expand_path(File.dirname(__FILE__) + '/../spec_helper')\n\ndescribe ScoringMethods do\n\n  describe "should have scorePublicContest method" do\n    methods = ScoringMethods.instance_methods.map(&:to_s)\n    expect(methods).to include('scorePublicContest')\n  end\nend