package com.shopee2.Sale.Controller;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.shopee2.Sale.Firebase.CommentService;
import com.shopee2.Sale.Model.CommentProduct;
import com.shopee2.Sale.Model.CommentShop;

@RestController
@RequestMapping("/api")
public class CommentController {

	@Autowired
	private CommentService commentService;

	public CommentController() {
	}

	// For CommentShop

	@GetMapping("/commentshop/{shop_id}")
	public List<CommentShop> allCommentShop(@PathVariable() int shop_id) {
		try {
			return commentService.allCommentShop(shop_id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add/commentshop")
	public void addCommentShop(@RequestBody CommentShop commentShop){
		try {
			commentService.addCommentShop(commentShop);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("delete/commentshop/{id}")
	public void deleteCommentShop(@PathVariable() int id) {
		commentService.deleteCommentShop(id);
	}

	// For CommentProduct

	@GetMapping("/commentproduct/{product_id}")
	public List<CommentProduct> allCommentProduct(@PathVariable() int product_id) {
		try {
			return commentService.allCommentProduct(product_id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/add/commentproduct")
	public void addCommentProduct(@RequestBody CommentProduct commentProduct) {
		commentService.addCommentProduct(commentProduct);
	}

	@DeleteMapping("delete/commentproduct/{id}")
	public void deleteCommentProduct(@PathVariable() int id) {
		commentService.deleteCommentProduct(id);
	}

}
