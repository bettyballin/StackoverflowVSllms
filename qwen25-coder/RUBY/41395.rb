require "minitest/autorun"\nrequire "minitest/benchmark"\n\nclass ParsingPerformanceTest < Minitest::Benchmark\n  FILE_PATH = 'path_to_your_data_file'\n\n  # Add this setup block if you need to load data for benchmarks\n  def setup\n    @data = File.read(FILE_PATH)\n  end\n\n  def bench_parsing()\n    assert_performance_linear(0.9) do |n|\n      n.times do\n        parse_data(@data)\n      end\n    end\n  end\n\n  def parse_data(data)\n    # Your parsing logic here\n  end\nend