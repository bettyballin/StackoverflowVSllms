# How to find out where a method comes from.\n# Learned this from Dave Thomas while teaching Advanced Ruby Studio\n# Makes the case for separating method definitions into\n# modules, especially when enhancing built-in classes.\nmodule Perpetrator\n  def crime\n  end\nend\n\nclass Fixnum\n  include Perpetrator\nend\n\np 2.method(:crime) # The "2" here is an instance of Fixnum.\n#<Method: Fixnum(Perpetrator)#crime>