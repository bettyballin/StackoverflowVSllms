iconv -f utf-16 -t utf-8 <input | sed -e expr | iconv -f utf-8 -t utf-16 >output