test_date = Date.new(2008, 12, 5)\nMyDateOnlyModel.create!(:effective_date => test_date)\nassert_equal test_date, MyDateOnlyModel.find(:first).effective_date