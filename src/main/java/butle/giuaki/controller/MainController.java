package butle.giuaki.controller;

import butle.giuaki.entities.Player;
import butle.giuaki.entities.Team;
import butle.giuaki.services.PlayerServices;
import butle.giuaki.services.TeamServices;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/controller")
public class MainController extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String action = req.getParameter("action");
        PlayerServices services = new PlayerServices();
        TeamServices teamServices = new TeamServices();
        HttpSession session = req.getSession(true);
        switch (action){
            case("list-players"):
                List<Player> lst = services.findAll();
                session.setAttribute("players",lst);
                res.sendRedirect("listPlayers.jsp");
                break;
            case ("new-player-view"):
                res.sendRedirect("newPlayer.jsp");
                break;
            case ("add-player"):
                String name = req.getParameter("playerName");
                String stringAge = req.getParameter("age");
                String stringTeamId = req.getParameter("teamId");
                int age = Integer.parseInt(stringAge);
                Player player = new Player(name,age);
                Team team = teamServices.findById(new Team(),Long.parseLong(stringTeamId));
                player.setTeam(team);
                services.save(player);
                res.sendRedirect("controller?action=list-players");
                break;
            case ("edit-player-view"):
                String playerId = req.getParameter("id");
                Player selPlayer = services.findById(new Player(),Long.parseLong(playerId));
                session.setAttribute("selPlayer",selPlayer);
                res.sendRedirect("editPlayer.jsp");
                break;
            case ("update-player"):
                playerId = req.getParameter("id");
                name = req.getParameter("playerName");
                stringAge = req.getParameter("age");
                stringTeamId = req.getParameter("teamId");
                age = Integer.parseInt(stringAge);
                Player newPlayer = new Player(name,age);
                team = teamServices.findById(new Team(),Long.parseLong(stringTeamId));
                newPlayer.setTeam(team);
                newPlayer.setPlayerId(Long.parseLong(playerId));
                services.update(newPlayer);
                res.sendRedirect("controller?action=list-players");
                break;
            case ("delete-player"):
                playerId = req.getParameter("id").trim();
                Player delPlayer =new Player();
                delPlayer.setPlayerId(Long.parseLong(playerId));
                services.delete(delPlayer,Long.parseLong(playerId));
                res.sendRedirect("controller?action=list-players");
                break;
            case ("list-teams"):
                List<Team> lstTeam = teamServices.findAll();
                System.out.println(lstTeam);
                session.setAttribute("teams",lstTeam);
                res.sendRedirect("listTeam.jsp");
                break;
            case ("add-team-view"):
                res.sendRedirect("addTeam.jsp");
                break;
            case ("add-team"):
                String teamName = req.getParameter("teamName");
                String location = req.getParameter("location");
                Team newTeam = new Team(teamName,location);
                teamServices.save(newTeam);
                res.sendRedirect("controller?action=list-teams");
                break;
        }
    }
}
