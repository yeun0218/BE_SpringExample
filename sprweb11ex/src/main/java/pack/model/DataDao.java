	package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport{
	public DataDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
	}
	
	public List<JikwonDto> getAllData() {
		String sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon";
		List<JikwonDto> list = getJdbcTemplate().query(sql, new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					JikwonDto dto = new JikwonDto();
					dto.setJikwonno(rs.getInt("jikwonno"));
					dto.setJikwonname(rs.getString("jikwonname"));
					dto.setJikwongen(rs.getString("jikwongen"));
					dto.setJikwonpay(rs.getInt("jikwonpay"));
					return dto;
			}
		});
		return list;
	}
	
	public List<JikwonDto> getJikData(String keyword) {
		String sql = "SELECT jikwonno, jikwonname, jikwongen, jikwonpay FROM jikwon WHERE jikwonjik=?";
		
		List<JikwonDto> list = getJdbcTemplate().query(sql, new Object[] {keyword}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				JikwonDto dto = new JikwonDto();
				dto.setJikwonno(rs.getInt("jikwonno"));
				dto.setJikwonname(rs.getString("jikwonname"));
				dto.setJikwongen(rs.getString("jikwongen"));
				dto.setJikwonpay(rs.getInt("jikwonpay"));
				return dto;
			}
		});
		return list;
	}
}