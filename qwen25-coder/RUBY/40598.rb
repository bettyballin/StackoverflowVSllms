# config/initializers/mime_types.rb\nMime::Type.register "application/vnd.com.example.Foo+json", :foobar_json\n\n# config/initializers/custom_parsers.rb\nActionDispatch::Request.parameter_parsers[:foobar_json] = lambda do |raw_post|\n  body = raw_post.force_encoding(Encoding::UTF_8)\n  parsed_body = ActiveSupport::JSON.decode(body) rescue {}\n  Rack::Utils.parse_nested_query(parsed_body)\nend