package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.contoroller.FormBean;

@Repository
public class DataDao {
	private Logger logger = LoggerFactory.getLogger(DataDao.class);
	
	@Autowired
	private DataMapperInterface dataInterface; 
	
	public List<JikwonDto> getDataAll() {
		List<JikwonDto> list = dataInterface.selectAll(); 
		logger.info("datas: " + list.size());
		
		return list;
	}
	
	public List<JikwonDto> getDataSearch(FormBean bean) {
		logger.info("bean: " + bean.getSearchValue()); 
		List<JikwonDto> list = dataInterface.selectSearch(bean.getSearchValue()); 
		logger.info("datas: " + list.size()); 
		
		return list;
	}
}
