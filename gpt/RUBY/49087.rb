class Man < ActiveRecord::Base\n  has_many :wives\n\n  scope :has_wife_named, ->(n) { joins(:wives).where(wives: { name: n }) }\n  scope :has_young_wife_named, ->(n) { joins(:wives).where(wives: { name: n, age: 0..30 }) }\n  scope :has_yw_named_v2, ->(n) { joins(:wives).where("wives.name = ? AND wives.age <= 30", n) }\n  scope :joins_wives, -> { joins(:wives) }\n\n  scope :has_red_cat, -> { joins(wives: :cats).where(cats: { color: 'red' }) }\n  scope :has_cat_of_color, ->(c) { joins(wives: :cats).where(cats: { color: c }) }\n  scope :has_7yo_cat, -> { joins(wives: :cats).where(cats: { age: 7 }) }\n  scope :has_cat_of_age, ->(a) { joins(wives: :cats).where(cats: { age: a }) }\n  scope :has_cat_older_than, ->(a) { joins(wives: :cats).where("cats.age > ?", a) }\n  scope :has_cat_younger_than, ->(a) { joins(wives: :cats).where("cats.age < ?", a) }\n  scope :has_cat_fatter_than, ->(w) { joins(wives: :cats).where("cats.weight > ?", w) }\n  scope :joins_wives_cats, -> { joins(wives: :cats) }\nend\n\nclass Wife < ActiveRecord::Base\n  belongs_to :man\n  has_many :cats\nend\n\nclass Cat < ActiveRecord::Base\n  belongs_to :wife\nend