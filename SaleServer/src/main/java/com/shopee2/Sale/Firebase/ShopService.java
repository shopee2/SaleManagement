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

@Service
public class ShopService {

	public void addShop(Shop shop) {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture;
		collectionsApiFuture = db.collection("Shop").document(Integer.toString(shop.getId())).set(shop);
	}

	public List<Shop> allShop() throws ExecutionException, InterruptedException {
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference collectionReference = db.collection("Shop");
		ApiFuture<QuerySnapshot> future = collectionReference.get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Shop> result = new ArrayList<>();
		if (!documents.isEmpty())
			for (DocumentSnapshot snapshot : documents)
				result.add(snapshot.toObject(Shop.class));

		return result;
	}

	public Shop shopInfo(int seller_id) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference collectionReference = db.collection("Shop");
		Query query = collectionReference.whereEqualTo("ownerId", seller_id);
		ApiFuture<QuerySnapshot> querySnapshot = query.get();
		List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
		List<Shop> result = new ArrayList<>();
		Shop temp = null;
		if (!documents.isEmpty())
			for (DocumentSnapshot snapshot : documents)
				temp = snapshot.toObject(Shop.class);
		return temp;
	}

	public void updateShop(int id, Shop shop) {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = db.collection("Shop").document(Integer.toString(id))
				.set(shop);
	}
	
	public void deleteShop(int id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("Shop").document(Integer.toString(id)).delete();
    }
	
}
