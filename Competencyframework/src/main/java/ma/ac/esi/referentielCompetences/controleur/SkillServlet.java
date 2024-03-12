package ma.ac.esi.referentielCompetences.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.ac.esi.referentielCompetences.model.Skill;
import ma.ac.esi.referentielCompetences.model.SkillDAO;

import java.io.IOException;
import java.util.List;

/**
 *  implementation class SkillServlet
 */
public class SkillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SkillServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		 String description = request.getParameter("description");
		 String domain = request.getParameter("domain");
		 String level = request.getParameter("level");


		 Skill skill = new Skill(name, description, domain, level);


		 SkillDAO skillDAO = new SkillDAO();
		 
		 
		 boolean succes = skillDAO.addSkill(skill);
		 
		   if (succes) {
			   List<Skill> skillList = skillDAO.getAllSkills();

			   request.setAttribute("skillList", skillList);
	request.setAttribute("message","La compétence a été ajoutée avec succès.");
		               }
		   else {
	request.setAttribute("erreur", "Erreur lors de l'ajout de la compétence.");
		        }
 RequestDispatcher dispatcher = request.getRequestDispatcher("/SkillCrud.jsp");
 dispatcher.forward(request, response);
		 

		// response.sendRedirect("SkillCrud.html");
	       }
		// TODO Auto-generated method stub
		
	}


