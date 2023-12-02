package com.TextGame.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
@Service
public class CurrentSessionService {

        public static String username(){
         HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
         String username = CurrentSessionService.getUsername(request);
         return username;
     }

        public static String getUsername(HttpServletRequest request) {
            return getUsername(request.getSession());
        }

        public static String getUsername(HttpSession session) {
            return (String)session.getAttribute("Username");
        }

        public static void addUsernameToSession(HttpServletRequest request, String name) {
            addUsernameToSession(request.getSession(), name);
        }

        public static void addUsernameToSession(HttpSession session, String name) {
            session.removeAttribute("Username");
            session.setAttribute("Username", name);
        }
}
