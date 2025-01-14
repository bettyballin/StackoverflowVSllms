models = [\n  { name: "User", fields: [{ name: "name", type: "string" }, { name: "age", type: "int" }] },\n  # Add more models as necessary\n]\n\ndef generate_csharp_class(model)\n  csharp_code = "public class #{model[:name]}\n{\n"\n  \n  model[:fields].each do |field|\n    field_name = field[:name]\n    field_type = case field[:type]\n                 when 'string' then 'String'\n                 when 'int' then 'int'\n                 else field[:type].capitalize\n                 end\n    \n    csharp_code += "    public #{field_type} #{field_name.capitalize} { get; set; }\n"\n    \n    # Simple validation logic (can be expanded)\n    if field[:type] == 'string'\n      csharp_code += %Q(\n        [System.ComponentModel.DataAnnotations.Required(ErrorMessage = "#{field_name} is required.")]\n        [System.ComponentModel.DataAnnotations.MaxLength(100, ErrorMessage = "Maximum length for #{field_name} is 100.")]\n      )\n    elsif field[:type] == 'int'\n      csharp_code += %Q(\n        [System.ComponentModel.DataAnnotations.Range(18, 120, ErrorMessage = "#{field_name} must be between 18 and 120.")]\n      )\n    end\n  end\n  \n  csharp_code += "}\n"\n  csharp_code\nend\n\nmodels.each do |model|\n  File.write("#{model[:name]}.cs", generate_csharp_class(model))\nend