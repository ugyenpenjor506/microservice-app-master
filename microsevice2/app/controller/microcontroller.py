from functools import wraps
from flask import Flask, request,jsonify, g
from app import app
import os
from dotenv import load_dotenv
from app.service.config import CONFIGURATION
load_dotenv()

RELATIVE_PATH = os.getenv('RELATIVE_PATH')

class MicroService4:
    oidc = CONFIGURATION.keycloakConfiguration()
    # def manager_required(f):
    #     @wraps(f)
    #     def decorated_function(*args, **kwargs):
    #         payload = g.oidc_token_info
    #         user_roles = payload["realm_access"]["roles"][0]
    #         print("roles ", user_roles )
    #         if user_roles != "manager":
    #             return jsonify({"message":"you are not authorised user", "code":403})
    #         return f(*args, **kwargs)
    #     return decorated_function
    
    # def developer_required(f):
    #     @wraps(f)
    #     def decorated_function(*args, **kwargs):
    #         payload = g.oidc_token_info
    #         user_roles = payload["realm_access"]["roles"][0]
    #         print("roles ", user_roles )
    #         if user_roles != "developer":
    #             return jsonify({"message":"you are not authorised user", "code":403})
    #         return f(*args, **kwargs)
    #     return decorated_function
    
    
    @app.route("/" + RELATIVE_PATH + '/show', methods=["GET"])
    # @oidc.accept_token(require_token=True) 
    # @manager_required
    def showuser1():
        return "hello manager weclome to managerdashboard!!!!!!!"
    
    @app.route("/" + RELATIVE_PATH + '/return', methods=["GET"])
    @oidc.accept_token(require_token=True) 
    # @developer_required
    def showuser2():
        return "hello developer welcome to developerdashboard!!!!!"