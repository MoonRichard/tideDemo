package com.smart.web;

import com.smart.cons.CommonConstant;
import com.smart.domain.Board;
import com.smart.domain.Record;
import com.smart.domain.User;
import com.smart.service.RecordService;
import com.smart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class RecordController {
    private UserService userService;

    private RecordService recordService;

    @Autowired
    public void setRecordService(RecordService recordService) {
        this.recordService = recordService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/record", method = RequestMethod.GET)
    public ModelAndView listAllBoards() {
        ModelAndView view =new ModelAndView();
        List<Record> records = recordService.getAllRecords();
        view.addObject("records", records);
        view.setViewName("/listAllRecords");
        return view;
    }

    /**
     * 添加record页面
     *
     * @return
     */
    @RequestMapping(value = "/record/addRecord", method = RequestMethod.GET)
    public ModelAndView addTopicPage() {
        ModelAndView view =new ModelAndView();
        view.setViewName("/addRecord");
        return view;
    }
    //处理新增record
    @RequestMapping(value = "/record/addRecord", method = RequestMethod.POST)
    public String addTopic(HttpServletRequest request, Record record) {
        User user = getSessionUser(request);
        record.setUserId(user.getUserId());
        Timestamp now = new Timestamp(new Date().getTime());
        record.setCreateTime(now);
        recordService.addRecord(record);
//        String targetUrl = "/board/listBoardTopics-" + topic.getBoardId()
//                + ".html";
        return "redirect:"+"record.html";

    }

    protected User getSessionUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(
                CommonConstant.USER_CONTEXT);
    }
}
