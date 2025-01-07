package pack.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Autowired
	private DataSource dataSource;

	public DataDao() {

	}

	public List<JikwonDto> getJobList(String job) {
		List<JikwonDto> list = new ArrayList<>();

		try {
			String sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon WHERE jikwonjik = ?";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				list.add(dto);
			}
		} catch (Exception e) {
		}

		return list;
	}

	public List<JikwonDto> getAllList() {
		List<JikwonDto> list = new ArrayList<>();

		try {
			String sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon";
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getString("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getString("jikwonpay"));
				list.add(dto);
			}
		} catch (Exception e) {
		}

		return list;
	}
}
