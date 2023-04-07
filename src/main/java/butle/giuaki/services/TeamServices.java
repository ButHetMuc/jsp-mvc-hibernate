package butle.giuaki.services;

import butle.giuaki.entities.Team;
import butle.giuaki.repo.CrudRepository;

import java.util.List;

public class TeamServices {
    private CrudRepository<Team,Long> repo;
    public  TeamServices(){
        repo = new CrudRepository<>("Team");
    }
    public Team save(Team team){
        return repo.save(team);
    }
    public Team update(Team team){
        return repo.update(team);
    }
    public Team delete(Team team,long id){
        return repo.delete(team,id);
    }
    public List<Team> findAll(){
        return repo.findAll();
    }
    public Team findById(Team team, long id){
        return repo.findByEntity(team,id);
    }
}
