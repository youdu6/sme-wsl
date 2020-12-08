package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.Order;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GameDao {

	private static Map<Integer, Game> games = null;
	

	static{
		games = new HashMap<Integer, Game>();
		games.put(1001, new Game(1001, 1, "lx","a", "动作",new Date()));
		games.put(1002, new Game(1002, 1, "lx","b", "悬疑", new Date()));
		games.put(1003, new Game(1003, 2, "slf","c", "冒险", new Date()));
		games.put(1004, new Game(1004, 2, "slf","d", "运动", new Date()));
		games.put(1005, new Game(1005, 3, "wxy","e", "动作", new Date()));
		games.put(1006, new Game(1006, 3, "wxy","lol", "moba", new Date()));

	}
	
	private static Integer initId = 1007;
	
	public void save(Game game){
		if(game.getId() == null){
			game.setId(initId++);
		}
		games.put(game.getId(), game);
	}

	//查询所有员工
	public Collection<Game> getAll(){
		return games.values();
	}
	
	public Game get(Integer id){
		return games.get(id);
	}
	
	public void delete(Integer id){
		games.remove(id);
	}

	public String findById(Integer id){
		for (Game game:this.getAll()){
			if (game.getId().equals(id)){
				return game.getName();
			}
		}
		return null;
	}

	public Collection<Game> getBypName(String pName){
		Map<Integer, Game> newGames = null;
		newGames=new HashMap<Integer, Game>();
		int count=0;
		for (Game game: this.getAll()){
			if (game.getpName().equals(pName)){
				newGames.put(count++,game);
			}
		}
		return newGames.values();
	}
}
