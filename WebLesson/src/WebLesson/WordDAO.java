package WebLesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class WordDAO {

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	ResultSet res = null;

	public int registWords(Word wd) {
		int result = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				System.out.println("DB接続完了（getConnection後）\r\n----");
			}
			else{
				System.out.println("DB接続失敗\r\n----");
			}

			String SQL = "INSERT INTO dictionary VALUES(?, ?)";
			st = con.prepareStatement(SQL);
			st.setString(1, wd.getEnglish()); //英語
			st.setString(2, wd.getJapanese()); //日本語
			result = st.executeUpdate();

//			String SQL2 = "SELECT count(*) FROM dictionary";
//			st = con.prepareStatement(SQL2);
//			rs = st.executeQuery();

//			while(rs.next()){
//			result = rs.getInt(1);}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public ArrayList<Word> getWords(){
		ArrayList<Word> list = new ArrayList<Word>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdb?useUnicode=true&characterEncoding=utf8", "root", "");

			if(con != null){
				System.out.println("DB接続完了（getConnection後）\r\n----");
			}
			else{
				System.out.println("DB接続失敗\r\n----");
			}

			String SQL = "SELECT * FROM dictionary";
			st = con.prepareStatement(SQL);
			ResultSet res = st.executeQuery();

			while(res.next()){
			String En = res.getString("english");
			String Jp = res.getString("japanese");
			Word wd2 = new Word(En,Jp);
			list.add(wd2);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;	// 結果を返す
	}}