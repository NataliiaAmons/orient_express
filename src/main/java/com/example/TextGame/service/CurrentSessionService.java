package com.example.TextGame.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class CurrentSessionService {

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
