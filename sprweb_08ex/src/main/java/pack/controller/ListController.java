package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
    private DataDao dataDao;
	
    @PostMapping(value="job")
    public String showJobList(@RequestParam(name="job") String job, Model model) {
        List<JikwonDto> list = new ArrayList<>();
        
        if (job == null || job.equals("")) {
            list = dataDao.getAllList();
        } else {
            list = dataDao.getJobList(job);
        }
        model.addAttribute("datas", list);
        return "show";
    }
}
