package com.example.capstone.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UserActivityLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserActivityLogger.class);

    public void logUserActivity() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String userRoles = authentication.getAuthorities().toString();
        LOGGER.info("User {} with roles {} accessed a secured resource.", username, userRoles);
    }
}
