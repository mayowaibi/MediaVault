package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import persistence.UserDB;

public class User {

	MediaCollection mediaList;
	public static HashMap<String, Integer> stub;
	private String username;
	private int id;
	private static final AtomicInteger count = new AtomicInteger(0); 
	/**
	 * Create a user with username
	 * @param username
	 */
	public User(String username) {
		this.username = username;
		if (!UseStub.getStubFlag()) {
			this.id = UserDB.getId(username);
		} else {
			if (stub==null) User.makeStub();
			if (!stub.containsKey(username)) stub.put(username, count.incrementAndGet());
			this.id = stub.get(username);
		}
		this.mediaList = new MediaCollection(this.id);
	}
	public static void makeStub() {
		stub = new HashMap<String, Integer>();
		stub.put("user1", count.incrementAndGet());
		stub.put("user2", count.incrementAndGet());
		stub.put("user3", count.incrementAndGet());
	}
	/**
	 * Returns the user's username
	 * @return
	 */
	public String getUsername() {
		
		return this.username;
	} 
	public int getId() {
		return this.id;
	}
	/**
	 * adds a media to a user's personal vault
	 * @param id is the id of the movie to added
	 * @return true if operation successful, false otherwise
	 */
	public boolean addMedia(int id) {
		return this.mediaList.addMedia(new Movie(id));
	} 
	/**
	 * removes a media from the user's personal vault
	 * @param id is the id of the movie to be removed
	 * @return true if operation successful, false otherwise
	 */
	public boolean removeMedia(int id) {
		return this.mediaList.removeMedia(id);
	} 
	/**
	 * gets the user's personal vault
	 * @return the arraylist containing movies from the user's personal vault
	 */
	public ArrayList<Media> getMediaList() {
		return this.mediaList.getMediaList(); 
	} 

	public static void main (String[] args) {
		UseStub.setStubFlag(false);
		User user = new User("mate");
		System.out.println(user.getId());
		System.out.println(user.getMediaList().size());
		for (int i = 0; i <user.getMediaList().size(); i++) {
			System.out.println(i + " - " + user.getMediaList().get(i).getId() + " - " + user.getMediaList().get(i).getTitle());
		}
		user=new User("user4");
		for (int i = 0; i <user.getMediaList().size(); i++) {
			System.out.println(i + " - " + user.getMediaList().get(i).getId() + " - " + user.getMediaList().get(i).getTitle());
		}
	}
}
