package com.shopee2.Sale.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shopee2.Sale.Firebase.SellerService;
import com.shopee2.Sale.Model.Seller;

@RestController
@RequestMapping("/api")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	public SellerController() {
	}
	
	@GetMapping("/seller")
	public List<Seller> allSeller(){
		try {
            return sellerService.allSeller();
        }
		catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/seller/{sid}")
	public Seller sellerinfo(@PathVariable() int sid){
		try {
            return sellerService.sellerInfo(sid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping("/add/seller")
	public void addSeller(@RequestBody Seller seller) {
		sellerService.addSeller(seller);
	}
	
	@PutMapping("/update/seller/{sid}")
	public void updateSeller(@PathVariable() int sid, @RequestBody Seller seller) {
		try {
			sellerService.updateSeller(sid, seller);
		} catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping("/delete/seller/{sid}")
	public void deleteSeller(@PathVariable() int sid) {
        sellerService.deleteSeller(sid);
    }
}
