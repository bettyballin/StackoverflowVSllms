std::map<int, urllib>& get_url_container() {\n    static std::map<int, urllib> url_container;\n    return url_container;\n}