# Avoid monkey patching core classes\nclass String\n  def my_custom_method\n    'custom behavior'\n  end\nend