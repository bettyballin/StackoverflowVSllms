# helpers/application_helper.rb\nmodule ApplicationHelper\n  def render_index(records, columns)\n    render partial: 'shared/index', locals: { records: records, columns: columns }\n  end\n\n  def render_form(record, fields)\n    render partial: 'shared/form', locals: { record: record, fields: fields }\n  end\nend