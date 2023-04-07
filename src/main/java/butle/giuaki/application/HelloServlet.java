package butle.giuaki.application;

import java.io.*;

import butle.giuaki.entities.Player;
import butle.giuaki.entities.Team;
import butle.giuaki.services.PlayerServices;
import butle.giuaki.services.TeamServices;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out =response.getWriter();

        Team team1 = new Team("Porto","portugal");
        Team team2 = new Team("Dortmund","Germany");
        TeamServices teamServices = new TeamServices();
        teamServices.save(team1);
        teamServices.save(team2);

        Player player1 = new Player("Cristiano Ronaldo",39);
        player1.setTeam(team1);
        Player player2 = new Player("pepe",40);
        player2.setTeam(team2);
        PlayerServices services = new PlayerServices();
        services.save(player1);
        services.save(player2);
        out.println("oke");
    }

    public void destroy() {
    }
}