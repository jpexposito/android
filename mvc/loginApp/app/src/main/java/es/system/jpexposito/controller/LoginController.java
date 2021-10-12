package es.system.jpexposito.controller;

import es.system.jpexposito.model.User;
import es.system.jpexposito.view.ILoginView;

public class LoginController implements ILoginController {
    ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    /**
     * Funcion que valida los parametros introducidos por el usuario
     * @param email del usuario
     * @param password del usuario
     */
    @Override
    public void OnLogin(String email, String password) {
        User user = new User(email,password);
        int loginCode = user.isValid();
        switch(loginCode) {
            case 0 :
                loginView.OnLoginError("Por favor introduce un Email");
                break;
            case 1 :
                loginView.OnLoginError("Por favor introduce un Email valido");
                break;
            case 2 :
                loginView.OnLoginError("Por favor introduce un Password");
                break;
            case 3 :
                loginView.OnLoginError("Por favor introduce un Password > 6");
                break;
            default :
                loginView.OnLoginSuccess("Login correcto");
        }
        /** Codigo menos optimo
        if(loginCode == 0) {
            loginView.OnLoginError("Por favor introduce un Email");
        }else  if (loginCode == 1){
            loginView.OnLoginError("Por favor introduce un Email valido");
        } else  if (loginCode == 2) {
            loginView.OnLoginError("Por favor introduce un Password");
        }else  if(loginCode == 3){
            loginView.OnLoginError("Por favor introduce un Password > 6");
        }
        else {
            loginView.OnLoginSuccess("Login correcto");
        }
         **/
    }
}
