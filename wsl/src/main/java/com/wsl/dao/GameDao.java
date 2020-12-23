package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.Order;
import com.wsl.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class GameDao {

	@Autowired
	GameMapper gameMapper;
	private static Map<Integer, Game> games = null;
	

	static{
		games = new HashMap<Integer, Game>();
		games.put(1, new Game(1, 1, "lx","a", "动作",new Date()));
		games.put(2, new Game(2, 1, "lx","b", "悬疑", new Date()));
		games.put(3, new Game(3, 2, "slf","c", "冒险", new Date()));
		games.put(4, new Game(4, 2, "slf","d", "运动", new Date()));
		games.put(5, new Game(5, 3, "wxy","e", "动作", new Date()));
		games.put(6, new Game(6, 3, "wxy","lol", "moba", new Date()));

	}
	
	private static Integer initId = 7;
	
	public void save(Game game){
		if(game.getId() == null){
			game.setId(initId++);
			gameMapper.insertGame(game);
		}else gameMapper.updateGame(game);
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
		gameMapper.deleteGameById(id);
		games.remove(id);
	}

	public Game findById(Integer id){
		for (Game game:this.getAll()){
			if (game.getId().equals(id)){
				return game;
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
