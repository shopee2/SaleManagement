package com.shopee2.Sale.Firebase;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {
	@PostConstruct
	public void initDB() throws IOException{
		InputStream serviceAccount = this.getClass().getClassLoader()
				.getResourceAsStream("./sop-sellermanagement-firebase-adminsdk-a3q2s-27464b78fc.json");

				FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
				  .setDatabaseUrl("https://sop-sellermanagement.firebaseio.com")
				  .build();

			if (FirebaseApp.getApps().isEmpty()) {
					FirebaseApp.initializeApp(options);
			}
		}
	public Firestore getFirebase() {
		return FirestoreClient.getFirestore();
	}
	
}
