package butle.giuaki.services;

import butle.giuaki.entities.Player;
import butle.giuaki.repo.CrudRepository;

import java.util.List;

public class PlayerServices {
    private CrudRepository<Player,Long> repo;
    public PlayerServices(){
        repo = new CrudRepository<>("Player");
    }
    public  Player save(Player player){
        return repo.save(player);
    }
    public List<Player> findAll(){
        return  repo.findAll();
    }
    public Player update(Player player){
        return repo.update(player);
    }
    public Player delete(Player player,long id){
        return repo.delete(player,id);
    }
    public Player findById(Player player, long id){
        return repo.findByEntity(player,id);
    }
}
