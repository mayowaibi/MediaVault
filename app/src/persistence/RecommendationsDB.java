package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.Media;
import backend.Movie;

public class RecommendationsDB {
	/**
	 * Gets the recommendations that are not in the vault already
	 * @param mediaCollectionId is the id of the collection that must be excluded
	 * @param n is the number of recommendations
	 * @return an arraylist of media containing the recommendations
	 */
	public static ArrayList<Media> get(int mediaCollectionId, int n){
		ArrayList<Media> list = new ArrayList<Media>();
		ResultSet result;
		ActiveConnection activeCon = JDBC_Connection.getResult("SELECT title,id FROM allmovies WHERE id NOT IN(SELECT mediaid FROM mediarelations WHERE mediacollectionid="+mediaCollectionId+") ORDER BY rand() LIMIT "+n+";");
		result = activeCon.result;
		try {
			while (result.next()) {
				Movie movie = new Movie(result.getInt("id"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		activeCon.closeConnection();
		return list;
	}
}
