package com.example.servlet;

import com.example.dao.TestDAO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class TestServlet extends HttpServlet {

    private Configuration cfg;
    private TestDAO testDAO;

    @Override
    public void init() throws ServletException {
        super.init();

        cfg = new Configuration(Configuration.VERSION_2_3_31);
        cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        testDAO = new TestDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        testDAO.exampleQuery();

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("message", "Hello, FreeMarker!");

        Template template = cfg.getTemplate("test.ftl");

        try (Writer out = response.getWriter()) {
            template.process(dataModel, out);
        } catch (TemplateException e) {
            throw new ServletException("Ошибка обработки шаблона", e);
        }
    }
}
