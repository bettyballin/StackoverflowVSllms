ulRead = boost::asio::read(spCon->socket(), boost::asio::buffer(_requestHeader, _requestHeader.size()), boost::asio::transfer_at_least(_requestHeader.size()), error_);\nif (error_) {\n    // handle error, e.g., log and abort the operation\n    // or try to recover from the error\n} else {\n    // proceed with the successfully read data\n}