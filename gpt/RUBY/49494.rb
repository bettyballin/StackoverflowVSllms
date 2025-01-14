class FileArray\n  def initialize(path)\n    @path = path\n    @data = File.readlines(path, chomp: true)\n  end\n\n  def [](index)\n    @data[index]\n  end\n\n  def []=(index, value)\n    @data[index] = value\n    save\n  end\n\n  def save\n    File.open(@path, 'w') do |file|\n      file.puts(@data)\n    end\n  end\n\n  def to_a\n    @data.dup\n  end\nend\n\n# Usage\nfile_array = FileArray.new('example.txt')\nputs file_array[0]  # Read the first line\nfile_array[0] = 'New content for the first line'  # Modify the first line