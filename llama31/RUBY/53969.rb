config.middleware.use Rack::SslEnforcer, :except => ['/public_pages']