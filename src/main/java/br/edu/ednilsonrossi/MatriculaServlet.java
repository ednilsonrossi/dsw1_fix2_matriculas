package br.edu.ednilsonrossi;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/matricula.do")
public class MatriculaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MatriculaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var database = Database.getInstance();
		Aluno aluno = null;
		Map<String, String[]> data = request.getParameterMap();
		
		String emails[] = data.get("textEmail")[0].split(";");
		String cursos[] = data.get("checkCurso");
		
		if (cursos != null && cursos.length > 0) {
			aluno = new Aluno(
					data.get("textProntuario")[0], 
					data.get("textNome")[0], 
					Arrays.asList(emails), 
					Arrays.asList(cursos) );
			
			database.insert(aluno);
		}
		
		response.setContentType("text/html");
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
					+ "                        <a class=\"nav-link active\" aria-current=\"page\" href=\"formulario.html\">Matricula</a>\n"
					+ "                    </li>\n"
					+ "                    <li class=\"nav-item\">\n"
					+ "                        <a class=\"nav-link\" href=\"report.do\">Relatório</a>\n"
					+ "                    </li>\n"
					+ "                </ul>\n"
					+ "            </div>\n"
					+ "        </div>\n"
					+ "    </nav>\n"
					+ "\n"
					+ "    <main class=\"container-sm flex-grow-1 d-flex justify-content-center align-items-center\">\n"
					+ "\n" );
			
			if (aluno == null) {
				out.println("<div class=\"card border-warning mb-3\" style=\"width: 70%;\">\n"
						+ "            <div class=\"card-header text-bg-warning\">Erro ao realizar a matrícula</div>\n"
						+ "            <div class=\"card-body\">\n"
						+ "                <h5 class=\"card-title\">Deve-se selecionar pelo menos um curso na matrícula.</h5>\n"
						+ "            </div>\n"
						+ "        </div>");
			} else {
				out.println("        <div class=\"card border-warning mb-3\" style=\"width: 70%;\">\n"
					+ "            <div class=\"card-header text-bg-warning\">Matrícula Realizada</div>\n"
					+ "            <div class=\"card-body\">\n"
					+ "                <h5 class=\"card-title\">"+ aluno.getNome() + "(" + aluno.getProntuario() + ")</h5>\n");
				for(var str : aluno.getEmails()) {
					if (str.contains("ifsp.edu.br")) {
						out.println("<p><strong>" + str + "</strong></p>");
					} else {
						out.println("<p>" + str + "</p>");
					}
				}
					
				out.println("                <ul class=\"list-unstyled\">\n");
				for (var str : aluno.getCursos()) {
					out.println("                    <li class=\"card-text\">" + str + "</li>\n");
				}
				out.println("                </ul>\n"
					+ "            </div>\n"
					+ "        </div>\n"
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
