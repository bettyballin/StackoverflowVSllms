module Animal\n  def make_sound\n    raise NotImplementedError, "This method should be overridden by the including class"\n  end\nend\n\nclass Dog\n  include Animal\n\n  def make_sound\n    puts "Woof"\n  end\nend\n\ndog = Dog.new\ndog.make_sound  # Output: Woof