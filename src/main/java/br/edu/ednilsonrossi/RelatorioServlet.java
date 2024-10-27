package br.edu.ednilsonrossi;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/report.do")
public class RelatorioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String curso = request.getParameter("selectCurso");
		
		response.setContentType("text/html");
		if (curso == null) {
			try(var out = response.getWriter()) {
				out.println("<!DOCTYPE html>\n"
						+ "<html lang=\"pt-br\">\n"
						+ "\n"
						+ "<head>\n"
						+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
						+ "        integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Matriculas</title>\n"
						+ "</head>\n"
						+ "\n"
						+ "<body class=\"d-flex flex-column min-vh-100\">\n"
						+ "    <nav class=\"navbar navbar-expand-lg bg-warning\">\n"
						+ "        <div class=\"container-fluid\">\n"
						+ "            <a class=\"navbar-brand\" href=\"index.html\">DSW1</a>\n"
						+ "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\n"
						+ "                aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
						+ "                <span class=\"navbar-toggler-icon\"></span>\n"
						+ "            </button>\n"
						+ "            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n"
						+ "                <ul class=\"navbar-nav\">\n"
						+ "                    <li class=\"nav-item\">\n"
						+ "                        <a class=\"nav-link\" href=\"formulario.html\">Matricula</a>\n"
						+ "                    </li>\n"
						+ "                    <li class=\"nav-item\">\n"
						+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"report.do\">Relatório</a>\n"
						+ "                    </li>\n"
						+ "                </ul>\n"
						+ "            </div>\n"
						+ "        </div>\n"
						+ "    </nav>\n"
						+ "\n"
						+ "    <main class=\"container-sm flex-grow-1  justify-content-center\">\n"
						+ "\n"
						+ "        \n"
						+ "        <form class=\"bg-white p-4 rounded-3 shadow\" style=\"margin-top: 30px;\" action=\"\" method=\"get\">\n"
						+ "            <div class=\"input-group mb-3\">\n"
						+ "                <select class=\"form-select\" name=\"selectCurso\">\n"
						+ "                    <option selected>Selecione o curso</option>\n"
						+ "                    <option value=\"Desenvolvimento de Aplicações Web com Java e Spring Boot\">Desenvolvimento de Aplicações Web com Java e Spring Boot</option>\n"
						+ "                    <option value=\"Kotlin para Desenvolvimento de Aplicações Android\">Kotlin para Desenvolvimento de Aplicações Android</option>\n"
						+ "                    <option value=\"Java Web Services: REST e SOAP\">Java Web Services: REST e SOAP</option>\n"
						+ "                  </select>\n"
						+ "                <button type=\"submit\" class=\"btn btn-warning\" style=\"text-align: center;\">Exibir</button>\n"
						+ "              </div>\n"
						+ "        </form>\n"
						+ "    </main>\n"
						+ "\n"
						+ "\n"
						+ "    <footer class=\"bg-warning text-black text-center py-3\">\n"
						+ "        <p>Desenvolvimento de Software para Web 1 (ARQDSW1) - <a class=\"link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover\" href=\"https://linktr.ee/ednilsonrossi\" target=\"_blank\">Prof. Ednilson Rossi</a></p>\n"
						+ "    </footer>\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\n"
						+ "        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\n"
						+ "        crossorigin=\"anonymous\"></script>\n"
						+ "</body>\n"
						+ "\n"
						+ "</html>");
			}
		} else {
			var database = Database.getInstance();
			try(var out = response.getWriter()) {
				out.println("<!DOCTYPE html>\n"
						+ "<html lang=\"pt-br\">\n"
						+ "\n"
						+ "<head>\n"
						+ "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
						+ "        integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n"
						+ "    <meta charset=\"UTF-8\">\n"
						+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
						+ "    <title>Matriculas</title>\n"
						+ "</head>\n"
						+ "\n"
						+ "<body class=\"d-flex flex-column min-vh-100\">\n"
						+ "    <nav class=\"navbar navbar-expand-lg bg-warning\">\n"
						+ "        <div class=\"container-fluid\">\n"
						+ "            <a class=\"navbar-brand\" href=\"index.html\">DSW1</a>\n"
						+ "            <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarNav\"\n"
						+ "                aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n"
						+ "                <span class=\"navbar-toggler-icon\"></span>\n"
						+ "            </button>\n"
						+ "            <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\n"
						+ "                <ul class=\"navbar-nav\">\n"
						+ "                    <li class=\"nav-item\">\n"
						+ "                        <a class=\"nav-link\" href=\"formulario.html\">Matricula</a>\n"
						+ "                    </li>\n"
						+ "                    <li class=\"nav-item\">\n"
						+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"report.do\">Relatório</a>\n"
						+ "                    </li>\n"
						+ "                </ul>\n"
						+ "            </div>\n"
						+ "        </div>\n"
						+ "    </nav>\n"
						+ "\n"
						+ "    <main class=\"container-sm flex-grow-1  justify-content-center\">\n"
						+ "\n"
						+ "        \n"
						+ "        <form class=\"bg-white p-4 rounded-3 shadow\" style=\"margin-top: 30px;\" action=\"\" method=\"get\">\n"
						+ "            <div class=\"input-group mb-3\">\n"
						+ "                <select class=\"form-select\" name=\"selectCurso\">\n"
						+ "                    <option selected>Selecione o curso</option>\n"
						+ "                    <option value=\"Desenvolvimento de Aplicações Web com Java e Spring Boot\">Desenvolvimento de Aplicações Web com Java e Spring Boot</option>\n"
						+ "                    <option value=\"Kotlin para Desenvolvimento de Aplicações Android\">Kotlin para Desenvolvimento de Aplicações Android</option>\n"
						+ "                    <option value=\"Java Web Services: REST e SOAP\">Java Web Services: REST e SOAP</option>\n"
						+ "                  </select>\n"
						+ "                <button type=\"submit\" class=\"btn btn-warning\" style=\"text-align: center;\">Exibir</button>\n"
						+ "              </div>\n"
						+ "        </form>\n"
						+ "\n"
						+ "\n"
						+ "        <h1 style=\"text-align: center; margin: 30px;\">Alunos Matriculados</h1>\n"
						+ "        <h1 style=\"text-align: center; margin: 30px;\">" + curso + "</h1>\n"
						+ "        <table class=\"table\">\n"
						+ "            <thead>\n"
						+ "              <tr>\n"
						+ "                <th scope=\"col\">#</th>\n"
						+ "                <th scope=\"col\">Prontuário</th>\n"
						+ "                <th scope=\"col\">Aluno</th>\n"
						+ "                <th scope=\"col\">E-mail</th>\n"
						+ "              </tr>\n"
						+ "            </thead>\n"
						+ "            <tbody class=\"table-group-divider\">\n" );
						
						int i = 1;
						for(var aluno : database.findByCurso(curso)) {
						
							out.println("              <tr>\n"
								+ "                <th scope=\"row\">" + i + "</th>\n"
								+ "                <td>" + aluno.getProntuario() + "</td>\n"
								+ "                <td>" + aluno.getNome() + "</td>\n"
								+ "                <td><ul class=\"list-unstyled\">" );
							for(var email : aluno.getEmails()) {
								out.println("<li>" + email + "</li>");
							}
							out.println("</ul></td>\n"
								+ "              </tr>\n" );
							i++;
						}
						
						out.println("            </tbody>\n"
						+ "          </table>\n"
						+ "\n"
						+ "    </main>\n"
						+ "\n"
						+ "\n"
						+ "    <footer class=\"bg-warning text-black text-center py-3\">\n"
						+ "        <p>Desenvolvimento de Software para Web 1 (ARQDSW1) - <a class=\"link-body-emphasis link-offset-2 link-underline-opacity-25 link-underline-opacity-75-hover\" href=\"https://linktr.ee/ednilsonrossi\" target=\"_blank\">Prof. Ednilson Rossi</a></p>\n"
						+ "    </footer>\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\n"
						+ "        integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\"\n"
						+ "        crossorigin=\"anonymous\"></script>\n"
						+ "</body>\n"
						+ "\n"
						+ "</html>");
			}
		}
	}


}
