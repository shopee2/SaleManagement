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

import com.shopee2.Sale.Firebase.ShopService;
import com.shopee2.Sale.Model.Shop;

@RestController
@RequestMapping("/api")
public class ShopController {

	@Autowired
	private ShopService shopService;
	
	public ShopController() {
	}
	
	@GetMapping("/shop")
	
	public List<Shop> allShop(){
		try {
            return shopService.allShop();
            }
		catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
	@GetMapping("/shop/{id}")
	public Shop shopInfo(@PathVariable() int id){
		try {
            return shopService.shopInfo(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PostMapping("/add/shop")
	public void addShop(@RequestBody Shop shop) {
		shopService.addShop(shop);
	}
	
	@PutMapping("/update/shop/{id}")
	public void updateShop(@PathVariable() int id, @RequestBody Shop shop) {
		try {
			shopService.updateShop(id, shop);
		} catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@DeleteMapping("delete/shop/{id}")
	public void deleteSeller(@PathVariable() int id) {
        shopService.deleteShop(id);
    }
	
}
