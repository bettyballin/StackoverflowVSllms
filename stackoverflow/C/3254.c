istream& operator >> (istream& is, PersonId &p)\n{\n    is >> p.fId;\n    return is;\n}