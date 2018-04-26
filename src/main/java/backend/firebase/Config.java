package backend.firebase;

public class Config {
	
	FileInputStream serviceAccount = new FileInputStream("path/to/serviceAccountKey.json");

	FirebaseOptions options = new FirebaseOptions.Builder()
	    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	    .setDatabaseUrl("https://<DATABASE_NAME>.firebaseio.com/")
	    .build();

	FirebaseApp.initializeApp(options);

}
