class Question < ApplicationRecord\n      acts_as_taggable_on :categories, :quizzes\n    end