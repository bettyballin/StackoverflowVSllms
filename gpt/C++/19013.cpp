struct FontManager::Impl {\n       std::map<std::string, tFontInfoRef> m_fonts;\n   };\n\n   FontManager::FontManager() : pImpl(new Impl) {}\n   FontManager::~FontManager() { delete pImpl; }\n\n   void FontManager::addFont(const std::string& name, const tFontInfoRef& fontInfo) {\n       pImpl->m_fonts[name] = fontInfo;\n   }\n\n   tFontInfoRef FontManager::getFont(const std::string& name) const {\n       return pImpl->m_fonts.at(name);\n   }