package com.github.martynfunclub.trackingsystem.config;

import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

public class RedirectAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    public RedirectAuthenticationSuccessHandler() {
        setUseReferer(true);
    }
}
