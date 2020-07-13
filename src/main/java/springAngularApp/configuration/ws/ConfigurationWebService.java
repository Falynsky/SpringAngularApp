package springAngularApp.configuration.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springAngularApp.system.service.AuthProvider;
import springAngularApp.configuration.ws.schema.ConfigurationModelResponse;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static springAngularApp.users.domain.entities.UserAuthorities.ROLE_USER_GROUP_VIEW;
import static springAngularApp.users.domain.entities.UserAuthorities.ROLE_USER_VIEW;

@RestController
@RequestMapping("ws/configuration")
public class ConfigurationWebService {

    @Autowired private AuthProvider authProvider;

    @GetMapping("/model")
    //polecam bardziej korzystać z tej adnotacji, jest nowsza :) ta sama sytuacja dla np, @PostMapping 
    public ConfigurationModelResponse model() {
        ConfigurationModelResponse response = new ConfigurationModelResponse();
        response.setHasUserViewAccess(authProvider.hasRole(ROLE_USER_VIEW));
        response.setHasUserGroupViewAccess(authProvider.hasRole(ROLE_USER_GROUP_VIEW));
        return response;
    }

}
