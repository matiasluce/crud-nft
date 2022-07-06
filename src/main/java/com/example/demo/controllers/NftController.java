package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;
import com.example.demo.models.NftModel;
import com.example.demo.services.NftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/nfts")         // mapea     /usuarios
public class NftController {
    @Autowired
    NftService nftService;
    @CrossOrigin   // para solucionar error “cors”
    @GetMapping()      //trae todos los usuarios y lo mapea  /usuarios
    public ArrayList<NftModel> obtenerNfts(){
        return nftService.obtenerNfts();
    }
    @CrossOrigin
    @PostMapping()    //   graba un usuario
    public NftModel guardarNft(@RequestBody NftModel nft){
        return this.nftService.guardarNft(nft);
    }
 
    @CrossOrigin
    @GetMapping( path = "/{id}")    // trae un usuario segun id
    public Optional<NftModel> obtenerNftPorId(@PathVariable("id") Long id) {
        return this.nftService.obtenerPorId(id);
    }
 
    //@CrossOrigin
    //@GetMapping("/query")        // trae los usuarios con determinada prioridad
    
    @CrossOrigin
    @DeleteMapping( path = "/{id}")   // borra un usuario con determinado id  
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.nftService.eliminarNft(id);
        if (ok){
            return "Se eliminó el nft con id " + id;
        }else{
            return "No pudo eliminar el nft con id" + id;
        }
    }
}


