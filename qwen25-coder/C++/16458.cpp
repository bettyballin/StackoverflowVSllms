if (itor != m_ResourceMap.end()) {\n    itor = m_ResourceMap.erase(itor);\n} else {\n    m_ResourceMap.erase(itor++);\n}