# Ruby 1.9\n   fiber = Fiber.new do\n     Fiber.yield 1\n     2\n   end\n   puts fiber.resume # => 1\n   puts fiber.resume # => 2