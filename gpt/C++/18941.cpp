Poco::AutoPtr<Poco::Util::LayeredConfiguration> config = new Poco::Util::LayeredConfiguration;\n  config->add(new Poco::Util::PropertyFileConfiguration("config.properties"));\n  std::string value = config->getString("someKey");