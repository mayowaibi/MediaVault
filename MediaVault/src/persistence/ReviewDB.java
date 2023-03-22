package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Review;
import backend.User;

public class ReviewDB {
	public static ArrayList<Review> get(Media media){
		ArrayList<Review> reviews = new ArrayList<Review>();
		ResultSet result;
		result = JDBC_Connection.getResult("SELECT * FROM review ORDER BY rand() LIMIT 2;");
		try {
			while (result.next()) {
				Review review = new Review(new User(result.getString(1)),result.getString(3));
				reviews.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviews;
	}

	public static void add(int id, String review) {
		
	}
}
