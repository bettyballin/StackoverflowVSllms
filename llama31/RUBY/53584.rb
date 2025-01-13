Factory.define :transporter do |f|\n  f.sequence(:company_name) {|n| "transporter_company#{n}"}\n  f.after_build do |transporter|\n    transporter.status = 'active'\n    transporter.save!\n  end\nend