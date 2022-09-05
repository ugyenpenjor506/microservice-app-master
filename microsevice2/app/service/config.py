from flask_oidc import OpenIDConnect
from app import app
import ssl

class CONFIGURATION:
    def keycloakConfiguration():
        
        app.config.from_mapping(
                SECRET_KEY='6V8f5mAEj6osDCD7yRlUvNtrKdIwHBqI',
                OIDC_CLIENT_SECRETS='./keycloak.json',
                OIDC_VALID_ISSUERS=['https://13.214.161.35:2000/realms/dk-realm/'],
                OIDC_INTROSPECTION_AUTH_METHOD='client_secret_post',
                OIDC_TOKEN_TYPE_HINT='access_token',
            )

        oidc = OpenIDConnect(app)
        return oidc