# app/decorators/employee_decorator.rb\nclass EmployeeDecorator < Draper::Decorator\n  delegate_all\n\n  def to_xml(options = {})\n    options[:procs] = [ Proc.new {|options| options[:builder].tag!('uri', h.employer_employee_url(object.employer, object, host: h.request.host)) } ]\n    options[:include] = { employer: { only: [:id, :name], methods: [:uri] } }\n    super(options)\n  end\nend\n\n# app/decorators/employer_decorator.rb\nclass EmployerDecorator < Draper::Decorator\n  delegate_all\n\n  def to_xml(options = {})\n    options[:procs] = [ Proc.new {|options| options[:builder].tag!('uri', h.employer_url(object, host: h.request.host)) } ]\n    options[:include] = { employees: { only: [:id, :name], methods: [:uri] } }\n    super(options)\n  end\nend