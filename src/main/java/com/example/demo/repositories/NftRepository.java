package com.example.demo.repositories;
import com.example.demo.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import java.util.ArrayList;

@Repository
public interface NftRepository extends CrudRepository<NftModel,Long> {
    //CrudRepository hace toda la magia de Spring
    //**************2da etapa ***********************

    //public abstract ArrayList<NftModel> findByPrioridad(Integer prioridad);
}
