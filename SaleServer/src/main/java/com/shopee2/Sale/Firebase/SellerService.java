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
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import com.shopee2.Sale.Model.Seller;

@Service
public class SellerService {

	public void addSeller(Seller seller) {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture;
		collectionsApiFuture = db.collection("Seller").document(Integer.toString(seller.getSid())).set(seller);
	}

	public List<Seller> allSeller() throws ExecutionException, InterruptedException {
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference collectionReference = db.collection("Seller");
		ApiFuture<QuerySnapshot> future = collectionReference.get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		List<Seller> result = new ArrayList<>();
		if (!documents.isEmpty())
			for (DocumentSnapshot snapshot : documents)
				result.add(snapshot.toObject(Seller.class));

		return result;
	}

	public Seller sellerInfo(int sid) throws InterruptedException, ExecutionException {
		Firestore db = FirestoreClient.getFirestore();
		DocumentReference documentReference = db.collection("Seller").document(Integer.toString(sid));
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();

		return document.toObject(Seller.class);
	}

	public void updateSeller(int sid, Seller seller) {
		Firestore db = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionsApiFuture = db.collection("Seller").document(Integer.toString(sid))
				.set(seller);
	}
	
	public void deleteSeller(int sid) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = db.collection("Seller").document(Integer.toString(sid)).delete();
    }
}
