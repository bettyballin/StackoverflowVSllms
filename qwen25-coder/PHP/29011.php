$value = preg_replace('/(?<!\]\()https?:\/\/[^\s\'">]+/', '[$0]($0)', $value);