package com.nighthawk.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class studentSQLrepo {
    @Autowired
    private studentJPArepo jpa;

    public List<student>listAll(){
        return jpa.findAll();

    }
    public void save(student student ){
        jpa.save(student);

    }
    public student get(long id){
        return jpa.findById(id).get();
    }
    public void delete(long id){
        jpa.deleteById(id);
    }
}

