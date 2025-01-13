QByteArray deriveKey(const QString &password, const QByteArray &salt) {\n    QByteArray key(32, 0); // 256-bit key\n    QByteArray iv(16, 0);  // 128-bit IV\n\n    int iterations = 10000;\n    const EVP_MD *digest = EVP_sha256();\n\n    PKCS5_PBKDF2_HMAC(password.toUtf8().constData(), password.size(), \n                      reinterpret_cast<const unsigned char*>(salt.constData()), salt.size(), \n                      iterations, digest, key.size(), \n                      reinterpret_cast<unsigned char*>(key.data()));\n\n    return key;\n}