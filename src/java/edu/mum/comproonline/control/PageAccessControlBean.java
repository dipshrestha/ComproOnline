/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.mum.comproonline.control;

import edu.mum.comproonline.model.UserEnum;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author User
 */
public class PageAccessControlBean implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }


    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpSession session = (HttpSession) ((HttpServletRequest) request).getSession(true);

        String contextpath = ((HttpServletRequest) request).getContextPath();
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        Object role = session.getAttribute("srole");
        if ( role == null) {
            ((HttpServletResponse) response).sendRedirect(contextpath + "/faces/pages/general/login.xhtml");
        }

        if (role != null) {
            if ((role.equals(UserEnum.APPLICANT)) && (!url.contains("/applicant/"))) {
                ((HttpServletResponse) response).sendRedirect(contextpath + "/faces/pages/general/login.xhtml");
            }
            if ((role.equals(UserEnum.STAFF)) && (url.contains("/Admin/"))) {
                ((HttpServletResponse) response).sendRedirect(contextpath + "/faces/pages/general/login.xhtml");
            }
        }

        chain.doFilter(request, response);
    }

}
