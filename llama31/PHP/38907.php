// In your LocalSettings.php or a custom extension\n$wgHooks['TitleReadWhitelist'][] = function ( Title $title, User $user ) {\n    if ( $title->getNamespace() == NS_PAID_CONTENT && !$user->is_paid_member ) {\n        return false;\n    }\n    return true;\n};