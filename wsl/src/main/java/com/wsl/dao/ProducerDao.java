package com.wsl.dao;

import com.wsl.entities.Game;
import com.wsl.entities.Producer;
import com.wsl.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProducerDao {

    private static Map<Integer, Producer> producers = null;


    static{
        producers = new HashMap<Integer, Producer>();
        producers.put(1001, new Producer(1001, "lx",123456));
        producers.put(1002, new Producer(1002, "slf",123456));
        producers.put(1003, new Producer(1003, "wxy",123456));

    }

    private static Integer initId = 1004;

    public void save(Producer producer){
        if(producer.getId() == null){
            producer.setId(initId++);
        }
        producers.put(producer.getId(), producer);
    }

    //查询所有员工
    public Collection<Producer> getAll(){
        return producers.values();
    }

    public Producer get(Integer id){
        return producers.get(id);
    }

    public Producer getByName(String name){
        for (Producer producer:this.getAll()){
            if (producer.getName().equals(name)){
                return producer;
            }
        }
        return null;
    }

    public void delete(Integer id){
        producers.remove(id);
    }
}
