package com.shopee2.Sale.Firebase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import com.shopee2.Sale.Model.CommentShop;
import com.shopee2.Sale.Model.Shop;
import com.shopee2.Sale.Model.CommentProduct;

@Service
public class CommentService {
	
	//CommentShop
	public void addCommentShop(CommentShop commentShop) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture;
		collectionsApiFuture = db.collection("CommentShop").document(Integer.toString(commentShop.getId())).set(commentShop);
		calculateRating(commentShop.getShopId());
	}

	public List<CommentShop> allCommentShop(int shop_id) throws ExecutionException, InterruptedException {
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference collectionReference = db.collection("CommentShop");
		Query query = collectionReference.whereEqualTo("shopId", shop_id);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<CommentShop> result = new ArrayList<>();
		if (!documents.isEmpty())
			for (DocumentSnapshot snapshot : documents)
				result.add(snapshot.toObject(CommentShop.class));

		return result;
	}

	public void deleteCommentShop(int id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("CommentShop").document(Integer.toString(id)).delete();
    }
	
	public void calculateRating(int shop_id){
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference collectionReference = db.collection("CommentShop");
		Query query = collectionReference.whereEqualTo("shopId", shop_id);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = null;
		try {
			documents = querySnapshot.get().getDocuments();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		List<CommentShop> result = new ArrayList<>();
		int amount = 0;
		int all = 0;
		if (!documents.isEmpty())
			for (DocumentSnapshot snapshot : documents)
				result.add(snapshot.toObject(CommentShop.class));
		
		for (int i = 0; i < result.size(); i++) {
			amount++;
			all = all+result.get(i).getRating();
//			System.out.println("amount: "+amount);
//			System.out.println("all: "+all);
		}
		double rate = all*1.0/amount;
		
//		System.out.println(all+"/"+amount+"="+rate);
		DocumentReference docRef = db.collection("Shop").document(Integer.toString(shop_id));
		ApiFuture<WriteResult> writeResult = docRef.update("rating", rate);
	}

	
	
	//CommentProduct
		public void addCommentProduct(CommentProduct commentProduct) {
			Firestore db = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> collectionsApiFuture;
			collectionsApiFuture = db.collection("CommentProduct").document(Integer.toString(commentProduct.getId())).set(commentProduct);
		}

		public List<CommentProduct> allCommentProduct(int product_id) throws ExecutionException, InterruptedException {
			Firestore db = FirestoreClient.getFirestore();
			CollectionReference collectionReference = db.collection("CommentProduct");
			Query query = collectionReference.whereEqualTo("productId", product_id);
			ApiFuture<QuerySnapshot> querySnapshot = query.get();
			List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
			List<CommentProduct> result = new ArrayList<>();
			if (!documents.isEmpty())
				for (DocumentSnapshot snapshot : documents)
					result.add(snapshot.toObject(CommentProduct.class));

			return result;
		}

		public void deleteCommentProduct(int id) {
	        Firestore db = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = db.collection("CommentProduct").document(Integer.toString(id)).delete();
	    }
}
