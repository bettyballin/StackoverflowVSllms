std::regex re(R"(<div\s+[^>]*\bclass="tab news selected"[^>]*>.*?<a\s+href\b[^>]*>.*?</a>(?:.*?<a\s+href\b[^>]*>.*?</a>)*.*?</div>)", std::regex_constants::dotall);