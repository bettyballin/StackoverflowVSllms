class Poll < ApplicationRecord\n  serialize :variants, ActiveRecord::Coders::JSONColumn.new(nil)\nend\n\n# Usage\npoll.variants = {0 => 'тест',1 => '-тест-',2 => 'test # test "тест'}