package com.example.demo.services;

import java.util.ArrayList;
import com.example.demo.models.NftModel;
import com.example.demo.repositories.NftRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class NftService {
    @Autowired
    NftRepository nftRepository;
    public ArrayList<NftModel> obtenerNfts(){
        return (ArrayList<NftModel>) nftRepository.findAll();
    //findAll metodo de CrudRepository
   }
    public NftModel guardarNft(NftModel nft){
        return nftRepository.save(nft);  //save metodo de CrudRepository
    }//**************** 2da etapa
    public Optional<NftModel> obtenerPorId(Long id){
        return nftRepository.findById(id);
    }
    public boolean eliminarNft(Long id) {
        try{
            nftRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }
}
