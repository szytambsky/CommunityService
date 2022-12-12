package pl.tamborski.npeapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.tamborski.npeapi.config.model.LoginRequestRecord;
import pl.tamborski.npeapi.service.TokenService;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/token")
    public String token(@RequestBody LoginRequestRecord loginCredentials) {
        LOG.debug("Token requested for user: '{}'", loginCredentials.username());
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginCredentials.username(), loginCredentials.password()));
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted {}", token);
        return token;
    }


}
