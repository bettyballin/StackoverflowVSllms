BYTE p[64] = { 139 }; // little-endian, all other bytes set to 0\nBYTE g[64] = { 5 };\n\nCRYPT_DATA_BLOB pblob;\npblob.cbData = sizeof( p);\npblob.pbData = p;\n\nCRYPT_DATA_BLOB gblob;\ngblob.cbData = sizeof( g );\ngblob.pbData = g;\n\nHCRYPTKEY hKey;\nif ( ::CryptGenKey( m_hCryptoProvider, CALG_DH_SF,\n                    ( 512 << 16 ) | CRYPT_PREGEN, &hKey ) )\n{\n    ::CryptSetKeyParam( hKey, KP_P, ( LPBYTE ) &pblob, 0 );